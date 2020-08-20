package com.akgoyal.CoffeeMachine.model;

import java.util.List;

public class Beverage {
	
	BeverageType beverageType;
	List<Ingredient> ingredients;
	
	public Beverage(BeverageType beverageType, List<Ingredient> ingredients) {
		super();
		this.beverageType = beverageType;
		this.ingredients = ingredients;
	}

	public BeverageType getBeverageType() {
		return beverageType;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	
	
}
