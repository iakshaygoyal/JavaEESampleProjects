package com.akgoyal.CoffeeMachine.manager;

import java.util.Arrays;

import com.akgoyal.CoffeeMachine.model.Beverage;
import com.akgoyal.CoffeeMachine.model.BeverageType;
import com.akgoyal.CoffeeMachine.model.Ingredient;
import com.akgoyal.CoffeeMachine.model.IngredientStock;
import com.akgoyal.CoffeeMachine.model.IngredientType;

public class HotWaterManager implements BeverageManager {

	public Beverage prepare(BeverageType beverageType) throws Exception {
		try {
			IngredientStock ingredientStock = IngredientStock.getInstance();
			Ingredient hotWater = ingredientStock.takeIngredient(IngredientType.HOT_WATER, 200);
			return new Beverage(beverageType, Arrays.asList(hotWater));
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Failed to prepare beverage : " + beverageType);
		}
	}

}
