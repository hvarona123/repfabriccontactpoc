package com.repfabric.poc.contact.service.mapper;

import com.repfabric.poc.contact.domain.CompanyRegion;
import com.repfabric.poc.contact.service.dto.CompanyRegionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CompanyRegion} and its DTO {@link CompanyRegionDTO}.
 */
@Mapper(componentModel = "spring")
public interface CompanyRegionMapper extends EntityMapper<CompanyRegionDTO, CompanyRegion> {}
