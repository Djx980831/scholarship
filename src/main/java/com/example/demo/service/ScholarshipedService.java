package com.example.demo.service;

import com.example.demo.vo.response.ScholarshipedVO;

import java.util.List;

public interface ScholarshipedService {

    Integer[] addList(Integer[] ids);

    Integer[] deleteList(Integer[] ids);

    ScholarshipedVO getList(String year, String grade, String major, String type, String sortKind, Integer nowPage, Integer pageSize);

    Integer checkId(Integer id);

    List<Integer> getIdByApplyId(Integer[] ids);
}
