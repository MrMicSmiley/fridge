import java.util.ArrayList;;

public class Recipe {
	String rec_name;
	ArrayList<String> ingredients;

	public Recipe(String rec_name) {
		this.rec_name = rec_name;
	}

	boolean add_ingredient(String ingredient) {
		if (ingredient.equals("") || ingredient.equals(" ")) {
			return false;
			}
		for (String each : ingredients) {
			if (each.equals(ingredient)) {
				System.out.println("This ingredient is already part of the recipe.");	
				return false;
			}
		}
		ingredients.add(ingredient);
		System.out.println("%s was added to the recipe.");
		return true;
	}
		
	
	boolean rem_ingredient(String ingredient) {
		return false;
		}
	}


