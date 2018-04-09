package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2018/4/9 0009.
 */
@Controller
public class HelloController {

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "index controller";
    }

    @RequestMapping("/name")
    public String name(Map<String, Object> map) {
        map.put("name", "Clark");
        System.out.println("============================================");
        return "hello";
    }
}