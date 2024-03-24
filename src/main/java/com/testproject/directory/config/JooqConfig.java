package com.testproject.directory.config;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JooqConfig {
    @Bean
    public DSLContext dsl() {
        return new DefaultDSLContext(SQLDialect.POSTGRES);
    }
}
