package com.visa.prj.client;

import com.visa.prj.entity.Account;

public class AccountClient {

	public static void main(String[] args) {
		Account rahulAcc=new Account();
		System.out.println(Account.getCount());
		Account shwetaAcc=new Account("SB120");
		System.out.println(Account.getCount());
		rahulAcc.deposit(4500.00); //deposit(Account,4500)
		shwetaAcc.deposit(6780.00);
		
		System.out.println(rahulAcc.getBalance());
		System.out.println(shwetaAcc.getBalance());

		Account smithaAcc=new Account("SB120");
		System.out.println(Account.getCount());
		
		smithaAcc.deposit(6780.00);
		
		Account other=smithaAcc;
		if(other==smithaAcc) {
			System.out.println("Both accounts same");
		}
		
		if(shwetaAcc.equals(smithaAcc))
		{
			System.out.print("Both accounts same");
		}
	}

}
