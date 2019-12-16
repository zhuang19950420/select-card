package com.songheng.monitor.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DemoController {

    //返回页面
    @GetMapping(value="/hellow")
    public ModelAndView index(Model m, @RequestParam(value ="id") String id) {
        m.addAttribute("now", id);
        ModelAndView modelAndView = new ModelAndView("/hellow");
        return modelAndView;
    }

    @GetMapping(value="/test1/is_alive")
    public String test1() {
        return "yes";
    }

    @GetMapping(value="/test2/is_alive")
    public String test2() {
        return "yes";
    }

    @GetMapping(value="/test3/is_alive")
    public String test3() {
        return "no";
    }

    @GetMapping(value="/test4/is_alive")
    public String test4() {
        return "no";
    }


}
