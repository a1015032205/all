package com.java.controller;

import com.java.pojo.Info;
import com.java.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 秒度
 * @Email: fangxin.md@Gmail.com
 * @Date: 2020-03-28 22:21
 * @Description: Demo
 */
@RestController
@RequestMapping("one")
public class DemoController {

    @Autowired
    private InfoService infoService;

    @GetMapping(value = "demo")
    public String demo(Model model) {
        String string = "hello，world";
        model.addAttribute("one", string);
        return "/index";
    }

    @PostMapping(value = "java")
    public Object java(@RequestBody Info info) {
        return info;
    }


    @PostMapping(value = "add")
    public String add(@RequestBody Info info) {
        infoService.add(info);
        return "新增成功";
    }

    @PostMapping(value = "del")
    public Object del(@RequestBody Info info) {
        infoService.del(String.valueOf(info.getId()));
        return "删除成功";
    }

    @PostMapping(value = "update")
    public Object update(@RequestBody Info info) {
        infoService.update(String.valueOf(info.getId()), String.valueOf(info.getName()));
        return "修改成功";
    }

    @GetMapping(value = "get")
    public Object get() {
        return infoService.getAll();
    }

    @PostMapping(value = "insert")
    public void insert() {
        infoService.addResource();
    }


    @PostMapping(value = "findAll")
    public Object findAll() {
        return infoService.findAll();
    }

    @RequestMapping(value = "123",method = RequestMethod.POST)
    public static void main(String[] args) {
        demo();
    }
    public static void demo() {
        List<Map> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map map = new HashMap();
            map.put("name", i+"");
            list.add(map);
        }
        Map map = new HashMap();
        map.put("name", "a");
        list.add(map);
        list.stream().filter(p -> "a".endsWith((String) p.get("name"))).forEach(System.out::println);

    }
}
