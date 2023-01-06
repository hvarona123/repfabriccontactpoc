package com.repfabric.poc.contact;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.repfabric.poc.contact.domain.Company;
import com.repfabric.poc.contact.domain.CompanyRegion;
import com.repfabric.poc.contact.domain.CompanyType;
import com.repfabric.poc.contact.domain.Contact;
import com.repfabric.poc.contact.domain.ContactAddress;
import com.repfabric.poc.contact.domain.ContactEmail;
import com.repfabric.poc.contact.domain.ContactPhone;
import com.repfabric.poc.contact.domain.RFUser;
import com.repfabric.poc.contact.domain.SalesTeam;
import com.repfabric.poc.contact.domain.Tenant;
import com.repfabric.poc.contact.domain.enums.AddressType;
import com.repfabric.poc.contact.domain.enums.EmailType;
import com.repfabric.poc.contact.domain.enums.PhoneType;
import com.repfabric.poc.contact.repository.CompanyRegionRepository;
import com.repfabric.poc.contact.repository.CompanyRepository;
import com.repfabric.poc.contact.repository.CompanyTypeRepository;
import com.repfabric.poc.contact.repository.ContactRepository;
import com.repfabric.poc.contact.repository.RFUserRepository;
import com.repfabric.poc.contact.repository.SalesTeamRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author Henry
 */
@Component
public class DataGenerator implements ApplicationListener<ApplicationReadyEvent> {

    private static final Faker faker = Faker.instance();

    private final CompanyRegionRepository companyRegionRepository;
    private final CompanyTypeRepository companyTypeRepository;
    private final CompanyRepository companyRepository;
    private final ContactRepository contactRepository;
    private final SalesTeamRepository salesTeamRepository;
    private final RFUserRepository userRepository;

    private static final int TENANT_AMOUNT = 3;

    private static final int MIN_COMPANIES = 20;
    private static final int MAX_COMPANIES = 30;

    private static final int MIN_REGION = 10;
    private static final int MAX_REGION = 50;

    private static final int MIN_COMPANY_TYPE = 5;
    private static final int MAX_COMPANY_TYPE = 20;

    private static final int MIN_SALES_TEAM = 10;
    private static final int MAX_SALES_TEAM = 20;

    private static final int MIN_CONTACT = 5;
    private static final int MAX_CONTACT = 60;

    private static final int MIN_USER = 5;
    private static final int MAX_USER = 15;

    private static final int SALES_TEAM_PERCENTAGE = 45;

    private static final int UPDATE_USER_PERCENTAGE = 65;
    private static final int USER_PERCENTAGE = 1;

    @Value("${app.generatedata}")
    private boolean generateData;

    public DataGenerator(CompanyRegionRepository companyRegionRepository, CompanyTypeRepository companyTypeRepository, CompanyRepository companyRepository, ContactRepository contactRepository, SalesTeamRepository salesTeamRepository, RFUserRepository userRepository) {
        this.companyRegionRepository = companyRegionRepository;
        this.companyTypeRepository = companyTypeRepository;
        this.companyRepository = companyRepository;
        this.contactRepository = contactRepository;
        this.salesTeamRepository = salesTeamRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent e) {
        if (generateData) {
            this.createData();
        }
    }

    public boolean isGenerateData() {
        return generateData;
    }

    public void setGenerateData(boolean generateData) {
        this.generateData = generateData;
    }

