package com.example.demo.service.impl;

import com.example.demo.entity.Scholarship;
import com.example.demo.mapper.ScholarshipMapper;
import com.example.demo.service.ScholarshipService;
import com.example.demo.util.PageInfo;
import com.example.demo.vo.request.ScholarshipVORequest;
import com.example.demo.vo.response.ScholarshipVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-20 21:41
 */
@Service
public class ScholarshipServiceImpl implements ScholarshipService {

    @Autowired
    private ScholarshipMapper mapper;

    @Override
    public Integer addScholarship(String name, Integer money, Integer count, String classCount, String description) {
        Scholarship scholarship = new Scholarship();
        scholarship.setName(name);
        scholarship.setClassCount(classCount);
        scholarship.setCount(count);
        scholarship.setDescription(description);
        scholarship.setMoney(money);

        mapper.addScholarship(scholarship);
        return scholarship.getId();
    }

    @Override
    public Integer deleteScholarship(Integer id) {
        mapper.deleteScholarship(id);
        return id;
    }

    @Override
    public ScholarshipVO getAllScholarship(Integer nowPage, Integer pageSize) {
        List<Scholarship> scholarshipList = mapper.getAllScholarship(nowPage - 1, pageSize);
        Integer count = mapper.getCount();

        ScholarshipVO scholarshipVO = new ScholarshipVO();
        List<ScholarshipVO.ScholarshipVo> scholarshipVoList = new ArrayList<>(10);
        for (Scholarship ship : scholarshipList) {
            ScholarshipVO.ScholarshipVo vo = new ScholarshipVO.ScholarshipVo();
            vo.setId(ship.getId());
            vo.setName(ship.getName());
            vo.setCount(ship.getCount());
            vo.setMoney(ship.getMoney());
            vo.setClassCount(ship.getClassCount());
            vo.setDescription(ship.getDescription());

            scholarshipVoList.add(vo);
        }

        PageInfo pageInfo = new PageInfo(count, nowPage, pageSize);

        scholarshipVO.setScholarshipVoList(scholarshipVoList);
        scholarshipVO.setPageInfo(pageInfo);
        return scholarshipVO;
    }

    @Override
    public Integer updateScholarshipById(Integer id, String name, Integer money, Integer count, String classCount, String description) {
        ScholarshipVORequest request = new ScholarshipVORequest();
        request.setId(id);
        request.setClassCount(classCount);
        request.setCount(count);
        request.setDescription(description);
        request.setMoney(money);
        request.setName(name);

        mapper.updateScholarshipById(request);
        return id;
    }

    @Override
    public ScholarshipVO.ScholarshipVo getScholarshipbyId(Integer id) {
        Scholarship scholarship = mapper.getScholarshipbyId(id);
        if (scholarship == null) {
            return null;
        }
        ScholarshipVO.ScholarshipVo vo = new ScholarshipVO.ScholarshipVo();
        vo.setId(scholarship.getId());
        vo.setName(scholarship.getName());
        vo.setMoney(scholarship.getMoney());
        vo.setCount(scholarship.getCount());
        vo.setClassCount(scholarship.getClassCount());
        vo.setDescription(scholarship.getDescription());

        return vo;
    }

    @Override
    public String getScholarshipDescriptionById(Integer id) {
        return mapper.getScholarshipDescriptionById(id);
    }
}
