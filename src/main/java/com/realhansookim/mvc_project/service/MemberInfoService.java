package com.realhansookim.mvc_project.service;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.realhansookim.mvc_project.entity.MemberInfoEntity;
import com.realhansookim.mvc_project.repository.MemberInfoRepository;
import com.realhansookim.mvc_project.utils.AESAlgorithm;
import com.realhansookim.mvc_project.vo.LoginAdd;
import com.realhansookim.mvc_project.vo.LoginVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberInfoService {
    private final MemberInfoRepository memberInfoRepository;
    public LoginVO addLogin(LoginAdd data){
        if(memberInfoRepository.countByMiId(data.getId())==1){
            LoginVO response = LoginVO.builder()
            .code(HttpStatus.BAD_REQUEST)
            .status(false)
            .message(data.getId()+"은/는 이미 등록된 아이디 입니다.")
            .build();
            return response;
        }
        try {
            String encPwd = AESAlgorithm.Encrypt(data.getPwd());
            data.setPwd(encPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MemberInfoEntity entity = MemberInfoEntity.builder()
        .miId(data.getId()).miPwd(data.getPwd()).miName(data.getName())
        .miBirth(data.getBirth()).build();
        memberInfoRepository.save(entity);
        return LoginVO.builder().code(HttpStatus.OK).message("등록되었습니다.").status(true).build();
    }
}
