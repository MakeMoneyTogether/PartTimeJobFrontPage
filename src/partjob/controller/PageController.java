package partjob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class PageController {

	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("test")
	public String test(){
		return "test";
	}
	
	@RequestMapping("restful")
	@ResponseBody
	public String restful(){
		String res = "success";
		return res;
	}
}
