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

import com.ldcc.android.dao.BoardDao;
import com.ldcc.android.domain.BoardVo;


@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardDao boardDao;

	//게시글 추가
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Object insert(@RequestParam  String bcontent,@RequestParam  String btitle) {
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBdate(new Date(Calendar.getInstance().getTimeInMillis()));
		boardVo.setBcontent(bcontent);
		boardVo.setBtitle(btitle);
		boardDao.insert(boardVo);
		
		return true;
	}
	
	//게시판 전체 보기
	@RequestMapping("/list")
	public Object list() {
	  System.out.println("리스트로 들어옴");
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
