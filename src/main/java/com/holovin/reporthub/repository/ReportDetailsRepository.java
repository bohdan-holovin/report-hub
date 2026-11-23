package com.holovin.reporthub.repository;

import com.holovin.reporthub.model.ReportDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ReportDetailsRepository extends MongoRepository<ReportDetails, UUID> {
}
