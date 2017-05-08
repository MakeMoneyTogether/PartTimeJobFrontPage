package partjob.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
		res.put("mname", "河海大学兼职平台");
		res.put("moneyable", 1000.00);
		res.put("moneyice", 200.00);
		return res;
	}
	@RequestMapping("update")
	@ResponseBody
	public int update(String citycode){
		System.out.println("citycode == null? "+citycode == null);
		if(citycode == null)
			return 0;
		return 1;
	}
	
	@RequestMapping("merme")
	@ResponseBody
	public Map<String, String> merinfo(String phone){
		Map<String, String> res = new HashMap<String, String>();
		res.put("mname","河海大学兼职平台");
		res.put("local","佛城西路8号");
		res.put("connectname","王乘");
		res.put("phone","10086");
		return res;
	}
	
	@RequestMapping("schedule")
	@ResponseBody
	public List<Map<String, Integer>> schedule(String phone){
		List<Map<String, Integer>> res = new ArrayList<Map<String,Integer>>();
		Random random = new Random();
		int n = random.nextInt(10)+5;
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		int idpre = cal.get(Calendar.YEAR)*10000+cal.get(Calendar.MONTH)*100+cal.get(Calendar.DATE);
		for(int i=0;i<n;i++){
			Map<String, Integer> item = new HashMap<String, Integer>();
			item.put("id", idpre*10+i);
			item.put("money", random.nextInt(100)+100);
			int statu = random.nextInt(3);
			item.put("statu", statu);
			res.add(item);
		}
		return res;
	}
}
