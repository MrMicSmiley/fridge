import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class Controller{
    private static ArrayList<String> fridge;
    private static ArrayList<Recipe> allRecipes;
    private static ArrayList<Recipe> shownRecipes;
    private static Scanner stringInput = new Scanner(System.in);

    public Controller(){
        fridge = new ArrayList<String>();
        allRecipes = new ArrayList<Recipe>();
        shownRecipes = new ArrayList<Recipe>();
    }
    
    public static void filter(){
        System.out.println("------------");
        ArrayList<String> ingredientList = new ArrayList<String>();
        shownRecipes.clear();
        for(String s: fridge){
            ingredientList.add(s);
            shownRecipes = filterRecipes(ingredientList);
        }
        if(shownRecipesToString().equals("")){
            System.out.println("This list is currently empty.");
        }
        else{
            System.out.println("Recipes possible based on current fridge: \n"+ shownRecipesToString());
        }
        System.out.println("------------");
    }
    private static ArrayList<Recipe> filterRecipes(ArrayList<String> ingredientList){
        ArrayList<Recipe> temp = new ArrayList<Recipe>();
        for (Recipe compare: allRecipes){
            for (String s: ingredientList){
                if(compare.containsIngredient(s)){
                    temp.add(compare);
                    break;
                }
               /*if(!compare.containsIngredient(s)){
                    addIngredient = false;
                    break;
                }*/
            }
            /*if(addIngredient){
                temp.add(compare);
            }*/
        }
        return temp;
    }
  private static void exactFilter(){
    shownRecipes.clear();
    for(Recipe compare: allRecipes){
        compare.sort();
        ArrayList<String> temp = compare.getArrayIngredients();
        boolean shouldAdd = true;
        for(String ingredient: temp){
            if (!fridge.contains(ingredient)){
                shouldAdd = false;
                break;
            }
        }
        if(shouldAdd){
            shownRecipes.add(compare);
        }
    }
    System.out.println("------------");
    if(shownRecipesToString().equals("")){
        System.out.println("This list is currently empty.");
    }
    else{
        System.out.println("Recipes possible based on current fridge: \n"+ shownRecipesToString());
    }
    System.out.println("------------");
  }

  
  public void addToFridge(String ingredient){
        fridge.add(ingredient);
    }
    public void addToAllRecipes(Recipe recipe){
        allRecipes.add(recipe);
    }
    public void addToShownRecipes(Recipe recipe){
        shownRecipes.add(recipe);
    }

    public static String getIngredient(int index){
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
        Recipe temp;
        for (int i = 0; i < shownRecipes.size(); i++){
            temp = shownRecipes.get(i);
            if(temp.containsIngredient(ingredient)){
                this.removeFromShown(temp);
            }
        }
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
    public static String shownRecipesToString(){
        String result = "";
        Recipe temp;
        for(int i = 0; i < shownRecipes.size(); i++){
            temp = shownRecipes.get(i);
            result += temp.get_name() +"\n"+ temp.get_link();
            result += "\n";
            result += temp.get_ingredients();
        }
        return result;
    }
    public String allRecipesToString(){
        String result = "";
        Recipe temp;
        for(int i = 0; i < allRecipes.size(); i++){
            temp = allRecipes.get(i);
            result += temp.get_name() +"\n"+ temp.get_link();
            result += "\n";
            result += temp.get_ingredients();
        }
        return result;
    }
    public void test1(){
        //Tests adding recipes and ingredients and toString functions

        //Test ingredient adding
        this.addToFridge("apple");
        System.out.println(this.fridgeToString());

        //Test recipe adding
        Recipe r1 = new Recipe("apple pie","link1");
        r1.add_ingredient("apple");
        Recipe r2 = new Recipe("peanut butter and jelly","link2");
        r2.add_ingredient("bread");
        r2.add_ingredient("peanut butter");
        r2.add_ingredient("jelly");
        this.addToAllRecipes(r1);
        this.addToAllRecipes(r2);
        this.addToShownRecipes(r1);
        System.out.println("Shown Recipes: "+ shownRecipesToString());
        System.out.println("All Recipes: "+ allRecipesToString());
    }
    public void test2(){
        //Tests removal, getting, and toStrings
        System.out.println("Fridge contents: "+this.fridgeToString());
        String testIngredient = getIngredient(0);
        if(testIngredient.equals(fridge.get(0))){
            System.out.println("getIngredient was successful");
        }
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
        System.out.println("Shown Recipes: "+ shownRecipesToString());
        System.out.println("All Recipes: "+this.allRecipesToString());
        this.removeFromFridge("orange");
        this.removeFromFridge("apple");
        System.out.println("Fridge contents: "+this.fridgeToString());
        System.out.println("Shown Recipes: "+ shownRecipesToString());
        System.out.println("All Recipes: "+this.allRecipesToString());
    }
    public void test3(){
        //Tests filtering functions
        this.addToFridge("bread");
        this.addToFridge("peanut butter");
        filter();
        System.out.println("Fridge contents: "+this.fridgeToString());
        System.out.println("Shown Recipes: "+ shownRecipesToString());
        System.out.println("All Recipes: "+this.allRecipesToString());
    }
    private static void addIngredients(){
        String ingredient;
        System.out.println("Enter the name of the ingredient to be added or type '-1' to cancel:");
        ingredient = stringInput.nextLine();
        if(ingredient.equals("-1")){
             System.out.println("Entry cancelled.");
            }
        else{
           fridge.add(ingredient);
             System.out.println("Entry added to fridge.");
        }
            Collections.sort(fridge);
                    //add ingredient to interior controller arraylist;
    }
    private static void addRecipe(){
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
                    allRecipes.add(newRecipe);
                    System.out.println("Entry added to all recipes.");
                }
    }       
    private void removeIngredient(){
        String ingredient;
        System.out.println("Enter the name of the ingredient to be removed or type '-1' to cancel:");
        ingredient = stringInput.nextLine();
        if(ingredient.equals("-1")){
            System.out.println("Entry cancelled.");
        }
        else{
            if(!fridge.contains(ingredient)){
                System.out.println("Ingredient not found.");
            }
            else{
                this.removeFromFridge(ingredient);
            }
        }
    }
    public static void main(String[] args){
        //initialize the user input variables
        Controller controller = new Controller();
        //load recipes either from file or manually here
        allRecipes = readRecipe.setUp();
        int input = 0;
        //int intInput = 0;
        //controller.test1();
        //controller.test2();
        //controller.test3();
        //menu loop
        System.out.println("Welcome to the Fridge.  What would you like to do?");
        while(input != -1){
            System.out.println("1. Browse Available Recipes");//show all recipes
            System.out.println("2. Browse Possible Recipes");//show shown recipes
            System.out.println("3. What can I make?");
            System.out.println("4. Browse Fridge");//show fridge
            System.out.println("5. Add ingredient to Fridge");
            System.out.println("6. Remove ingredient from Fridge");
            System.out.println("7. Add recipe");
            System.out.println("-1. Quit");

            //retrieve input from user
            input = stringInput.nextInt();
            
            stringInput.nextLine();
            //intInput = Integer.parseInt(input);

            //browse
            //SORT HERE
            switch (input){
                case 1:
                    System.out.println("------------");
                    System.out.println("If a recipe you want isn't shown, use the add recipe function.");
                    if(controller.allRecipesToString().equals("")){
                        System.out.println("This list is currently empty.");
                    }
                    else{
                        System.out.println("Current logged recipes: \n"+controller.allRecipesToString());
                    }
                    System.out.println("------------");
                    break;
                case 2: 
                    filter();
                    break;
                case 3:
                    exactFilter();
                    break;
                case 4:
                    System.out.println("------------"); 
                    if(controller.fridgeToString().equals("")){
                        System.out.println("This list is currently empty.");
                    }
                    else{
                        System.out.println("Current fridge contents: \n"+controller.fridgeToString());
                    }
                    System.out.println("------------");
                    break;
                case 5:
                    addIngredients();
                    break;
                case 6:
                    controller.removeIngredient();
                    break;
                case 7:
                    addRecipe();
                    break;
                case -1:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    break;

            }

        
        }
        stringInput.close();
    }



}
