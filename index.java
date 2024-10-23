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

        setShipsRandomly(board, random, 3, 1); 
        setShipsRandomly(board, random, 2, 2);
        setShipsRandomly(board, random, 1, 4); 
        printBoard(board);
        askForPosition(scanner);
        turnInputIntoIndex(position); 
        playerTurn(board); 
        printBoard(board);
}

    //     field
    static String name; 
    static String position;
    static int rowIndex;
    static int colIndex;

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

    public static void askForName(Scanner scanner){
        cleanConsole();
        System.out.print("Type down your name: ");
        String toScan = scanner.nextLine().toLowerCase();
        String firstLetter = toScan.substring(0, 1).toUpperCase();
        String lastLetters = toScan.substring(1);
        name = firstLetter + lastLetters; // Upcasing the name
    }

    public static void askForPosition(Scanner scanner){
        System.out.print("\n" + name + ", choose the position: ");
        position = scanner.nextLine().toUpperCase();
    }    

    public static void turnInputIntoIndex(String position) {
        String[] parts = position.split(" ");
        if (parts.length != 2) {
            System.out.println("Invalid input format. Try again...");
            return; 
        }

        char rowChar = parts[0].charAt(0); 
        char colChar = parts[1].charAt(0);
    
        switch (rowChar) {
            case 'A': rowIndex = 0; break;
            case 'B': rowIndex = 1; break;
            case 'C': rowIndex = 2; break;
            case 'D': rowIndex = 3; break;
            case 'E': rowIndex = 4; break;
            case 'F': rowIndex = 5; break;
            case 'G': rowIndex = 6; break;
            default: System.out.println("Invalid row input");
            return;
        }

        switch (colChar) {
            case '1': colIndex = 0; break;
            case '2': colIndex = 1; break;
            case '3': colIndex = 2; break;
            case '4': colIndex = 3; break;
            case '5': colIndex = 4; break;
            case '6': colIndex = 5; break;
            case '7': colIndex = 6; break;
            default: System.out.println("Invalid column input");
            return;
        }

    }

    public static void setShipsRandomly(char[][] board, Random random, int size, int count) {
        for (int i = 0; i < count; i++) {
            boolean placed = false;

            while (!placed) {
                int row = random.nextInt(7);
                int col = random.nextInt(7);
                boolean vertical = random.nextBoolean();

                if (canPlaceShip(board, row, col, size, vertical)) {
                    for (int j = 0; j < size; j++) {
                        if (vertical) {
                            board[row + j][col] = 'X';
                        } else {
                            board[row][col + j] = 'X';
                        }
                    }
                    placed = true;
                }
            }
        }
    }

    public static boolean canPlaceShip(char[][] board, int row, int col, int size, boolean vertical) {
        if (vertical) {
            if (row + size > board.length) return false; // of bounds vertically
            for (int i = 0; i < size; i++) {
                if (board[row + i][col] == 'X') return false;
    
                // above and below 
                if (row + i > 0 && board[row + i - 1][col] == 'X') return false; // above
                if (row + i < board.length - 1 && board[row + i + 1][col] == 'X') return false; // Below
                
                // diagonal
                if (row + i > 0) {
                    if (col > 0 && board[row + i - 1][col - 1] == 'X') return false; 
                    if (col < board[0].length - 1 && board[row + i - 1][col + 1] == 'X') return false;
                }
                if (row + i < board.length - 1) {
                    if (col > 0 && board[row + i + 1][col - 1] == 'X') return false; 
                    if (col < board[0].length - 1 && board[row + i + 1][col + 1] == 'X') return false; 
                }
            }
    
            if (col > 0 && (board[row][col - 1] == 'X' || (row + size - 1 < board.length && board[row + size - 1][col - 1] == 'X'))) {
                return false; // left
            }
            if (col < board[0].length - 1 && (board[row][col + 1] == 'X' || (row + size - 1 < board.length && board[row + size - 1][col + 1] == 'X'))) {
                return false; // right
            }
        } else {
            if (col + size > board[0].length) return false; //  out of bounds horizontally
            for (int i = 0; i < size; i++) {
                if (board[row][col + i] == 'X') return false;
                if (col + i > 0 && board[row][col + i - 1] == 'X') return false; // left
                if (col + i < board[0].length - 1 && board[row][col + i + 1] == 'X') return false; // right
                
                // diagonals
                if (row > 0) {
                    if (col + i > 0 && board[row - 1][col + i - 1] == 'X') return false; 
                    if (col + i < board[0].length - 1 && board[row - 1][col + i + 1] == 'X') return false; 
                }
                if (row < board.length - 1) {
                    if (col + i > 0 && board[row + 1][col + i - 1] == 'X') return false; 
                    if (col + i < board[0].length - 1 && board[row + 1][col + i + 1] == 'X') return false; 
                }
            }
            if (row > 0 && (board[row - 1][col] == 'X' || (col + size - 1 < board[0].length && board[row - 1][col + size - 1] == 'X'))) {
                return false;
            }
            if (row < board.length - 1 && (board[row + 1][col] == 'X' || (col + size - 1 < board[0].length && board[row + 1][col + size - 1] == 'X'))) {
                return false; 
            }
        }
        return true; 
    }

    public static char [][] playerTurn(char[][] board){    
            if (board[rowIndex][colIndex] == 'X') {
                board[rowIndex ][colIndex] = '*';  
                System.out.println("Hit!");
            } else if (board[rowIndex][colIndex] == ' ') {
                board[rowIndex][colIndex] = 'o'; 
                System.out.println("Miss...");
            } else {
                System.out.println("You already played this move. Try again.");
                return board;  
            }
        
        return board;
    }


    
}

    
