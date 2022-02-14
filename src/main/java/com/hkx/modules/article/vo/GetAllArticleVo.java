package com.hkx.modules.article.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllArticleVo {
    @NotBlank
    private Integer id;

    @NotBlank
    private String title;

    @NotBlank
    private String Brief;

    @NotBlank
    private String updateTime;

    @NotBlank
    private String tags;

    @NotBlank
    private String haveLike;

    @NotBlank
    private String likes;

}
