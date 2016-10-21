package com.chen.annotation;

@Table("department")
public class Filter2 {

	@Column("id")
	private int id;
	
	@Column("leader")
	private String leader;
	
	@Column("name")
	private String name;
	
	@Column("amount")
	private int amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
}
