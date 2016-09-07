CREATE TABLE `fitness`.`runs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL,
  `starttime` DATETIME NOT NULL,
  `endtime` DATETIME NULL,
  `created` TIMESTAMP NOT NULL DEFAULT Now(),
  `modified` TIMESTAMP NOT NULL DEFAULT Now(),
  `device_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_devices_idx` (`device_id` ASC),
  CONSTRAINT `fk_devices`
  FOREIGN KEY (`device_id`)
  REFERENCES `fitness`.`devices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

