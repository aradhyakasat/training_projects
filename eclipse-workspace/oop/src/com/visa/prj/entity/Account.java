/**
 * 
 */
package com.visa.prj.entity;

/**
 * @author Administrator
 *
 */
public class Account {
	/*
	 * state of objects
	 */
	private String accNo;
	private double balance;    //state of object
	private static int count; //class member
	
	public Account(String accNo) {
		super();
		this.accNo = accNo;
		count++;
	}
	
	
	public Account() {
		super();
		count++;
	}


	/**
	 * Documentation comments(for API users)
	 * This method is to credit amount into account
	 * 
	 * @param amt amount to be credited 
	 */
	public void deposit(double amt) { //public void deposit(Account this, double amt)
		balance+=amt;  // this.balance+=amt; this depends on the object
	}
/**
 * This method return current account balance
 */
	public double getBalance() {
		return balance;
	}
	
	public String getAccno() {
		return this.accNo;
	}
	
	public boolean equals(Object obj) {
		Account other=(Account) obj;
        return (this.accNo.equals(other.accNo));
    }
	
	public static int getCount(){
		return count;
	}

}
