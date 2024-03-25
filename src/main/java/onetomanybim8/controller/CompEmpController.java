package onetomanybim8.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanybim8.dto.Company;
import onetomanybim8.dto.Employees;

public class CompEmpController {
public static void main(String[] args) {
	Company company=new Company();
	company.setId(1);
	company.setName("TYSS");
	company.setGst("tyss@123");
	
	Employees employees1=new Employees();
	employees1.setId(1);
	employees1.setName("Poojitha");
	employees1.setAddress("Bangalore");
	employees1.setCompany(company);
	
	Employees employees2=new Employees();
	employees2.setId(2);
	employees2.setName("Prem");
	employees2.setAddress("Bangalore");
	employees2.setCompany(company);
	
	List<Employees> employees=new ArrayList<Employees>();
	employees.add(employees1);
	employees.add(employees2);
	
	company.setEmployees(employees);
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(employees1);
	entityManager.persist(employees2);
	entityManager.persist(company);
	entityTransaction.commit();
}
}
