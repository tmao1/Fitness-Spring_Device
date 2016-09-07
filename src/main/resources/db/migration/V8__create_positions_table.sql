CREATE TABLE `fitness`.`positions` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL DEFAULT 0,
  `latitude` DECIMAL(9,6) NOT NULL,
  `longitude` DECIMAL(9,6) NOT NULL,
  `altitude` INT NOT NULL,
  `currenttime` TIMESTAMP NOT NULL DEFAULT Now(),
  `run_id` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_runs_idx` (`run_id` ASC),
  CONSTRAINT `fk_runs`
  FOREIGN KEY (`run_id`)
  REFERENCES `fitness`.`runs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);