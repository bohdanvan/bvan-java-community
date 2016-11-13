CREATE TABLE other_employee
(
  id          BIGINT(20)  AUTO_INCREMENT PRIMARY KEY,
  name        VARCHAR(30) NOT NULL,
  surname     VARCHAR(30) NOT NULL,
  birth_date  BIGINT(20),
  hire_date   BIGINT(20),
  position    INT(11)     NOT NULL,
  description VARCHAR(256),
  PRIMARY KEY (id)
);
