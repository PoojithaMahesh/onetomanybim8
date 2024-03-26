package onetomanybim8.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanybim8.dto.Company;
import onetomanybim8.dto.Employees;

public class EmployeeDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	public void updateEmployee(int id,Employees  employees) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Employees dbEmployees=entityManager.find(Employees.class, id);
		if(dbEmployees!=null) {
			entityTransaction.begin();
			
			employees.setId(id);
			employees.setCompany(dbEmployees.getCompany());
			entityManager.merge(employees);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry Id is not present");
		}
	}
	
	public void findEmployee(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Employees dbEmployees=entityManager.find(Employees.class, id);
		if(dbEmployees!=null) {
			System.out.println(dbEmployees);
		}else {
			System.out.println("Sorry Id is not present");
		}
	}
	
	public void deleteEmployee(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Employees dbEmployees=entityManager.find(Employees.class, id);
		if(dbEmployees!=null) {
			entityTransaction.begin();
			Company dbCompany=dbEmployees.getCompany();
			List<Employees> employees=dbCompany.getEmployees();
			employees.remove(dbEmployees);
			dbCompany.setEmployees(employees);
			entityManager.remove(dbEmployees);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry Id is not present");
		}
	}
	
	
	
	
	
}
