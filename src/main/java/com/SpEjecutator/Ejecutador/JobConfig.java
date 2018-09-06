package com.SpEjecutator.Ejecutador;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class JobConfig  {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;


    @Bean
    public Job EjecutarSP() {
        return jobBuilderFactory.get("ejecutarSP")
                .incrementer(new RunIdIncrementer())
                .listener(new ListenerJob())
                .start(EjecucionSP())
                .build();
    }

        @Bean
        public Step EjecucionSP () {
            return stepBuilderFactory.get("ejecucionSP")
                    .tasklet(new TaskEjecutarSP(dataSource))
                    .listener(new ListenerStep())
                    .build();
        }

    }