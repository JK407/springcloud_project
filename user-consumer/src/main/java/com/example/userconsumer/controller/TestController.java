package com.example.userconsumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

  @GetMapping("/toLogin")
  public String toLogin(){
      return "login";
  }

  @GetMapping("/toRegister")
  public String toRegister(){
    return "register";
  }
}
