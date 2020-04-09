package com.example.demo.mapper;

import com.example.demo.entity.Scholarshiped;
import com.example.demo.vo.request.ScholarshipedRequestVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScholarshipedMapper {

    void addList(Integer[] ids);

    void updateList(Integer[] ids);

    void deleteList(Integer[] ids);

    List<Scholarshiped> getList(ScholarshipedRequestVO vo);

    Integer getCount(ScholarshipedRequestVO vo);

    Integer checkId(Integer id);

    List<Integer> getIdByApplyId(Integer[] ids);

    List<Scholarshiped> getScholarshipedList(ScholarshipedRequestVO vo);
}
