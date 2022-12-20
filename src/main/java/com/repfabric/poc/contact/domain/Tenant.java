package com.repfabric.poc.contact.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Tenant {

    @Column(name = "tenantId")
    private String tenantName;

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
}
