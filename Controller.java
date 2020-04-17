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

    public String getIngredient(int index){
        return fridge.get(index);
    }
    public Recipe getShownRecipe(int index){
        return shownRecipes.get(index);
    }
    public Recipe getAllRecipe(int index){
        return allRecipes.get(index);
    }

    public void removeFromFridge(String ingredient){
        fridge.remove(ingredient);
        //should add functionality to remove recipes that contained removed ingredient from shown
        //to implement this, write a contains function in recipe
        /*Recipe temp;
        for (int i = 0; i < shownRecipes.size(); i++){
            temp = shownRecipes.get(i);
            if(temp.ingredients.contains(ingredient)){
                this.removeFromShown(temp);
            }
        }*/
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
    //For the following two methods: temp.print_ingredients is a print statement, does not return ingredients to string.
    public String shownRecipesToString(){
        String result = "";
        Recipe temp;
        for(int i = 0; i < shownRecipes.size(); i++){
            temp = shownRecipes.get(i);
            result += temp.get_name() +" "+ temp.get_link();
            result += "\n";
            //result += temp.print_ingredients();
        }
        return result;
    }
    public String allRecipesToString(){
        String result = "";
        Recipe temp;
        for(int i = 0; i < allRecipes.size(); i++){
            temp = allRecipes.get(i);
            result += temp.get_name() +" "+ temp.get_link();
            result += "\n";
            //result += temp.print_ingredients();
        }
        return result;
    }
    public void test1(){
        //Tests adding recipes and ingredients and toString functions

        //Test ingredient adding
        this.addToFridge("apple");
        System.out.println(this.fridgeToString());

        //Test recipe adding
        /*NOTES:
          Recipe constructor errors with string, probably is changed in newer version, but note just in case
          When adding an ingredient to a recipe, null pointer exception is given because nothing was actually initialized in the constructor
          There is a void constructor that sucks - should have only the link/name constructor
          Remove print statements from recipe
        */
        Recipe r1 = new Recipe("apple pie","link1");
        r1.add_ingredient("apple");
        Recipe r2 = new Recipe("peanut butter and jelly","link2");
        r2.add_ingredient("bread");
        r2.add_ingredient("peanut butter");
        r2.add_ingredient("jelly");
        this.addToAllRecipes(r1);
        this.addToAllRecipes(r2);
        this.addToShownRecipes(r1);
        System.out.println("Shown Recipes: "+this.shownRecipesToString());
        System.out.println("All Recipes: "+this.allRecipesToString());
    }
    public void test2(){
        //Tests removal, getting, and toStrings
        /*NOTES:
            Currently, if an item is removed from the fridge, the recipe remain in shown recipes.  Functionality is written in the
            removeFromFridge function to fix this, but needs a public contains for the arraylist in Recipe.
        */
        System.out.println("Fridge contents: "+this.fridgeToString());
        String testIngredient = this.getIngredient(0);
        if(testIngredient.equals(fridge.get(0))){
            System.out.println("getIngredient was successful");
        }
        this.removeFromFridge("orange");
        this.removeFromFridge("apple");
        Recipe r1 = shownRecipes.get(0);
        Recipe r2 = allRecipes.get(1);
        Recipe testr2 = this.getAllRecipe(1);
        Recipe testr1 = this.getShownRecipe(0);
        if(testr1 == r1){
            System.out.println("getShownRecipe was successful");
        }
        if(testr2 == r2){
            System.out.println("getAllRecipe was successful");
        }
        System.out.println("Fridge contents: "+this.fridgeToString());
        System.out.println("Shown Recipes: "+this.shownRecipesToString());
        System.out.println("All Recipes: "+this.allRecipesToString());
        this.removeFromShown(r1);
        System.out.println("Fridge contents: "+this.fridgeToString());
        System.out.println("Shown Recipes: "+this.shownRecipesToString());
        System.out.println("All Recipes: "+this.allRecipesToString());
    }

    public static void main(String[] args){
        //initialize the user input variables
        Controller controller = new Controller();
        //controller.test1();
        //controller.test2();

        //load recipes either from file or manually here

        String input = "";
        Scanner stringInput = new Scanner(System.in);
        int intInput = 0;

        //menu loop
        System.out.println("Welcome to the Fridge.  What would you like to do?");
        while(intInput != -1){
            System.out.println("1. Browse Available Recipes");//show all recipes
            System.out.println("2. Browse Possible Recipes");//show shown recipes
            System.out.println("3. Browse Fridge");//show fridge
            System.out.println("4. Add ingredient to Fridge");
            System.out.println("5. Add recipe");
            System.out.println("6. Quit");

            //retrieve input from user
            input = stringInput.nextLine();
            intInput = Integer.parseInt(input);

            //browse
            //SORT HERE
            if(intInput == 1){
                System.out.println("If a recipe you want isn't shown, use the add recipe function.");
                System.out.println("Current logged recipes: \n"+controller.allRecipesToString());
            }
            else if(intInput == 2){
                //call filter function here
                System.out.println("Recipes possible based on current fridge: \n"+controller.shownRecipesToString());
            }
            else if(intInput == 3){
                System.out.println("Current fridge contents: \n"+controller.fridgeToString());
            }
            //add ingredient
            else if(intInput == 4){
                String ingredient;
                System.out.println("Enter the name of the ingredient to be added or type '-1' to cancel:");
                ingredient = stringInput.nextLine();
                if(ingredient.equals("-1")){
                    System.out.println("Entry cancelled.");
                }
                else{
                    controller.fridge.add(ingredient);
                    System.out.println("Entry added to fridge.");
                }
                //add ingredient to interior controller arraylist;
            }
            else if(intInput == 5){
                String name;
                String ingredients;
                String link;
                System.out.println("Enter the name of the recipe to be added or type '-1' to cancel:");
                name = stringInput.nextLine();
                if(name.equals("-1")){
                    System.out.println("Entry cancelled.");
                }
                else{
                    System.out.println("Enter the ingredients on one line separated by commas (e.g. butter, flour, etc):");
                    ingredients = stringInput.nextLine();
                    System.out.println("Enter the link/instructions for the recipe:");
                    link = stringInput.nextLine();
                    //add one more line for tags?
                    Recipe newRecipe = new Recipe(name,link);
                    String[] elements = ingredients.split(",");
                    for(int i = 0; i < elements.length; i++){
                        newRecipe.add_ingredient(elements[i]);
                    }
                    controller.allRecipes.add(newRecipe);
                    System.out.println("Entry added to all recipes.");
                }
            }
            //quit
            else if(intInput == 6){
                intInput = -1;
            }
            else{
                System.out.println("Invalid input, please try again.");
            }
        }
    }


}