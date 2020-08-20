package com.akgoyal.CoffeeMachine.manager;

import java.util.Arrays;

import com.akgoyal.CoffeeMachine.model.Beverage;
import com.akgoyal.CoffeeMachine.model.BeverageType;
import com.akgoyal.CoffeeMachine.model.Ingredient;
import com.akgoyal.CoffeeMachine.model.IngredientStock;
import com.akgoyal.CoffeeMachine.model.IngredientType;

public class HotMilkManager implements BeverageManager {

	public Beverage prepare(BeverageType beverageType) throws Exception {
		try {
			IngredientStock ingredientStock = IngredientStock.getInstance();
			Ingredient hotMilk = ingredientStock.takeIngredient(IngredientType.HOT_MILK, 200);
			return new Beverage(beverageType, Arrays.asList(hotMilk));
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Failed to prepare beverage : " + beverageType);
		}
	}

}
