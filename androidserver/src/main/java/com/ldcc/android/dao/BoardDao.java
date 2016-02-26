package com.ldcc.android.dao;

import java.util.List;

import com.ldcc.android.domain.BoardVo;


public interface BoardDao {
  // 글 추가
  void insert(BoardVo boardVo);
  
  // 글 목록 가져오기
  List<BoardVo> selectAll();
  
  // 글 하나만 가져오기
  BoardVo selectOne(int bidx);
  
  // 글 삭제하기
  void delete(int bidx);
  
  // 글 수정하기
  void update(BoardVo boardVo);
  
  

}











