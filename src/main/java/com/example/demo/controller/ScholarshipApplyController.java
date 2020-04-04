package com.example.demo.controller;

import com.example.demo.entity.ScholarshipApply;
import com.example.demo.service.ScholarshipApplyService;
import com.example.demo.util.ParamUtil;
import com.example.demo.util.RpcResponse;
import com.example.demo.vo.response.ScholarshipApplyVO;
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
 * @Date 2020-03-29 22:40
 */
@RestController
@RequestMapping("/apply")
public class ScholarshipApplyController {

    @Autowired
    private ScholarshipApplyService service;

    @PostMapping("/addApply")
    public RpcResponse<Integer> addApply(String studentId, String grade, String major, String gradeClass, String userName, String type, Double jiaQuan, Double zongHe, String caoXing, String jiaQuanClassRank, String jiaquanMajorRank, String zongHeClassRank, String description) {
        if (!ParamUtil.checkString(studentId, grade, major, gradeClass, userName, type, caoXing, jiaQuanClassRank, jiaquanMajorRank, zongHeClassRank)) {
            return RpcResponse.error(APPLY_PARAM_NOT_ENOUGH);
        }
        if (!ParamUtil.checkDouble(jiaQuan, zongHe)) {
            return RpcResponse.error(APPLY_PARAM_NOT_ENOUGH);
        }
        return RpcResponse.success(service.addApply(studentId, grade, major, gradeClass, userName, type, jiaQuan, zongHe, caoXing, jiaQuanClassRank, jiaquanMajorRank, zongHeClassRank, description));
    }

    @PostMapping("/getApplyList")
    public RpcResponse<ScholarshipApplyVO> getApplyList(String studentId, String grade, String major, String gradeClass, String userName, String type, String time, String sortKind, Integer nowPage, Integer pageSize) {
        if (!ParamUtil.checkNumbers(nowPage, pageSize)) {
            return RpcResponse.error(APPLY_LIMIT_NOT_ENOUGH);
        }
        if (!ParamUtil.checkString(sortKind)) {
            return RpcResponse.error(APPLY_SORT_NOT_ENOUGH);
        }
        return RpcResponse.success(service.getApplyList(studentId, grade, major, gradeClass, userName, type, time, sortKind, nowPage, pageSize));
    }

    @PostMapping("/deleteApplyById")
    public RpcResponse<Integer> deleteApplyById(Integer id) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(APPLY_ID_IS_EMPTY);
        }
        Integer res = service.deleteApplyById(id);
        if (res  == null) {
            return RpcResponse.error(APPLY_NOT_EXIST);
        }
        return RpcResponse.success(res);
    }

    @PostMapping("/getApplyIdByStudentIdAndCtime")
    public RpcResponse<Integer> getApplyIdByStudentIdAndCtime(String studentId) {
        if (!ParamUtil.checkString(studentId)) {
            return RpcResponse.error(APPLY_STUDENT_ID_IS_EMPTY);
        }
        return RpcResponse.success(service.getApplyIdByStudentIdAndCtime(studentId));
    }

    @PostMapping("/getStudentIdById")
    public RpcResponse<String> getStudentIdById(Integer id) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(APPLY_ID_IS_EMPTY);
        }
        return RpcResponse.success(service.getStudentIdById(id));
    }

    @PostMapping("/getApplyById")
    public RpcResponse<ScholarshipApply> getApplyById(Integer id) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(APPLY_ID_IS_EMPTY);
        }
        ScholarshipApply apply = service.getApplyById(id);
        if (apply == null) {
            return RpcResponse.error(APPLY_NOT_EXIST);
        }
        return RpcResponse.success(apply);
    }

    @PostMapping("/updateApplyById")
    public RpcResponse<Integer> updateApplyById(Integer id, String studentId, String grade, String major, String gradeClass, String userName, String type, Double jiaQuan, Double zongHe,
                                                String caoXing, String jiaQuanClassRank, String jiaquanMajorRank, String zongHeClassRank, String description) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(APPLY_ID_IS_EMPTY);
        }
        if (!ParamUtil.checkString(studentId, grade, major, gradeClass, userName, type, caoXing, jiaQuanClassRank, jiaquanMajorRank, zongHeClassRank, description)) {
            return RpcResponse.error(APPLY_PARAM_NOT_ENOUGH);
        }
        if (!ParamUtil.checkDouble(jiaQuan, zongHe)) {
            return RpcResponse.error(APPLY_PARAM_NOT_ENOUGH);
        }
        return RpcResponse.success(service.updateApplyById(id, studentId, grade, major, gradeClass, userName, type, jiaQuan, zongHe, caoXing, jiaQuanClassRank, jiaquanMajorRank, zongHeClassRank, description));
    }
 }
