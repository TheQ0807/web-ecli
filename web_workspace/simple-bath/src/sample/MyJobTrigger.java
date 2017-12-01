package sample;

import org.apache.log4j.spi.TriggeringEventEvaluator;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

import com.oracle.webservices.internal.api.databinding.Databinding.Builder;

public class MyJobTrigger {

	public static void main(String[] args) throws Exception {
		
		// JobDetail 객체 생성
		// JobDetail 객체는 실행할 Job 객체, jobName, jobGroup 정보를 가진다.
		JobDetail job = JobBuilder.newJob(MyJob.class)
				.withIdentity("myjob","mygroup")
				.build();
		
		// Trigger 객체 생성
		/*Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("mytrigger","mygroup")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();*/
		
		//cron 표현식
		// * * * *  * *
		// 초 분 시 일 월 요일
		Trigger trigger = TriggerBuilder
							.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0 35 17 * * ?")).build();
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.scheduleJob(job, trigger);
		scheduler.start();
		
		
	}
}
