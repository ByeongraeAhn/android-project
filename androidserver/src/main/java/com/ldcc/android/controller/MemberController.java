package com.ldcc.android.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ldcc.android.dao.MemberDao;
import com.ldcc.android.domain.MemberVo;
import com.ldcc.android.domain.type.GRADE;


@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberDao memberDao;

	@Autowired
	ShaPasswordEncoder shaPasswordEncoder;
	
	//회원 가입
	@RequestMapping(value = "/join")
	public Object insert(
	    @RequestParam  String mname,
		  @RequestParam  String mpwd,
		  @RequestParam  String mloc) {
	  
	  HashMap<String,Object> responseData = new HashMap<String,Object>();
		MemberVo memberVo = new MemberVo();

		memberVo.setMname(mname);
		memberVo.setMpwd(shaPasswordEncoder.encodePassword("#소금값@"+mpwd,null));
		memberVo.setMloc(mloc);
		memberVo.setMdate(new Date(Calendar.getInstance().getTimeInMillis()));
		memberVo.setMgrade(GRADE.USER);
		memberDao.insert(memberVo);
		
    responseData.put("caseby", "join");
    responseData.put("status", "success");
    responseData.put("ale", "회원가입되었습니다.");
		
		return responseData;
	}
	
	
	//회원 로그인
	@RequestMapping(value = "/login")
	public Object login(
	    @RequestParam  String mname,
			@RequestParam  String mpwd, HttpSession session) {
	  
	  HashMap<String,Object> responseData = new HashMap<String,Object>();
	  MemberVo memberVo = new MemberVo();
	  
	  memberVo = memberDao.selectOneByMname(mname);
	  
	  responseData.put("caseby", "login");
	  responseData.put("status", "success");
	  responseData.put("ale", "로그인 되었습니다.");
	  
	  if (memberVo==null || 
		  !memberVo.getMpwd().equals(shaPasswordEncoder.encodePassword("#소금값@"+mpwd,null))) {
	    responseData.put("status", "disaccord");
	    responseData.put("ale", "아이디 혹은 비밀번호를 확인해주세요");
	    return responseData;
    }
	  
	  //세션저장(로그인 유지)
    session.setAttribute("user", memberVo); 
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
