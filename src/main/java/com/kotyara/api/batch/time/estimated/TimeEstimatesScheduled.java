package com.kotyara.api.batch.time.estimated;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Profile("local")
@Component
public class TimeEstimatesScheduled {
  
  private Job job;

  private JobLauncher jobLauncher;

  @Autowired
  public TimeEstimatesScheduled(JobLauncher jobLauncher, @Qualifier("importTicketJob") Job job){
    this.job = job;
    this.jobLauncher = jobLauncher;
  }

  @Scheduled(cron = "0 * * * * *")
  public void runJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
    JobParameters param = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis()))
        .toJobParameters();
    jobLauncher.run(job, param);
  }
}
