package com.ldcc.android.dao;

import java.util.List;

import com.ldcc.android.domain.MemberVo;


public interface MemberDao {
  // 회원 추가
  void insert(MemberVo memberVo);
  
  // 회원 목록 가져오기
  List<MemberVo> selectAll();
  
  // 회원 하나만 가져오기
  MemberVo selectOne(int bidx);
  
  // 회원 삭제하기
  void delete(int bidx);
  
  // 회원 수정하기
  void update(MemberVo memberVo);
  
  

}











