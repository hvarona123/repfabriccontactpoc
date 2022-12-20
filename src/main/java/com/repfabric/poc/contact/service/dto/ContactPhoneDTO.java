package com.repfabric.poc.contact.service.dto;

import com.repfabric.poc.contact.domain.enums.PhoneType;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotNull;


/**
 * A DTO for the {@link com.rebfabric.poc.contact.domain.ContactPhone} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ContactPhoneDTO implements Serializable {

    private Long id;

    @NotNull
    private PhoneType phoneType;

    @NotNull
    private String phone;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ContactPhoneDTO)) {
            return false;
        }

        ContactPhoneDTO contactPhoneDTO = (ContactPhoneDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, contactPhoneDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ContactPhoneDTO{" +
            "id=" + getId() +
            ", phoneType=" + getPhoneType() +
            ", phone='" + getPhone() + "'" +
            "}";
    }
}
