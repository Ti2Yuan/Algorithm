/**
 * 
 */
package com.chen.designpattern.proxy.staticproxy;

/**
 * 银行柜员，相当于代理类
 */
public class BankTeller implements BankAccount {
	
	private BankAccount bankAccount;
	
	public BankTeller(BankAccount bankAccount){
		this.bankAccount = bankAccount;
	}

	/* TODO
	 * @see com.chen.designpattern.proxy.staticproxy.BankAccount#query()
	 */
	@Override
	public void query() {
		System.out.println("hello! what can I do for you?");
		bankAccount.query();
		System.out.println("ok! ");
	}

	/* TODO
	 * @see com.chen.designpattern.proxy.staticproxy.BankAccount#take()
	 */
	@Override
	public void take() {
		System.out.println("hello! what can I do for you?");
		bankAccount.take();
		System.out.println("ok! ");
	}

	/* TODO
	 * @see com.chen.designpattern.proxy.staticproxy.BankAccount#add()
	 */
	@Override
	public void add() {
		System.out.println("hello! what can I do for you?");
		bankAccount.add();
		System.out.println("ok! ");
	}

}
