package cn.iris.seckill.service;

import cn.iris.seckill.pojo.Order;
import cn.iris.seckill.pojo.User;
import cn.iris.seckill.vo.GoodsVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Iris 2022/4/20
 */
public interface IOrderService extends IService<Order> {

    /**
     * 用户秒杀
     * @param user
     * @param goodsVO
     * @return
     */
    Order secKill(User user, GoodsVO goodsVO);
}
