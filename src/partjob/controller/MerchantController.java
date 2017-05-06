package partjob.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/merurl/json")
public class MerchantController {
	@RequestMapping("me")
	@ResponseBody
	public Map<String, Object> me(String phone,String password){
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("mname", "我是商户的名称");
		res.put("moneyable", 1000.00);
		res.put("moneyice", 200.00);
		return res;
	}
}
