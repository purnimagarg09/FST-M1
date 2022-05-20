package Activities;

abstract class Book {
    String title;

    abstract void setTitle(String name);

    public String getTitle(){
        return title;
    }
}

class MyBook extends Book {
    public void setTitle(String name) {
        title = name;
    }
}

public class Activity5 {
    public static void main (String[] args){
        MyBook newNovel = new MyBook();
        newNovel.setTitle("Adventures");
        System.out.println("Title of new Novel is "+newNovel.getTitle());

    }
}
