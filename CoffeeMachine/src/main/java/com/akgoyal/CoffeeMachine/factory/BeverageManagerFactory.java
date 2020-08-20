package com.akgoyal.CoffeeMachine.factory;

import com.akgoyal.CoffeeMachine.manager.BeverageManager;
import com.akgoyal.CoffeeMachine.manager.CoffeeManager;
import com.akgoyal.CoffeeMachine.manager.ElaichiTeaManager;
import com.akgoyal.CoffeeMachine.manager.GingerTeaManager;
import com.akgoyal.CoffeeMachine.manager.HotMilkManager;
import com.akgoyal.CoffeeMachine.manager.HotWaterManager;
import com.akgoyal.CoffeeMachine.model.BeverageType;

public class BeverageManagerFactory {
	
	public BeverageManager getBeverageManager(BeverageType beverageType) throws Exception {
		if(beverageType.equals(BeverageType.COFFEE))
			return new CoffeeManager();
		else if(beverageType.equals(BeverageType.GINGER_TEA))
			return new GingerTeaManager();
		else if(beverageType.equals(BeverageType.ELAICHI_TEA))
			return new ElaichiTeaManager();
		else if(beverageType.equals(BeverageType.HOT_MILK))
			return new HotMilkManager();
		else if(beverageType.equals(BeverageType.HOT_WATER))
			return new HotWaterManager();
		throw new Exception("Beverage Not Found");
	}

}
