package com.ldcc.android.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ldcc.android.dao.BoardDao;
import com.ldcc.android.domain.BoardVo;
import com.ldcc.android.domain.MemberVo;


@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardDao boardDao;

	//게시글 추가
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Object insert(@RequestParam  String bcontent,@RequestParam  String btitle, HttpSession session) {
	  
	  MemberVo memberVo = (MemberVo)session.getAttribute("user");
	
		BoardVo boardVo = new BoardVo();
		boardVo.setMid(memberVo.getMid());
		/*boardVo.setMid(40);*/
		boardVo.setBdate(new Date(Calendar.getInstance().getTimeInMillis()));
		boardVo.setBcontent(bcontent);
		boardVo.setBtitle(btitle);
		boardVo.setBhits(0);
		boardVo.setRecommend(0);
		boardDao.insert(boardVo);
	  
	  HashMap<String,Object> responseData = new HashMap<String,Object>();
    responseData.put("caseby", "boardlist");
    responseData.put("status", "success");
		
		return responseData;
	}
	
	//게시판 전체 보기
	@RequestMapping("/list")
	public Object list(HttpSession session) {
	  
	  MemberVo memberVo = (MemberVo)session.getAttribute("user");
	  System.out.println("리스트에서      "+memberVo.getMid());
	    
	  HashMap<String,Object> responseData = new HashMap<String,Object>();
    /*responseData.put("caseby", "boardlist");
    responseData.put("status", "success");*/
    responseData.put("data", boardDao.selectAll());
		return responseData;
	}
	
	//게시글 하나 보기
	@RequestMapping("/{bidx}")
	public Object view(@PathVariable int bidx) {
		BoardVo boardVo = boardDao.selectOne(bidx);
		boardVo.setBhits(boardVo.getBhits()+1);
		boardDao.update(boardVo);
		return boardVo;
	}
	
	//게시글 수정
	@RequestMapping(value = "/{bidx}", method = RequestMethod.PUT)
	public Object update(@PathVariable int bidx,@RequestParam  String btitle,@RequestParam String bcontent) {
		
		BoardVo boardVo = boardDao.selectOne(bidx);
		boardVo.setBcontent(bcontent);
		boardVo.setBtitle(btitle);
		boardDao.update(boardVo);
		
		return true;
	}
	
	//게시글 하나 삭제
	@RequestMapping(value = "/{bidx}", method = RequestMethod.DELETE)
	public Object delete(@PathVariable int bidx) {
		boardDao.delete(bidx);
		return true;
	}
	
	

}
