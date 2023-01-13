package com.repfabric.poc.contact.builder;


import com.repfabric.poc.contact.domain.Company;
import com.repfabric.poc.contact.domain.Contact;
import com.repfabric.poc.contact.domain.RFUser;
import java.time.LocalDate;

public class ContactTestBuilder {
    
    public static Contact contact(String firstName, Company company, RFUser createUser, LocalDate createDate) {
        
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setCompany(company);
        contact.setCreaterUser(createUser);
        contact.setCreateDate(createDate);
        contact.setUpdateUser(createUser);
        contact.setUpdateDate(createDate);
        
        return contact;
    }
}
