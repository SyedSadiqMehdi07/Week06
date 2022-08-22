package com.example.demo.controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class Controller {

 @RequestMapping("/hi")

 public String sayHello(@RequestParam("cid") String id,Model m ,("cname") String cname,Model m , ("caddress") String address,Model m),("cnumber") int address,Model m)("cid") int id,Model m),("cpassword") String password,Model m)  

 {

 m.addAttribute("cid", id);
 m.addAttribute("cname",name);
 m.addAttribute("caddress",address);
 m.addAttribute("cnumber",number);
 m.addAttribute("clogin",login);
 m.addAttribute("cpassword",password);
 

 return "hello";

 }

 @RequestMapping("/xx")

 public String xx()

 {

 return "xy";

 }

}