package com.example.springbootsecurity;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("")
    public String index() {
        return "hello/index";
    }
    
    
//    @GetMapping("")
//    public String index(HttpSession sess) {
//        sess.setAttribute("uname", getLoggedInName());
//        return "hello/index";
//    }
    
    @GetMapping("english")
    public String helloEng() {
        return "hello/english";
    }

    @GetMapping("irish")
    public String helloIre() {
        return "hello/irish";
    }

  
  
}
