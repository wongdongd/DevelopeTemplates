package com.wdd.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ANOHelloController {

    @RequestMapping("/anohello")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("message","注解 hello world");
        ModelAndView mav = new ModelAndView("index");
        //mav.addObject("message","注解 hello world");
        return mav;
    }

    /**
     *  使用Model对象给页面传值,可以结合@RequestParam使用
     * @param model
     * @return
     */
    @RequestMapping("/model")
    public String handleRequest(Model model){
        model.addAttribute("message","model hello world");
        return "index";
    }

    //**************@ModelAttribute注解方式 不好用******************
//    @RequestMapping("/value")
//    public String handleRequest(){
//        return "index";
//    }
//
//    @ModelAttribute
//    public void model(Model model){
//        model.addAttribute("message","value");
//    }
    //******************************************************


    //*******页面跳转...
    @RequestMapping("/jump")
    public ModelAndView jump(){
        return new ModelAndView("redirect:/anohello");
    }

    @RequestMapping("/jumpS")
    public String jumpS(){
        return "redirect:./anohello";
    }

}
