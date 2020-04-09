package com.example.demo.controller;

import com.example.demo.service.ScholarshipedService;
import com.example.demo.util.ParamUtil;
import com.example.demo.util.RpcResponse;
import com.example.demo.vo.response.ScholarshipedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.constant.ErrorConsant.*;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-04-09 15:21
 */
@RestController
@RequestMapping("/scholarshiped")
public class ScholarshipedController {

    @Autowired
    private ScholarshipedService service;

    @PostMapping("/addList")
    public RpcResponse<Integer[]> addList(Integer[] ids) {
        if (ids.length == 0) {
            return RpcResponse.error(ED_IDS_IS_EMPTY);
        }
        List<Integer> existIds = new ArrayList<>();
        for (Integer id : ids) {
            if (service.checkId(id) != null) {
                existIds.add(id);
            }
        }
        if (!existIds.isEmpty()) {
            Integer[] idsRes = new Integer[existIds.size()];
            for (int i = 0; i < idsRes.length; i++) {
                idsRes[i] = existIds.get(i);
            }
            return RpcResponse.error(ED_APPLY_IS_EXIST, idsRes);
        }
        Integer[] idsList = service.addList(ids);
        return RpcResponse.success(idsList);
    }

    @PostMapping("/deleteList")
    public RpcResponse<Integer[]> deleteList(Integer[] ids) {
        if (ids.length == 0) {
            return RpcResponse.error(ED_IDS_IS_EMPTY);
        }
        Integer[] idsList = service.deleteList(ids);
        return RpcResponse.success(idsList);
    }

    @PostMapping("/getList")
    public RpcResponse<ScholarshipedVO> getList(String year, String grade, String major, String type, String sortKind, Integer nowPage, Integer pageSize) {
        if (!ParamUtil.checkString(sortKind)) {
            return RpcResponse.error(APPLY_SORT_NOT_ENOUGH);
        }
        if (!ParamUtil.checkNumbers(nowPage, pageSize)) {
            return RpcResponse.error(COMMENT_LIMIT_NOT_ENOUGH);
        }

        return RpcResponse.success(service.getList(year, grade, major, type, sortKind, nowPage, pageSize));
    }
}

