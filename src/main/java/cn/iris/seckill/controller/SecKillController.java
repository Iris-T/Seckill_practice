package cn.iris.seckill.controller;

import cn.iris.seckill.pojo.Order;
import cn.iris.seckill.pojo.SeckillOrder;
import cn.iris.seckill.pojo.User;
import cn.iris.seckill.service.IGoodsService;
import cn.iris.seckill.service.IOrderService;
import cn.iris.seckill.service.ISeckillOrderService;
import cn.iris.seckill.vo.GoodsVO;
import cn.iris.seckill.vo.RespBeanEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author Iris 2022/4/25
 */
@Controller
@RequestMapping("/secKill")
public class SecKillController {
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private ISeckillOrderService seckillOrderService;
    @Autowired
    private IOrderService orderService;

    /**
     * 用户秒杀
     * @param user    用户数据
     * @param goodsId 商品ID
     * @return        描述结果
     */
    @RequestMapping("/doSeckill")
    public String doSeckill(Model model, User user, long goodsId) {
        if (user == null) {
            return "login";
        }
        Date now = new Date();
        model.addAttribute("user", user);
        GoodsVO goodsVO = goodsService.findGoodsVOByGoodsId(goodsId);

        // 避免前端修改代码导致提前抢购或截止后抢购
        if (now.before(goodsVO.getStartDate()) || now.after(goodsVO.getEndDate())) {
            model.addAttribute("errmsg", RespBeanEnum.BUY_TIME_ERROR.getMessage());
            return "secKillFail";
        }

        // 判断库存
        if (goodsVO.getStockCount() < 1) {
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
        }
        // 判断订单
        SeckillOrder seckillOrder = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>()
                .eq("user_id", user.getId())
                .eq("goods_id", goodsId));
        // 订单存在
        if (seckillOrder != null) {
            model.addAttribute("errmsg", RespBeanEnum.REPEAT_ERROR.getMessage());
            return "secKillFail";
        }

        Order order = orderService.secKill(user, goodsVO);
        model.addAttribute("order", order);
        model.addAttribute("goods", goodsVO);
        return "orderDetail";
    }
}
