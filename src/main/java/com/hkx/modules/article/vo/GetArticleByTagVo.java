package com.hkx.modules.article.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GetArticleByTagVo {
    @NotBlank
    private Integer id;

    @NotBlank
    private String title;

    @NotBlank
    private String brief;

    @NotBlank
    private String tags;

    @NotBlank
    private String updateTime;
}
