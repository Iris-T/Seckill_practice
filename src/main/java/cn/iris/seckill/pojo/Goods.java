package cn.iris.seckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Iris
 * @since 2022-04-19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_goods")
@ApiModel(value = "Goods对象", description = "")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品标题")
    private String goodsTitle;

    @ApiModelProperty("商品图片")
    private String goodsImg;

    @ApiModelProperty("商品描述")
    private String goodsDetail;

    @ApiModelProperty("商品价格")
    private BigDecimal goodsPrice;

    @ApiModelProperty("商品库存,-1表示没有限制")
    private Integer goodsStock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }
    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }
    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    @Override
    public String toString() {
        return "Goods{" +
            "id=" + id +
            ", goodsName=" + goodsName +
            ", goodsTitle=" + goodsTitle +
            ", goodsImg=" + goodsImg +
            ", goodsDetail=" + goodsDetail +
            ", goodsPrice=" + goodsPrice +
            ", goodsStock=" + goodsStock +
        "}";
    }
}
