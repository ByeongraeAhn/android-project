-- 게시물테이블
DROP TABLE IF EXISTS BOARD RESTRICT;

-- 회원테이블
DROP TABLE IF EXISTS MEMBER RESTRICT;

-- 댓글테이블
DROP TABLE IF EXISTS COMMENT RESTRICT;

-- 게시물테이블
CREATE TABLE BOARD (
  BIDX      INTEGER      NOT NULL,     -- 게시물IDX
  MID       INTEGER      NOT NULL,     -- 회원아이디
  BDATE     DATE         NOT NULL,     -- 게시물등록일
  BTITLE    VARCHAR(50)  NOT NULL,     -- 게시물제목
  BCONTENT  VARCHAR(255) NULL,         -- 게시물내용
  RECOMMEND INTEGER      NULL,         -- 추천수
  BHITS     INTEGER      NULL          -- 조회수
);

-- 게시물테이블
ALTER TABLE BOARD
  ADD CONSTRAINT PK_BOARD -- 게시물테이블 기본키
    PRIMARY KEY (
      BIDX -- 게시물IDX
    );

-- 회원테이블
CREATE TABLE MEMBER (
  MID    INTEGER      NOT NULL,     -- 회원아이디
  MNAME  VARCHAR(50)  NOT NULL,     -- 회원이름
  MPWD   VARCHAR(50)  NOT NULL,     -- 회원비밀번호
  MLOC   VARCHAR(255) NOT NULL,     -- 회원주소
  MDATE  DATE         NOT NULL,     -- 회원가입일
  MGRADE INTEGER      NOT NULL      -- 회원등급
);

-- 회원테이블
ALTER TABLE MEMBER
  ADD CONSTRAINT PK_MEMBER -- 회원테이블 기본키
    PRIMARY KEY (
      MID -- 회원아이디
    );

-- 댓글테이블
CREATE TABLE COMMENT (
  CIDX     INTEGER      NOT NULL,     -- 댓글IDX
  MID      INTEGER      NOT NULL,     -- 회원아이디
  BIDX     INTEGER      NOT NULL,     -- 게시물IDX
  CCONTENT VARCHAR(255) NOT NULL,     -- 댓글내용
  CDATE    DATE         NOT NULL      -- 댓글등록일
);

-- 댓글테이블
ALTER TABLE COMMENT
  ADD CONSTRAINT PK_COMMENT -- 댓글테이블 기본키
    PRIMARY KEY (
      CIDX -- 댓글IDX
    );

-- 게시물테이블
ALTER TABLE BOARD
  ADD CONSTRAINT FK_MEMBER_TO_BOARD -- 회원테이블 -> 게시물테이블
    FOREIGN KEY (
      MID -- 회원아이디
    )
    REFERENCES MEMBER ( -- 회원테이블
      MID -- 회원아이디
    )
    ON DELETE CASCADE);

-- 댓글테이블
ALTER TABLE COMMENT
  ADD CONSTRAINT FK_BOARD_TO_COMMENT -- 게시물테이블 -> 댓글테이블
    FOREIGN KEY (
      BIDX -- 게시물IDX
    )
    REFERENCES BOARD ( -- 게시물테이블
      BIDX -- 게시물IDX
    )
    ON DELETE CASCADE);

-- 댓글테이블
ALTER TABLE COMMENT
  ADD CONSTRAINT FK_MEMBER_TO_COMMENT -- 회원테이블 -> 댓글테이블
    FOREIGN KEY (
      MID -- 회원아이디
    )
    REFERENCES MEMBER ( -- 회원테이블
      MID -- 회원아이디
    )
    ON DELETE CASCADE);











/*
 
---------------------------------------------------------


CREATE SCHEMA IF NOT EXISTS `andboarddb` DEFAULT CHARACTER SET utf8 ;
USE `andboarddb` ;

-- -----------------------------------------------------
-- Table `andboarddb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `andboarddb`.`user` (
  `user_id` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `join_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `andboarddb`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `andboarddb`.`post` (
  `post_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(140) NULL DEFAULT NULL,
  `content` TEXT NULL DEFAULT NULL,
  `created` DATETIME NULL DEFAULT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`post_id`),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `andboarddb`.`user` (`user_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `andboarddb`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `andboarddb`.`comment` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `content` TEXT NULL DEFAULT NULL,
  `created` DATETIME NULL DEFAULT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `post_number` INT NOT NULL,
  PRIMARY KEY (`comment_id`),
  CONSTRAINT `user_name`
    FOREIGN KEY (`user_name`)
    REFERENCES `andboarddb`.`user` (`user_id`)
    ON DELETE CASCADE,
  CONSTRAINT `post_number`
    FOREIGN KEY (`post_number`)
    REFERENCES `andboarddb`.`post` (`post_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB;

*/