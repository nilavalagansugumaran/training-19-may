package com.example.demo;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
public class DemoSpringBatchApplication {

	private static int count = 1000;
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBatchApplication.class, args);
	}

    @Autowired
    JobLauncher jobLauncher;
 
    @Autowired
    @Qualifier("myNewJob")
    Job myJob;
    
	@Scheduled(cron = "0 */1 * * * ?")
	public void readFileSchedular() throws Exception {
		
        JobParameters jobParameters = new JobParametersBuilder()
				.addString(Integer.toString(count), "Spring Boot")
				.toJobParameters();
        count++;
        jobLauncher.run(myJob, jobParameters);
	System.out.println("Job started at " + new Date().toLocaleString() );
	
	}
}
