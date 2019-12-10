package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles requests at path/hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    // Handles requests at path/hello
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, "+name+"!";
    }

    // Handles request of the from /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + // submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value='eng'>English</option>" +
                "<option value='jap'>Japanese</option>" +
                "<option value='spn'>Spanish</option>" +
                "<option value='frn'>French</option>" +
                "<option value='swh'>Swahili</option>" +
                "<select/>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
