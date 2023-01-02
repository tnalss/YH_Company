package com.and.middle;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import and.testVO;
import common.CommonService;


@RestController
public class AndController {
	@Autowired
	private CommonService common;
	@Autowired @Qualifier("hanul") SqlSession sql;	
	@RequestMapping("/and")								
	public String test(String emp_no, String emp_pw, Model model) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("emp_no", emp_no);
		map.put("emp_pw", emp_pw);
		 testVO vo = sql.selectOne("yh.login", map);
		if(vo == null) {			
			return new Gson().toJson(vo).toString();
		} else {
			model.addAttribute("vo",vo);
			return new Gson().toJson(vo).toString();
		}
	}


}
