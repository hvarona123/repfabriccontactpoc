package com.repfabric.poc.contact;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Henry
 */
@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
public class RepfabricContactPOC {

    public static void main(String[] args) {
        SpringApplication.run(RepfabricContactPOC.class, args);
    }
    
}
