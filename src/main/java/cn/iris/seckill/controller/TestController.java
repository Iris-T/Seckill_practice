package cn.iris.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试接口
 * @author Iris 2022/4/19
 */
@Controller
@RequestMapping("/test")
public class TestController {

    /**
     * 测试页面跳转
     */
    @RequestMapping("/hello")
    public String test(Model model) {
        model.addAttribute("name", "FoxIris");
        return "test";
    }
}
