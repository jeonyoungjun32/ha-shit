
CREATE TABLE member (
  id VARCHAR(20) NOT NULL,
  pw VARCHAR(30) NOT NULL,
  name VARCHAR(10) NOT NULL,
  address_number VARCHAR(10) NOT NULL,
  address VARCHAR(100) NOT NULL,
  address_contents VARCHAR(100) NOT NULL,
  email VARCHAR(30) NOT NULL,
  birth DATE NOT NULL,
  gender CHAR(1) NOT NULL,
  grade CHAR(1) NOT NULL DEFAULT '1',
  id_code VARCHAR(14) NOT NULL,
  join_member DATE NOT NULL,
  money INT NULL,
  point INT NULL DEFAULT 0,
  author CHAR(1) NOT NULL,
  PRIMARY KEY (id)
)

select * from member;

CREATE TABLE Notice (
  Notice_num INT NOT NULL,
  Notice_title VARCHAR(50) NOT NULL,
  Notice_contents VARCHAR(100) NULL,
  Notice_readcount INT NULL DEFAULT 0,
  Notice_date DATETIME NOT NULL,
  member_id VARCHAR(20) NOT NULL
)

CREATE TABLE Notice_review (
  Notice_review_contents VARCHAR(200) NOT NULL,
  member_id VARCHAR(20) NOT NULL,
  Notice_Notice_num INT NOT NULL
)


CREATE TABLE QnA (
  QnA_num INT NOT NULL,
  QnA_title VARCHAR(50) NOT NULL,
  QnA_contents VARCHAR(1000) NULL,
  QnA_readcount INT NOT NULL DEFAULT 0,
  QnA_date DATE NOT NULL,
  QnA_re_ref INT NOT NULL,
  QnA_re_lev INT NOT NULL,
  QnA_re_seq INT NOT NULL,
  member_id VARCHAR(20) NOT NULL
)


CREATE TABLE object (
  object_code VARCHAR(10) NOT NULL,
  object_name VARCHAR(20) NOT NULL,
  object_kcal INT NOT NULL,
  object_allergy VARCHAR(200) NULL,
  object_price INT NOT NULL,
  object_inout CHAR(1) NOT NULL,
  object_date DATE NOT NULL,
  object_count INT NULL,
  object_img VARCHAR(50) NULL,
  PRIMARY KEY (object_code)
)


CREATE TABLE ice (
  ice_code VARCHAR(10) NOT NULL,
  ice_name VARCHAR(20) NOT NULL,
  ice_totalg INT NULL,
  ice_kcal INT NULL,
  ice_allergy VARCHAR(200) NULL,
  ice_totalprice INT NULL,
  ice_choice CHAR(1) NOT NULL,
  ice_inout CHAR(1) NOT NULL,
  ice_date DATE NOT NULL,
  ice_count INT NULL,
  ice_file VARCHAR(50) NULL,
  PRIMARY KEY (`ice_code`)
)


CREATE TABLE inOut (
  inOut_index INT NOT NULL,
  inOut_status CHAR(1) NOT NULL,
  inOut_count INT NULL,
  inOut_date DATE NOT NULL,
  object_object_code VARCHAR(10) NOT NULL,
  ice_ice_code VARCHAR(10) NOT NULL,
  PRIMARY KEY (inOut_index)
)

CREATE TABLE object_review (
  member_id VARCHAR(20) NOT NULL,
  object_object_code INT NOT NULL,
  object_review VARCHAR(200) NULL,
  object_review_grade INT NULL  
)


CREATE TABLE member_order (
  order_code INT NOT NULL,
  order_totalprice INT NOT NULL,
  order_how CHAR(1) NOT NULL,
  order_date DATE NULL,
  member_id VARCHAR(20) NOT NULL,
  object_object_code VARCHAR(10) NOT NULL,
  ice_ice_code VARCHAR(10) NOT NULL
)

CREATE TABLE order_summary (
  order_summary_process VARCHAR(1) NOT NULL,
  order_order_code INT NOT NULL
)

CREATE TABLE basket (
  basket_num INT NOT NULL,
  basket_choice CHAR(1) NULL,
  member_id VARCHAR(20) NOT NULL,
  PRIMARY KEY (basket_num) 
)

CREATE TABLE basket_detail (
  basket_detail_name VARCHAR(20) NOT NULL,
  basket_detail_choice CHAR(1) NOT NULL,
  basket_detail_count INT NULL,
  basket_detail_date DATE NOT NULL,
  basket_basket_num INT NOT NULL
)
