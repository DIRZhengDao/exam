package com.cmsz.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
 * @author lenovo
 *
 */
@Controller
public class MathController {
	
	//随机数集合
	public static Map<String,String> numMap = new HashMap<String,String>();
	
	/**
	 * 判断输入数字与随机数的大小
	 * @param guessNumber
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/guessNumber",method = RequestMethod.POST)
	@ResponseBody
	public String guess(@RequestParam(value="guessNumber") int guessNumber,HttpSession session) {
		System.out.println(guessNumber);
		int num = Integer.parseInt(numMap.get(session.getId()));
	      if (guessNumber>num) {
	          return "猜大了。0---"+guessNumber;
	        } else if (guessNumber<num) {
	          return "猜小了。"+guessNumber+"---100";
	        } else {
	          return "恭喜，猜对了。";
	        } 
	}
	
	/**
	 * 生成随机数
	 * @param session
	 */
	@RequestMapping(value = "/makeNumber")
	@ResponseBody
	public void makeNumber(HttpSession session) {
		int num = new Random().nextInt(100);
		numMap.put(session.getId(), Integer.toString(num));
	}
}
