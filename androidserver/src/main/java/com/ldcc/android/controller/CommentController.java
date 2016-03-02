package com.ldcc.android.controller;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ldcc.android.dao.CommentDao;
import com.ldcc.android.domain.CommentVo;


@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentDao commentDao;

	//답변 추가
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Object insert(@RequestParam  String ccontent) {
		
		CommentVo commentVo = new CommentVo();
		commentVo.setCcontent(ccontent);
		commentDao.insert(commentVo);
		
		return true;
	}
	
	//답변 전체 보기
	@RequestMapping("/")
	public Object list() {
		return commentDao.selectAll();
	}
	
	//답변 하나 보기
	@RequestMapping("/{cidx}")
	public Object view(@PathVariable int cidx) {
		return commentDao.selectOne(cidx);
	}
	
	//답변 수정
	@RequestMapping(value = "/{cidx}", method = RequestMethod.PUT)
	public Object update(@PathVariable int cidx,@RequestParam  String ccontent) {
		
		CommentVo commentVo = commentDao.selectOne(cidx);
		commentVo.setCcontent(ccontent);
		commentDao.update(commentVo);
		
		return true;
	}
	
	//답변 하나 삭제
	@RequestMapping(value = "/{cidx}", method = RequestMethod.DELETE)
	public Object delete(@PathVariable int cidx) {
		commentDao.delete(cidx);
		return true;
	}
	
	

}
