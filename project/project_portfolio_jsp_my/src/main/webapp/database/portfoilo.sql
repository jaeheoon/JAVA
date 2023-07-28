--테이블 생성과 제약조건 분리 생성
CREATE TABLE hr.member(
  id VARCHAR2(20),
  passwd VARCHAR2(20),
  name VARCHAR2(30),
  email VARCHAR2(40),
  regdate DATE
);

CREATE TABLE hr.memo(
  m_id NUMBER(10),
  content VARCHAR2(4000),
  write_date DATE,
  id VARCHAR2(20)
);

CREATE TABLE hr.project(
  p_id NUMBER(5),
  name VARCHAR2(100),
  partcipation NUMBER(3),
  start_date DATE,
  end_dat DATE,
  skills VARCHAR2(2000)
);

-- PRIMARY KEY -----------------------------------------------------------------------------------------
ALTER TABLE hr.member ADD CONSTRAINT PK_MEMBER PRIMARY KEY (
	ID
);

ALTER TABLE hr.memo ADD CONSTRAINT PK_MEMO PRIMARY KEY (
	M_ID
);

ALTER TABLE hr.project ADD CONSTRAINT PK_PROJECT PRIMARY KEY (
	P_ID
);

commit;

-- FOREIGN KEY -----------------------------------------------------------------------------------------
ALTER TABLE hr.memo ADD CONSTRAINT FK_MEMBER_TO_MEMO FOREIGN KEY (
	ID
)
REFERENCES hr.member (
	ID
);

SELECT * FROM hr.member;
-- 혹은
SELECT * FROM hr.memo;




