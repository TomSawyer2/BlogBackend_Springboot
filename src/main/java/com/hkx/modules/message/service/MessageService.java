package com.hkx.modules.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hkx.modules.message.dto.AddMessageDto;
import com.hkx.modules.message.dto.DeleteMessageDto;
import com.hkx.modules.message.dto.ReplyMessageDto;
import com.hkx.modules.message.model.Message;
import com.hkx.modules.message.vo.AddMessageVo;

import java.util.List;

public interface MessageService extends IService<Message> {
    public List<Message> getAllMessages();
    public AddMessageVo addMessage(AddMessageDto addMessageDto);
    public void replyMessage(ReplyMessageDto replyMessageDto);
    public void deleteMessage(DeleteMessageDto deleteMessageDto);
}
