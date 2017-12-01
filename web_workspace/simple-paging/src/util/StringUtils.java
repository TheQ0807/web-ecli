package util;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;

import dao.EmployeeDao;
import vo.Employee;

public class StringUtils {

	/**
	 * 문자열의 값이 null 이면 빈 문자를 반환한다.
	 * @param str 원본 문자열
	 * @return  빈 문자나 원본 문자열
	 */
	public static String nullToBlank(String str){
		if(str == null) {
			return "";
		}
		return str.trim();
	}
	/**
	 * 숫자들로 구성된 문자열을 정수값으로 변환해서 반환한다.
	 * @param str 숫자로 구성된 문자열
	 * @return 변환된 정수값, 문자열이 숫자로 구성되어 있지 않거나 null이면 0을 반환한다.
	 */
	
	public static int strToNumber(String str) {
		return strToNumber(str, 0);
	}
	/**
	 * 숫자들로 구성된 문자열을 정수값으로 변환해서 반환한다.
	 * 문자열을 숫자로 변환 중 오류가 발생하면 기본값으로 지정된 값을 반환한다.
	 * @param str 숫자로 구성된 문자열
	 * @param defaultValue 기본값
	 * @return 변환된 정수값, 문자열이 숫자로 구성되어 있지 않거나 null이면 기본값을 반환한다.
	 */
	
	public static int strToNumber(String str, int defaultValue){
		if(str == null){
			return defaultValue;
		}
		try{
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
		
	}	 
}
