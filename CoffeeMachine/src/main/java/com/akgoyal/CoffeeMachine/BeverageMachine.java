package com.akgoyal.CoffeeMachine;

import com.akgoyal.CoffeeMachine.factory.BeverageManagerFactory;
import com.akgoyal.CoffeeMachine.manager.BeverageManager;
import com.akgoyal.CoffeeMachine.model.Beverage;
import com.akgoyal.CoffeeMachine.model.BeverageType;

public class BeverageMachine {

	private int outlets;

	private BeverageManagerFactory beverageManagerFactory;
	
	private static final Object countLock1 = new Object();
	private static final Object countLock2 = new Object();
	
	public BeverageMachine(int outlets, BeverageManagerFactory beverageManagerFactory) {
		super();
		this.outlets = outlets;
		this.beverageManagerFactory = beverageManagerFactory;
	}
	
	public Beverage prepareBeverage(BeverageType beverageType) throws Exception {
		System.out.println("Order given for : " + beverageType);
		
		synchronized (countLock1) {
			if (outlets == 0) {
				System.out.println("No vacant Outlet. Waiting for outlet for beverage "+ beverageType +" ...");
			}
			while(outlets == 0) {
				
			}
			outlets--;
		}
		
		BeverageManager beverageManager = beverageManagerFactory.getBeverageManager(beverageType);
		Beverage beverage = beverageManager.prepare(beverageType);
		System.out.println("Prepared : " + beverage.getBeverageType().toString());
		synchronized (countLock2) {
			outlets++;
		}
		return beverage;
	}

}
