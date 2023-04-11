package com.realhansookim.mvc_project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.realhansookim.mvc_project.service.MemberInfoService;
import com.realhansookim.mvc_project.vo.LoginAdd;
import com.realhansookim.mvc_project.vo.LoginVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/member")
@Controller

public class LoginController {
    private final MemberInfoService memberInfoService;
   @GetMapping("/add")
    public String getLogin(){
        return "member/add";
    }

    @PostMapping("/add")
    public String addMembers(LoginAdd add, Model model){
        model.addAttribute("inputdata", memberInfoService.addLogin(add));
        
        return "/member/add";
    } 
}
