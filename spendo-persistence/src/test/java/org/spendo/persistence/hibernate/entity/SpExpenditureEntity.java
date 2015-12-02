package org.spendo.persistence.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sp_expenditure_entity")
public class SpExpenditureEntity {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@Column(name="exp_category_id")
	private SpExpenditureCategoryMast expCategoryId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="modified_by")
	private String modifiedBy;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="modified_date")
	private Date modifiedDate;

}
