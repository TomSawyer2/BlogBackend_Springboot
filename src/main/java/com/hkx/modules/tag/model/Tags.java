package com.hkx.modules.tag.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tags")
public class Tags {

    @TableId(value = "id", type = IdType.AUTO)

    private Integer id;

    private String name;

    private String color;

    private Integer value;

    private String imgUrl;
}