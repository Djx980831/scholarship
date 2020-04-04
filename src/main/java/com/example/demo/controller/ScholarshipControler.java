package com.example.demo.controller;

import com.example.demo.service.ScholarshipService;
import com.example.demo.util.ParamUtil;
import com.example.demo.util.RpcResponse;
import com.example.demo.vo.response.ScholarshipVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static com.example.demo.constant.ErrorConsant.*;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-20 21:27
 */
@RestController
@RequestMapping("/scholarship")
public class ScholarshipControler {

    @Autowired
    private ScholarshipService service;

    @PostMapping("/addScholarship")
    public RpcResponse<Integer> addScholarship(String name, Integer money, Integer count, String classCount, String description) {
        if (!ParamUtil.checkString(name, classCount, description)) {
            return RpcResponse.error(PARAM_NOT_ENOUGH);
        }
        if (!ParamUtil.checkNumbers(money, count)) {
            return RpcResponse.error(PARAM_NOT_ENOUGH);
        }

        return RpcResponse.success(service.addScholarship(name, money, count, classCount, description));
    }

    @PostMapping("/deleteScholarship")
    public RpcResponse<Integer> deleteScholarship(Integer id) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(ID_IS_EMPTY);
        }
        if (service.getScholarshipbyId(id) == null) {
            return RpcResponse.error(SCHOLARSHIP_ID_NOT_EXIST);
        }

        return RpcResponse.success(service.deleteScholarship(id));
    }

    @PostMapping("/getAllScholarship")
    public RpcResponse<ScholarshipVO> getAllScholarship(Integer nowPage, Integer pageSize) {
        if (!ParamUtil.checkNumbers(nowPage, pageSize)) {
            return RpcResponse.error(LIMIT_IS_EMPTY);
        }
        return RpcResponse.success(service.getAllScholarship(nowPage, pageSize));
    }

    @PostMapping("/updateScholarshipById")
    public RpcResponse<Integer> updateScholarshipById(Integer id, String name, Integer money, Integer count, String classCount, String description) {
        if (!ParamUtil.checkString(name, classCount, description)) {
            return RpcResponse.error(PARAM_NOT_ENOUGH);
        }
        if (!ParamUtil.checkNumbers(id, money, count)) {
            return RpcResponse.error(PARAM_NOT_ENOUGH);
        }
        return RpcResponse.success(service.updateScholarshipById(id, name, money, count, classCount, description));
    }

    @PostMapping("/getScholarshipbyId")
    public RpcResponse<ScholarshipVO.ScholarshipVo> getScholarshipbyId(Integer id) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(ID_IS_EMPTY);
        }
        if (service.getScholarshipbyId(id) == null) {
            return RpcResponse.error(SCHOLARSHIP_ID_NOT_EXIST);
        }
        return RpcResponse.success(service.getScholarshipbyId(id));
    }
}
