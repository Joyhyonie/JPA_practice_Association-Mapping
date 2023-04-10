package com.greedy.practice.associationmapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AssociationTests {

	private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }
    
    @Test
    public void 특정_EMP_ID를_가진_사원_조회_테스트() {
    	
    	// given
    	String empId = "255";
    	
    	// when
    	Employee foundEmployee = entityManager.find(Employee.class, empId);
    	
    	// then
    	assertNotNull(foundEmployee);
    	System.out.println("foundEmployee : " + foundEmployee);
    	
    }
    
    @Test
    public void 새로운_사원_등록_테스트() {
    	
    	// given
    	Employee emp = new Employee();
    	emp.setEmpId("256");
    	emp.setEmpName("허꼬순");
    	emp.setEmpNo("201021-1234567");
    	emp.setEmail("cheese@gmail.com");
    	emp.setPhone("01072728282");
    	emp.setDepartment(null);
    	emp.setJobCode("J1");
    	emp.setSalLevel("S5");
    	emp.setSalary(5000000);
    	emp.setBonus(7);
    	emp.setManagerId("240");
    	emp.setHireDate(new java.sql.Date(System.currentTimeMillis()));
    	emp.setEntDate(null);
    	emp.setEntYn("N");
    	
    	// when
    	EntityTransaction tran = entityManager.getTransaction();
    	tran.begin();
    	entityManager.persist(emp);
    	tran.commit();
    	
    	// then
    	Employee foundEmployee = entityManager.find(Employee.class, "256");
    	assertEquals("256", foundEmployee.getEmpId());
 
    }
    
    @Test
    public void 새로운_부서_등록_및_해당_부서에_등록된_사원_등록_테스트() {
    	
    	// given
    	Employee emp = new Employee();
    	emp.setEmpId("257");
    	emp.setEmpName("허소세지");
    	emp.setEmpNo("201021-1234567");
    	emp.setEmail("cheese@gmail.com");
    	emp.setPhone("01072728282");
//    	emp.setDepartment(null);
    	emp.setJobCode("J1");
    	emp.setSalLevel("S5");
    	emp.setSalary(5000000);
    	emp.setBonus(7);
    	emp.setManagerId("240");
    	emp.setHireDate(new java.sql.Date(System.currentTimeMillis()));
    	emp.setEntDate(null);
    	emp.setEntYn("N");
    	
    	Department dep = new Department();
    	dep.setDeptId("D10");
    	dep.setDeptTitle("갱얼쥐대장부");
    	dep.setLocationId("L5");
    	
    	/* 생성된 새로운 부서를 Employee 엔티티에 추가(영속성 전이 반드시 해야함) */
    	emp.setDepartment(dep);
    	
    	// when
    	EntityTransaction tran = entityManager.getTransaction();
    	tran.begin();
    	entityManager.persist(emp);
    	tran.commit();
    	
    	// then
    	Employee foundEmpAndDep = entityManager.find(Employee.class, 257);
    	assertEquals("257", foundEmpAndDep.getEmpId());
    	assertEquals("D10", foundEmpAndDep.getDepartment().getDeptId());
    	
    }
    
    @Test
    public void 전체_사원_조회_테스트() {
    	
    	// when
    	String jpql = "SELECT e FROM employee AS e";
    	TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
    	
    	List<Employee> foundEmployeeList = query.getResultList();
    	
    	// then
    	assertNotNull(foundEmployeeList);
    	foundEmployeeList.forEach(System.out::println);
    }
    
    @Test
    public void 하씨_성을_가진_사원_조회_테스트() {
    	
    	// when
    	String jpql = "SELECT e FROM employee AS e WHERE empName LIKE '하%'";
    	TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
    	
    	List<Employee> foundEmployeeList = query.getResultList();
    	
    	// then
    	assertNotNull(foundEmployeeList);
    	foundEmployeeList.forEach(System.out::println);
    	
    }
    
}
