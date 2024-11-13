package com.pblgllgs.sb3mcsvccompany.company;

import com.pblgllgs.sb3mcsvccompany.dto.ReviewMessage;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    List<Company> findAll();
    void createCompany(Company company);
    Optional<Company> findCompanyById(Long id);
    boolean deleteCompany(Long id);
    boolean updateCompany(Long id, Company company);
    void updateCompanyRating(ReviewMessage reviewMessage);
}
