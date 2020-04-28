package com.example.demo.service.impl;

import com.example.demo.entity.Scholarshiped;
import com.example.demo.mapper.ScholarshipedMapper;
import com.example.demo.service.ScholarshipedService;
import com.example.demo.util.PageInfo;
import com.example.demo.vo.request.ScholarshipedRequestVO;
import com.example.demo.vo.response.ScholarshipedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-04-08 23:46
 */
@Service
public class ScholarshipedServiceImpl implements ScholarshipedService {

    @Autowired
    private ScholarshipedMapper mapper;

    @Override
    public Integer[] addList(Integer[] ids) {
        mapper.addList(ids);
        List<Integer> idList = mapper.getIdByApplyId(ids);
        Integer[] idsRes = new Integer[idList.size()];
        for (int i = 0; i < idsRes.length; i++) {
            idsRes[i] = idList.get(i);
        }
        mapper.updateList(idsRes);
        return idsRes;
    }

    @Override
    public Integer[] deleteList(Integer[] ids) {
         mapper.deleteList(ids);
         return ids;
    }

    @Override
    public ScholarshipedVO getList(String studentId, String year, String grade, String major, String type, String sortKind, Integer nowPage, Integer pageSize) {
        ScholarshipedVO scholarshipedVO = new ScholarshipedVO();

        ScholarshipedRequestVO request = new ScholarshipedRequestVO();
        request.setStudentId(studentId);
        request.setYear(year);
        request.setGrade(grade);
        request.setMajor(major);
        request.setType(type);
        request.setSortKind(sortKind);
        request.setNowPage(nowPage - 1);
        request.setPageSize(pageSize);

        List<Scholarshiped> scholarshipedList = mapper.getList(request);
        if (scholarshipedList == null) {
            return null;
        }

        Integer count = mapper.getCount(request);

        List<ScholarshipedVO.ScholarshipedVo> scholarshipedVoList = new ArrayList<>(20);
        for (Scholarshiped ed : scholarshipedList) {
            ScholarshipedVO.ScholarshipedVo vo = new ScholarshipedVO.ScholarshipedVo();
            vo.setId(ed.getId());
            vo.setApplyId(ed.getApplyId());
            vo.setStudentId(ed.getStudentId());
            vo.setUserName(ed.getUserName());
            vo.setYear(ed.getYear());
            vo.setGrade(ed.getGrade());
            vo.setMajor(ed.getMajor());
            vo.setType(ed.getType());
            vo.setJiaQuan(ed.getJiaQuan());
            vo.setZongHe(ed.getZongHe());
            vo.setGradeClass(ed.getGradeClass());
            vo.setCaoXIng(ed.getCaoXIng());

            scholarshipedVoList.add(vo);
        }

        PageInfo pageInfo = new PageInfo(count, nowPage, pageSize);

        scholarshipedVO.setPageInfo(pageInfo);
        scholarshipedVO.setScholarshipedVoList(scholarshipedVoList);

        return scholarshipedVO;
    }

    @Override
    public Integer checkId(Integer id) {
        return mapper.checkId(id);
    }

    @Override
    public List<Integer> getIdByApplyId(Integer[] ids) {
        return mapper.getIdByApplyId(ids);
    }

    @Override
    public ScholarshipedVO getScholarshipedList(String type, String grade, String sortKind, Integer nowPage, Integer pageSize) {
        ScholarshipedVO scholarshipedVO = new ScholarshipedVO();

        ScholarshipedRequestVO request = new ScholarshipedRequestVO();
        Calendar c = Calendar.getInstance();
        int year = c.get(1);
        request.setYear(String.valueOf(year));
        request.setGrade(grade);
        request.setType(type);
        request.setSortKind(sortKind);
        request.setNowPage(nowPage - 1);
        request.setPageSize(pageSize);

        List<Scholarshiped> scholarshipedList = mapper.getScholarshipedList(request);
        if (scholarshipedList == null) {
            return null;
        }

        Integer count = mapper.getCount(request);

        List<ScholarshipedVO.ScholarshipedVo> scholarshipedVoList = new ArrayList<>(20);
        for (Scholarshiped ed : scholarshipedList) {
            ScholarshipedVO.ScholarshipedVo vo = new ScholarshipedVO.ScholarshipedVo();
            vo.setId(ed.getId());
            vo.setApplyId(ed.getApplyId());
            vo.setStudentId(ed.getStudentId());
            vo.setUserName(ed.getUserName());
            vo.setYear(ed.getYear());
            vo.setGrade(ed.getGrade());
            vo.setMajor(ed.getMajor());
            vo.setType(ed.getType());
            vo.setJiaQuan(ed.getJiaQuan());
            vo.setZongHe(ed.getZongHe());
            vo.setGradeClass(ed.getGradeClass());
            vo.setCaoXIng(ed.getCaoXIng());

            scholarshipedVoList.add(vo);
        }

        PageInfo pageInfo = new PageInfo(count, nowPage, pageSize);

        scholarshipedVO.setPageInfo(pageInfo);
        scholarshipedVO.setScholarshipedVoList(scholarshipedVoList);

        return scholarshipedVO;
    }
}
