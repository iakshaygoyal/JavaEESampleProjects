package com.akgoyal.CoffeeMachine.manager;

import java.util.Arrays;

import com.akgoyal.CoffeeMachine.model.Beverage;
import com.akgoyal.CoffeeMachine.model.BeverageType;
import com.akgoyal.CoffeeMachine.model.Ingredient;
import com.akgoyal.CoffeeMachine.model.IngredientStock;
import com.akgoyal.CoffeeMachine.model.IngredientType;

public class CoffeeManager implements BeverageManager {

	public Beverage prepare(BeverageType beverageType) throws Exception {
		try {
			IngredientStock ingredientStock = IngredientStock.getInstance();
			Ingredient hotMilk = ingredientStock.takeIngredient(IngredientType.HOT_MILK, 100);
			Ingredient hotWater = ingredientStock.takeIngredient(IngredientType.HOT_WATER, 100);
			Ingredient sugarSyrup = ingredientStock.takeIngredient(IngredientType.SUGAR_SYRUP, 100);
			Ingredient coffee = ingredientStock.takeIngredient(IngredientType.COFFEE, 100);
			return new Beverage(beverageType, Arrays.asList(hotMilk, hotWater, sugarSyrup, coffee));
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Failed to prepare beverage : " + beverageType);
		}

	}

}
