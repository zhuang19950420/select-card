package com.songheng.monitor.controller;

import com.songheng.monitor.service.MonitorService;
import com.songheng.monitor.utils.ResponceBean;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

@Controller
public class MonitorController {
    @Autowired
    MonitorService monitorService;


    @GetMapping(value="/getStatu")
    @ResponseBody
    public ResponceBean index() {
        List list = monitorService.getIsalive();
        return new ResponceBean(200,"ok",list);
    }
}
