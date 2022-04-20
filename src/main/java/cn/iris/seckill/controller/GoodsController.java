package cn.iris.seckill.controller;


import cn.iris.seckill.pojo.User;
import cn.iris.seckill.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Iris
 * @since 2022-04-19
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/toList")
    public String toList(HttpSession session, Model model, @CookieValue("UserLoginTicket") String ticket) {
        if (ObjectUtils.isEmpty(ticket)) {
            return "login";
        }
        User user = (User) session.getAttribute(ticket);
        if (null == user) {
            return "login";
        }
        model.addAttribute("user", user);
        model.addAttribute("goodsList", goodsService.findGoodsVO());
        return "goodsList";
    }
}
