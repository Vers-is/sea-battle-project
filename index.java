import java.util.Random;
import java.util.Scanner;
        
class index 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
                
// o - miss, * - hint, X - sunk
        char[][] board = new char[7][7];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }

        askForName(scanner);
        printBoard(board);
        askForPosition(scanner, name);
}
    public static void cleanConsole(){ 
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
    }

    public static void printBoard(char[][] board){
        cleanConsole();
        System.out.println("    1   2   3   4   5   6   7"+
                        "\n"+ "A | "+ board[0][0]+" | "+board[0][1]+" | "+board[0][2]+" | "+ board[0][3]+" | "+board[0][4]+" | "+board[0][5]+" | "+board[0][6]+
                        "\n"+ "--+---+---+---+---+---+---+---"+
                        "\n"+ "B | "+ board[1][0]+" | "+board[1][1]+" | "+board[1][2]+" | "+ board[1][3]+" | "+board[1][4]+" | "+board[1][5]+" | "+board[1][6]+
                        "\n"+ "--+---+---+---+---+---+---+---"+
                        "\n"+ "C | "+ board[2][0]+" | "+board[2][1]+" | "+board[2][2]+" | "+ board[2][3]+" | "+board[2][4]+" | "+board[2][5]+" | "+board[2][6]+
                        "\n"+ "--+---+---+---+---+---+---+---"+
                        "\n"+ "D | "+ board[3][0]+" | "+board[3][1]+" | "+board[3][2]+" | "+ board[3][3]+" | "+board[3][4]+" | "+board[3][5]+" | "+board[3][6]+
                        "\n"+ "--+---+---+---+---+---+---+---"+
                        "\n"+ "E | "+ board[4][0]+" | "+board[4][1]+" | "+board[4][2]+" | "+ board[4][3]+" | "+board[4][4]+" | "+board[4][5]+" | "+board[4][6]+
                        "\n"+ "--+---+---+---+---+---+---+---"+
                        "\n"+ "F | "+ board[5][0]+" | "+board[5][1]+" | "+board[5][2]+" | "+ board[5][3]+" | "+board[5][4]+" | "+board[5][5]+" | "+board[5][6]+
                        "\n"+ "--+---+---+---+---+---+---+---"+
                        "\n"+ "G | "+ board[6][0]+" | "+board[6][1]+" | "+board[6][2]+" | "+ board[6][3]+" | "+board[6][4]+" | "+board[6][5]+" | "+board[6][6]
                        );
    }
    
    static String name; // now name is a field

    public static void askForName(Scanner scanner){
        cleanConsole();
        System.out.print("Type down your name: ");
        String toScan = scanner.nextLine().toLowerCase();
        String firstLetter = toScan.substring(0, 1).toUpperCase();
        String lastLetters = toScan.substring(1);
        name = firstLetter + lastLetters; // Upcasing the name
    }

    public static void askForPosition(Scanner scanner, String name){
        System.out.print("\n" + name + ", choose the position: ");
        String position = scanner.nextLine().toUpperCase();
    }    

    //public static void setShipsRandomly() {
        
    //}

    public static void turnInputIntoIndex(int index, char[][] board) {
        
    }
}