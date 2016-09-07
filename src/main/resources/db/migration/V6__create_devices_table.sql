CREATE TABLE `fitness`.`devices` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL DEFAULT 0,
  `category` ENUM('RUN', 'SWIM', 'BIKE', 'LIFT') NULL,
  `serialnumber` VARCHAR(45) NULL,
  `product` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT NOW(),
  `modified` TIMESTAMP NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`),
  INDEX `fk_users_idx` (`user_id` ASC),
  CONSTRAINT `fk_users`
  FOREIGN KEY (`user_id`)
  REFERENCES `fitness`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);