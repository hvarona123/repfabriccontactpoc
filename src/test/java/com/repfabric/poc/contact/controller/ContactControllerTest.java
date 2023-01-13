package com.repfabric.poc.contact.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.repfabric.poc.contact.RepfabricContactPOC;
import com.repfabric.poc.contact.service.dto.CompanyDTO;
import com.repfabric.poc.contact.service.dto.ContactDTO;
import com.repfabric.poc.contact.service.dto.RFUserDTO;
import java.time.LocalDate;
import java.util.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = RepfabricContactPOC.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:contactpoctest.properties")
class ContactControllerTest {
    private static final String TEMPLATE_PATH = "/api/contacts";

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void shouldFetchAllContacts() throws Exception {
        this.mockMvc.perform(get(TEMPLATE_PATH)).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName", Is.is("First Name 1")))
                .andExpect(jsonPath("$[0].assistantName", Is.is("Assistant 1")))
                .andExpect(jsonPath("$[1].firstName", Is.is("First Name 2")))
                .andExpect(jsonPath("$[1].assistantName", Is.is("Assistant 2")))
                .andExpect(jsonPath("$[2].firstName", Is.is("First Name 3")))
                .andExpect(jsonPath("$[2].assistantName", Is.is("Assistant 3")))
                .andExpect(jsonPath("$[3].firstName", Is.is("First Name 4")))
                .andExpect(jsonPath("$[3].assistantName", Is.is("Assistant 4")))
                .andExpect(jsonPath("$[4].firstName", Is.is("First Name 5")))
                .andExpect(jsonPath("$[4].assistantName", Is.is("Assistant 5")))
                .andExpect(jsonPath("$[5].firstName", Is.is("First Name 6")))
                .andExpect(jsonPath("$[5].assistantName", Is.is("Assistant 6")));
    }

    @Test
    public void shouldFetchOneContactById() throws Exception {
        long id = 1L;
        this.mockMvc.perform(get(TEMPLATE_PATH + "/{id}", id)).andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", Is.is("First Name 1")));
    }

    @Test
    public void shouldGetErrorWhenFetchContactById() throws Exception {
        long id = 99999L;
        this.mockMvc.perform(get(TEMPLATE_PATH + "/{id}", id))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldCreateNewContact() throws Exception {
        CompanyDTO company = new CompanyDTO();
        RFUserDTO createUser = new RFUserDTO();
        
        company.setId(1L);
        createUser.setId(1L);
        
        Date createDate = new Date();
        Long epochDay = createDate.getTime() / (1000 * 60 * 60 * 24);

        ContactDTO contact = new ContactDTO();
        contact.setFirstName("testName");
        contact.setCompany(company);
        contact.setCreaterUser(createUser);
        contact.setCreateDate(LocalDate.ofEpochDay(epochDay));
        contact.setUpdateUser(createUser);
        contact.setUpdateDate(LocalDate.ofEpochDay(epochDay));


        MvcResult result = this.mockMvc.perform(post(TEMPLATE_PATH).contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(contact)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName", Is.is(contact.getFirstName())))
                .andReturn();
        
        ContactDTO contactAnswer = objectMapper.readValue(result.getResponse().getContentAsString(),ContactDTO.class);
        this.mockMvc.perform(get(TEMPLATE_PATH + "/{id}", contactAnswer.getId())).andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", Is.is(contact.getFirstName())));
    }

    @Test
    public void invalidInputShouldReturnError() throws Exception {
        CompanyDTO company = new CompanyDTO();
        RFUserDTO createUser = new RFUserDTO();
        
        company.setId(1L);
        createUser.setId(1L);
        
        Date createDate = new Date();
        Long epochDay = createDate.getTime() / (1000 * 60 * 60 * 24);

        ContactDTO contact = new ContactDTO();
        contact.setFirstName(null);
        contact.setCompany(company);
        contact.setCreaterUser(createUser);
        contact.setCreateDate(LocalDate.ofEpochDay(epochDay));
        contact.setUpdateUser(createUser);
        contact.setUpdateDate(LocalDate.ofEpochDay(epochDay));

        this.mockMvc.perform(post(TEMPLATE_PATH).contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(contact)))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertThat(
                        result.getResponse().getContentAsString()).contains("Contact first name can't be null."));
    }

    
    @Test
    public void invalidFirstNameInputShouldReturnError() throws Exception {
        CompanyDTO company = new CompanyDTO();
        RFUserDTO createUser = new RFUserDTO();
        
        company.setId(1L);
        createUser.setId(1L);
        
        Date createDate = new Date();
        Long epochDay = createDate.getTime() / (1000 * 60 * 60 * 24);

        ContactDTO contact = new ContactDTO();
        contact.setFirstName("First Name".repeat(255));
        contact.setCompany(company);
        contact.setCreaterUser(createUser);
        contact.setCreateDate(LocalDate.ofEpochDay(epochDay));
        contact.setUpdateUser(createUser);
        contact.setUpdateDate(LocalDate.ofEpochDay(epochDay));

        this.mockMvc.perform(post(TEMPLATE_PATH).contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(contact)))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertThat(
                        result.getResponse().getContentAsString()).contains("Contact First Name maximum size is 255 characters."));
    }

}