    public void createData() {
        System.out.println("on Create data");
        Random random = new Random();
        for (int i = 0; i < TENANT_AMOUNT; i++) {
            Tenant tenant = new Tenant();
            tenant.setTenantName(Integer.toString(i));

            int regionAmount = random.nextInt(MAX_REGION - MIN_REGION) + MIN_REGION;
            int companyTypeAmount = random.nextInt(MAX_COMPANY_TYPE - MIN_COMPANY_TYPE) + MIN_COMPANY_TYPE;
            int salesTeamAmount = random.nextInt(MAX_SALES_TEAM - MIN_SALES_TEAM) + MIN_SALES_TEAM;
            int companyAmount = random.nextInt(MAX_COMPANIES - MIN_COMPANIES) + MIN_COMPANIES;
            int userAmount = random.nextInt(MAX_USER - MIN_USER) + MIN_USER;

            List<CompanyRegion> regions = new ArrayList();
            List<CompanyType> companyTypes = new ArrayList();
            List<SalesTeam> salesTeams = new ArrayList();
            List<RFUser> users = new ArrayList();

            for (int j = 0; j < regionAmount; j++) {
                CompanyRegion region = createFakeRegion(tenant);
                regions.add(region);
            }

            for (int j = 0; j < companyTypeAmount; j++) {
                CompanyType type = createFakeCompanyType(tenant);
                companyTypes.add(type);
            }

            for (int j = 0; j < salesTeamAmount; j++) {
                SalesTeam salesTeam = createFakeSalesTeam(tenant);
                salesTeams.add(salesTeam);
            }

            for (int j = 0; j < userAmount; j++) {
                RFUser user = createFakeUser(tenant);
                users.add(user);
            }

            for (int j = 0; j < companyAmount; j++) {

                Company company = createFakeCompany(companyTypes.get(random.nextInt(companyTypeAmount)),
                        salesTeams.get(random.nextInt(salesTeamAmount)), tenant);
                int contactAmount = random.nextInt(MAX_CONTACT - MIN_CONTACT) + MIN_CONTACT;
                for (int k = 0; k < contactAmount; k++) {
                    createFakeContact(company, users.get(random.nextInt(userAmount)), regions.get(random.nextInt(regionAmount)),
                            random.nextInt(100) < SALES_TEAM_PERCENTAGE ? salesTeams.get(random.nextInt(salesTeamAmount)) : null,
                            random.nextInt(100) < UPDATE_USER_PERCENTAGE ? users.get(random.nextInt(userAmount)) : null,
                            random.nextInt(100) < USER_PERCENTAGE ? users.get(random.nextInt(userAmount)) : null,
                            tenant);
                }
            }

        }
    }

    private CompanyRegion createFakeRegion(Tenant tenant) {

        CompanyRegion region = new CompanyRegion();
        region.setName(faker.address().state());
        region.setTenant(tenant);
        region = companyRegionRepository.save(region);
        return region;
    }

    private CompanyType createFakeCompanyType(Tenant tenant) {
        CompanyType type = new CompanyType();
        type.setName(faker.company().profession());
        type.setTenant(tenant);
        type = companyTypeRepository.save(type);
        return type;
    }

    private SalesTeam createFakeSalesTeam(Tenant tenant) {
        SalesTeam salesTeam = new SalesTeam();
        salesTeam.setName(faker.team().name());
        salesTeam.setTenant(tenant);
        salesTeam = salesTeamRepository.save(salesTeam);
        return salesTeam;
    }

    private Company createFakeCompany(CompanyType companyType, SalesTeam salesTeam, Tenant tenant) {
        Company company = new Company();
        company.setName(faker.company().name());
        company.setCompanyType(companyType);
        company.setSalesTeam(salesTeam);
        company.setPrivTeam(faker.company().catchPhrase());
        company.setTenant(tenant);
        company = companyRepository.save(company);
        return company;
    }

    private RFUser createFakeUser(Tenant tenant) {
        RFUser user = new RFUser();
        user.setName(faker.name().name());
        user.setTenant(tenant);

        user = userRepository.save(user);
        return user;
    }

