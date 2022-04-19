package cn.iris.seckill.vo;

import cn.iris.seckill.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品详情返回对象
 *
 * @author: Iris
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailVO {


    private User user;

    private GoodsVO goodsVo;

    private int secKillStatus;

    private int remainSeconds;


}
