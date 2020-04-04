package com.example.demo.service;

import com.example.demo.vo.response.ScholarshipVO;


public interface ScholarshipService {

    Integer addScholarship(String name, Integer money, Integer count, String classCount, String description);

    Integer deleteScholarship(Integer id);

    ScholarshipVO getAllScholarship(Integer nowPage, Integer pageSize);

    Integer updateScholarshipById(Integer id, String name, Integer money, Integer count, String classCount, String description);

    ScholarshipVO.ScholarshipVo getScholarshipbyId(Integer id);
}