    public Contact createFakeContact(Company company, RFUser createUser, CompanyRegion region, SalesTeam salesTeam, RFUser updateUser, RFUser contactUser, Tenant tenant) {
        Contact contact = new Contact();
        contact.setCompany(company);
        if (faker.bool().bool()) {
            contact.setAssistantName(faker.name().fullName());
        }
//        contact.setContext("");
        contact.setCreateDate(LocalDate.ofEpochDay(faker.date().past(5, TimeUnit.DAYS).getTime() / 86400000L));
        contact.setCreaterUser(createUser);
        contact.setDept(faker.commerce().department());
        Name contactName = faker.name();
        contact.setFirstName(contactName.firstName());
        contact.setFullName(contactName.fullName());
        contact.setLastName(contactName.lastName());
        contact.setImagePAth(faker.company().logo());
        contact.setIsActive(Boolean.TRUE);
        contact.setIsBounce(Boolean.FALSE);
        contact.setIsDelete(Boolean.FALSE);
        contact.setIsGlobalContact(Boolean.FALSE);
        contact.setIsPrimary(Boolean.TRUE);
        contact.setIsSync(Boolean.FALSE);
        contact.setJobTitle(faker.job().title());
//        contact.setLocation(faker.address().fullAddress());
        if (faker.bool().bool()) {
            contact.setManagerName(faker.name().fullName());
        }
        contact.setMiddleName(faker.name().firstName());
        contact.setNotes(faker.chuckNorris().fact());
        contact.setParentCompany(null);
        contact.setRefNo(faker.commerce().promotionCode());
        contact.setReferredBy(faker.name().fullName());
        contact.setRegion(region);
        contact.setSalesTeam(salesTeam);
        contact.setSuffix(contactName.suffix());
        contact.setTenant(tenant);
        contact.setTitle(contactName.title());
        if (updateUser != null) {
            contact.setUpdateDate(LocalDate.now());
            contact.setUpdateUser(updateUser);
        }
        contact.setUser(contactUser);

        if (faker.bool().bool()) {
            contact.addEmail(createFakeEmail(EmailType.BUSINESS, contact));
            if (faker.bool().bool()) {
                contact.addEmail(createFakeEmail(EmailType.BUSINESS2, contact));
            }
        }

        if (contact.getEmails().isEmpty() || faker.bool().bool()) {
            contact.addEmail(createFakeEmail(EmailType.PERSONAL, contact));
        }

        if (!contact.getEmails().isEmpty() && faker.bool().bool()) {
            contact.addEmail(createFakeEmail(EmailType.ALTERNATIVE, contact));
        }

        if (faker.bool().bool()) {
            contact.addPhone(createFakePhone(contact, PhoneType.BUSINESS));
        }

        if (faker.bool().bool()) {
            contact.addPhone(createFakePhone(contact, PhoneType.ALTERNATIVE));
        }

        if (faker.bool().bool()) {
            contact.addPhone(createFakePhone(contact, PhoneType.FAX));
        }

        if (contact.getPhones().isEmpty() || faker.bool().bool()) {
            contact.addPhone(createFakePhone(contact, PhoneType.HOME));
        }

        if (faker.bool().bool()) {
            contact.addAddress(createFakeAddress(AddressType.HOME, contact));

            if (faker.bool().bool()) {
                contact.addAddress(createFakeAddress(AddressType.BUSINESS, contact));
            }
        } else {
            contact.addAddress(createFakeAddress(AddressType.BUSINESS, contact));
        }

        contact = contactRepository.save(contact);
        return contact;
    }

    private static ContactPhone createFakePhone(Contact contact, PhoneType phoneType) {
        ContactPhone phone = new ContactPhone();
        phone.setPhoneType(phoneType);
        phone.setPhone(faker.phoneNumber().phoneNumber());
        phone.setContact(contact);

        return phone;
    }

    private static ContactEmail createFakeEmail(EmailType type, Contact contact) {
        ContactEmail email = new ContactEmail();
        email.setEmailType(type);
        email.setEmail(faker.internet().emailAddress());
        email.setContact(contact);
        return email;
    }

    private static ContactAddress createFakeAddress(AddressType type, Contact contact) {
        Address cAddress = faker.address();
        ContactAddress address = new ContactAddress();
        address.setAddressType(type);
        address.setAddress(cAddress.fullAddress());
        address.setCity(cAddress.cityName());
        address.setContact(contact);
        address.setCountry(cAddress.country());
        address.setFormattedAddress(cAddress.fullAddress());
        address.setPoBox(faker.commerce().promotionCode());
        address.setState(cAddress.state());
        address.setZipCode(cAddress.zipCode());
        return address;
    }
}
