package com.akgoyal.CoffeeMachine.model;

import java.util.HashMap;
import java.util.Map;

public class IngredientStock {
	
	private static IngredientStock ingredientStock = null;
	
	private static Map<IngredientType, Integer> stock;
	
	public static synchronized IngredientStock getInstance() {
		if(ingredientStock == null) {
			ingredientStock = new IngredientStock();
			stock = new HashMap<IngredientType, Integer>();
			stock.put(IngredientType.HOT_MILK, 300);
			stock.put(IngredientType.HOT_WATER, 300);
			stock.put(IngredientType.TEA_LEAVES, 200);
			stock.put(IngredientType.COFFEE, 200);
			stock.put(IngredientType.GINGER_SYRUP, 200);
			stock.put(IngredientType.ELAICHI_SYRUP, 200);
			stock.put(IngredientType.SUGAR_SYRUP, 300);
		}
		return ingredientStock;
	}
	
	public synchronized Ingredient takeIngredient(IngredientType ingredientType, int quantity) throws Exception {
		if(!stock.containsKey(ingredientType))
			throw new Exception("Ingredient Not Found : " + ingredientType.toString());
		if(stock.get(ingredientType) < quantity)
			throw new Exception("Ingredient not present in adequate amount : " + ingredientType.toString());
		stock.put(ingredientType, stock.get(ingredientType) - quantity);
		return new Ingredient(ingredientType, quantity);
	}
	
}
