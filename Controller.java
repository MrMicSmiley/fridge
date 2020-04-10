import java.util.ArrayList;

public class Controller {
    ArrayList<String> ingredients = new ArrayList();
    ArrayList<Recipe> allRecipes = new ArrayList();
    ArrayList<Recipe> shownRecipe = new ArrayList();




    public static void main(String[] args){

        //menu loop



        //browse recipes
        //add ingreddient

            //if user selected 3 and entered their option
        String ingred = "apple";
        ingredients.add(ingred);

        //add recipe
            //if user selected 4 and entered their option

        String recipeName = "apple pie";
        String recipeIngreds = "butter, flour, sugar, apple";
        ArrayList<String> listIngredsforRecipe = new ArrayList();
        String[] elements = recipeIngreds.split(",");
        for(int i = 0; i < elements.length; i++){
            listIngredsforRecipe.add(elements[i]);
        }
        Recipe temp = new Recipe("recipeName");
        for(int i = 0; i < listIngredsforRecipe.size(); i++){
            temp.addIngredient(listIngredsforRecipe.get(i));
        }
        //perhaps have to do test cases for null and stuff
        allRecipes.add(temp);



        //quit

        //menu loop end

        System.out.println(ingredients.toString());

    }


}
