package com.shop.controller;

import com.shop.Model.Cart;
import com.shop.Model.Item;
import com.shop.Model.User;
import com.shop.repository.ItemRepository;
import com.shop.repository.UserRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import netscape.security.UserTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by student on 3/30/2017.
 */
@Controller
public class CartController {


  @Autowired
  ItemRepository itemRepository;

  @Autowired
  private Cart cart;

  @Autowired
  UserRepository userRepository;

  @RequestMapping(value = "/cart/add/{id}")
  public String addToCart(@PathVariable("id") Long id, @RequestHeader("referer") String referedFrom){

    Item item = itemRepository.findOne(id);
    cart.addItem(item, (long) 1);
//    System.out.println("Adding product ro cart " + item.getName());
    return "redirect:" + referedFrom;
  }
  @RequestMapping(value = "/cart", method = RequestMethod.GET)
  public String showCart(Model model){
    Double totalCost = cart.getTotalCost();
    model.addAttribute(cart);
    model.addAttribute("totalCost", totalCost);
    return "cart";


  }
}
