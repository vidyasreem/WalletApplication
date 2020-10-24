package com.cg.paymentapp.test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.paymentapp.beans.BenificiaryDetails;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repo.BenificiaryRepository;
import com.cg.paymentapp.service.IBenificiaryService;
import com.mysql.cj.Query;

public class TestBenificiaryDetails {
	private IBenificiaryService service;
	static BenificiaryDetails details = null;
//testcase for add Benificiary name and mobile number

	EntityManager entityManager;

	@Before
	public void setup() {
		details = new BenificiaryDetails();

	}

	@Test

	public void testaddBenificiary() {
		BenificiaryDetails bd = new BenificiaryDetails();
		bd.setName("sowmya");
		bd.setMobileNumber("9876543210");
		bd.setBenificiaryId(101);
		service.addBenificiary(bd);
		TypedQuery<BenificiaryDetails> query = entityManager.createQuery("from BenificiaryDetails",BenificiaryDetails.class);
		List<BenificiaryDetails> list = query.getResultList();
		assertEquals(1, list.size());
		BenificiaryDetails stored = list.get(0);
		assertEquals("sowmya", stored.getName());
		assertEquals("9876543210", stored.getMobileNumber());
		assertEquals(101, stored.getBenificiaryId());

	}

	@Test
	void deleteBenificiary() {
		BenificiaryDetails details = new BenificiaryDetails();
		details.setMobileNumber("7036522");
		details.setName("User1");
		service.deleteBenificiary(details);// (bd.getUserId());
		TypedQuery<BenificiaryDetails> returnedValue = entityManager.createQuery("from BenificiaryDetails",BenificiaryDetails.class);
		List<BenificiaryDetails> returnedBenificiaryDetailsObject = returnedValue.getResultList();
		assertEquals(1, returnedBenificiaryDetailsObject.size());

	}

	@Test
	public void testupdateBenificiary() {
		BenificiaryDetails Benificiary = new BenificiaryDetails();
		Benificiary.setMobileNumber("7036522");
		Benificiary.setName("sowmya");
		service.updateBenificiary(Benificiary);
		TypedQuery<BenificiaryDetails> query = entityManager.createQuery("from BenificiaryDetails",
				BenificiaryDetails.class);
		List<BenificiaryDetails> list = query.getResultList();
	assertEquals(1, list.size());
		BenificiaryDetails Benificiary2 = new BenificiaryDetails();
		Benificiary2.setMobileNumber("7036522");
		Benificiary2.setName("Benificiary2");
		service.updateBenificiary(Benificiary2);
		TypedQuery<BenificiaryDetails> querySecond = entityManager.createQuery("from BenificiaryDetails",
				BenificiaryDetails.class);
		List<BenificiaryDetails> listSecond = querySecond.getResultList();
		assertEquals(2, listSecond.size());
	}

	@Test
	public void testViewBenificiary() {
		BenificiaryDetails details = new BenificiaryDetails();
		details.setName("sowmya");
		try {
			if (service.viewBenificiary(details) == null) {
				throw new InvalidInputException("Invalid Input");
			} else {
				System.out.println(service.viewBenificiary(details));
			}

		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
	}

}
