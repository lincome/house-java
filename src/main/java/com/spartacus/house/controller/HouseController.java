package com.spartacus.house.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author spartacus
 */
@RestController
public class HouseController {

    @RequestMapping("/hello")
    public String index(){
        return  "hello";
    }

}
