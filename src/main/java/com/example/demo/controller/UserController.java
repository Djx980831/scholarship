package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户接口", value = "实现用户的相关操作")
@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据id查询用户", notes = "根据id查询用户")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int")
    )
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public String getUser(@RequestBody String id) {
       return userService.getUser(id).toString();
    }

    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @RequestMapping(value = "/getAllUser", method = RequestMethod.POST)
    public String getAllUser() {
        return userService.getAllUser().toString();
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "string"),
            @ApiImplicitParam(name = "userName", value = "用户name", dataType = "string"),
            @ApiImplicitParam(name = "password", value = "用户password", dataType = "string"),
            @ApiImplicitParam(name = "realName", value = "用户realName", dataType = "string")
    })
    @PostMapping("/updateUserById")
    public String updateUserById(String id, String userName, String password, String realName){
        return userService.updateUserById(id, userName, password, realName).toString();
    }
}
