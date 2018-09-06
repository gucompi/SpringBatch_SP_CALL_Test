package com.SpEjecutator.Ejecutador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class TaskEjecutarSP implements Tasklet {
    private static final Logger logger = LoggerFactory.getLogger(TaskEjecutarSP.class);

    private DataSource dataSource;

    private String getDateSP = "SP_GETDATE_INSERT";
    final String spInsertDate = "EXEC " + getDateSP;
    public TaskEjecutarSP(DataSource dataSource) {
        this.dataSource=dataSource;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
        logger.info("Por Correr SP " + getDateSP);
        jdbcTemplate.execute(spInsertDate);



        return RepeatStatus.FINISHED;
    }
}
