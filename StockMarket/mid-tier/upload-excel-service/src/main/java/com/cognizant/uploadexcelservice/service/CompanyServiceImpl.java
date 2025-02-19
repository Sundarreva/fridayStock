package com.cognizant.uploadexcelservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.uploadexcelservice.entity.Company;
import com.cognizant.uploadexcelservice.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;

	@Transactional
	public List<Company> getAllCompany() {
		return companyRepository.findAll();
	}
}
