package com.chen.junit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@Suite.SuiteClasses({TaskTest1.class,TaskTest2.class,TaskTest3.class})
public class SuiteTest {

	/**
	 * 1.�����׼�������֯������һ�����е�
	 * 
	 * дһ����Ϊ�����׼�������࣬������ﲻ���������ķ���
	 * ���Ĳ���������Suite.class
	 * ��Ҫ���Ե�����Ϊ���鴫�뵽Suite.SuiteClass({})
	 */
}
