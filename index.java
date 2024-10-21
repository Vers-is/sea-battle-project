import java.util.Scanner;
class index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // o - miss, * - hint, X - sunk

        char[][] board = {{' ', ' ', ' ', ' ', ' ', ' ', ' '},
                          {' ', 'o', ' ', ' ', ' ', ' ', ' '},
                          {' ', ' ', ' ', ' ', ' ', '*', ' '},
                          {' ', ' ', ' ', ' ', 'X', ' ', ' '},
                          {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                          {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                          {' ', ' ', ' ', ' ', ' ', ' ', ' '}};


        askForName();
        
        String name = scanner.nextLine();
        printBoard(board);
        System.out.println(name);


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

    public static void askForName(){
        System.out.print("Type down your name: ");
    }

    //public static void setShipsOnPosisions() {
        
    //}
}