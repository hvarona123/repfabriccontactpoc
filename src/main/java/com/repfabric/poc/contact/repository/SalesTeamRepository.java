package com.repfabric.poc.contact.repository;

import com.repfabric.poc.contact.domain.SalesTeam;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the SalesTeam entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SalesTeamRepository extends JpaRepository<SalesTeam, Long> {}
