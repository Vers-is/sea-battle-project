import java.util.Scanner;

class index {

public static void main(String[] args, String name) {
    askForName(name);
}
    public static String askForName(String name){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type down your name: ");
        return name;
    }
}