package com.erpro.orderby.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.erpro.orderby.entities.pk.OrderItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer quantidade;
	private Double price;
	@EmbeddedId
	private OrderItemPk id = new OrderItemPk();

	
	
	public OrderItem(Order order, Product product ,Integer quantidade, Double price) {
		super();
		this.quantidade = quantidade;
		this.price = price;
		id.setOrder(order);
		id.setProduct(product);
	}

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	public void setOrder(Order order) {
		id.setOrder(order);
	}

	public Product getProduct() {
		return id.getProduct();
	}
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
