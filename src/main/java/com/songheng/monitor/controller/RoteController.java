package com.songheng.monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: monitor
 * @description:
 * @author: Mr.Shi
 * @create: 2019-11-29 17:12
 **/
@Controller
public class RoteController {
    @RequestMapping("/")
    public String index() {
        return "info";
    }
}
