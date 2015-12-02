package org.spendo.persistence.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sp_income_transaction")
public class SpIncomeTransaction {
	
	@Id
	@Column(name="income_transaction_id")
	@GeneratedValue
	private int incomeTransactionId;
	
	@ManyToOne
	@Column(name="sp_users")
	private SpUsers spUsers;
	
	@ManyToOne
	@Column(name="income_source_id")
	private SpIncomeSourceMast incomeSourceId;
	
	@Column(name="transaction_date")
	private Date transactionDate;

	@Column(name="amount")
	private Double amount;

	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="modified_by")
	private String modifiedBy;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="modified_date")
	private Date modifiedDate;

	public SpIncomeTransaction() {}

	public int getIncomeTransactionId() {
		return incomeTransactionId;
	}

	public void setIncomeTransactionId(int incomeTransactionId) {
		this.incomeTransactionId = incomeTransactionId;
	}

	public SpUsers getSpUsers() {
		return spUsers;
	}

	public void setSpUsers(SpUsers spUsers) {
		this.spUsers = spUsers;
	}

	public SpIncomeSourceMast getIncomeSourceId() {
		return incomeSourceId;
	}

	public void setIncomeSourceId(SpIncomeSourceMast incomeSourceId) {
		this.incomeSourceId = incomeSourceId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	

}
