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

import partjob.entity.JZItem;

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
	
	@RequestMapping("issue")
	@ResponseBody
	public int issue(String hourOfDay){
		System.out.println("hourOfDay = "+hourOfDay);
		if(hourOfDay == hourOfDay){
			return 1;
		}
		return 10086;
	}
	
	@RequestMapping("jzs")
	@ResponseBody
	public List<JZItem> jzsByPhone(String phone){
		String disesall[] = {"江宁区","鼓楼区","浦口区","六合区","栖霞区","高淳区","路口区","仙林区"};
		String labelsall[] = {"发单","销售","家教","调研","客服"};
		String jznames[] = {"诚聘贴棉包布刷胶水人员","北京展会兼职","电销助理","孝心大使招募","财务助理","英语兼职-英语写手","兼职UI设计师","发单员","问卷调查员","兼职英语助教","宁波和公馆招聘模特","急聘业余假期工作","商品销售","大学生课间兼职","网易自营项目兼职","中科院招聘兼职人员","大学生校区招生代理","传单派发等","手机App试玩兼职","校园推广员","婚礼布置","招募校园销售代表","外婆家招服务员","西安嘉旅俱乐部","高薪诚聘大学生兼职","幼儿美术助教老师","app推广","宁波百健医疗科技有限公司","课程顾问"};
		int jzn = jznames.length;
		int disn = disesall.length;
		int labeln = labelsall.length;
		List<JZItem> items = new ArrayList<JZItem>();
		Random random = new Random();
		for(int i=0;i<20;i++){
			JZItem item = new JZItem(random.nextInt(100000),jznames[random.nextInt(jzn)], labelsall[random.nextInt(labeln)], disesall[random.nextInt(disn)], "2017-05-01", "100", "天");
			item.setJstatu(random.nextInt(5));
			items.add(item);
		}
		return items;
	}
}
