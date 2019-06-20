package com.javainuse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("/welcome.html")
	@ResponseBody
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}
	@RequestMapping(value="/value",method=RequestMethod.GET)
	public String getValue()
	{
		Systm.out.println("=========Hello World=============");
		return "welcome";
	}
	@RequestMapping(value="/message",method=RequestMethod.GET)
	public String getMessage()
	{
		Systm.out.println("=========Hello World=============");
		return "welcome";
	}

}
