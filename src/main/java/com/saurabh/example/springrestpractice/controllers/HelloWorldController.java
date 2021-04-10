package com.saurabh.example.springrestpractice.controllers;

import com.saurabh.example.springrestpractice.models.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello")
    public String helloMethod() {
        return "Hello Sir...";
    }

    @GetMapping(path = "/hello-bean")
        public HelloWorldBean helloMethodBean() {
            return new HelloWorldBean("Hello Sir from bean...");
    }


    @GetMapping(path = "/hello/{name}")
    public String helloMethodBeanForName(@PathVariable("name") String name) {
        return "Hello "+name;
    }
}
