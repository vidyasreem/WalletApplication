package com.cg.paymentapp.service;

import com.cg.paymentapp.beans.BenificiaryDetails;
import com.cg.paymentapp.beans.Customer;

public interface IBenificiaryService {

	public BenificiaryDetails addBenificiary(BenificiaryDetails bd);
	public BenificiaryDetails updateBenificiary(BenificiaryDetails bd);
	public BenificiaryDetails deleteBenificiary(BenificiaryDetails bd);
	public BenificiaryDetails viewBenificiary(BenificiaryDetails bd);
	public BenificiaryDetails viewAllBenificiary(Customer customer);
	
}
