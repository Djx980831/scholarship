package com.example.demo.mapper;

import com.example.demo.entity.Scholarship;
import com.example.demo.vo.request.ScholarshipVORequest;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ScholarshipMapper {

    Integer addScholarship(Scholarship scholarship);

    Integer deleteScholarship(Integer id);

    List<Scholarship> getAllScholarship(@RequestParam("nowPage") Integer nowPage, @RequestParam("pageSize") Integer pageSize);

    Integer getCount();

    Integer updateScholarshipById(ScholarshipVORequest scholarshipVORequest);
}
