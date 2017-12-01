package sample3;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import sample2.ImageBackupJob;

public class ImageBackupTrigger {
	
	
	public static void main(String[] args) throws Exception {
		
		JobDetail job = JobBuilder.newJob(ImageZipJob.class).build();
		
		Trigger trigger = TriggerBuilder.newTrigger()
							.withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?")).build();
		
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.scheduleJob(job, trigger);
		scheduler.start();
	}
}
