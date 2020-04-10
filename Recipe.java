import java.util.ArrayList;;

public class Recipe extends tagManagement {
	private String rec_name;
	private ArrayList<String> ingredients;
	private String link;

	public Recipe() {
		this.rec_name = null;
		this.ingredients = null;
		this.link = null;
	}

	public Recipe(String rec_name, String link) {
		this.rec_name = rec_name;
		this.ingredients = new ArrayList<String>();
		this.link = link;
	}

	private boolean add_ingredient(String ingredient) {
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
		System.out.printf("%s was added to the recipe.", ingredient);
		return true;
	}

	private void getLink() {
		System.out.println("Please follow link to view the recipe.");
		System.out.printf("%s", this.link);
	}

	private void print_ingredients() {
		if (ingredients == null) {
			System.out.println("Nothing to see hear");
			return;
		}
		int counter = 1;
		for (String string : ingredients) {
			System.out.println("Here is the list of all the ingredients in this recipe.");
			System.out.printf("(%i) %s ", counter, string);
			counter++;
		}
	}

	private boolean rem_ingredient(String ingredient) {
		if (ingredient.equals("") || ingredient.equals(" ")) {
			System.out.println("Enter a valid ingredient to remove from the recipe.");
			return false;
		}
		for (String each : ingredients) {
			if (each.equals(ingredient)) {
				ingredients.remove(ingredient);
				System.out.printf("The %s was removed from recipe.");
				return true;
			}
		}
		return false;
	}

}
