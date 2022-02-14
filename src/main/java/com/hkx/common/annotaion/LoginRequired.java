package com.hkx.common.annotaion;

import com.hkx.common.enums.Permission;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginRequired {
    Permission[] needPermission();
}
