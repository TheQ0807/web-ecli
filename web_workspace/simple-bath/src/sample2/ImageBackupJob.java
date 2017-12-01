package sample2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ImageBackupJob implements Job {

	private String srcDir = "C:\\users\\JHTA\\Pictures\\book2";
	private String backupDir = "c:\\temp";
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
	try{
		File src = new File(srcDir);
		File dest = new File(backupDir);
		
		String[] filenames = src.list();
		for(String filename : filenames){
			FileInputStream fis = new FileInputStream(new File(src , filename));
			FileOutputStream fos = new FileOutputStream(new File(dest, filename));
			
			IOUtils.copy(fis, fos);
		}
	}catch(IOException e){
		
	}
		
	}
	
}
