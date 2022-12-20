package com.repfabric.poc.contact.repository;

import com.repfabric.poc.contact.domain.ContactEmail;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ContactEmail entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ContactEmailRepository extends JpaRepository<ContactEmail, Long> {}
