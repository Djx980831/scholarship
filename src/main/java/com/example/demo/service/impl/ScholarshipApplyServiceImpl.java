package com.example.demo.service.impl;

import com.example.demo.entity.ScholarshipApply;
import com.example.demo.mapper.ScholarshipApplyMapper;
import com.example.demo.service.ScholarshipApplyService;
import com.example.demo.util.PageInfo;
import com.example.demo.vo.request.ScholarshipApplyVORequest;
import com.example.demo.vo.response.ScholarshipApplyVO;
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
 * @Date 2020-03-29 22:16
 */
@Service
public class ScholarshipApplyServiceImpl implements ScholarshipApplyService {

    @Autowired
    private ScholarshipApplyMapper mapper;

    @Override
    public Integer addApply(String studentId, String grade, String major, String gradeClass, String userName, String type, Double jiaQuan, Double zongHe, String caoXing, String jiaQuanClassRank, String jiaquanMajorRank, String zongHeClassRank, String description) {
        ScholarshipApply apply = new ScholarshipApply();

        apply.setStudentId(studentId);
        apply.setGrade(grade);
        apply.setMajor(major);
        apply.setGradeClass(gradeClass);
        apply.setUserName(userName);
        apply.setType(type);
        apply.setJiaQuan(jiaQuan);
        apply.setZongHe(zongHe);
        apply.setCaoXing(caoXing);
        apply.setJiaQuanClassRank(jiaQuanClassRank);
        apply.setJiaquanMajorRank(jiaquanMajorRank);
        apply.setZongHeClassRank(zongHeClassRank);
        apply.setDescription(description);

        return  mapper.addApply(apply);
    }

    @Override
    public Integer getApplyIdByStudentIdAndCtime(String studentId) {
        Calendar c = Calendar.getInstance();
        int time = c.get(1);
        return mapper.getApplyIdByStudentIdAndCtime(studentId, String.valueOf(time));
    }

    @Override
    public String getStudentIdById(Integer id) {
        return mapper.getStudentIdById(id);
    }

    @Override
    public ScholarshipApply getApplyById(Integer id) {
        return mapper.getApplyById(id);
    }

    @Override
    public ScholarshipApplyVO getApplyList(String studentId, String grade, String major, String gradeClass, String userName, String type, String time, String sortKind, Integer nowPage, Integer pageSize) {
        ScholarshipApplyVORequest request = new ScholarshipApplyVORequest();

        request.setSortKind(sortKind);
        request.setStudentId(studentId);
        request.setGrade(grade);
        request.setMajor(major);
        request.setGradeClass(gradeClass);
        request.setUserName(userName);
        request.setType(type);
        request.setTime(time);
        request.setNowPage(nowPage);
        request.setPageSize(pageSize);

        List<ScholarshipApply> applyList = mapper.getApplyList(request);

        ScholarshipApplyVO responseVO = new ScholarshipApplyVO();
        List<ScholarshipApplyVO.ScholarshipApplyVo> applyVoList = new ArrayList<>(15);
        for (ScholarshipApply apply : applyList) {
            ScholarshipApplyVO.ScholarshipApplyVo vo = new ScholarshipApplyVO.ScholarshipApplyVo();
            vo.setId(apply.getId());
            vo.setStudentId(apply.getStudentId());
            vo.setGrade(apply.getGrade());
            vo.setMajor(apply.getMajor());
            vo.setGradeClass(apply.getGradeClass());
            vo.setUserName(apply.getUserName());
            vo.setType(apply.getType());
            vo.setFlag(apply.getFlag());
            vo.setJiaQuan(apply.getJiaQuan());
            vo.setZongHe(apply.getZongHe());
            vo.setJiaQuanClassRank(apply.getJiaQuanClassRank());
            vo.setJiaquanMajorRank(apply.getJiaquanMajorRank());
            vo.setZongHeClassRank(apply.getZongHeClassRank());
            vo.setDescription(apply.getDescription());

            applyVoList.add(vo);
        }

        Integer count = getCount(studentId, grade, major, gradeClass, userName, type, time);

        responseVO.setPageInfo(new PageInfo(count, nowPage, pageSize));
        responseVO.setScholarshipApplyVoList(applyVoList);

        return responseVO;
    }

    @Override
    public Integer deleteApplyById(Integer id) {
        String studentId = getStudentIdById(id);
        if (studentId == null) {
            return null;
        }
        return mapper.deleteApplyById(id);
    }

    @Override
    public Integer getCount(String studentId, String grade, String major, String gradeClass, String userName, String type, String time) {
        ScholarshipApplyVORequest request = new ScholarshipApplyVORequest();

        request.setStudentId(studentId);
        request.setGrade(grade);
        request.setMajor(major);
        request.setGradeClass(gradeClass);
        request.setUserName(userName);
        request.setType(type);
        request.setTime(time);

        return mapper.getCount(request);
    }

    @Override
    public Integer updateApplyById(Integer id, String studentId, String grade, String major, String gradeClass, String userName, String type, Double jiaQuan, Double zongHe,
                                   String caoXing, String jiaQuanClassRank, String jiaquanMajorRank, String zongHeClassRank, String description) {
        ScholarshipApply app = mapper.getApplyById(id);
        if (app == null) {
            return null;
        }
        mapper.deleteApplyById(id);

        ScholarshipApply apply = new ScholarshipApply();

        apply.setStudentId(studentId);
        apply.setGrade(grade);
        apply.setMajor(major);
        apply.setGradeClass(gradeClass);
        apply.setUserName(userName);
        apply.setType(type);
        apply.setJiaQuan(jiaQuan);
        apply.setZongHe(zongHe);
        apply.setCaoXing(caoXing);
        apply.setJiaQuanClassRank(jiaQuanClassRank);
        apply.setJiaquanMajorRank(jiaquanMajorRank);
        apply.setZongHeClassRank(zongHeClassRank);
        apply.setDescription(description);
        return mapper.addApply(apply);
    }
}
