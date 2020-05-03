package com.example.demo.vo.response;

import com.example.demo.util.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-31 23:12
 */
@Data
public class ReplyVO {

    private PageInfo pageInfo;
    private List<ReplyVo> replyVoList;

    @Data
    public static class ReplyVo{
        private Integer id;
        private Integer commentId;
        private String replyUserName;
        private String reply;
        private String createTime;
    }
}
