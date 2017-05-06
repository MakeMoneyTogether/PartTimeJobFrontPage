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
		return "mer/index";
	}
	
	@RequestMapping("user")
	public String user(){
		return "user/index";
	}

	@RequestMapping("user/net")
	public String net(){
		return "user/net";
	}
	
	@RequestMapping("test")
	public String test(){
		return "test";
	}
	@RequestMapping("user/list")
	public String list(){
		return "user/list";
	}
	@RequestMapping("user/info/{jid}")
	public String info(){
		return "user/info";
	}
	@RequestMapping("user/netinfo/{jid}")
	public String netinfo(){
		return "user/netinfo";
	}
	
	@RequestMapping("user/me")
	public String me(){
		return "user/me";
	}
	
	@RequestMapping("user/login")
	public String login(){
		return "user/login";
	}

	@RequestMapping("user/register")
	public String register(){
		return "user/register";
	}
	
	@RequestMapping("user/editcv")
	public String editCV(){
		return "user/editcv";
	}
	
	@RequestMapping("user/wallet")
	public String wallet(){
		return "user/wallet";
	}
	
	@RequestMapping("restful")
	@ResponseBody
	public String restful(){
		String res = "success";
		return res;
	}
	
	//商家端
	public String mer(){
		return "mer/index";
	}
}
