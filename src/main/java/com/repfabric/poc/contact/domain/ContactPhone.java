package com.repfabric.poc.contact.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.repfabric.poc.contact.domain.enums.PhoneType;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A ContactPhone.
 */
@Entity
@Table(name = "contact_phone")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ContactPhone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnore
    private Contact contact;

    @NotNull
    @Column(name = "phone_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private PhoneType phoneType;

    @NotNull
    @Column(name = "phone", nullable = false)
    private String phone;

    public Long getId() {
        return this.id;
    }

    public ContactPhone id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhoneType getPhoneType() {
        return this.phoneType;
    }

    public ContactPhone phoneType(PhoneType phoneType) {
        this.setPhoneType(phoneType);
        return this;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhone() {
        return this.phone;
    }

    public ContactPhone phone(String phone) {
        this.setPhone(phone);
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public ContactPhone contact(Contact contact) {
        this.setContact(contact);
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContactPhone other = (ContactPhone) obj;
        return Objects.equals(this.id, other.id);
    }

        

    @Override
    public String toString() {
        return "ContactPhone{" +
            "id=" + getId() +
            ", phoneType=" + getPhoneType() +
            ", phone='" + getPhone() + "'" +
            "}";
    }
}
