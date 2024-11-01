package com.ess.recruitment.infrastructure.domain.sql.service.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class Mapper {
    @Bean
    public Mapper modelMapper(){
        return new Mapper();
    }
}
