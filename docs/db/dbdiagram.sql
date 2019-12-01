CREATE TABLE `sp_users` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_login` VARCHAR,
  `user_name` VARCHAR,
  `user_pass` VARCHAR(20),
  `contact_number` VARCHAR(20),
  `email_id` VARCHAR(50),
  `created_by` VARCHAR(20),
  `modified_by` VARCHAR(20),
  `created_date` DATETIME,
  `modified_date` DATETIME
);

CREATE TABLE `sp_income_source_mast` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `source_name` VARCHAR(20),
  `description` VARCHAR(50),
  `created_by` VARCHAR(20),
  `modified_by` VARCHAR(20),
  `created_date` DATETIME,
  `modified_date` DATETIME
);

CREATE TABLE `sp_exp_category_mast` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `category_name` VARCHAR(50),
  `category_description` VARCHAR(100),
  `created_by` VARCHAR(50),
  `modified_by` VARCHAR(50),
  `created_date` DATETIME,
  `modified_date` DATETIME
);

CREATE TABLE `sp_exp_entity` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `exp_category_id` INT,
  `name` VARCHAR(20),
  `description` VARCHAR(50),
  `created_by` VARCHAR(20),
  `modified_by` VARCHAR(20),
  `created_date` DATETIME,
  `modified_date` DATETIME
);

CREATE TABLE `sp_income_transaction` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `user_id` INT,
  `income_source_id` INT,
  `transaction_date` DATETIME,
  `amount` FLOAT,
  `created_by` VARCHAR(20),
  `modified_by` VARCHAR(20),
  `created_date` DATETIME,
  `modified_date` DATETIME
);

CREATE TABLE `sp_exp_transaction` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `exp_entity_id` INT,
  `user_id` INT,
  `expenditure_date` DATETIME,
  `amount` FLOAT,
  `created_by` VARCHAR(20),
  `modified_by` VARCHAR(20),
  `created_date` DATETIME,
  `modified_date` DATETIME
);

ALTER TABLE `sp_exp_entity` ADD FOREIGN KEY (`exp_category_id`) REFERENCES `sp_exp_category_mast` (`id`);

ALTER TABLE `sp_income_transaction` ADD FOREIGN KEY (`user_id`) REFERENCES `sp_users` (`id`);

ALTER TABLE `sp_income_transaction` ADD FOREIGN KEY (`income_source_id`) REFERENCES `sp_income_source_mast` (`id`);

ALTER TABLE `sp_exp_transaction` ADD FOREIGN KEY (`exp_entity_id`) REFERENCES `sp_exp_entity` (`id`);

ALTER TABLE `sp_exp_transaction` ADD FOREIGN KEY (`user_id`) REFERENCES `sp_users` (`id`);

CREATE INDEX `sp_exp_entity_FKIndex1` ON `sp_exp_entity` (`exp_category_id`);

CREATE INDEX `sp_income_transaction_FKIndex1` ON `sp_income_transaction` (`income_source_id`);

CREATE INDEX `sp_income_transaction_FKIndex2` ON `sp_income_transaction` (`user_id`);

CREATE INDEX `sp_expenditure_transaction_FKIndex1` ON `sp_exp_transaction` (`user_id`);

CREATE INDEX `sp_expenditure_transaction_FKIndex2` ON `sp_exp_transaction` (`exp_entity_id`);

