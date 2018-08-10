package springboot.controller;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String Hello(Model model) throws Exception {
		model.addAttribute("now", DateFormat.getDateInstance().format(new Date()));
		if(true) {
			throw new Exception("原来这就是异常啊!!!!!！！！9999999999999999999999");
		}
		return "hello";
	}
}
