package com.akgoyal.CoffeeMachine.model;

public class Ingredient {
	
	IngredientType ingredientType;
	int quantity;
	
	public Ingredient(IngredientType ingredientType, int quantity) {
		super();
		this.ingredientType = ingredientType;
		this.quantity = quantity;
	}
	
	public IngredientType getIngredientType() {
		return ingredientType;
	}
	public int getQuatity() {
		return quantity;
	}
	
}
