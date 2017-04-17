package partjob.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import partjob.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import partjob.entity.JZItem;

@Controller
@RequestMapping("jzurl")
public class JZController {
		
	@ResponseBody
	@RequestMapping("pages/select/{offset}/{length}")
	public List<JZItem> select(@PathVariable int offset,@PathVariable int length,String dises,String labels,String dates,String city){
		System.out.println(dises);
		System.out.println(labels);
		System.out.println(dates);
		System.out.println(city);

		String disesall[] = {"江宁区","鼓楼区","浦口区","六合区","栖霞区","高淳区","路口区","仙林区"};
		String labelsall[] = {"发单","销售","家教","调研","客服"};
		String jznames[] = {"诚聘贴棉包布刷胶水人员","北京展会兼职","电销助理","孝心大使招募","财务助理","英语兼职-英语写手","兼职UI设计师","发单员","问卷调查员","兼职英语助教","宁波和公馆招聘模特","急聘业余假期工作","商品销售","大学生课间兼职","网易自营项目兼职","中科院招聘兼职人员","大学生校区招生代理","传单派发等","手机App试玩兼职","校园推广员","婚礼布置","招募校园销售代表","外婆家招服务员","西安嘉旅俱乐部","高薪诚聘大学生兼职","幼儿美术助教老师","app推广","宁波百健医疗科技有限公司","课程顾问"};
		int jzn = jznames.length;
		int disn = 8;
		int labeln = 5;
		if(!dises.equals("all")){
			disesall = dises.split(",");
			disn = disesall.length;
		}
		if(!labels.equals("all")){
			labelsall = labels.split(",");
			labeln = labelsall.length;
		}
		List<JZItem> items = new ArrayList<JZItem>();
		Random random = new Random();
		for(int i=0;i<length;i++){
			items.add(new JZItem(random.nextInt(100000),jznames[random.nextInt(jzn)], labelsall[random.nextInt(labeln)], disesall[random.nextInt(disn)], "2017-05-01", "100", "天"));
		}
		return items;
	}
	
	@ResponseBody
	@RequestMapping("pages/search/{offset}/{length}")
	public List<JZItem> search(@PathVariable int offset,@PathVariable int length,String keys,String city){
		System.out.println(keys);
		System.out.println(city);

		String disesall[] = {"江宁区","鼓楼区","浦口区","六合区","栖霞区","高淳区","路口区","仙林区"};
		String labelsall[] = {"发单","销售","家教","调研","客服"};
		String jznames[] = {"诚聘贴棉包布刷胶水人员","北京展会兼职","电销助理","孝心大使招募","财务助理","英语兼职-英语写手","兼职UI设计师","发单员","问卷调查员","兼职英语助教","宁波和公馆招聘模特","急聘业余假期工作","商品销售","大学生课间兼职","网易自营项目兼职","中科院招聘兼职人员","大学生校区招生代理","传单派发等","手机App试玩兼职","校园推广员","婚礼布置","招募校园销售代表","外婆家招服务员","西安嘉旅俱乐部","高薪诚聘大学生兼职","幼儿美术助教老师","app推广","宁波百健医疗科技有限公司","课程顾问"};
		int jzn = jznames.length;
		int disn = 8;
		int labeln = 5;
		List<JZItem> items = new ArrayList<JZItem>();
		Random random = new Random();
		for(int i=0;i<length;i++){
			items.add(new JZItem(random.nextInt(100000),keys+ jznames[random.nextInt(jzn)], labelsall[random.nextInt(labeln)], disesall[random.nextInt(disn)], "2017-05-01", "100", "天"));
		}
		return items;
	}
	
	@ResponseBody
	@RequestMapping("pages/item/{jid}")
	public JZItem item(@PathVariable int jid){
		String disesall[] = {"江宁区","鼓楼区","浦口区","六合区","栖霞区","高淳区","路口区","仙林区"};
		String labelsall[] = {"发单","销售","家教","调研","客服"};
		String jznames[] = {"诚聘贴棉包布刷胶水人员","北京展会兼职","电销助理","孝心大使招募","财务助理","英语兼职-英语写手","兼职UI设计师","发单员","问卷调查员","兼职英语助教","宁波和公馆招聘模特","急聘业余假期工作","商品销售","大学生课间兼职","网易自营项目兼职","中科院招聘兼职人员","大学生校区招生代理","传单派发等","手机App试玩兼职","校园推广员","婚礼布置","招募校园销售代表","外婆家招服务员","西安嘉旅俱乐部","高薪诚聘大学生兼职","幼儿美术助教老师","app推广","宁波百健医疗科技有限公司","课程顾问"};
		int jzn = jznames.length;
		int disn = 8;
		int labeln = 5;
		Random random = new Random();
		JZItem jzItem = new JZItem(jid,jznames[random.nextInt(jzn)], labelsall[random.nextInt(labeln)], disesall[random.nextInt(disn)], "2017-05-01", "100", "天");
		return jzItem;
	}
	@ResponseBody
	@RequestMapping("pages/sitem/{uid}/{statuId}")
	public List<JZItem> userJZ(@PathVariable int uid,@PathVariable int statuId){
		String disesall[] = {"江宁区","鼓楼区","浦口区","六合区","栖霞区","高淳区","路口区","仙林区"};
		String labelsall[] = {"发单","销售","家教","调研","客服"};
		String jznames[] = {"诚聘贴棉包布刷胶水人员","北京展会兼职","电销助理","孝心大使招募","财务助理","英语兼职-英语写手","兼职UI设计师","发单员","问卷调查员","兼职英语助教","宁波和公馆招聘模特","急聘业余假期工作","商品销售","大学生课间兼职","网易自营项目兼职","中科院招聘兼职人员","大学生校区招生代理","传单派发等","手机App试玩兼职","校园推广员","婚礼布置","招募校园销售代表","外婆家招服务员","西安嘉旅俱乐部","高薪诚聘大学生兼职","幼儿美术助教老师","app推广","宁波百健医疗科技有限公司","课程顾问"};
		int jzn = jznames.length;
		int disn = 8;
		int labeln = 5;
		List<JZItem> items = new ArrayList<JZItem>();
		Random random = new Random();
		int n = random.nextInt(10)+5;
		for(int i=0;i<n;i++){
			items.add(new JZItem(random.nextInt(100000),jznames[random.nextInt(jzn)], labelsall[random.nextInt(labeln)], disesall[random.nextInt(disn)], "2017-05-01", "100", "天"));
		}
		return items;
	}
	
	@ResponseBody
	@RequestMapping("pages/u2j/{phone}/{jid}")
	public int jz2userStatu(@PathVariable String phone,@PathVariable int jid){
		System.out.println(phone);
		System.out.println(jid);
		Random random = new Random();
		return random.nextInt(5);
	}
	
	@ResponseBody
	@RequestMapping("pages/apply/{phone}/{jid}")
	public Map<String, Integer> apply(@PathVariable String phone,@PathVariable int jid){
		Map<String, Integer> res = new HashMap<String, Integer>();
		Random random = new Random();
		int code = random.nextInt(4);
		int all = random.nextInt(10)+5;
		if(code == 1){
			res.put("code", code);
			res.put("applied", all);
			res.put("all", all);
		}else {
			int num = random.nextInt(all);
			res.put("code", code);
			res.put("applied", num);
			res.put("all", all);
		}
		return res;
	}

}
