package com.shop.controller;

import com.shop.Model.*;
import com.shop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 3/27/2017.
 */
@Controller
public class MainController {

  @Autowired
  ItemRepository itemRepository;

  @Autowired
  CategoryRepository categoryRepository;

  @Autowired
  CommentRepository commentRepository;

  @Autowired
  ImmageRepository immageRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  ProfileRepository profileRepository;


  private Path path;

  @RequestMapping("/")
  public String controller(Model model){
    Integer commentsSize = 0;
    List<Comment> commentList = (List<Comment>) commentRepository.findAll();
    if((commentList.size() > 0) && (commentList != null)){
      commentsSize = commentList.size();
    }
    model.addAttribute("commentsSize", commentsSize);
    model.addAttribute("items", itemRepository.findAll());
    return "home";
  }

  @RequestMapping("/addItem")
  public String addItemGet(Model model){
    Item item = new Item();
    model.addAttribute("item", item);
    model.addAttribute("category", categoryRepository.findAll());
    return "addItem";
  }

  @PostMapping(value = "addItem")
  public String addItemPost(@ModelAttribute("item") Item item) throws IOException {
    itemRepository.save(item);
    List<Immage> imgs = new ArrayList<>();
    List<MultipartFile> files = item.getImageMultipart();
    if (null != files && files.size() > 0)
    {
      for (MultipartFile multipartFile : files) {
        String fileName = multipartFile.getOriginalFilename();
        path = Paths.get("C:/Users/student/IdeaProjects/andrei-coder/src/main/resources/static/images/" + item.getId()+ "-" + fileName);
        multipartFile.transferTo(new File(path.toString()));
        Immage immage = new Immage();
        immage.setItem(item);
        immage.setPath(item.getId() + "-" + fileName);
        immageRepository.save(immage);
        imgs.add(immage);
      }
      item.setImmages(imgs);
      itemRepository.save(item);
    }
    return "redirect:/";
  }

  @RequestMapping("/register")
  public String register(Model model){
    User user = new User();
    model.addAttribute("user", user);
    return "register";
  }

  @PostMapping(value = "register")
  public String registerPost(@ModelAttribute("user") User user) throws IOException {
    Profile profile = profileRepository.findOne((long) 2);
    user.setProfile(profile);
    MultipartFile multipartFile = user.getImageMultipart();
    String fileName = multipartFile.getOriginalFilename();
    path = Paths.get("C:/Users/student/IdeaProjects/andrei-coder/src/main/resources/static/images/user" + "_" + fileName);
    multipartFile.transferTo(new File(path.toString()));
    user.setPath("user_" + fileName);
    userRepository.save(user);
    return "redirect:/";
  }

  @RequestMapping("/login")
  public String login(){
    return "login";
  }

  @RequestMapping("/loguot")
  public String loguot(){
    return "redirect:/";
  }

  @PostMapping(value = "login")
  public String loginPost(HttpServletRequest rs){
    User user = userRepository.findUserByName(rs.getParameter("username"));
    if(user.getPassword().equals(rs.getParameter("password"))){
      return "redirect:/";
    }
    System.out.println("hello");
    return "test";
  }

  @RequestMapping("/toCart/{id}")
  public String toCart(Model model, @PathVariable Long id){
    Item item = itemRepository.findOne(id);
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentUserName = authentication.getName();
    User user = userRepository.findUserByName(currentUserName);


    return "redirect:/";
  }



}
