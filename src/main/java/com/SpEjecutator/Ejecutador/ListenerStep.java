package com.SpEjecutator.Ejecutador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;

public class ListenerStep implements  org.springframework.batch.core.StepExecutionListener {
    private static final Logger logger = LoggerFactory.getLogger(ListenerStep.class);

    @Override
    public void beforeStep(StepExecution stepExecution) {
        logger.info("Inicio STEP");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        logger.info("Fin STEP");
        logger.info("Estado STEP :  " +  stepExecution.getExitStatus().toString());
        return null;
    }
}
