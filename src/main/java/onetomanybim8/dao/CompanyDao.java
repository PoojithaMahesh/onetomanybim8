package onetomanybim8.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanybim8.dto.Company;

public class CompanyDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	public void updateCompany(int id,Company  company) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Company dbCompany=entityManager.find(Company.class, id);
		if(dbCompany!=null) {
			entityTransaction.begin();
			
			company.setId(id);
			company.setEmployees(dbCompany.getEmployees());
			entityManager.merge(company);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry Id is not present");
		}
	}
	
	
	public void findCompany(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Company dbCompany=entityManager.find(Company.class, id);
		if(dbCompany!=null) {
			System.out.println(dbCompany);
		}else {
			System.out.println("Sorry Id is not present");
		}
	}
	public void deleteCompany(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Company dbCompany=entityManager.find(Company.class, id);
		if(dbCompany!=null) {
			entityTransaction.begin();
			
			
			entityManager.remove(dbCompany);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry Id is not present");
		}
	}

	
	
}
