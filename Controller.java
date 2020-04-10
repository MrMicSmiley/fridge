import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    ArrayList<String> fridge = new ArrayList();
    ArrayList<Recipe> shownRecipe = new ArrayList();
    ArrayList<Recipe> allRecipes = new ArrayList();




    public filterRecipes(multiple tags ){
        //sort with these tags, update shownRecipe
    }
    public static void main(String[] args){
        //initialize the user input variables


        String input = '';
        Scanner stringInput = new Scanner(System.in);
        int intInput = 0;

        //menu loop
        System.out.println("Welcome to the Fridge.  What would you like to do?");
        while(intInput != -1){
            System.out.println("1. Browse Recipes");
            System.out.println("2. Add ingredient to Fridge");
            System.out.println("3. Add recipe");
            System.out.println("4. Quit");

            //retrieve input from user
            input = stringInput.nextLine();
            intInput = Integer.parseInt(input);

            //browse
            //SORT HERE
            if(intInput == 1){
                filterRecipes(tags);
                for(int i = 0; i < shownRecipe.size(); i++){
                    shownRecipe.get(i).toString();
                    System.out.println("");
                }

                //maybe ask to select what recipe you want to select
            }
            //add ingredient
            else if(intInput == 2){
                String ingredient;
                System.out.println("Enter the name of the ingredient to be added:");
                ingredient = stringInput.nextLine();
                fridge.add(ingredient);
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
                    newRecipe.add_ingredient(elements[i]);
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
        }
    }


}