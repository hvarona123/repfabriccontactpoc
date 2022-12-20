// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package com.repfabric.poc.multitenancy.core;

import com.repfabric.poc.contact.domain.Tenant;

public interface TenantAware {

    Tenant getTenant();

    void setTenant(Tenant tenant);
}
