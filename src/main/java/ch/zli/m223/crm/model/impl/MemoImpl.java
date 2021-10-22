package ch.zli.m223.crm.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.zli.m223.crm.model.Memo;

@Entity(name = "Memo")
public class MemoImpl implements Memo{
	
	@Id //makes the id to the primary-key
	@GeneratedValue //makes an auto-increment on the id
	private Long id;
	
	@Column(nullable = false)
	private String memo;
	
	@ManyToOne
	private CustomerImpl customer;
	
	public MemoImpl(String memo, CustomerImpl customer) {
		this.customer = customer;
		this.memo = memo;
	}
	
	protected MemoImpl() {
		
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getMemo() {
		return memo;
	}
}
