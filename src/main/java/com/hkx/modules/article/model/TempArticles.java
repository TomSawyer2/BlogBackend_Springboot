package com.hkx.modules.article.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tempArticles")
public class TempArticles {

    @TableId(value = "id", type = IdType.AUTO)

    private Integer id;

    private String title;

    private String content;

    private String tags;

    private String brief;

    private String haveTemp;
}
