package API.POJO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public @Data class Posts {


     String title;
  String content;
  String status;





    public Posts(String title, String content,String  status){
        this.title=title;
        this.content=content;
        this.status=status;

    }

     @Override
    public String toString(){
        return "This is the title of object "+this.title+" This is the content of the object "+this.content +" This is the status of the object "+this.status;
    }
}
