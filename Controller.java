import java.util.ArrayList;
import java.util.Scanner;

public class Controller{
    private ArrayList<String> fridge;
    private ArrayList<Recipe> allRecipes;
    private ArrayList<Recipe> shownRecipes;

    public Controller(){
        fridge = new ArrayList<String>();
        allRecipes = new ArrayList<Recipe>();
        shownRecipes = new ArrayList<Recipe>();
    }

    //public ArrayList<Recipe> filterRecipes(multiple tags ){
    //sort with these tags, update shownRecipe
    //}
    //public ArrayList<Recipe> browseRecipe(){

    //}

    public void addToFridge(String ingredient){
        fridge.add(ingredient);
    }
    public void addToAllRecipes(Recipe recipe){
        allRecipes.add(recipe);
    }
    public void addToShownRecipes(Recipe recipe){
        shownRecipes.add(recipe);
    }

    public String getIngredient(String ingredient){
        int index = fridge.indexOf(ingredient);
        return fridge.get(index);
    }
    public Recipe getShownRecipe(Recipe recipe){
        int index;
        index = shownRecipes.indexOf(recipe);
        return shownRecipes.get(index);
    }
    public Recipe getAllRecipe(Recipe recipe){
        int index;
        index = allRecipes.indexOf(recipe);
        return allRecipes.get(index);
    }

    public void removeFromFridge(String ingredient){
        fridge.remove(ingredient);
    }
    public void removeFromShown(Recipe recipe){
        shownRecipes.remove(recipe);
    }

    public String fridgeToString(){
        String result = "";
        for(int i = 0; i < fridge.size(); i++){
            result += fridge.get(i);
            result += "\n";
        }
        return result;
    }
    public String shownRecipesToString(){
        String result = "";
        Recipe temp;
        for(int i = 0; i < shownRecipes.size(); i++){
            temp = shownRecipes.get(i);
            result += temp.get_name() + temp.get_link();
            result += "\n";
            result += temp.print_ingredients();
        }
        return result;
    }
    public String allRecipesToString(){
        String result = "";
        Recipe temp;
        for(int i = 0; i < allRecipes.size(); i++){
            temp = allRecipes.get(i);
            result += temp.get_name() + temp.get_link();
            result += "\n";
            result += temp.print_ingredients();
        }
        return result;
    }

    /**
    TO-DO: ADD MORE TEST CASES, IMPLEMENT BROWSE FUNCTION  MAKE SURE TO GET NEW RECIPE
    */

    public void test1(){
        //Tests adding recipes and ingredients

        //Test ingredient adding
        this.addToFridge("apple")
        System.out.println(this.fridgeToString());

        //Test recipe adding
        Recipe r1 = new Recipe("apple pie");
        Recipe r2 = new Recipe("peanut butter and jelly");
        this.addToAllRecipes(r1);
        this.addToAllRecipes(r2);
        this.addToShownRecipes(r1);
        System.out.println("Shown Recipes: "+shownRecipes.toString());
        System.out.println("All Recipes: "+allRecipes.toString());
    }
    public static void main(String[] args){
        //initialize the user input variables

        Controller controller = new Controller();


        String input = "";
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
                //filterRecipes(tags);
//                for(int i = 0; i < shownRecipes.size(); i++){
//                    shownRecipes.get(i).toString();
//                    System.out.println("");
//                }

                //maybe ask to select what recipe you want to select
            }
            //add ingredient
            else if(intInput == 2){
                String ingredient;
                System.out.println("Enter the name of the ingredient to be added:");
                ingredient = stringInput.nextLine();
                controller.fridge.add(ingredient);
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
                controller.allRecipes.add(newRecipe);
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