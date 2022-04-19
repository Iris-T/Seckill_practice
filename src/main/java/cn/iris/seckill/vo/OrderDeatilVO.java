package cn.iris.seckill.vo;

import cn.iris.seckill.pojo.SeckillOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单详情返回对象
 *
 * @author: Iris
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDeatilVO {

    private SeckillOrder order;

    private GoodsVO goodsVo;
}
