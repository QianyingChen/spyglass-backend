package com.skillstorm.spyglass.models;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.skillstorm.spyglass.dtos.GoalDto;

@Entity
@Table(name = "goals")
public class Goal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Long id;
	
	@Column
	private String userId;
	
	@Column
    private String name;
	
	@Column
    private String description;
	
	@Column
    private String picture;
	
	@Column(name = "satrt_date")
	private LocalDate startDate;
	
	@Column(name = "target_date")
    private LocalDate targetDate;
	
	@Column(name = "target_amount")
    private double targetAmount;
	
	@Column(name = "current_amount")
	private double currentAmount;

	
	public Goal() {
		
	}

	public Goal(Long id, String userId, String name, String description, String picture, LocalDate startDate,
			LocalDate targetDate, double targetAmount, double currentAmount) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.startDate = startDate;
		this.targetDate = targetDate;
		this.targetAmount = targetAmount;
		this.currentAmount = currentAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public double getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(double targetAmount) {
		this.targetAmount = targetAmount;
	}

	public double getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(double currentAmount) {
		this.currentAmount = currentAmount;
	}
	
	

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public GoalDto toDto() {
		return new GoalDto(
				id, userId, name, description, picture, startDate, targetDate, targetAmount,
				currentAmount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goal other = (Goal) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Goal [id=" + id + ", userId=" + userId + ", name=" + name + ", description=" + description
				+ ", picture=" + picture + ", startDate=" + startDate + ", targetDate=" + targetDate + ", targetAmount="
				+ targetAmount + ", currentAmount=" + currentAmount + "]";
	}

	

	
	
	
	
}	
