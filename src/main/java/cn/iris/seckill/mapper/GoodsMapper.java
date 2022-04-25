package cn.iris.seckill.mapper;

import cn.iris.seckill.pojo.Goods;
import cn.iris.seckill.vo.GoodsVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Iris
 * @since 2022-04-19
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 获取商品列表信息
     * @return
     */
    List<GoodsVO> findGoodsVO();

    /**
     * 通过商品ID获取商品详情信息
     * @param goodId
     * @return
     */
    GoodsVO findGoodsVOByGoodsId(@Param("goodId") long goodId);
}
