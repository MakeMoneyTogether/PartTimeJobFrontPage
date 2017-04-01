package partjob.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import partjob.entity.JZItem;

@Controller
@RequestMapping("jzurl")
public class JZController {

	@ResponseBody
	@RequestMapping("pages/{offset}/{length}")
	public List<JZItem> pages(@PathVariable int offset,@PathVariable int length,String dises,String labels,String dates){
		System.out.println(dises);
		System.out.println(labels);
		System.out.println(dates);
		List<JZItem> items = new ArrayList<JZItem>();
		for(int i=0;i<length;i++){
			items.add(new JZItem("实验室诏搬砖", "体力活", "江宁", "2017-05-01", "100", "天"));
		}
		return items;
	}
}
