package com.kotyara.api;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class TimeEstimatesScheduled {
  @Autowired
  private Job job;
  @Autowired
  private JobLauncher jobLauncher;

  @Autowired
  public TimeEstimatesScheduled(JobLauncher jobLauncher, @Qualifier("importTicketJob") Job job){
    this.job = job;
    this.jobLauncher = jobLauncher;
  }

  @Scheduled(cron = "0 0/1 0 ? * *")
  public void runJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
    System.out.println();
    jobLauncher.run(job, new JobParameters());
  }
}
