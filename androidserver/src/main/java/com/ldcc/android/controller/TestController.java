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

import com.ldcc.android.domain.BoardVo;
import com.ldcc.android.domain.VoteVo;
import com.ldcc.android.dao.VoteDao;


@Controller
@RequestMapping("/vote")
public class TestController {

	@Autowired
	VoteDao voteDao;

	//json리턴
	@RequestMapping(value = "/voteinsert", method = RequestMethod.GET)
	public Object voteinsert(@RequestParam  String checked,HttpSession session) {
	  int idx = Integer.parseInt(checked);
	  
	  HashMap<String,Object> responseData = new HashMap<String,Object>();
	  
	  if (session.isNew() == false ) {
	    System.out.println("isnew 들어옴");
	    responseData.put("status", "dup");
	    return responseData;
    } else {
      VoteVo voteVo = new VoteVo();
      voteDao.update(idx);
      System.out.println("else 들어옴");
      
      responseData.put("status", "new");
      
      return responseData;
      
    }
	  
	}
	
	 //json리턴
  @RequestMapping(value = "/voteresult", method = RequestMethod.GET)
  public Object voteresult() {
    
    VoteVo voteVo = new VoteVo();
    
    HashMap<String,Object> responseData = new HashMap<String,Object>();
    responseData.put("caseby", "boardlist");
    responseData.put("status", "success");
    responseData.put("data", voteDao.selectAll());
    
    return responseData;
  }

	
	

}
