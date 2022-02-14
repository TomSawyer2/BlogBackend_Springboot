package com.hkx.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hkx.common.api.ResultCode;
import com.hkx.common.exception.Asserts;
import com.hkx.common.util.JwtUtils;
import com.hkx.modules.tag.model.Tags;
import com.hkx.modules.user.dto.LoginDto;
import com.hkx.modules.user.dto.RegisterDto;
import com.hkx.modules.user.mapper.UserMapper;
import com.hkx.modules.user.model.User;
import com.hkx.modules.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public Boolean register(RegisterDto registerDto) {
        int userCount = baseMapper.selectCount(new LambdaQueryWrapper<User>().eq(User::getUserName, registerDto.getUserName()));
        if (userCount > 0) return false;
        else {
            User user = new User();
            BeanUtils.copyProperties(registerDto, user);
            String pwd = user.getPassword();
            user.setPassword(DigestUtils.md5DigestAsHex(pwd.getBytes()));
            baseMapper.insert(user);
            return true;
        }
    }

    @Override
    public String login(LoginDto loginDto) {
        User userCount = baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUserName, loginDto.getUserName()));
        if (userCount == null) Asserts.fail(ResultCode.USER_NOT_EXIST);
        if (userCount.getUserName().equals(loginDto.getUserName())) {
            if(userCount.getPassword().equals(DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes()))) {
                String token = jwtUtils.generateJwtToken(userCount.getId());
                return token;
            } else {
                Asserts.fail(ResultCode.PWD_ERR);
                return null;
            }
        }
        return null;
    }
}
