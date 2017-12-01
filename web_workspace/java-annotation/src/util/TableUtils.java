package util;

import java.lang.reflect.Field;

import custom.annotation.Columm;
import custom.annotation.Table;

public class TableUtils {

	public static String parseTableAndColumn(Object obj) throws Exception{
		if(obj == null) {
			return null;
		}
		
		Class<?> claz= obj.getClass();
		Table table = claz.getDeclaredAnnotation(Table.class);
		if (table == null) {
			return null;
		}
		if(!table.generated()) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		result.append("create table ");
		result.append(table.name());
		result.append(" (");
		result.append(System.lineSeparator());
		
		Field[] fields=claz.getDeclaredFields();
		boolean first= true;
		for (Field field : fields) {
			Columm column =field.getDeclaredAnnotation(Columm.class);
			if(column != null) {
				String type = column.type();
				String name = column.name();
				if(first) {
					first=false;
				}else{
					result.append(",");
				}
				result.append(name);
				result.append("");
				result.append(type);
				result.append(System.lineSeparator());
			}
		}	
			
		
		result.append(") ");
		return result.toString();
		
	}
}
