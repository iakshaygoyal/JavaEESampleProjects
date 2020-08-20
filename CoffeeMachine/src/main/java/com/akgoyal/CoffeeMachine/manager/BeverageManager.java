package com.akgoyal.CoffeeMachine.manager;

import com.akgoyal.CoffeeMachine.model.Beverage;
import com.akgoyal.CoffeeMachine.model.BeverageType;

public interface BeverageManager {
	
	Beverage prepare(BeverageType beverageType) throws Exception;
	
}
