package com.cj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class TestController {


    @GetMapping("/bZQNQFGf1m.txt")
    public String wxTxt(){

        return "25e7d773f01c6e0d8a070f66c4d61fbb";
    }

    @GetMapping("/YMmsgyoayL.txt")
    public String YMmsgyoayL(){

        return "d905164baf82f5c78387615250092510";
    }

    @GetMapping("/MP_verify_bDVsqQ353QP3gRHv.txt")
    public String wxTxt2(){

        return "bDVsqQ353QP3gRHv";
    }

}
