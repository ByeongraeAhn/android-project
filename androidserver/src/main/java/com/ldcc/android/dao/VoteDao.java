package com.ldcc.android.dao;

import java.util.List;

import com.ldcc.android.domain.VoteVo;


public interface VoteDao {
  
  //투표하기
  void update(int idx);
  
  
  //결과 가져오기
  List<VoteVo> selectAll();
  
}











