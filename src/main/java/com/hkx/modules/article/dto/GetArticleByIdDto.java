package com.hkx.modules.article.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GetArticleByIdDto {
    @NotBlank
    private Integer id;
}
