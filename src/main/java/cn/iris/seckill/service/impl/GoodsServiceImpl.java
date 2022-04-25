package cn.iris.seckill.service.impl;

import cn.iris.seckill.pojo.Goods;
import cn.iris.seckill.mapper.GoodsMapper;
import cn.iris.seckill.service.IGoodsService;
import cn.iris.seckill.vo.GoodsVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Iris
 * @since 2022-04-19
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 获取商品列表信息
     * @return List-GoodsVO
     */
    @Override
    public List<GoodsVO> findGoodsVO() {
        return goodsMapper.findGoodsVO();
    }

    /**
     * 通过商品ID获取商品详情信息
     * @param goodId 商品ID
     * @return 商品详情信息
     */
    @Override
    public GoodsVO findGoodsVOByGoodsId(long goodId) {
        return goodsMapper.findGoodsVOByGoodsId(goodId);
    }
}
