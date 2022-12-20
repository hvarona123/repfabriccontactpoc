package com.repfabric.poc.contact.service.mapper;

import com.repfabric.poc.contact.domain.Company;
import com.repfabric.poc.contact.domain.CompanyRegion;
import com.repfabric.poc.contact.domain.Contact;
import com.repfabric.poc.contact.domain.RFUser;
import com.repfabric.poc.contact.domain.SalesTeam;
import com.repfabric.poc.contact.service.dto.CompanyDTO;
import com.repfabric.poc.contact.service.dto.CompanyRegionDTO;
import com.repfabric.poc.contact.service.dto.ContactDTO;
import com.repfabric.poc.contact.service.dto.RFUserDTO;
import com.repfabric.poc.contact.service.dto.SalesTeamDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Contact} and its DTO {@link ContactDTO}.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactMapper extends EntityMapper<ContactDTO, Contact> {

    @Mapping(target = "company", source = "company", qualifiedByName = "companyId")
    @Mapping(target = "user", source = "user", qualifiedByName = "rFUserId")
    @Mapping(target = "salesTeam", source = "salesTeam", qualifiedByName = "salesTeamId")
    @Mapping(target = "createrUser", source = "createrUser", qualifiedByName = "rFUserId")
    @Mapping(target = "updateUser", source = "updateUser", qualifiedByName = "rFUserId")
    @Mapping(target = "parentCompany", source = "parentCompany", qualifiedByName = "companyId")
    @Mapping(target = "region", source = "region", qualifiedByName = "companyRegionId")
    @Override
    ContactDTO toDto(Contact s);

    @Named("companyId")
    //@BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CompanyDTO toDtoCompanyId(Company company);

    @Named("rFUserId")
    //@BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RFUserDTO toDtoRFUserId(RFUser rFUser);

    @Named("salesTeamId")
    //@BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    SalesTeamDTO toDtoSalesTeamId(SalesTeam salesTeam);

    @Named("companyRegionId")
    //@BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CompanyRegionDTO toDtoCompanyRegionId(CompanyRegion companyRegion);
}
