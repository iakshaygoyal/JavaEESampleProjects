package com.akgoyal.CoffeeMachine;

import org.junit.BeforeClass;
import org.junit.Test;

import com.akgoyal.CoffeeMachine.factory.BeverageManagerFactory;
import com.akgoyal.CoffeeMachine.model.BeverageType;

public class BeverageMachineTest {
	
	static BeverageMachine beverageMachine;
	
	@BeforeClass
	public static void setUp() {
		beverageMachine = new BeverageMachine(3, new BeverageManagerFactory());
	}

	@Test
	public void testPrepareBeverage() {
		Thread coffee = prepareBeverage(BeverageType.COFFEE);
		Thread elaichiTea = prepareBeverage(BeverageType.ELAICHI_TEA);
		Thread gingerTea = prepareBeverage(BeverageType.GINGER_TEA);
		Thread hotMilk = prepareBeverage(BeverageType.HOT_MILK);
		Thread hotWater = prepareBeverage(BeverageType.HOT_WATER);
		
		coffee.start();
		elaichiTea.start();
		gingerTea.start();
		hotMilk.start();
		hotWater.start();
		
		try {
            coffee.join();
            hotWater.join();
            hotMilk.join();
            elaichiTea.join();
            gingerTea.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	private Thread prepareBeverage(BeverageType beverageType) {
		Runnable runnable = () -> {
			try {
				beverageMachine.prepareBeverage(beverageType);
			} catch (Exception e) {
				System.out.println(e);
			}
		};
		
		return new Thread(runnable);
	}


}
