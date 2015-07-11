package com.brahalla.Cerberus.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if (username != "user") {
      throw new UsernameNotFoundException("no user found with " + username);
    }
    return new UserDetails(
      "user",
      "password",
      true, true, true, true,
      AuthorityUtils.createAuthorityList("USER")
    );
  }
}
