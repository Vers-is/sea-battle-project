import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
        
class Index {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
                
// o - miss, * - hint, X - sunk 
// 222 - cheat code

        int shots;
        HashMap<String, Integer> players = new HashMap<>();
            

        while(true){

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
            shots = 0;
        while (!checkForShips(board, 0)) {
            boolean validInput = true;
            
            while (validInput) {
                askForPosition(scanner, board);
                if (position.equals("222")) {
                    applyCheat(board);
                    validInput = false; 
                    break;
                }

                rowIndex = returnRowIndex(position);
                colIndex = returnColumnIndex(position);
                shots++;
                if (rowIndex != -1 && colIndex != -1) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input, please try again.");
                }
            }
            
            if (!position.equals("222")) { 
                cleanConsole();
                playerTurn(board, rowIndex, colIndex);
                printBoard(board);
            }
            
            if (checkForShips(board, 0)) {
                cleanConsole();
                System.out.println("Win!");
                System.out.println("Your amount of shots: " + shots + "\n");
                players.put( name, shots);
                break;
            }
        }
        
        gameOver(name);
        while (true) {
            String command = scanner.nextLine().toLowerCase();
            if (command.equals("no")) {
                cleanConsole();
                System.out.println("The list of players: "); 
                printSortedPlayers(players);
                return;
            } else if (command.equals("yes")) {
                break;
            } else {
                System.out.print("Invalid input. Try again: ");
            }
        }
    }
}
    //     field
    static String name; 
    static String position;
    static int rowIndex;
    static int colIndex;

     public static void printSortedPlayers(HashMap<String, Integer> players) {
        List<Map.Entry<String, Integer>> sortedPlayers = new ArrayList<>(players.entrySet());
        
        sortedPlayers.sort(Map.Entry.comparingByValue());

        for (Map.Entry<String, Integer> entry : sortedPlayers) {
            System.out.println(entry.getKey() + "  -  " + entry.getValue());
        }
    }

    public static void cleanConsole(){ 
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
    }
  
    public static void printBoard(char[][] board){
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

    public static String removeSpaces(String position) {
        return position.replaceAll("\\s+", ""); 
    }
    
    public static void askForPosition(Scanner scanner, char[][] board){
        System.out.print("\n" + name + ", choose the position: ");
        position = scanner.nextLine().toUpperCase();
        position = removeSpaces(position);
    
        if (position.equals("222")) {
            applyCheat(board);
        }
    }    
    
    public static void applyCheat(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    board[i][j] = '*';  
                }
            }
        }
        cleanConsole();
        System.out.println("Cheat code activated!");
    }
    
        
    public static int returnRowIndex(String position) {
        position = removeSpaces(position); 
        if (position.length() != 2) {
            System.out.println("Invalid input format. \nTry again: ");
            return -1; 
        }
    
        char rowChar = position.charAt(0); 
    
        switch (rowChar) {
            case 'A': return 0;
            case 'B': return 1;
            case 'C': return 2;
            case 'D': return 3;
            case 'E': return 4;
            case 'F': return 5;
            case 'G': return 6;
            default:  
                System.out.print("Invalid row input. ");
                return -1;  
        }
    }
    
    public static int returnColumnIndex(String position) {
        position = removeSpaces(position); 
        if (position.length() != 2) {
            System.out.print("Invalid input format. \nTry again: ");
            return -1; 
        }
    
        char colChar = position.charAt(1);
    
        switch (colChar) {
            case '1': return 0;
            case '2': return 1;
            case '3': return 2;
            case '4': return 3;
            case '5': return 4;
            case '6': return 5;
            case '7': return 6;
            default: 
                System.out.print("Invalid column input. ");
                return -1; 
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

    public static char [][] playerTurn(char[][] board, int rowIndex, int colIndex ){    
            
            if (board[rowIndex][colIndex] == 'X') {
                board[rowIndex ][colIndex] = '*';  
                System.out.println("Hit!");
            } else if (board[rowIndex][colIndex] == ' ') {
                board[rowIndex][colIndex] = 'o'; 
                System.out.println("Miss...");
            } else {
                System.out.println("You already played this move. Try again.");
                //return board;  
            }
        return board;
    }

    public static boolean checkForShips(char[][] board, int ships){
    
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == 'X') {  
                ships++;
            }
        }
    }
        return ships == 0;
    }   
        
    public static void gameOver(String name){
        System.out.println(name + ", do you want to continue? \nYES \nNO");
    }

}

    
