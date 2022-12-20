package com.repfabric.poc.contact.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.repfabric.poc.contact.domain.enums.EmailType;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A ContactEmail.
 */
@Entity
@Table(name = "contact_email")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ContactEmail implements Serializable {

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
    @Column(name = "email_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EmailType emailType;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    public Long getId() {
        return this.id;
    }

    public ContactEmail id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmailType getEmailType() {
        return this.emailType;
    }

    public ContactEmail emailType(EmailType emailType) {
        this.setEmailType(emailType);
        return this;
    }

    public void setEmailType(EmailType emailType) {
        this.emailType = emailType;
    }

    public String getEmail() {
        return this.email;
    }

    public ContactEmail email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public ContactEmail contact(Contact contact) {
        this.setContact(contact);
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final ContactEmail other = (ContactEmail) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "ContactEmail{"
                + "id=" + getId()
                + ", emailType=" + getEmailType()
                + ", email='" + getEmail() + "'"
                + "}";
    }
}
