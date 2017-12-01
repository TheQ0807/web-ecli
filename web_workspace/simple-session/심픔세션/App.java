import org.apache.commons.codec.digest.DigestUtils;

public class App {

	public static void main(String[] args) throws Exception {
		
		String text1 = "zxcv1234";
		String text2 = "zxcv1233";
		
		String md5Text1 = DigestUtils.md5Hex(text1);
		String md5Text2 = DigestUtils.md5Hex(text2);
		System.out.println("md5 : "+ md5Text1);
		System.out.println("md5 : "+ md5Text2);
		
		String shaText1 = DigestUtils.sha256Hex(text1);
		String shaText2 = DigestUtils.sha256Hex(text2);
		System.out.println("sha256 : "+shaText1);
		System.out.println("sha256 : "+shaText2);
	}
}
