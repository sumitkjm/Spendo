package org.spendo.persistence.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sp_expenditure_transaction")
public class SpExpenditureTransaction {
	
	@Id
	@Column(name="sp_transaction_id")
	@GeneratedValue
	private long spTransactionId;
	
	@ManyToOne
	@Column(name="exp_entity_id")
	private SpExpenditureEntity expEntityId;
	
	@ManyToOne
	@Column(name="user_id")
	private SpUsers userId;
	
	@Column(name="expenditure_date")
	private Date expenditureDate;
	
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

	public SpExpenditureTransaction(){}

	public long getSpTransactionId() {
		return spTransactionId;
	}

	public void setSpTransactionId(long spTransactionId) {
		this.spTransactionId = spTransactionId;
	}

	public SpExpenditureEntity getExpEntityId() {
		return expEntityId;
	}

	public void setExpEntityId(SpExpenditureEntity expEntityId) {
		this.expEntityId = expEntityId;
	}

	public SpUsers getUserId() {
		return userId;
	}

	public void setUserId(SpUsers userId) {
		this.userId = userId;
	}

	public Date getExpenditureDate() {
		return expenditureDate;
	}

	public void setExpenditureDate(Date expenditureDate) {
		this.expenditureDate = expenditureDate;
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
