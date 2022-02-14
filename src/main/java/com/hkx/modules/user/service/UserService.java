package com.hkx.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hkx.modules.user.dto.LoginDto;
import com.hkx.modules.user.dto.RegisterDto;
import com.hkx.modules.user.model.User;

public interface UserService extends IService<User> {
    public Boolean register(RegisterDto registerDto);
    public String login(LoginDto loginDto);
}
