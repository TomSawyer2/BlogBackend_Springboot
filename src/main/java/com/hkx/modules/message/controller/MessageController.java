package com.hkx.modules.message.controller;

import com.hkx.common.annotaion.LoginRequired;
import com.hkx.common.api.CommonResult;
import com.hkx.common.enums.Permission;
import com.hkx.modules.message.dto.AddMessageDto;
import com.hkx.modules.message.dto.DeleteMessageDto;
import com.hkx.modules.message.dto.ReplyMessageDto;
import com.hkx.modules.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/getAllMessages")
    public CommonResult getAllMessages() {
        return CommonResult.success(messageService.getAllMessages());
    }

    @PostMapping("/addMessage")
    @LoginRequired(needPermission = Permission.USER)
    public CommonResult addMessage(@RequestBody AddMessageDto addMessageDto) {
        return CommonResult.success(messageService.addMessage(addMessageDto));
    }

    @PostMapping("/replyMessage")
    public CommonResult replyMessage(@RequestBody ReplyMessageDto replyMessageDto) {
        messageService.replyMessage(replyMessageDto);
        return CommonResult.success(null, "回复成功");
    }

    @PostMapping("/deleteMessage")
    public CommonResult deleteMessage(@RequestBody DeleteMessageDto deleteMessageDto) {
        messageService.deleteMessage(deleteMessageDto);
        return CommonResult.success(null, "回复删除成功");
    }
}
