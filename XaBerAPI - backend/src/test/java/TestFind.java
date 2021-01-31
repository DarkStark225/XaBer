import Logic.Find;

public class TestFind {
    public static void main(String[] args) {
        Find find = new Find();
        String temp = find.find("A");
        if(temp!=null){
            System.out.println(temp);
            System.out.println("test successful");
        }
        else{
            System.out.println("test fail");
        }
    }
}
