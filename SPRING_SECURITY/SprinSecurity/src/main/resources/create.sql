-- Table users
CREATE TABLE users
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  username VARCHAR(255) NOT NULL,
  pasword VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table roles
CREATE TABLE roles
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table for mapping user and roles
CREATE TABLE user_roles
(
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;

-- INSERT
INSERT INTO users VALUE (1, 'admin', 'nimda');
INSERT INTO users VALUE (2, 'user', 'resu');

INSERT INTO roles VALUE (1, 'ROLE_ADMIN');
INSERT INTO roles VALUE (2, 'ROLE_USER');

INSERT INTO user_roles VALUE (1, 1);
INSERT INTO user_roles VALUE (2, 2);