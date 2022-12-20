package com.repfabric.poc.contact.service.mapper;

import com.repfabric.poc.contact.domain.Contact;
import com.repfabric.poc.contact.domain.ContactEmail;
import com.repfabric.poc.contact.service.dto.ContactDTO;
import com.repfabric.poc.contact.service.dto.ContactEmailDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ContactEmail} and its DTO {@link ContactEmailDTO}.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactEmailMapper extends EntityMapper<ContactEmailDTO, ContactEmail> {
    
    @Override
    ContactEmailDTO toDto(ContactEmail s);
    
    

    /*@Named("contactId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ContactDTO toDtoContactId(Contact contact);*/
}
