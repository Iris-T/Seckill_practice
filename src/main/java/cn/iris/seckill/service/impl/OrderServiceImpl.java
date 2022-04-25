package cn.iris.seckill.service.impl;

import cn.iris.seckill.mapper.OrderMapper;
import cn.iris.seckill.pojo.Order;
import cn.iris.seckill.pojo.SeckillGoods;
import cn.iris.seckill.pojo.SeckillOrder;
import cn.iris.seckill.pojo.User;
import cn.iris.seckill.service.IOrderService;
import cn.iris.seckill.service.ISeckillGoodsService;
import cn.iris.seckill.service.ISeckillOrderService;
import cn.iris.seckill.vo.GoodsVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Iris 2022/4/20
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Autowired
    private ISeckillGoodsService seckillGoodsService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ISeckillOrderService seckillOrderService;

    /**
     * 秒杀
     *
     * @param user
     * @param goodsVO
     * @return
     */
    @Override
    public Order secKill(User user, GoodsVO goodsVO) {
        // 减库存
        SeckillGoods seckillGoods = seckillGoodsService.getOne(new QueryWrapper<SeckillGoods>()
                .eq("goods_id", goodsVO.getId()));
        seckillGoods.setStockCount(seckillGoods.getStockCount() - 1);
        seckillGoodsService.updateById(seckillGoods);

        // 生成订单
        Order order = new Order();
        order.setUserId(user.getId());
        order.setGoodsId(goodsVO.getId());
        order.setDeliveryAddrId(0L);
        order.setGoodsName(goodsVO.getGoodsName());
        order.setGoodsCount(1);
        order.setGoodsPrice(seckillGoods.getSeckillPrice());
        order.setOrderChannel(1);
        order.setStatus(0);
        order.setCreateDate(new Date());
        orderMapper.insert(order);

        // 生成秒杀订单
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setUserId(user.getId());
        seckillOrder.setOrderId(order.getId());
        seckillOrder.setGoodsId(goodsVO.getId());
        seckillOrderService.save(seckillOrder);

        return order;
    }
}
