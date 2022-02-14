package com.hkx.modules.article.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SearchTempArticleVo {
    @NotBlank
    private Integer id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private String tags;

    @NotBlank
    private String brief;

    @NotBlank
    private String haveTemp;
}
