package com.chen.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
@Target({ElementType.TYPE})   //ע���ʹ�÷�Χ  �˴�Ϊ��
//ע�����������  ��Ҫ��3��:Դ���루class�ļ������ڣ��������ڣ�class�ļ����ڣ�������ʱ
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {

	String value();
}
