package com.hkx.modules.article.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class UpdateTempArticleDto {
    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private List<String> tags;

    @NotBlank
    private String brief;

    @NotBlank
    private String haveTemp;
}
