package com.repfabric.poc.contact.repository;

import com.repfabric.poc.contact.domain.CompanyRegion;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CompanyRegion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompanyRegionRepository extends JpaRepository<CompanyRegion, Long> {}
