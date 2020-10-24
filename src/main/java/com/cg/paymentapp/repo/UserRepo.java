package com.cg.paymentapp.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.exception.InvalidInputException;

public class UserRepo implements IUserRepo  
{
	public Customer validateLogin(String mobileNumber, String password) throws InvalidInputException 
	{
		EntityManagerFactory emf = null;
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction=em.getTransaction();
		try 
		{
			Customer ct =  new Customer();
			if(checkvalidateLogin(mobileNumber, password))
			{
				ct.getMobileNo();
				ct.getPassword();				
				transaction.begin();
				em.persist(ct);
				transaction.commit();
			}
			else
			{
			throw new InvalidInputException("");
			}
			return ct;
		}
		finally {
			em.close();
		}
	}
public boolean checkvalidateLogin(String mobileNumber, String password)
{
	String mobile = "^[6-9][0-9]{9}";
	String pass = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}";
	if(mobileNumber == null || password == null)
	{
		return false;
	}
	else if(mobile.matches(mobileNumber) && pass.matches(password))
	{
		return true;
	}
	else {
		return false;
	}
		
	}	
}

