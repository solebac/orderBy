package com.erpro.orderby.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.erpro.orderby.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	//Um Order tem um User
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	//private OrderStatus ordeStatus;//Sem construtor
	private Integer ordeStatus;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Long id, Instant moment, OrderStatus ordeStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
		//this.ordeStatus = ordeStatus;
		setOrdeStatus(ordeStatus);
	}
	
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Set<OrderItem> getItems(){
		return items;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getMoment() {
		return moment;
	}
	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	
	public OrderStatus getOrdeStatus() {
		return OrderStatus.valuesOf(ordeStatus);
	}
	public void setOrdeStatus(OrderStatus ordeStatus) {
		if(ordeStatus != null)
		this.ordeStatus = ordeStatus.getCode();
	}
	public double getTotal() {
		double sum = 0.0;
		for (OrderItem orderItem : items) {
			sum += orderItem.getSubTotal();
		}
		return sum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
