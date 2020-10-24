package com.cg.paymentapp.repo;

import com.cg.paymentapp.beans.BenificiaryDetails;
import com.cg.paymentapp.beans.Customer;

public interface IBenificiaryRepository {

	public BenificiaryDetails addBenificiary(BenificiaryDetails bd);
	public BenificiaryDetails updateBenificiary(BenificiaryDetails bd);
	public BenificiaryDetails deleteBenificiary(BenificiaryDetails bd);
	public BenificiaryDetails viewBenificiary(BenificiaryDetails bd);
	public BenificiaryDetails viewAllBenificiary(Customer customer);
	
}
