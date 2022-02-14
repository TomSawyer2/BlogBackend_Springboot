package com.hkx.modules.article.dto;

import com.hkx.modules.tag.model.Tags;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class UpdateArticleDto {
    @NotBlank
    private Integer id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private List<String> tags;

    @NotBlank
    private String brief;
}
