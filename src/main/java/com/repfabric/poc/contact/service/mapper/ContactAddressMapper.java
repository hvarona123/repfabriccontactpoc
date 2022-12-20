package com.repfabric.poc.contact.service.mapper;

import com.repfabric.poc.contact.domain.Contact;
import com.repfabric.poc.contact.domain.ContactAddress;
import com.repfabric.poc.contact.service.dto.ContactAddressDTO;
import com.repfabric.poc.contact.service.dto.ContactDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ContactAddress} and its DTO {@link ContactAddressDTO}.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactAddressMapper extends EntityMapper<ContactAddressDTO, ContactAddress> {
    ContactAddressDTO toDto(ContactAddress s);

}
