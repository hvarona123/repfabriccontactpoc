package com.repfabric.poc.contact.service;

import com.repfabric.poc.contact.builder.ContactTestBuilder;
import com.repfabric.poc.contact.domain.Company;
import com.repfabric.poc.contact.domain.Contact;
import com.repfabric.poc.contact.domain.RFUser;
import com.repfabric.poc.contact.repository.ContactRepository;
import com.repfabric.poc.contact.service.dto.CompanyDTO;
import com.repfabric.poc.contact.service.dto.ContactDTO;
import com.repfabric.poc.contact.service.dto.RFUserDTO;
import com.repfabric.poc.contact.service.mapper.ContactMapper;
import com.repfabric.poc.contact.service.mapper.ContactMapperImpl;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.assertj.core.util.Lists;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;

    private final ContactMapper contactMapper = new ContactMapperImpl();

    private ContactService contactService;

    @BeforeEach
    public void setup() {
        contactService = new ContactService(contactRepository, contactMapper);
    }

    @Test
    public void testCreatingSuccess() {

        Company company = new Company();
        RFUser createUser = new RFUser();
        LocalDate localDate = LocalDate.of(2022, Month.DECEMBER, 18);
        company.setId(1L);
        createUser.setId(1L);

        String firstName = "Test Name";

        Contact contact = ContactTestBuilder.contact(firstName, company, createUser, localDate);

        CompanyDTO companyDTO = new CompanyDTO();
        RFUserDTO createUserDTO = new RFUserDTO();
        companyDTO.setId(1L);
        createUserDTO.setId(1L);
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setFirstName(firstName);
        contactDTO.setCompany(companyDTO);
        contactDTO.setCreaterUser(createUserDTO);
        contactDTO.setCreateDate(localDate);
        contactDTO.setUpdateUser(createUserDTO);
        contactDTO.setUpdateDate(localDate);

        Mockito.when(contactRepository.save(Mockito.any(Contact.class))).thenReturn(contact);

        contactService.save(contactDTO);

        ArgumentCaptor<Contact> contactCaptor = ArgumentCaptor.forClass(Contact.class);

        Mockito.verify(contactRepository).save(contactCaptor.capture());

        assertEquals(firstName, contactCaptor.getValue().getFirstName());
    }

    @Test
    public void testGetAll() {
        Company company1 = new Company();
        RFUser createUser1 = new RFUser();
        company1.setId(1L);
        createUser1.setId(1L);
        LocalDate localDate1 = LocalDate.of(2022, Month.DECEMBER, 18);

        Company company2 = new Company();
        RFUser createUser2 = new RFUser();
        LocalDate localDate2 = LocalDate.of(2022, Month.DECEMBER, 19);
        company2.setId(2L);
        createUser2.setId(2L);

        String firstName = "First Name 1";
        String firstName2 = "First Name 2";
        Contact contact = ContactTestBuilder.contact(firstName, company1, createUser1, localDate1);
        Contact contact2 = ContactTestBuilder.contact(firstName2, company2, createUser2, localDate2);
        List<Contact> contactList = Lists.newArrayList(contact, contact2);
        Mockito.when(contactRepository.findAll()).thenReturn(contactList);

        List<ContactDTO> contactDTO = contactService.findAll();

        Mockito.verify(contactRepository).findAll();
        assertEquals(contactDTO.size(), 2);

    }
}
