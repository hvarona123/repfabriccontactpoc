package com.repfabric.poc.contact.service.dto;

import com.repfabric.poc.contact.domain.enums.EmailType;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.rebfabric.poc.contact.domain.ContactEmail} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ContactEmailDTO implements Serializable {

    private Long id;

    @NotNull
    private EmailType emailType;

    @NotNull
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmailType getEmailType() {
        return emailType;
    }

    public void setEmailType(EmailType emailType) {
        this.emailType = emailType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ContactEmailDTO)) {
            return false;
        }

        ContactEmailDTO contactEmailDTO = (ContactEmailDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, contactEmailDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ContactEmailDTO{" +
            "id=" + getId() +
            ", emailType=" + getEmailType() +
            ", email='" + getEmail() + "'" +
            "}";
    }
}
