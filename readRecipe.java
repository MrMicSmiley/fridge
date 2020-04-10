import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class readRecipe {
    public void setUp(){

        File file = new File("recipe.txt");
        try{
            String read;
            Scanner sc = new Scanner(file); 
            while(sc.hasNextLine()){
                Recipe recipe = new Recipe (sc.nextLine(), sc.nextLine());
                while((read = sc.nextLine()) != "***"){
                    recipe.add_ingredients(read);
                }
                read = " ";
                while((read = sc.nextLine()) != "***"){
                    recipe.add_tag(read);
                }
                allRecipes.add(recipe);
                sc.nextLine();
            }
        }
          catch(FileNotFoundException e){
            printErrorMsg();
          }
    }

    private void printErrorMsg(){
        System.out.println("Cannot find file");
    }
}
