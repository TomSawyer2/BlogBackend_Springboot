package com.hkx.modules.article.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GetArticleByTagDto {
    @NotBlank
    private String tag;
}
