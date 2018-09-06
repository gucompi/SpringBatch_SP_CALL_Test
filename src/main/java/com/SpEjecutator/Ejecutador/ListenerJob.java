package com.SpEjecutator.Ejecutador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;

public class ListenerJob implements org.springframework.batch.core.JobExecutionListener {
    private static final Logger logger = LoggerFactory.getLogger(ListenerJob.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("Inicio JOB ");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        logger.info("FIN JOB");

    }
}
