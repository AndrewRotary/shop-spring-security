package com.shop.service;

import com.shop.Model.User;
import com.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by student on 3/28/2017.
 */
@Component("userDetailsService")
public class CurrentUserDetailsService implements UserDetailsService {
  private final UserRepository userService;

  @Autowired
  public CurrentUserDetailsService(UserRepository userService) {
    this.userService = userService;
  }

  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    User user = userService.findUserByName(name);
    if(user == null){
      throw new UsernameNotFoundException(String.format("User with username=%s was not found", name));
    }
    return new CurrentUser(user);
  }
}
