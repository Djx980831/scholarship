package com.example.demo.vo.response;

import com.example.demo.util.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-22 22:45
 */
@Data
public class ScholarshipVO {

    private PageInfo pageInfo;
    private List<ScholarshipVo> scholarshipVoList;

    @Data
    public static class ScholarshipVo{
        private Integer id;
        private String name;
        private Integer money;
        private Integer count;
        private String classCount;
        private String description;
    }
}
