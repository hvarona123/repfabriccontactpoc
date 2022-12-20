package com.repfabric.poc.contact.repository;

import com.repfabric.poc.contact.domain.RFUser;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the RFUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RFUserRepository extends JpaRepository<RFUser, Long> {}
