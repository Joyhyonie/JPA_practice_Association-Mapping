package com.greedy.practice.associationmapping;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="employee")
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@Column(name="EMP_ID")
	private String empId;
	
	@Column(name="EMP_NAME")
	private String empName;
	
	@Column(name="EMP_NO")
	private String empNo;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private String phone;
	
	@JoinColumn(name="DEPT_CODE")
	@ManyToOne(cascade=CascadeType.PERSIST)	// 영속성 전이 설정
	private Department department;
	
	@Column(name="JOB_CODE")
	private String jobCode;
	
	@Column(name="SAL_LEVEL")
	private String salLevel;
	
	@Column(name="SALARY")
	private int salary;
	
	@Column(name="BONUS")
	private Integer bonus;	// null value was assigned to a property 오류로 인해 int를 Integer로 변경
	
	@Column(name="MANAGER_ID")
	private String managerId;
	
	@Column(name="HIRE_DATE")
	private Date hireDate;
	
	@Column(name="ENT_DATE")
	private Date entDate;
	
	@Column(name="ENT_YN")
	private String entYn;
	
	public Employee() {}

	public Employee(String empId, String empName, String empNo, String email, String phone, Department department,
			String jobCode, String salLevel, int salary, Integer bonus, String managerId, Date hireDate, Date entDate,
			String entYn) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.department = department;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.salary = salary;
		this.bonus = bonus;
		this.managerId = managerId;
		this.hireDate = hireDate;
		this.entDate = entDate;
		this.entYn = entYn;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getSalLevel() {
		return salLevel;
	}

	public void setSalLevel(String salLevel) {
		this.salLevel = salLevel;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getEntDate() {
		return entDate;
	}

	public void setEntDate(Date entDate) {
		this.entDate = entDate;
	}

	public String getEntYn() {
		return entYn;
	}

	public void setEntYn(String entYn) {
		this.entYn = entYn;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empNo=" + empNo + ", email=" + email
				+ ", phone=" + phone + ", department=" + department + ", jobCode=" + jobCode + ", salLevel=" + salLevel
				+ ", salary=" + salary + ", bonus=" + bonus + ", managerId=" + managerId + ", hireDate=" + hireDate
				+ ", entDate=" + entDate + ", entYn=" + entYn + "]";
	}
	
}
