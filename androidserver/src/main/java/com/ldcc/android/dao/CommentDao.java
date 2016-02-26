package com.ldcc.android.dao;

import java.util.List;

import com.ldcc.android.domain.CommentVo;


public interface CommentDao {
  // 답변 추가
  void insert(CommentVo commentVo);
  
  // 답변 목록 가져오기
  List<CommentVo> selectAll();
  
  // 답변 하나만 가져오기
  CommentVo selectOne(int cidx);
  
  // 답변 삭제하기
  void delete(int cidx);
  
  // 답변 수정하기
  void update(CommentVo commentVo);
  
  

}











