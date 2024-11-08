package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.JobsDTO;
import com.ess.recruitment.infrastructure.domain.sql.model.JobsEntity;
import com.ess.recruitment.infrastructure.domain.sql.repo.JobsRepository;
import com.ess.recruitment.infrastructure.domain.sql.service.handler.MapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobsServiceImpl implements JobsService {
    @Autowired
    JobsRepository jobsRepository;
    @Autowired
    MapperConfig mapperConfig;

    @Override
    public JobsDTO createJob(JobsDTO jobsDTO) {
        JobsEntity jobsEntity= mapperConfig.toEntity(jobsDTO);
        JobsEntity saveJobsEntity=jobsRepository.save(jobsEntity);
        JobsDTO saveDto=mapperConfig.toDto(saveJobsEntity);
        return saveDto;
    }

    @Override
    public List<JobsDTO> getAll() {
        List<JobsEntity> jobsEntity = jobsRepository.findAll();
        List<JobsDTO> jobsDTOList = new ArrayList<>();
        for(JobsEntity jobsEntity1: jobsEntity){
            JobsDTO jobsDTO = mapperConfig.toDto(jobsEntity1);
            jobsDTOList.add(jobsDTO);
        }
        return jobsDTOList;
    }

    @Override
    public JobsDTO getById(Long jobId) {
        JobsEntity jobsEntity  =jobsRepository.findById(jobId).orElseThrow();
        JobsDTO jobsDTO = mapperConfig.toDto(jobsEntity);
        return jobsDTO;
    }

}
