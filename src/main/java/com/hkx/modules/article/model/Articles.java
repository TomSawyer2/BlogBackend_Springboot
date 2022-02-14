package com.hkx.modules.article.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("articles")
public class Articles {

    @TableId(value = "id", type = IdType.AUTO)

    private Integer id;

    private String title;

    private String content;

    private String likes;

    private Integer comments;

    private String tags;

    private String updateTime;

    private String brief;

    private String haveLike;
}
