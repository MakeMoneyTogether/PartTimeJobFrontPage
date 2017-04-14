package partjob.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import partjob.entity.User;

@Controller
@RequestMapping("uurl")
public class UserController {
	String names[] = {"柳新颖","令狐飞沉","赧夏烟","守苇然","荤明轩","兴晓凡","羊问兰","养之桃","阮迎荷","闽友易","塔淑雅"};
	
	@ResponseBody
	@RequestMapping("pages/login")
	public int login(String loginId,String password){
		System.out.println("loginId = "+loginId);
		System.out.println("password = "+password);
		return 0;
	}
	
	@ResponseBody
	@RequestMapping("pages/me")
	public User me(String loginId,String password){
		System.out.println("loginId = "+loginId);
		System.out.println("password = "+password);
		Random random = new Random();
		User user = new User();
		user.setName(names[random.nextInt(names.length)]);
		user.setGrade(""+(random.nextInt(5)+1));
		user.setBalance((random.nextInt(1000)+100)/100.0);
		user.setS1(random.nextInt(10));
		user.setS2(random.nextInt(10));
		user.setS3(random.nextInt(10));
		user.setS4(random.nextInt(10));
		return user;
	}
	
	@RequestMapping("judgeId")
	@ResponseBody
	public int judgeLoginId(String loginId){
		return 0;
	}
	
	@RequestMapping("register")
	@ResponseBody
	public int register(String loginId,String pwd,String phone,String invitation){
		System.out.println("---------register-------");
		System.out.println(loginId);
		System.out.println(pwd);
		System.out.println(phone);
		System.out.println(invitation);
		return 0;
	}
}
