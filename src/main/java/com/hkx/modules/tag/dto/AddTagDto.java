package com.hkx.modules.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTagDto {
    @NotBlank
    private String name;

    @NotBlank
    private String color;
}
