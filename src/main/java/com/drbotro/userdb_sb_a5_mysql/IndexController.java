package com.drbotro.userdb_sb_a5_mysql;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String getIndexPage(){
		return "index";
	}
}
