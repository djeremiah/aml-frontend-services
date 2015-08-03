package com.redhat.aml.model.service;

import com.redhat.aml.model.*;

import javax.persistence.*;

import java.util.List;

public class AccountService {
    protected EntityManager em;

    public AccountService(EntityManager em) {
        this.em = em;
    }


    
    public Accountdetails createAccount (int accountNo, String firstname, String lastname,
			String street, String city, String state, long zipcode,
			String occupation, int age, String sex, String marritialstatus,
			String accounttype){
    	Accountdetails acc = new Accountdetails( accountNo,  firstname,  lastname,
    			 street,  city,  state,  zipcode,
    			 occupation,  age,  sex,  marritialstatus,
    			 accounttype);
    	
    	// persist the new object
    	em.persist(acc);
    	return acc;
    	
    	
    }

    public void removeAccount(int id) {
    	Accountdetails acc = findAccount(id);
        if (acc != null) {
            em.remove(acc);
        }
    }


    public Accountdetails findAccount(int id) {
        return em.find(Accountdetails.class, id);
    }

    public List<Accountdetails> findAllAccounts() {
        TypedQuery<Accountdetails> query = em.createQuery(
                  "FROM Accountdetails", Accountdetails.class);
        return query.getResultList();
    }
}