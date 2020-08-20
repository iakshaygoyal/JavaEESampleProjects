package com.akgoyal.CoffeeMachine.manager;

import java.util.Arrays;

import com.akgoyal.CoffeeMachine.model.Beverage;
import com.akgoyal.CoffeeMachine.model.BeverageType;
import com.akgoyal.CoffeeMachine.model.Ingredient;
import com.akgoyal.CoffeeMachine.model.IngredientStock;
import com.akgoyal.CoffeeMachine.model.IngredientType;

public class GingerTeaManager implements BeverageManager {

	public Beverage prepare(BeverageType beverageType) throws Exception {
		try {
			IngredientStock ingredientStock = IngredientStock.getInstance();
			Ingredient hotMilk = ingredientStock.takeIngredient(IngredientType.HOT_MILK, 100);
			Ingredient hotWater = ingredientStock.takeIngredient(IngredientType.HOT_WATER, 100);
			Ingredient sugarSyrup = ingredientStock.takeIngredient(IngredientType.SUGAR_SYRUP, 100);
			Ingredient teaLeaves = ingredientStock.takeIngredient(IngredientType.TEA_LEAVES, 100);
			Ingredient gingerSyrup = ingredientStock.takeIngredient(IngredientType.GINGER_SYRUP, 100);
			return new Beverage(beverageType, Arrays.asList(hotMilk, hotWater, sugarSyrup, teaLeaves, gingerSyrup));
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Failed to prepare beverage : " + beverageType);
		}

	}

}
