package com.repfabric.poc.contact.service.mapper;

import com.repfabric.poc.contact.domain.Contact;
import com.repfabric.poc.contact.domain.ContactPhone;
import com.repfabric.poc.contact.service.dto.ContactDTO;
import com.repfabric.poc.contact.service.dto.ContactPhoneDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ContactPhone} and its DTO {@link ContactPhoneDTO}.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactPhoneMapper extends EntityMapper<ContactPhoneDTO, ContactPhone> {
    ContactPhoneDTO toDto(ContactPhone s);

}
