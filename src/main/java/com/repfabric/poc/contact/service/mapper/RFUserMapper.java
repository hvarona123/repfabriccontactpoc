package com.repfabric.poc.contact.service.mapper;

import com.repfabric.poc.contact.domain.RFUser;
import com.repfabric.poc.contact.service.dto.RFUserDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link RFUser} and its DTO {@link RFUserDTO}.
 */
@Mapper(componentModel = "spring")
public interface RFUserMapper extends EntityMapper<RFUserDTO, RFUser> {}
