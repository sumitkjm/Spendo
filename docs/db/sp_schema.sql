CREATE TABLE sp_users (
  user_id INT NOT NULL AUTO_INCREMENT,
  user_login VARCHAR(50) NULL,
  user_name VARCHAR(50) NULL,
  user_pass VARCHAR(20) NULL,
  contact_number VARCHAR(20) NULL,
  email_id VARCHAR(50) NULL,
  created_by VARCHAR(20) NULL,
  modified_by VARCHAR(20) NULL,
  created_date DATETIME NULL,
  modified_date DATETIME NULL,
  PRIMARY KEY(user_id)
);

CREATE TABLE sp_income_source_mast (
  id INT NOT NULL AUTO_INCREMENT,
  source_name VARCHAR(20) NULL,
  description VARCHAR(50) NULL,
  created_by VARCHAR(20) NULL,
  modified_by VARCHAR(20) NULL,
  created_date DATETIME NULL,
  modified_date DATETIME NULL,
  PRIMARY KEY(id)
);

CREATE TABLE sp_expenditure_category_mast (
  exp_category_id INT NOT NULL AUTO_INCREMENT,
  category_name VARCHAR(50) NULL,
  category_description VARCHAR(100) NULL,
  created_by VARCHAR(50) NULL,
  modified_by VARCHAR(50) NULL,
  created_date DATETIME NULL,
  modified_date DATETIME NULL,
  PRIMARY KEY(exp_category_id)
);

CREATE TABLE sp_expenditure_entity (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  exp_category_id INT NOT NULL,
  name VARCHAR(20) NULL,
  description VARCHAR(50) NULL,
  created_by VARCHAR(20) NULL,
  modified_by VARCHAR(20) NULL,
  created_date DATETIME NULL,
  modified_date DATETIME NULL,
  PRIMARY KEY(id),
  INDEX sp_expenditure_entity_FKIndex1(exp_category_id),
  FOREIGN KEY(exp_category_id)
    REFERENCES sp_expenditure_category_mast(exp_category_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE sp_income_transaction (
  income_transaction_id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  income_source_id INT NOT NULL,
  transaction_date DATETIME NULL,
  amount FLOAT NULL,
  created_by VARCHAR(20) NULL,
  modified_by VARCHAR(20) NULL,
  created_date DATETIME NULL,
  modified_date DATETIME NULL,
  PRIMARY KEY(income_transaction_id),
  INDEX sp_income_transaction_FKIndex1(income_source_id),
  INDEX sp_income_transaction_FKIndex2(user_id),
  FOREIGN KEY(income_source_id)
    REFERENCES sp_income_source_mast(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(user_id)
    REFERENCES sp_users(user_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE sp_expenditure_transaction (
  sp_transaction_id INT NOT NULL AUTO_INCREMENT,
  exp_entity_id INTEGER UNSIGNED NOT NULL,
  user_id INT NOT NULL,
  expenditure_date DATETIME NULL,
  amount FLOAT NULL,
  created_by VARCHAR(20) NULL,
  modified_by VARCHAR(20) NULL,
  created_date DATETIME NULL,
  modified_date DATETIME NULL,
  PRIMARY KEY(sp_transaction_id),
  INDEX sp_expenditure_transaction_FKIndex2(user_id),
  INDEX sp_expenditure_transaction_FKIndex2(exp_entity_id),
  FOREIGN KEY(user_id)
    REFERENCES sp_users(user_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(exp_entity_id)
    REFERENCES sp_expenditure_entity(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);


