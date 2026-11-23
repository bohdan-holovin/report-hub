package com.holovin.reporthub.repository;

import com.holovin.reporthub.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, UUID> {

    List<Report> findAllByCompanyId(UUID companyId);
}
