package com.repfabric.poc.contact.service.mapper;

import com.repfabric.poc.contact.domain.SalesTeam;
import com.repfabric.poc.contact.service.dto.SalesTeamDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SalesTeam} and its DTO {@link SalesTeamDTO}.
 */
@Mapper(componentModel = "spring")
public interface SalesTeamMapper extends EntityMapper<SalesTeamDTO, SalesTeam> {}
