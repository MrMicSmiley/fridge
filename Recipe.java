import java.util.ArrayList;;

public class Recipe extends tagManagement {
	public static void main(String[] args) {
		Recipe chalupa = new Recipe("chalupaz", "https://en.wikipedia.org/wiki/Chalupa");
		chalupa.add_ingredient("Taco");
		chalupa.add_ingredient("Lettuce");
		chalupa.add_ingredient("Tomato");
		chalupa.add_ingredient(" ");
		chalupa.get_name();
		chalupa.getLink();
		chalupa.print_ingredients();
		chalupa.rem_ingredient("Taco");
		chalupa.print_ingredients();

	}

	private String rec_name;
	private ArrayList<String> ingredients;
	private String link;

	public Recipe() {
		this.rec_name = null;
		this.ingredients = null;
		this.link = null;
	}

	public String get_name() {
		System.out.printf("%s \n", rec_name);
		return rec_name;
	}

	public String get_link() {
		System.out.printf("%s \n", link);
		return link;
	}

	public int num_ingred() {
		return ingredients.size();
	}

	public Recipe(String rec_name, String link) {
		this.rec_name = rec_name;
		this.ingredients = new ArrayList<String>();
		this.link = link;
	}

	public boolean add_ingredient(String ingredient) {
		if (ingredient.equals("") || ingredient.equals(" ")) {
			System.out.println("That was not a valid ingredient to add.");
			return false;
		}
		for (String each : ingredients) {
			if (each.equals(ingredient)) {
				System.out.println("This ingredient is already part of the recipe.\n");
				return false;
			}
		}
		ingredients.add(ingredient);
		System.out.printf("%s was added to the recipe.\n", ingredient);
		return true;
	}

	private void getLink() {
		System.out.println("Please follow link to view the recipe.");
		System.out.printf("%s", this.link);
	}
	
	public void get_ingredients()	{
		
		int counter = 1;
		String sb = new String();
		String ing = new String();
		sb = "";
		
		for (String string : ingredients) {
			ing = "(" + counter + ")" + " " + string + "\n";
			sb = sb + ing;
			counter++;
		}
	}
	
	public void print_ingredients() {
		if (ingredients == null) {
			System.out.println("Nothing to see hear");
			return;
		}
		int counter = 1;
		System.out.println("Here is the list of all the ingredients in this recipe.\n");
		for (String string : ingredients) {
			
			System.out.printf("(%d) %s ", counter, string);
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
				System.out.printf("The %s was removed from recipe.", ingredient);
				return true;
			}
		}
		return false;
	}

}
