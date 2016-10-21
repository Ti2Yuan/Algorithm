package com.chen.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//generate SQL sentences using annotation

public class Test {

	public static void main(String[] args) {
		Filter f1 = new Filter();
		f1.setId(10);
		
		Filter f2 = new Filter();
		f2.setUserName("lucy");
		f2.setAge(18);
		
		Filter f3 = new Filter();
		f3.setEmail("liu@sina.com,zh@163.com,chenti@qq.com");
		
		Filter2 f4 = new Filter2();
		f4.setLeader("chen");
		f4.setName("technology");
		
		String sql1 = query(f1);
		String sql2 = query(f2);
		String sql3 = query(f3);
		String sql4 = query(f4);
		
		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql3);
		System.out.println(sql4);
	}
	
/**
 * 利用反射原理解析注解
 * @param f
 * @return
 */
	private static String query(Object f) {
		StringBuilder sb = new StringBuilder();
		//1.获取到class
		Class c = f.getClass();
		//2.获取到table的名字
		boolean exists = c.isAnnotationPresent(Table.class);
		if(!exists){
			return null;
		}
		Table table = (Table) c.getAnnotation(Table.class);
		String tableName = table.value();
		sb.append("select * from ").append(tableName).append(" where 1=1");
		//遍历所有字段
		Field[] fields = c.getDeclaredFields();
		for(Field field:fields){
			//处理每个字段对应的sql
			//拿到字段名
			boolean fExists = field.isAnnotationPresent(Column.class);
			if(!fExists){
				continue;
			}
			Column column = field.getAnnotation(Column.class);
			String columnName = column.value();
			//拿到字段的值
			String fieldName = field.getName();
			String getMethodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
			Method getMethod;
			Object fieldValue = null;
			try {
				getMethod = c.getMethod(getMethodName);
				fieldValue = getMethod.invoke(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//拼装sql
			if(fieldValue == null || (fieldValue instanceof Integer && (Integer)fieldValue == 0)){
				continue;
			}
			sb.append(" and ").append(fieldName).append("=");
			if(fieldValue instanceof String){
				if(((String) fieldValue).contains(",")){
					String[] values = ((String) fieldValue).split(",");
					sb.append(" in(");
					for(String value:values){
						sb.append("'").append(value).append("'").append(",");
					}
					sb.deleteCharAt(sb.length()-1);
					sb.append(")");
				}else {
					sb.append("'").append(fieldValue).append("'");					
				}
			}else {
				sb.append(fieldValue);				
			}
			
		}
		return sb.toString();
	}

}
