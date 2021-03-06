package com.anna.coupons.api;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anna.coupons.controller.CompanyController;
import com.anna.coupons.entities.CompanyEntity;
import com.anna.coupons.exceptions.ApplicationException;

@RestController
@RequestMapping("/companies")
public class CompanyApi {

	@Autowired
	private CompanyController companyController;

	
	@PostMapping
	public void createCompany(@RequestBody CompanyEntity company) throws ApplicationException {
		companyController.createCompany(company);
	}

	@DeleteMapping
	@RequestMapping("/{companyId}")
	public void deleteCompany(@PathVariable("companyId") long companyId) throws ApplicationException {
		companyController.deleteCompany(companyId);
	}

	@PutMapping
	public void updateCompany(@RequestBody CompanyEntity company) throws ApplicationException {
		companyController.updateCompany(company);
	}

	@GetMapping
	public List<CompanyEntity> getAllCompanies() throws ApplicationException {
		return companyController.getAllCompanies();
	}

	@GetMapping
	@RequestMapping("/getCompany/{companyId}")
	public CompanyEntity getCompany(@PathVariable("companyId") long companyId) throws ApplicationException {
		return companyController.getCompanyByCompanyId(companyId);
	}

}
 