package com.repfabric.poc.contact.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * A Contact.
 */
@Entity
@Table(name = "contact")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "suffix")
    private String suffix;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "dept")
    private String dept;

    @Column(name = "location")
    private String location;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "assistant_name")
    private String assistantName;

    @Column(name = "referred_by")
    private String referredBy;

    @Column(name = "context")
    private String context;

    @Column(name = "is_primary")
    private Boolean isPrimary;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "image_p_ath")
    private String imagePAth;

    @Column(name = "notes")
    private String notes;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "ref_no")
    private String refNo;

    @Column(name = "is_global_contact")
    private Boolean isGlobalContact;

    @Column(name = "is_bounce")
    private Boolean isBounce;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_sync")
    private Boolean isSync;

    @ManyToOne(optional = false)
    private Company company;

    @ManyToOne
    private RFUser user;

    @ManyToOne
    private SalesTeam salesTeam;

    @ManyToOne(optional = false)
    private RFUser createrUser;

    @ManyToOne
    private RFUser updateUser;

    @ManyToOne
    private Company parentCompany;

    @ManyToOne
    private CompanyRegion region;

    @Embedded
    private Tenant tenant;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private Set<ContactAddress> addresses = new HashSet<>();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private Set<ContactEmail> emails = new HashSet<>();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private Set<ContactPhone> phones = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public Contact id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public Contact title(String title) {
        this.setTitle(title);
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Contact firstName(String firstName) {
        this.setFirstName(firstName);
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public Contact middleName(String middleName) {
        this.setMiddleName(middleName);
        return this;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Contact lastName(String lastName) {
        this.setLastName(lastName);
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public Contact suffix(String suffix) {
        this.setSuffix(suffix);
        return this;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getFullName() {
        return this.fullName;
    }

    public Contact fullName(String fullName) {
        this.setFullName(fullName);
        return this;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public Contact jobTitle(String jobTitle) {
        this.setJobTitle(jobTitle);
        return this;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDept() {
        return this.dept;
    }

    public Contact dept(String dept) {
        this.setDept(dept);
        return this;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getLocation() {
        return this.location;
    }

    public Contact location(String location) {
        this.setLocation(location);
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManagerName() {
        return this.managerName;
    }

    public Contact managerName(String managerName) {
        this.setManagerName(managerName);
        return this;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getAssistantName() {
        return this.assistantName;
    }

    public Contact assistantName(String assistantName) {
        this.setAssistantName(assistantName);
        return this;
    }

    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName;
    }

    public String getReferredBy() {
        return this.referredBy;
    }

    public Contact referredBy(String referredBy) {
        this.setReferredBy(referredBy);
        return this;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public String getContext() {
        return this.context;
    }

    public Contact context(String context) {
        this.setContext(context);
        return this;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Boolean getIsPrimary() {
        return this.isPrimary;
    }

    public Contact isPrimary(Boolean isPrimary) {
        this.setIsPrimary(isPrimary);
        return this;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public Boolean getIsDelete() {
        return this.isDelete;
    }

    public Contact isDelete(Boolean isDelete) {
        this.setIsDelete(isDelete);
        return this;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getImagePAth() {
        return this.imagePAth;
    }

    public Contact imagePAth(String imagePAth) {
        this.setImagePAth(imagePAth);
        return this;
    }

    public void setImagePAth(String imagePAth) {
        this.imagePAth = imagePAth;
    }

    public String getNotes() {
        return this.notes;
    }

    public Contact notes(String notes) {
        this.setNotes(notes);
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getCreateDate() {
        return this.createDate;
    }

    public Contact createDate(LocalDate createDate) {
        this.setCreateDate(createDate);
        return this;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getUpdateDate() {
        return this.updateDate;
    }

    public Contact updateDate(LocalDate updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getRefNo() {
        return this.refNo;
    }

    public Contact refNo(String refNo) {
        this.setRefNo(refNo);
        return this;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public Boolean getIsGlobalContact() {
        return this.isGlobalContact;
    }

    public Contact isGlobalContact(Boolean isGlobalContact) {
        this.setIsGlobalContact(isGlobalContact);
        return this;
    }

    public void setIsGlobalContact(Boolean isGlobalContact) {
        this.isGlobalContact = isGlobalContact;
    }

    public Boolean getIsBounce() {
        return this.isBounce;
    }

    public Contact isBounce(Boolean isBounce) {
        this.setIsBounce(isBounce);
        return this;
    }

    public void setIsBounce(Boolean isBounce) {
        this.isBounce = isBounce;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public Contact isActive(Boolean isActive) {
        this.setIsActive(isActive);
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsSync() {
        return this.isSync;
    }

    public Contact isSync(Boolean isSync) {
        this.setIsSync(isSync);
        return this;
    }

    public void setIsSync(Boolean isSync) {
        this.isSync = isSync;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Contact company(Company company) {
        this.setCompany(company);
        return this;
    }

    public RFUser getUser() {
        return this.user;
    }

    public void setUser(RFUser rFUser) {
        this.user = rFUser;
    }

    public Contact user(RFUser rFUser) {
        this.setUser(rFUser);
        return this;
    }

    public SalesTeam getSalesTeam() {
        return this.salesTeam;
    }

    public void setSalesTeam(SalesTeam salesTeam) {
        this.salesTeam = salesTeam;
    }

    public Contact salesTeam(SalesTeam salesTeam) {
        this.setSalesTeam(salesTeam);
        return this;
    }

    public RFUser getCreaterUser() {
        return this.createrUser;
    }

    public void setCreaterUser(RFUser rFUser) {
        this.createrUser = rFUser;
    }

    public Contact createrUser(RFUser rFUser) {
        this.setCreaterUser(rFUser);
        return this;
    }

    public RFUser getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(RFUser rFUser) {
        this.updateUser = rFUser;
    }

    public Contact updateUser(RFUser rFUser) {
        this.setUpdateUser(rFUser);
        return this;
    }

    public Company getParentCompany() {
        return this.parentCompany;
    }

    public void setParentCompany(Company company) {
        this.parentCompany = company;
    }

    public Contact parentCompany(Company company) {
        this.setParentCompany(company);
        return this;
    }

    public CompanyRegion getRegion() {
        return this.region;
    }

    public void setRegion(CompanyRegion companyRegion) {
        this.region = companyRegion;
    }

    public Contact region(CompanyRegion companyRegion) {
        this.setRegion(companyRegion);
        return this;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Set<ContactAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<ContactAddress> addresses) {
        if (this.addresses != null) {
            this.addresses.forEach(i -> i.setContact(null));
        }
        if (addresses != null) {
            addresses.forEach(i -> i.setContact(this));
        }
        this.addresses = addresses;
    }

    public Contact addresses(Set<ContactAddress> addresses) {
        this.setAddresses(addresses);
        return this;
    }

    public Contact addAddress(ContactAddress address) {
        this.addresses.add(address);
        address.setContact(this);
        return this;
    }

    public Contact removeAddress(ContactAddress address) {
        this.addresses.remove(address);
        address.setContact(null);
        return this;
    }

    public Set<ContactEmail> getEmails() {
        return emails;
    }

    public void setEmails(Set<ContactEmail> emails) {
        if (this.emails != null) {
            this.emails.forEach(i -> i.setContact(null));
        }
        if (emails != null) {
            emails.forEach(i -> i.setContact(this));
        }
        this.emails = emails;
    }

    public Contact emails(Set<ContactEmail> emails) {
        this.setEmails(emails);
        return this;
    }

    public Contact addEmail(ContactEmail email) {
        this.emails.add(email);
        email.setContact(this);
        return this;
    }

    public Contact removeEmail(ContactEmail email) {
        this.emails.remove(email);
        email.setContact(null);
        return this;
    }
    
    public Set<ContactPhone> getPhones() {
        return phones;
    }

    public void setPhones(Set<ContactPhone> phones) {
        if (this.phones != null) {
            this.phones.forEach(i -> i.setContact(null));
        }
        if (phones != null) {
            phones.forEach(i -> i.setContact(this));
        }
        this.phones = phones;
    }

    public Contact phones(Set<ContactPhone> phones) {
        this.setPhones(phones);
        return this;
    }

    public Contact addPhone(ContactPhone phone) {
        this.phones.add(phone);
        phone.setContact(this);
        return this;
    }

    public Contact removePhone(ContactPhone phone) {
        this.phones.remove(phone);
        phone.setContact(null);
        return this;
    }


    @Override
    public int hashCode() {
        int hash = 3;
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
        final Contact other = (Contact) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Contact{"
                + "id=" + getId()
                + ", title='" + getTitle() + "'"
                + ", firstName='" + getFirstName() + "'"
                + ", middleName='" + getMiddleName() + "'"
                + ", lastName='" + getLastName() + "'"
                + ", suffix='" + getSuffix() + "'"
                + ", fullName='" + getFullName() + "'"
                + ", jobTitle='" + getJobTitle() + "'"
                + ", dept='" + getDept() + "'"
//                + ", location='" + getLocation() + "'"
                + ", managerName='" + getManagerName() + "'"
                + ", assistantName='" + getAssistantName() + "'"
                + ", referredBy='" + getReferredBy() + "'"
//                + ", context='" + getContext() + "'"
                + ", isPrimary='" + getIsPrimary() + "'"
                + ", isDelete='" + getIsDelete() + "'"
                + ", imagePAth='" + getImagePAth() + "'"
                + ", notes='" + getNotes() + "'"
                + ", createDate='" + getCreateDate() + "'"
                + ", updateDate='" + getUpdateDate() + "'"
                + ", refNo='" + getRefNo() + "'"
                + ", isGlobalContact='" + getIsGlobalContact() + "'"
                + ", isBounce='" + getIsBounce() + "'"
                + ", isActive='" + getIsActive() + "'"
                + ", isSync='" + getIsSync() + "'"
                + "}";
    }
}
