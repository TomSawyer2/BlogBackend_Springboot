package com.hkx.modules.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddArticleDto {
    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private List<String> tags;

    @NotBlank
    private String update_time;

    @NotBlank
    private String brief;
}
