package com.example.springbootsecurity;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goodbye")
public class GoodbyeController {

  @GetMapping("")
  public String index(HttpServletRequest req) {
    return "goodbye/index";
  }

  @GetMapping("english")
  public String helloEng() {
    return "goodbye/english";
  }

  @GetMapping("irish")
  public String helloIre() {
    return "goodbye/irish";
  }
}
