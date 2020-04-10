import java.util.ArrayList;
public class tagManagement {
   ArrayList<String> tags = new ArrayList<String>();
   
   public boolean add_Tag(String tag){
       return tags.add(tag);
   }

   public boolean remove_Tag(String tag){
       return tags.remove(tag);
   }

   public void changeTag(String oldTag, String newTag){
       tags.set(tags.indexOf(oldTag), newTag);
   }

   public boolean containsTag(String tagCompare){
        return tags.contains(tagCompare);
   }

   public boolean containsTags(ArrayList<String> tagsCompare){
        //String temp;
        for (String temp: tagsCompare){
            if (tags.contains(temp) == false){
                return false;
            }
        }
        return true;
   }
}