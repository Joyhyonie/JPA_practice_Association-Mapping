package com.greedy.practice.associationmapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="department")
@Table(name="DEPARTMENT")
public class Department {
	
	@Id
	@Column(name="DEPT_ID")
	private String deptId;
	@Column(name="DEPT_TITLE")
	private String deptTitle;
	@Column(name="LOCATION_ID")
	private String locationId;

	public Department() {}

	public Department(String deptId, String deptTitle, String locationId) {
		super();
		this.deptId = deptId;
		this.deptTitle = deptTitle;
		this.locationId = locationId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptTitle() {
		return deptTitle;
	}

	public void setDeptTitle(String deptTitle) {
		this.deptTitle = deptTitle;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptTitle=" + deptTitle + ", locationId=" + locationId + "]";
	}
	
}
