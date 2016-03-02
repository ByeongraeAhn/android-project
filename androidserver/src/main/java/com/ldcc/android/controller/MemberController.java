package com.ldcc.android.controller;

import java.sql.Date;
import java.util.Calendar;

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
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberDao memberDao;

	//회원 추가
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Object insert(@RequestParam  String mname,
						@RequestParam  String mpwd,
						@RequestParam  String mloc,
						@RequestParam  String btitle) {
		
		MemberVo memberVo = new MemberVo();
		memberVo.setMname(mname);
		memberVo.setMpwd(mpwd);
		memberVo.setMloc(mloc);
		memberVo.setMdate(new Date(Calendar.getInstance().getTimeInMillis()));
		memberVo.setMgrade(GRADE.USER);
		memberDao.insert(memberVo);
		
		return true;
	}
	
	//회원 전체 보기
	@RequestMapping("/")
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
