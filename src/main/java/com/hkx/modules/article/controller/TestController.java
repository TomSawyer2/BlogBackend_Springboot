package com.hkx.modules.article.controller;

import com.hkx.modules.article.model.Articles;
import com.hkx.modules.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/test")
    public Map testSpring() {
        HashMap<String, Object> res = new HashMap<>();
        res.put("data", 0);
        res.put("msg", "Hello World");
        return res;
    }
}
