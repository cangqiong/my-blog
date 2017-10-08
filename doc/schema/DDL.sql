USE blog;

DROP TABLE IF EXISTS blog_user;

CREATE TABLE blog_user(
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` VARCHAR(50) NOT NULL COMMENT '用户名' UNIQUE,
  `password` VARCHAR(150) NOT NULL COMMENT '用户密码',
  `modify_time` DATETIME  COMMENT '修改时间',
  `create_time` DATETIME  COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET=utf8;

DELIMITER $$
CREATE TRIGGER USER_INSER
BEFORE INSERT ON blog_user
FOR EACH ROW BEGIN
      -- Set the creation date
       SET new.create_time = NOW();

       -- Set the udpate date
       SET new.modify_time = NOW();
END $$
DELIMITER ;