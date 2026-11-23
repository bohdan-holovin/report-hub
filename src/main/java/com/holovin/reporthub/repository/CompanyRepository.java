package com.holovin.reporthub.repository;

import com.holovin.reporthub.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
}
