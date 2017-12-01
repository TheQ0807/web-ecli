package util;

import java.lang.reflect.Method;

import custom.annotation.Path;
import web.BoardController;

public class PathUtils {

	public static void parsePath(Object obj) throws Exception{
		// 전달받은 객체의 설계도 정보를 담고 있는 Class 타입의 객체를 반환한다.
		Class<?> clazz = obj.getClass();
		
		// 선언된 메소드 정보 조회하기
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method: methods) {
			// 메소드에 정의된 어노테이션 정보 조회하기
			Path pathAnnotation = method.getDeclaredAnnotation(Path.class);
			// 어노테이션의 요소값 조회하기
			String pathValue = pathAnnotation.value();
			
			System.out.println(method.getName()+" : "+ pathValue);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		PathUtils.parsePath(new BoardController());
	}
}
