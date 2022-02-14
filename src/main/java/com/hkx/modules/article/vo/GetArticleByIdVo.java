package com.hkx.modules.article.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GetArticleByIdVo {
    @NotBlank
    private Integer id;

    @NotBlank
    private String title;

    @NotBlank
    private String Brief;

    @NotBlank
    private String updateTime;

    @NotBlank
    private String content;

    @NotBlank
    private String tags;

    @NotBlank
    private String haveLike;

    @NotBlank
    private String likes;
}
