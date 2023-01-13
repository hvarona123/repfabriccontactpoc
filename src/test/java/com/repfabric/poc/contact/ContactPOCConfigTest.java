package com.repfabric.poc.contact;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebMvcConfig.class)
@TestPropertySource(
        locations = "classpath:contactpoctest.properties")
class ContactPOCConfigTest {

    @Autowired
    WebMvcConfig applicationConfig;

    @Test
    void webMvcTest() {
        Assertions.assertThat(applicationConfig).isInstanceOf(WebMvcConfig.class);
    }

}
