/**
 * 
 */
package com.chen.designpattern.proxy.staticproxy;

/**
 * 我的个人银行账户，实现BankAccount接口
 */
public class MyBankAccount implements BankAccount {

	/* TODO
	 * @see com.chen.designpattern.proxy.staticproxy.BankAccount#query()
	 */
	@Override
	public void query() {
		System.out.println("query my bank account money----");
	}

	/* TODO
	 * @see com.chen.designpattern.proxy.staticproxy.BankAccount#take()
	 */
	@Override
	public void take() {
		System.out.println("take money from my bank account----");
	}

	/* TODO
	 * @see com.chen.designpattern.proxy.staticproxy.BankAccount#add()
	 */
	@Override
	public void add() {
		System.out.println("add money to my bank account----");
	}

}
