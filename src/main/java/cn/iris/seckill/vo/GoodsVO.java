package cn.iris.seckill.vo;

import cn.iris.seckill.pojo.Goods;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品返回对象
 * @author: Iris
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel("商品返回对象")
public class GoodsVO extends Goods {

    /**
     * 秒杀价格
     **/
    @ApiModelProperty("秒杀价格")
    private BigDecimal seckillPrice;

    /**
     * 剩余数量
     **/
    @ApiModelProperty("剩余数量")
    private Integer stockCount;

    /**
     * 开始时间
     **/
    @ApiModelProperty("开始时间")
    private Date startDate;

    /**
     * 结束时间
     **/
    @ApiModelProperty("结束时间")
    private Date endDate;
}

