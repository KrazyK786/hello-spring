package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloController {

    // Handles requests at path/hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    // translates language
    public static String createMessage(String name, String lang){
        HashMap<String,String> greetings = new HashMap<>();
        greetings.put("eng","Hello");
        greetings.put("jpn","Konichiwa");
        greetings.put("frn","Bonjour");
        greetings.put("spn","Hola");
        greetings.put("swh","Jambo");

        return greetings.get(lang) + ", " + name + "!" +
                "<br><br><a href='http://localhost:8080/hello/form'>Try Again!</a>";
    }

    // Handles requests at path/hello
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "hello")
//    @ResponseBody
    public String helloWithQueryParam(Model model, @RequestParam String name, @RequestParam String language){
//        return createMessage(name,language);
        String greeting = createMessage(name,language);  //"Hello, " + name + "!";
        model.addAttribute("greeting",greeting);
        return "hello";
    }

    // Handles request of the from /hello/LaunchCode
    @GetMapping("{name}")
//    @ResponseBody
    public String helloWithPathParam(Model model,@PathVariable String name){
        model.addAttribute("greeting","Hello, " + name + "!");
        return "hello";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }
    
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String>names = new ArrayList<>();
        names.add("Knuckles");
        names.add("Sonic");
        names.add("Tails");
        
        model.addAttribute("names",names);
        
        return "hello-list";
    }
}
