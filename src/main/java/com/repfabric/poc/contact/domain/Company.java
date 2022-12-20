package com.repfabric.poc.contact.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * A Company.
 */
@Entity
@Table(name = "company")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "priv_team")
    private String privTeam;

    @ManyToOne
    private SalesTeam salesTeam;

    @ManyToOne
    @JsonIgnoreProperties(value = {"companies"}, allowSetters = true)
    private CompanyType companyType;

    @Embedded
    private Tenant tenant;

    public Long getId() {
        return this.id;
    }

    public Company id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Company name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrivTeam() {
        return this.privTeam;
    }

    public Company privTeam(String privTeam) {
        this.setPrivTeam(privTeam);
        return this;
    }

    public void setPrivTeam(String privTeam) {
        this.privTeam = privTeam;
    }

    public SalesTeam getSalesTeam() {
        return this.salesTeam;
    }

    public void setSalesTeam(SalesTeam salesTeam) {
        this.salesTeam = salesTeam;
    }

    public Company salesTeam(SalesTeam salesTeam) {
        this.setSalesTeam(salesTeam);
        return this;
    }

    public CompanyType getCompanyType() {
        return this.companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public Company companyType(CompanyType companyType) {
        this.setCompanyType(companyType);
        return this;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Company other = (Company) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Company{"
                + "id=" + getId()
                + ", name='" + getName() + "'"
                + ", privTeam='" + getPrivTeam() + "'"
                + "}";
    }
}
