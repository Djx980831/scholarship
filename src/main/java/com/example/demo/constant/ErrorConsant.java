package com.example.demo.constant;

import com.example.demo.util.ErrorInfo;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-17 23:22
 */
public class ErrorConsant {
    private ErrorConsant(){};

    public static final Integer SUCCESS_CODE = 0;


    /*
    user错误代码
     */
    public static final ErrorInfo PARAM_NOT_ENOUGH = new ErrorInfo(100, "缺少参数");

    public static final ErrorInfo PARAM_ERROR = new ErrorInfo(101, "参数错误");

    public static final ErrorInfo STUDENTID_IS_EXIST = new ErrorInfo(102, "学号已存在，请直接登陆");

    public static final ErrorInfo MOBILE_IS_EXIST = new ErrorInfo(103, "手机号已存在，请直接登陆");

    public static final ErrorInfo STUDENTID_IS_EMPTY = new ErrorInfo(104, "学号为空");

    public static final ErrorInfo MOBILE_IS_EMPTY = new ErrorInfo(105, "手机号为空");

    public static final ErrorInfo STUDENTID_OR_MOBILE_IS_EMPTY = new ErrorInfo(106, "学号或手机号不可为空");

    public static final ErrorInfo PASSWORD_IS_EMPTY = new ErrorInfo(107, "密码不可为空");

    public static final ErrorInfo LOGIN_ERROR = new ErrorInfo(108, "学号、手机号或密码不正确，请重新输入");

    public static final ErrorInfo ANSWER_IS_EMPTY = new ErrorInfo(109, "密保答案为空");

    public static final ErrorInfo STUDENTID_IS_ERROR = new ErrorInfo(110, "学号格式不对，学号以2开头的纯数字组成。");

    public static final ErrorInfo USER_MOBILE_IS_EXIST = new ErrorInfo(111, "手机号已存在，请重新输入。");

    public static final ErrorInfo USER_YANZHENGMA_IS_EMPTY = new ErrorInfo(112, "验证码为空。");

    public static final ErrorInfo USER_YANZHENGMA_IS_ERROR = new ErrorInfo(113, "验证码输入错误。。");

    public static final ErrorInfo ANSWER_IS_ERROR = new ErrorInfo(114, "密保答案错误");

    public static final ErrorInfo QUESTION_IS_EMPTY = new ErrorInfo(115, "密保问题为空");

    /*
    奖学金错误代码
     */
    public static final ErrorInfo ID_IS_EMPTY = new ErrorInfo(201, "奖学金id不可为空");

    public static final ErrorInfo LIMIT_IS_EMPTY = new ErrorInfo(202, "分页缺少当前页或页面大小");

    public static final ErrorInfo SCHOLARSHIP_ID_NOT_EXIST = new ErrorInfo(203, "该奖学金不存在");

    /*
    公告错误代码
     */
    public static final ErrorInfo CREATE_USER_ID_IS_EMPTY = new ErrorInfo(301, "创建者id不可为空");

    public static final ErrorInfo CONTENT_IS_EMPTY = new ErrorInfo(302, "公告内容不可为空");

    public static final ErrorInfo CONTENT_ID_IS_EMPTY = new ErrorInfo(303, "公告id不可为空");

    public static final ErrorInfo CONTENT_LIMIT_IS_EMPTY = new ErrorInfo(304, "分页缺少当前页或页面大小");

    public static final ErrorInfo CONTENT_NOT_EXIST = new ErrorInfo(305, "该公告不存在");

    /*
    申请奖学金错误代码
     */
    public static final ErrorInfo APPLY_PARAM_NOT_ENOUGH = new ErrorInfo(401, "申请奖学金参数不完整，请补充完全再提交申请");

    public static final ErrorInfo APPLY_LIMIT_NOT_ENOUGH = new ErrorInfo(402, "缺少分页参数");

    public static final ErrorInfo APPLY_SORT_NOT_ENOUGH = new ErrorInfo(403, "缺少默认排序参数");

    public static final ErrorInfo APPLY_NOT_EXIST = new ErrorInfo(404, "该申请id不存在");

    public static final ErrorInfo APPLY_ID_IS_EMPTY = new ErrorInfo(405, "申请id为空");

    public static final ErrorInfo APPLY_STUDENT_ID_IS_EMPTY = new ErrorInfo(405, "学生id为空");

    /*
    留言板错误代码
     */

    public static final ErrorInfo COMMENT_IS_EMPTY = new ErrorInfo(501, "留言内容不可为空");

    public static final ErrorInfo COMMENT_ID_IS_EMPTY = new ErrorInfo(502, "留言id不可为空");

    public static final ErrorInfo COMMENT_LIMIT_NOT_ENOUGH = new ErrorInfo(503, "缺少分页参数");

    public static final ErrorInfo COMMENT_IS_NOT_EXIST= new ErrorInfo(504, "该留言不存在");

    public static final ErrorInfo COMMENT_IS_ALL_EMPTY = new ErrorInfo(504, "没有任何留言");

    public static final ErrorInfo COMMENT_QUANXIAN_ERROR= new ErrorInfo(505, "没有权限进行删除操作");

    /*
    奖学金错误代码
     */

    public static final ErrorInfo ED_IDS_IS_EMPTY = new ErrorInfo(601, "未选中任何申请条目。");

    public static final ErrorInfo ED_APPLY_IS_EXIST = new ErrorInfo(602, "重复添加");

    public static final ErrorInfo ED_PARAM_IS_NOT_ENOUGH = new ErrorInfo(603, "缺少奖学金类型或年级");


    /*
    回复错误代码
     */

    public static final ErrorInfo REPLY_COMMENTID_IS_EMPTY = new ErrorInfo(701, "缺少评论id");

    public static final ErrorInfo REPLY_REPLYID_IS_EMPTY= new ErrorInfo(702, "缺少回复id");

    public static final ErrorInfo REPLY_REPLY_IS_EMPTY= new ErrorInfo(703, "缺少回复内容");

    public static final ErrorInfo REPLY_REPLYUSERNAME_IS_EMPTY= new ErrorInfo(704, "缺少回复用户名");

    public static final ErrorInfo REPLY_LIMIT_IS_EMPTY= new ErrorInfo(705, "缺少分页信息");

    public static final ErrorInfo REPLY_QUANXIAN_ERROR= new ErrorInfo(706, "没有权限进行删除操作");

}
