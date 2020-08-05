package com.nn.swagger.controller;

import com.nn.swagger.empty.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName SwaggerController
 * @Author nn
 * @Date 2020/8/4 20:30
 */
@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    @PostMapping("/hello")
    public Object hello() {
        return null;
    }

    @ApiOperation("测试 接口")
    @GetMapping("/test/{name}")
    public User test(@ApiParam("用户名") @PathVariable("name") String name) {
        User user = new User();
        user.setName(name);
        return user;
    }

}
