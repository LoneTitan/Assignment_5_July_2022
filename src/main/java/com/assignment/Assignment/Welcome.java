package com.assignment.Assignment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @GetMapping("/welcome")
    public String welcome(){
        return "I am bhalu";
    }
}
//
//@RestController
//public class PrintData{
//
//    @GetMapping("/printdata")
//    public String printdata(){
//    }
//}
