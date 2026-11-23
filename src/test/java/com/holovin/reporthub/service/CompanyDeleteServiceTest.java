package com.holovin.reporthub.service;

import com.holovin.reporthub.AbstractUnitTest;
import com.holovin.reporthub.model.Company;
import com.holovin.reporthub.model.Report;
import com.holovin.reporthub.utils.RandomUtils;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.holovin.reporthub.utils.RandomUtils.createRandomReport;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CompanyDeleteServiceTest extends AbstractUnitTest {

    @Mock
    private ReportService reportService;

    @Mock
    private CompanyService companyService;

    @InjectMocks
    private CompanyDeleteService companyDeleteService;

    @Test
    void shouldCascadeDeleteCompany() {
        // Given
        Company company = RandomUtils.createRandomCompany();
        List<Report> reports = List.of(createRandomReport(company), createRandomReport(company));
        List<UUID> reportIds = reports.stream().map(Report::getId).collect(Collectors.toList());

        when(reportService.getAllReportsByCompanyId(company.getId())).thenReturn(reports);

        // When
        companyDeleteService.cascadeCompanyDelete(company.getId());

        // Then
        verify(reportService).getAllReportsByCompanyId(company.getId());
        verify(reportService).cascadeDeleteAllReportByReportId(reportIds);
        verify(companyService).deleteCompanyByCompanyId(company.getId());
    }
}
