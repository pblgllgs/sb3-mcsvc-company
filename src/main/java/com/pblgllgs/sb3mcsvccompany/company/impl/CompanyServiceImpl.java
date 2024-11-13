package com.pblgllgs.sb3mcsvccompany.company.impl;
/*
 *
 * @author pblgl
 * Created on 23-10-2024
 *
 */

import com.pblgllgs.sb3mcsvccompany.company.Company;
import com.pblgllgs.sb3mcsvccompany.company.CompanyRepository;
import com.pblgllgs.sb3mcsvccompany.company.CompanyService;
import com.pblgllgs.sb3mcsvccompany.company.clients.ReviewClient;
import com.pblgllgs.sb3mcsvccompany.dto.ReviewMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ReviewClient reviewClient;

    public CompanyServiceImpl(CompanyRepository companyRepository, ReviewClient reviewClient) {
        this.companyRepository = companyRepository;
        this.reviewClient = reviewClient;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company companyToUpdate = optionalCompany.get();
            companyToUpdate.setName(company.getName());
            companyToUpdate.setDescription(company.getDescription());
            companyRepository.save(companyToUpdate);
            return true;
        }
        return false;
    }

    @Override
    public void updateCompanyRating(ReviewMessage reviewMessage) {
        log.info("This is a review message from rabbitMQ: {}", reviewMessage.getDescription());
        Company company = companyRepository.findById(reviewMessage.getCompanyId())
                .orElseThrow(()-> new RuntimeException("NOT_FOUND"));
        double averageRating = reviewClient.getAverageRating(reviewMessage.getCompanyId());
        company.setRating(averageRating);
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompany(Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Company> findCompanyById(Long id) {
        return companyRepository.findById(id);
    }
}
