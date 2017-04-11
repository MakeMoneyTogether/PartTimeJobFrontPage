package partjob.controller;

import javax.sound.midi.MidiDevice.Info;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class PageController {

	@RequestMapping("/")
	public String index(){
		return "user/index";
	}
	
	@RequestMapping("test")
	public String test(){
		return "test";
	}
	@RequestMapping("list")
	public String list(){
		return "user/list";
	}
	@RequestMapping("info/{jid}")
	public String info(){
		return "user/info";
	}
	
	@RequestMapping("restful")
	@ResponseBody
	public String restful(){
		String res = "success";
		return res;
	}
}
