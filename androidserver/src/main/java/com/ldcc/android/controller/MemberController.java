package com.ldcc.android.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ldcc.android.dao.MemberDao;
import com.ldcc.android.domain.MemberVo;
import com.ldcc.android.domain.type.GRADE;


@Controller
@RequestMapping
public class MemberController {

	@Autowired
	MemberDao memberDao;

	//회원 가입
	@RequestMapping(value = "/join")
	public Object insert(
	    @RequestParam  String mname,
		  @RequestParam  String mpwd,
		  @RequestParam  String mloc) {
	  System.out.println("회원가입 들어옴");
		
	  HashMap<String,Object> responseData = new HashMap<String,Object>();
		MemberVo memberVo = new MemberVo();
		/*memberVo.setMname("aaaa");
		memberVo.setMpwd("1111");
		memberVo.setMloc("asdf");*/
		memberVo.setMname(mname);
		memberVo.setMpwd(mpwd);
		memberVo.setMloc(mloc);
		memberVo.setMdate(new Date(Calendar.getInstance().getTimeInMillis()));
		memberVo.setMgrade(GRADE.USER);
		memberDao.insert(memberVo);
		
    responseData.put("case", "join");
    responseData.put("status", "success");
		
		return responseData;
	}
	
	
	//회원 로그인
	@RequestMapping(value = "/login")
	public Object login(
	    @RequestParam  String mname,
			@RequestParam  String mpwd) {
	  System.out.println("로그인 들어옴");
	  System.out.println(mname);
	  System.out.println(mpwd);
	  
	  HashMap<String,Object> responseData = new HashMap<String,Object>();
	  MemberVo memberVo = new MemberVo();
	  
	  memberVo = memberDao.selectOneByMname(mname);
	  responseData.put("case", "login");
	  
	  if (memberVo==null) {
	    System.out.println("들어옴");
	    responseData.put("status", "disaccord");
	    return responseData;
    }
	  
	  responseData.put("status", "success");
	  if (!mpwd.equals(memberVo.getMpwd())) {
	    responseData.put("status", "disaccord");
	  }
	  
	  return responseData;
	}
	
	//회원 전체 보기
	@RequestMapping("/list")
	public Object list() {
		return memberDao.selectAll();
	}
	
	//회원 하나 보기
	@RequestMapping("/{mid}")
	public Object view(@PathVariable int mid) {
		return memberDao.selectOne(mid);
	}
	//회원 수정
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public Object update(@RequestParam  String mname,
						@RequestParam  String mpwd,
						@RequestParam  String rempwd,
						@RequestParam  String mloc) {
		
		MemberVo memberVo = new MemberVo();
		memberVo.setMname(mname);
		memberVo.setMpwd(mpwd);
		memberVo.setMloc(mloc);
		memberDao.update(memberVo);
		
		return true;
	}
	
	//회원 하나 삭제
	@RequestMapping(value = "/{mid}", method = RequestMethod.DELETE)
	public Object delete(@PathVariable int mid) {
		memberDao.delete(mid);
		return true;
	}
	
	

}
