package com.example.demo.vo.response;

import com.example.demo.util.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-29 22:12
 */
@Data
public class ScholarshipApplyVO {

    private PageInfo pageInfo;
    private List<ScholarshipApplyVo> scholarshipApplyVoList;

    @Data
    public static class ScholarshipApplyVo{
        private Integer id;
        private String studentId;
        private String grade;
        private String major;
        private String gradeClass;
        private String userName;
        private String type;
        private Integer flag;
        private Double jiaQuan;
        private Double zongHe;
        private String caoXing;
        private String jiaQuanClassRank;
        private String jiaquanMajorRank;
        private String zongHeClassRank;
        private String description;
    }
}
