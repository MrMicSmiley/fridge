import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    ArrayList<String> ingredients = new ArrayList();
    ArrayList<Recipe> allRecipes = new ArrayList();
    ArrayList<Recipe> shownRecipe = new ArrayList();



    public static void main(String[] args){
    	//initialize the user input variables

        String input = '';
        Scanner stringInput = new Scanner(System.in);

        //menu loop
        System.out.println("Welcome to the Fridge.  What would you like to do?");
        while(intInput != -1){
       		System.out.println("1. Browse Recipes");
       		System.out.println("2. Add ingredient to Fridge");
       		System.out.println("3. Add recipe");
       		System.out.println("4. Quit");

       		//retrieve input from user
       		input = stringInput.nextLine();
       		intInput = parseInt(input);

       		//browse
       		if(intInput == 1){
       			
       		}
       		//add ingredient
       		else if(intInput == 2){
       			String ingredient;
       			System.out.println("Enter the name of the ingredient to be added:");
       			ingredient = stringInput.nextLine();
                ingredients.add(ingredent);
       			//add ingredient to interior controller arraylist;
       		}
       		else if(intInput == 3){
       			String name;
       			String ingredients;
       			String link;
       			System.out.println("Enter the name of the recipe to be added:");
       			name = stringInput.nextLine(); 
       			System.out.println("Enter the ingredients on one line separated by commas (e.g. butter, flour, etc):");
       			ingredients = stringInput.nextLine();
       			System.out.println("Enter the link/instructions for the recipe:");
       			link = stringInput.nextLine();
       			Recipe newRecipe = new Recipe(name,link);
            
                String[] elements = ingredients.split(",");
                for(int i = 0; i < elements.length; i++){
                  newRecipe.addIngredient(elements[i]);
                }
                allRecipes.add(newRecipe);
            
       		}
        //quit
        	else if(intInput == 4){
       			intInput = -1;
       		}
       		else{
       			System.out.println("Invalid input, please try again.");
       		}
        //menu loop end

        //System.out.println(ingredients.toString());
    	}
    }


}
