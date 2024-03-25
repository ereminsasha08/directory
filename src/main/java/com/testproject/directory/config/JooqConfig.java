package com.testproject.directory.config;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JooqConfig {
    @Value("${spring.jpa.properties.hibernate.dialect}")
    public String dialect;
    @Bean
    public DSLContext dsl() {
        return new DefaultDSLContext(dialect.contains("PostgreSQL")? SQLDialect.POSTGRES: SQLDialect.H2);
    }
}
