package com.hkx.modules.message.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReplyMessageDto {
    @NotBlank
    private Integer id;

    @NotBlank
    private String reply;
}
