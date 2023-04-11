package com.realhansookim.mvc_project.service;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.realhansookim.mvc_project.entity.MemberInfoEntity;
import com.realhansookim.mvc_project.repository.MemberInfoRepository;
import com.realhansookim.mvc_project.vo.LoginAdd;
import com.realhansookim.mvc_project.vo.LoginVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberInfoService {
    private final MemberInfoRepository memberInfoRepository;
    public LoginVO addLogin(LoginAdd data){
        MemberInfoEntity entity = MemberInfoEntity.builder()
        .miId(data.getId()).miPwd(data.getPwd()).miName(data.getName())
        .miBirth(data.getBirth()).build();
        memberInfoRepository.save(entity);
        return LoginVO.builder().code(HttpStatus.OK).message("등록되었습니다.").status(true).build();
    }
}
