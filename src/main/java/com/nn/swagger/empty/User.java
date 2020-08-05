package com.nn.swagger.empty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName empty
 * @Author nn
 * @Date 2020/8/5 17:34
 */
@ApiModel("用户实体类")
public class User {
    @ApiModelProperty("用户ID")
    private Integer id;

    @ApiModelProperty("用户名称")
    private String name;

    public User() {
        this.id = 1;
        this.name = "小明";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
