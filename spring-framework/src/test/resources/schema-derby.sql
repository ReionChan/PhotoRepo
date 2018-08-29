-- DROP TABLE t_user;
CREATE TABLE t_user (
  id       INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY ,
  name     VARCHAR(50)  UNIQUE NOT NULL,
  password VARCHAR(128) NOT NULL
);

INSERT INTO t_user (name, password)
VALUES ('admin', 'admin'), ('reion', '123');