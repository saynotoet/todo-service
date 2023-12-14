package com.todo.service.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min=10, message="Enter atleast 10 characters")
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name="target_date")
	private LocalDate targetDate;
	
	private boolean done;
	
	@ManyToOne
	private User user;

	
	public Todo() {
		super();
	}

	public Todo( String description,User user, LocalDate targetDate, boolean done) {
		super();
		this.description = description;
 		this.targetDate = targetDate;
		this.done = done;
		this.user=user;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
 

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", userId="  + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}

}
