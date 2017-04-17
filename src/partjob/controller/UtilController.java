package partjob.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import partjob.entity.District;
import partjob.entity.Labels;

@Controller
@RequestMapping("util")
public class UtilController {
	@RequestMapping("city/districts/{cityCode}")
	@ResponseBody
	public List<District> districtsByCity(@PathVariable int cityCode){
		List<District> districts = new ArrayList<District>();
		districts.add(new District(1000, "江宁区"));
		districts.add(new District(1001, "鼓楼区"));
		districts.add(new District(1002, "浦口区"));
		districts.add(new District(1003, "六合区"));
		districts.add(new District(1004, "栖霞区"));
		districts.add(new District(1005, "高淳区"));
		districts.add(new District(1006, "路口区"));
		districts.add(new District(1007, "仙林区"));
		return districts;
	}
	
	@RequestMapping("labels")
	@ResponseBody
	public List<Labels> labels(){
		List<Labels> labels = new ArrayList<Labels>();
		labels.add(new Labels(1000, "发单"));
		labels.add(new Labels(1001, "销售"));
		labels.add(new Labels(1002, "家教"));
		labels.add(new Labels(1003, "调研"));
		labels.add(new Labels(1004, "客服"));
		return labels;
	}
	
	@RequestMapping("sendCode")
	@ResponseBody
	public int sendCode(String phone){
		return 0;
	}
	

}
