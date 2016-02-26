package com.ldcc.android.controller;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ldcc.android.dao.BoardDao;


@Controller
@RequestMapping
public class BoardController {

  @Autowired
  BoardDao boardDao;

  //초기 진입 여부
  @RequestMapping("/join")
  public Object searchlist() throws Exception {
    
    System.out.println("안드로이드 접속 성공");
    
    HashMap<String,Object> responseData = new HashMap<String,Object>();
    responseData.put("status", "success");
    
    return responseData;
  }
  
  //로그인
  @RequestMapping("/login")
  public Object login(String out_data) throws Exception {
    
    System.out.println("로그인 접속 성공");
    System.out.println(out_data);
    
    Object jsonobject=JSONValue.parse(out_data);
    JSONObject jsonobj=(JSONObject)jsonobject;
    System.out.println(jsonobj.get("id"));
    System.out.println(jsonobj.get("pwd"));
    //String id = (String) jsonobj.get("id");
    //String pwd = (String) jsonobj.get("pwd");

    HashMap<String,Object> responseData = new HashMap<String,Object>();
    responseData.put("status", "success");
    
    return responseData;
  }
  
}









