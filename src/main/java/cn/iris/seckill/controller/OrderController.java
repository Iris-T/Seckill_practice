package cn.iris.seckill.controller;


import cn.iris.seckill.pojo.User;
import cn.iris.seckill.service.IOrderService;
import cn.iris.seckill.vo.OrderDeatilVO;
import cn.iris.seckill.vo.RespBean;
import cn.iris.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Iris
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	/**
	 * 功能描述: 订单详情
	 */
//	@RequestMapping("/detail")
//	@ResponseBody
//	public RespBean detail(User user, Long orderId) {
//		if (user == null) {
//			return RespBean.error(RespBeanEnum.SESSION_ERROR);
//		}
//		OrderDeatilVO detail = orderService.detail(orderId);
//		return RespBean.success(detail);
//	}

}
