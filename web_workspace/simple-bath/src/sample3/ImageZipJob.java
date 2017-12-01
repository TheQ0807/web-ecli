package sample3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ImageZipJob implements Job {

	private String srcDir = "C:\\users\\JHTA\\Pictures\\book2";
	private String backupDir = "c:\\temp";
	
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("이미지 백업 시작");
		try {
			String zipFilename = System.currentTimeMillis() + ".zip";
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(new File(backupDir,zipFilename)));
			
			File src = new File(srcDir);
			File[] files =  src.listFiles();
			
			byte[] buf = new byte[1024];
			for(File f : files){
				if(f.isFile()){
					ZipEntry entry = new ZipEntry(f.getName());
					out.putNextEntry(entry);
					
					FileInputStream in = new FileInputStream(f);
					
					int len = 0;
					while((len=in.read(buf)) != -1){
						out.write(buf, 0, len);
					}
					in.close();
				}
			}
			out.closeEntry();
			out.close();
			
			System.out.println("이미지 백업 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
