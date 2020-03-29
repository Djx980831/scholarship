package com.example.demo.service;

import com.example.demo.entity.ScholarshipApply;
import com.example.demo.vo.response.ScholarshipApplyVO;


public interface ScholarshipApplyService {

    Integer addApply(String studentId, String grade, String major, String gradeClass, String userName, String type, Double jiaQuan, Double zongHe,
                     String caoXing, String jiaQuanClassRank, String jiaquanMajorRank, String zongHeClassRank, String description);

    Integer getApplyIdByStudentIdAndCtime(String studentId);

    String getStudentIdById(Integer id);

    ScholarshipApply getApplyById(Integer id);

    ScholarshipApplyVO getApplyList(String studentId, String grade, String major, String gradeClass, String userName, String type, String time, String sortKind, Integer nowPage, Integer pageSize);

    Integer deleteApplyById(Integer id);

    Integer getCount(String studentId, String grade, String major, String gradeClass, String userName, String type, String time);

    Integer updateApplyById(Integer id, String studentId, String grade, String major, String gradeClass, String userName, String type, Double jiaQuan, Double zongHe,
                            String caoXing, String jiaQuanClassRank, String jiaquanMajorRank, String zongHeClassRank, String description);
}
