//// -- LEVEL 1
//// -- Tables and References
// Tables are created in https://dbdiagram.io/
// Creating tables
Table sp_users {
  id int [PK, increment]
  user_login VARCHAR
  user_name VARCHAR 
  user_pass VARCHAR(20)
  contact_number VARCHAR(20)
  email_id VARCHAR(50) 
  created_by VARCHAR(20) 
  modified_by VARCHAR(20) 
  created_date DATETIME 
  modified_date DATETIME
}

Table sp_income_source_mast {
  id INT [PK, increment]
  source_name VARCHAR(20)
  description VARCHAR(50)
  created_by VARCHAR(20)
  modified_by VARCHAR(20)
  created_date DATETIME
  modified_date DATETIME
}

Table sp_exp_category_mast {
  id INT [PK, increment]
  category_name VARCHAR(50)
  category_description VARCHAR(100)
  created_by VARCHAR(50)
  modified_by VARCHAR(50)
  created_date DATETIME
  modified_date DATETIME
}

Table sp_exp_entity {
  id INT [PK,increment]
  exp_category_id INT [ref: > sp_exp_category_mast.id]
  name VARCHAR(20)
  description VARCHAR(50)
  created_by VARCHAR(20) 
  modified_by VARCHAR(20) 
  created_date DATETIME 
  modified_date DATETIME 
  Indexes {
    (exp_category_id)[name:'sp_exp_entity_FKIndex1']
  }
}

Table sp_income_transaction {
  id INT [PK,increment]
  user_id INT [ref: > sp_users.id]
  income_source_id INT [ref: > sp_income_source_mast.id]
  transaction_date DATETIME
  amount FLOAT
  created_by VARCHAR(20)
  modified_by VARCHAR(20)
  created_date DATETIME
  modified_date DATETIME
  Indexes {
    (income_source_id) [name:'sp_income_transaction_FKIndex1']
    (user_id) [name:'sp_income_transaction_FKIndex2']
  }
}

Table sp_exp_transaction {
  id INT [PK, increment]
  exp_entity_id INT [ref: > sp_exp_entity.id]
  user_id INT [ref: > sp_users.id]
  expenditure_date DATETIME
  amount FLOAT
  created_by VARCHAR(20)
  modified_by VARCHAR(20)
  created_date DATETIME
  modified_date DATETIME
  Indexes {
    (user_id)[name:'sp_expenditure_transaction_FKIndex1']
    (exp_entity_id)[name:'sp_expenditure_transaction_FKIndex2']
  }
}


