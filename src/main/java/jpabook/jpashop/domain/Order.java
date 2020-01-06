package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {

	@Id @GeneratedValue
	@Column(name="order_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "delivery_id")
	private Delivery delivery;
	
	private LocalDateTime orderDate;

	@Enumerated(EnumType.STRING)
	private OrderState status;

}
