package com.ldcc.android.dao;

import java.util.List;

import com.ldcc.android.domain.ResultVo;
import com.ldcc.android.domain.VoteVo;


public interface VoteDao {
  
  //투표하기(과거)
  void update(int idx);
  
  
  //랭킹 결과 가져오기
  List<VoteVo> selectAll();
  
  //중복 검증하기
  List<VoteVo> validationName();
  
  //투표하기
  void insert(VoteVo voteVo);
  
  //결과 가져오기 (문제1)
  ResultVo selectCal1();
  
  //결과 가져오기 (문제2)
  ResultVo selectCal2();
  
  //결과 가져오기 (문제3)
  ResultVo selectCal3();
  
  //결과 가져오기 (문제4)
  ResultVo selectCal4();
  
  //결과 가져오기 (문제5)
  ResultVo selectCal5();
  
}











