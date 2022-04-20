package cn.iris.seckill.service.impl;

import cn.iris.seckill.mapper.OrderMapper;
import cn.iris.seckill.pojo.Order;
import cn.iris.seckill.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Iris 2022/4/20
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
}
