import java.util.ArrayList;
import java.util.Scanner;

public class Controller{
    private static ArrayList<String> fridge;
    private static ArrayList<Recipe> allRecipes;
    private static ArrayList<Recipe> shownRecipes;

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
    
    public static void filter(){
        Scanner stringInput = new Scanner(System.in);
        ArrayList<String> ingredientList = new ArrayList<String>();
        while(true){
            System.out.println("Enter ingredients to filter");
            String s = stringInput.nextLine();
            if(s == "q"){break;}
            ingredientList.add(s);
            shownRecipes = filterRecipes(ingredientList);
            System.out.println("Recipes possible based on current fridge: \n"+ shownRecipesToString());
        }
        stringInput.close();

    }
    private static ArrayList<Recipe> filterRecipes(ArrayList<String> ingredientList){
        ArrayList<Recipe> temp = new ArrayList<Recipe>();
        for (Recipe compare: allRecipes){
            boolean addIngredient = true;
            for (String s: ingredientList){
                if(!compare.getIngredients().contains(s)){
                    addIngredient = false;
                    break;
                }
            }
            if(addIngredient){
                temp.add(compare);
            }
        }
        return temp;
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
    public static String shownRecipesToString(){
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


    public static void main(String[] args){
        //initialize the user input variables
        Controller controller = new Controller();
        //load recipes either from file or manually here
        allRecipes = readRecipe.setUp();
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
                filter();
               
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
                    fridge.add(ingredient);
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
                    allRecipes.add(newRecipe);
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
        stringInput.close();
    }



}
