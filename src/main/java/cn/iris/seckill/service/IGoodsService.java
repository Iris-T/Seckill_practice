package cn.iris.seckill.service;

import cn.iris.seckill.pojo.Goods;
import cn.iris.seckill.vo.GoodsVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Iris
 * @since 2022-04-19
 */
public interface IGoodsService extends IService<Goods> {

    /**
     * 获取商品列表
     * @return List-GoodsVO
     */
    List<GoodsVO> findGoodsVO();

    /**
     * 通过goodsId获取商品详情
     * @param goodId 商品ID
     * @return 商品详情信息
     */
    GoodsVO findGoodsVOByGoodsId(long goodId);
}
