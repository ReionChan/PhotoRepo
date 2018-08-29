-- This is for Derby database.
DROP TABLE t_user;
CREATE TABLE t_user (
  id       INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY ,
  name     VARCHAR(50)  NOT NULL,
  password VARCHAR(128) NOT NULL
);