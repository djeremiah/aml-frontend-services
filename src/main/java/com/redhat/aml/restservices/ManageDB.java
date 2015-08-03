package com.redhat.aml.restservices;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.redhat.aml.model.service.*;
import com.redhat.aml.model.Accountdetails;

public class ManageDB {
// public static void main(String[] args){
//	 MySQLDBConnect connect = new MySQLDBConnect();
// }
	public static void main(String[] args) {
	EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("aml-frontend-services");
    EntityManager em = emf.createEntityManager();
    AccountService service = new AccountService(em);
	
	
//  create and persist an Account
    
    int acctNo = 1111;
	
    em.getTransaction().begin();
    
    // clean up previously inserted account
    service.removeAccount(acctNo);
    
    Accountdetails acc = service.createAccount(acctNo,  "Anurag",  "Saran",
			 "1",  "a",  "a",  60090,
			 "sa",  22,  "m",  "m",
			 "Savings");
    em.getTransaction().commit();
    System.out.println("Persisted " + acc);

    // find a specific Account
    acc = service.findAccount(acctNo);
    System.out.println("Found " + acc);
	}
}
