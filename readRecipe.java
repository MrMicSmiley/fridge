import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class readRecipe {
    static public ArrayList<Recipe> setUp(){

        ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
        File file = new File("recipe.txt");
        try{
            String read;
            Scanner sc = new Scanner(file); 
            while(sc.hasNextLine()){
                Recipe recipe = new Recipe (sc.nextLine(), sc.nextLine());
                while(!(read = sc.nextLine()).equals("***")){
                    recipe.add_ingredient(read);
                }
                while(!(read = sc.nextLine()).equals("***")){
                    recipe.add_Tag(read);
                }
                recipeList.add(recipe);
                if(sc.hasNextLine()){sc.nextLine();}
 
            }
            return recipeList;
            
        }
          catch(FileNotFoundException e){
            printErrorMsg();
            return null;
          }
    }

    static private void printErrorMsg(){
        System.out.println("Cannot find file");
    }
    public static void main(String[] args) {
        ArrayList<Recipe> test = setUp();
        test.get(1).print_ingredients();


    }
}