package com.cg.paymentapp.repo;

import com.cg.paymentapp.beans.Customer;

public interface IUserRepo {

	public Customer validateLogin(String mobileNumber,String password);
}
