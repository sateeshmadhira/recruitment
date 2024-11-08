package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.InterviewDto;
import com.ess.recruitment.infrastructure.domain.sql.model.InterviewEntity;
import com.ess.recruitment.infrastructure.domain.sql.repository.InterviewRepository;
import com.ess.recruitment.infrastructure.domain.sql.service.handler.MapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    MapperConfig mapperConfig;

    @Autowired
    InterviewRepository interviewRepository;

    @Override
    public InterviewDto createInterivew(InterviewDto interviewDto) {
        InterviewEntity interviewEntity =mapperConfig.toInterviewEntity(interviewDto);
        InterviewEntity saveInterviewEntity = interviewRepository.save(interviewEntity);
        InterviewDto saveDto=mapperConfig.toInterviewDto(saveInterviewEntity);
        return saveDto;
    }
}
