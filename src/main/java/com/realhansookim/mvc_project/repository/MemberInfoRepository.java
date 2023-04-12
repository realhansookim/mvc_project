package com.realhansookim.mvc_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realhansookim.mvc_project.entity.MemberInfoEntity;

public interface MemberInfoRepository extends JpaRepository<MemberInfoEntity,Long>{
    public Integer countByMiId (String MiId);
}
