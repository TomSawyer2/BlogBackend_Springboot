package com.hkx.modules.message.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DeleteMessageDto {
    @NotBlank
    private Integer id;
}
