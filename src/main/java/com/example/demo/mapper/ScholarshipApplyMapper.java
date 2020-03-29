package com.example.demo.mapper;
;
import com.example.demo.entity.ScholarshipApply;
import com.example.demo.vo.request.ScholarshipApplyVORequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScholarshipApplyMapper {

    Integer addApply(ScholarshipApply apply);

    Integer getApplyIdByStudentIdAndCtime(String studentId, String time);

    String getStudentIdById(Integer id);

    ScholarshipApply getApplyById(Integer id);

    List<ScholarshipApply> getApplyList(ScholarshipApplyVORequest request);

    Integer deleteApplyById(Integer id);

    int getCount(ScholarshipApplyVORequest request);
}
