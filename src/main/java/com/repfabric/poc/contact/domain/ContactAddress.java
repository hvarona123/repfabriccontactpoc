package com.repfabric.poc.contact.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.repfabric.poc.contact.domain.enums.AddressType;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A ContactAddress.
 */
@Entity
@Table(name = "contact_address")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ContactAddress implements Serializable {

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
    @Column(name = "address_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private AddressType addressType;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "country")
    private String country;

    @Column(name = "formatted_address")
    private String formattedAddress;

    @Column(name = "po_box")
    private String poBox;

    public Long getId() {
        return this.id;
    }

    public ContactAddress id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContactAddress addressType(AddressType addressType) {
        this.setAddressType(addressType);
        return this;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getAddress() {
        return this.address;
    }

    public ContactAddress address(String address) {
        this.setAddress(address);
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public ContactAddress city(String city) {
        this.setCity(city);
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public ContactAddress state(String state) {
        this.setState(state);
        return this;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public ContactAddress zipCode(String zipCode) {
        this.setZipCode(zipCode);
        return this;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return this.country;
    }

    public ContactAddress country(String country) {
        this.setCountry(country);
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFormattedAddress() {
        return this.formattedAddress;
    }

    public ContactAddress formattedAddress(String formattedAddress) {
        this.setFormattedAddress(formattedAddress);
        return this;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getPoBox() {
        return this.poBox;
    }

    public ContactAddress poBox(String poBox) {
        this.setPoBox(poBox);
        return this;
    }

    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public ContactAddress contact(Contact contact) {
        this.setContact(contact);
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final ContactAddress other = (ContactAddress) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "ContactAddress{"
                + "id=" + getId()
                + ", addressType=" + getAddressType()
                + ", address='" + getAddress() + "'"
                + ", city='" + getCity() + "'"
                + ", state='" + getState() + "'"
                + ", zipCode='" + getZipCode() + "'"
                + ", country='" + getCountry() + "'"
                + ", formattedAddress='" + getFormattedAddress() + "'"
                + ", poBox='" + getPoBox() + "'"
                + "}";
    }
}
