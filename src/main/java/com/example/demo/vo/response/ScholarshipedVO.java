package com.example.demo.vo.response;

import com.example.demo.util.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-04-08 23:33
 */
@Data
public class ScholarshipedVO {
    private PageInfo pageInfo;
    private List<ScholarshipedVo> scholarshipedVoList;

    @Data
    public static class ScholarshipedVo{
        private Integer id;
        private Integer applyId;
        private String studentId;
        private String userName;
        private String year;
        private String grade;
        private String major;
        private String gradeClass;
        private String type;
        private Double jiaQuan;
        private Double zongHe;
        private String caoXIng;
    }

}
