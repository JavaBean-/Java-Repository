package com.ice.summer.controller;

import com.ice.summer.Dao.Person;
import com.ice.summer.Dao.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @Value("${spring.application.name:summer}")
    private String applicationName;

    @GetMapping(path = "/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello Mr.%s! \r\n Welcome to %s", name, applicationName);
    }

    @PostMapping(path = "/postUser")
    public User getUser() {
        User user=new User();
        user.setUserName("小明");
        user.setPassWord("345");
        return user;
    }

    @GetMapping(path = "/mainPage")
    public String getMain() {
        User user=new User();
        user.setUserName("小明");
        user.setPassWord("345");
        return "main";
    }

    @GetMapping("/userList")
    public List<User> index(Model model) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setId((long) i);
            u.setName("javaboy:" + i);
            u.setAddress("深圳:" + i);
            users.add(u);
        }
        model.addAttribute("users", users);
        return users;
    }

    @RequestMapping("/thyme.do")
    public ModelAndView login(User user){
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person u = new Person();
            u.setId(i);
            u.setUsername("javaboy:" + i);
            u.setDescription("深圳:" + i);
            u.setCreated("by barry");
            u.setPassword("12345");
            persons.add(u);
        }

        ModelAndView mv=new ModelAndView();
        mv.addObject("newText","你好，Thymeleaf！");
        mv.addObject("gender","1");
        mv.addObject("personList",persons);

        mv.setViewName("thyme");
        return mv;
    }
}
