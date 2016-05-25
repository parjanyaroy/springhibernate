package com.mastertheboss.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Order")
@Table(name = "orders",schema="persistence")
@NamedNativeQueries({
    @NamedNativeQuery(
            name    =   "getAllOrders",query=   "SELECT * FROM orders",
                        resultClass=Order.class
    ),
    @NamedNativeQuery(
            name    =   "getAllOrdersByComment",
            query   =   "SELECT * FROM orders WHERE o_comment = ?",
                        resultClass=Order.class
    )
})
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "o_comment")
	private String comment;
	@Temporal(TemporalType.DATE)
	@Column(name = "o_time")
	private Date date;
	@Column(name="o_cost")
//	@Convert(converter = CurrencyConverter.class)
	private Double cost;

	public Order() {
	}

	public Order(String comment, Date date , Double cost) {
		this.comment = comment;
		this.date=date;
		this.cost=cost;
	}
	
	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
}