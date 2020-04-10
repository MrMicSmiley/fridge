import java.util.ArrayList;
public class tagManagement {
   ArrayList<String> tags = new ArrayList<String>();
   
   private boolean add_Tag(String tag){
       return tags.add(tag);
   }

   private boolean remove_Tag(String tag){
       return tags.remove(tag);
   }

   private void changeTag(String oldTag, String newTag){
       tags.set(tags.indexOf(oldTag), newTag);
   }

   private boolean containsTag(String tagCompare){
        return tags.contains(tagCompare);
   }

   private boolean containsTags(ArrayList<String> tagsCompare){
        //String temp;
        for (String temp: tagsCompare){
            if (tags.contains(temp) == false){
                return false;
            }
        }
        return true;
   }
}