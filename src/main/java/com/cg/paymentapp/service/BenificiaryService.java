package com.cg.paymentapp.service;

import com.cg.paymentapp.beans.BenificiaryDetails;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.repo.BenificiaryRepository;

public class BenificiaryService implements IBenificiaryService {
	public BenificiaryService () {
		new BenificiaryRepository();
	}
	

	public BenificiaryDetails addBenificiary(BenificiaryDetails bd) {
		new BenificiaryRepository().addBenificiary(bd);
		return null;
	}

	public BenificiaryDetails updateBenificiary(BenificiaryDetails bd) {
		// TODO Auto-generated method stub
		new BenificiaryRepository().updateBenificiary(bd);
		return null;
	}

	public BenificiaryDetails deleteBenificiary(BenificiaryDetails bd) {
		// TODO Auto-generated method stub
		new BenificiaryRepository().deleteBenificiary(bd);
		return null;
	}

	public BenificiaryDetails viewBenificiary(BenificiaryDetails bd) {
		// TODO Auto-generated method stub
		new BenificiaryRepository().viewBenificiary(bd);
		return null;
	}

	public BenificiaryDetails viewAllBenificiary(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}