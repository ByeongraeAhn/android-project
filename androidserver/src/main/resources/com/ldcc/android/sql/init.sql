-- 게시물테이블
DROP TABLE IF EXISTS board RESTRICT;

-- 회원테이블
DROP TABLE IF EXISTS member RESTRICT;

-- 댓글테이블
DROP TABLE IF EXISTS comment RESTRICT;

-- 게시물테이블
CREATE TABLE board (
  bidx      INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,     -- 게시물IDX
  mid       INTEGER      NOT NULL,     -- 회원내부아이디
  bdate     DATE         NOT NULL,     -- 게시물등록일
  btitle    VARCHAR(50)  NOT NULL,     -- 게시물제목
  bcontent  VARCHAR(255) NULL,         -- 게시물내용
  recommend INTEGER      NULL,         -- 추천수
  bhits     INTEGER      NULL          -- 조회수
);

-- 회원테이블
CREATE TABLE member (
  mid    INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,     -- 회원내부아이디
  mname  VARCHAR(50)  NOT NULL,     -- 회원아이디
  mpwd   VARCHAR(50)  NOT NULL,     -- 회원비밀번호
  mloc   VARCHAR(255) NOT NULL,     -- 회원주소
  mdate  DATE         NOT NULL,     -- 회원가입일
  mgrade INTEGER      NOT NULL      -- 회원등급
);

-- 댓글테이블
CREATE TABLE comment (
  cidx     INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,     -- 댓글IDX
  mid      INTEGER      NOT NULL,     -- 회원내부아이디
  bidx     INTEGER      NOT NULL,     -- 게시물IDX
  ccontent VARCHAR(255) NOT NULL,     -- 댓글내용
  cdate    DATE         NOT NULL      -- 댓글등록일
);

-- 게시물테이블
ALTER TABLE board
  ADD CONSTRAINT FK_member_TO_board -- 회원테이블 -> 게시물테이블
    FOREIGN KEY (
      mid -- 회원내부아이디
    )
    REFERENCES member ( -- 회원테이블
      mid -- 회원내부아이디
    )
    ON DELETE CASCADE;

-- 댓글테이블
ALTER TABLE comment
  ADD CONSTRAINT FK_board_TO_comment -- 게시물테이블 -> 댓글테이블
    FOREIGN KEY (
      bidx -- 게시물IDX
    )
    REFERENCES board ( -- 게시물테이블
      bidx -- 게시물IDX
    )
    ON DELETE CASCADE;

-- 댓글테이블
ALTER TABLE comment
  ADD CONSTRAINT FK_member_TO_comment -- 회원테이블 -> 댓글테이블
    FOREIGN KEY (
      mid -- 회원내부아이디
    )
    REFERENCES member ( -- 회원테이블
      mid -- 회원내부아이디
    )
    ON DELETE CASCADE;
    
CREATE UNIQUE INDEX uniqueindex ON member (mname);

    