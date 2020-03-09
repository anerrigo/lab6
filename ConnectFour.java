import java.util.Scanner;
public class ConnectFour {
    public static void printBoard(char[][] array) { //prints the board

        for (int r = array.length - 1; r >= 0; r--) {
            for (int c = 0; c < array[0].length; c++) {
                System.out.print(array[r][c] + " "); //the array for the rows and columns on // the board

            }
            System.out.println(); //space

        }
    }
//for lab 6
    public static void initializeBoard(char[][] array) { // sets each array to '-'
        for(int r = 0; r < array.length; r++){
        for(int c = 0; c < array[0].length; c++){
                array[r][c] = '-'; //adds the - as spaces
            }
        }
    }

    public static int insertChip(char[][] array, int col, char chipType) { //places token in the column the user has chosen
        //finds the next available spot in that column if there are already tokens there
        for (int r = 0; r < array.length; r++)
            if (array[r][col] == '-') {
                array[r][col] = chipType;
                return r; //the row the token is placed in is returned
            }


        return col; //returns the columns
    }
//return - 1

//}
public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {
        //after token is added this checks if the token is in this location
    int count = 0;
    for (int r = 0; r < array.length; r++) {
        if (array[r][col] == chipType) {
            count++;
            if (count == 4) {
                return true; // returns true is someone won (4 in a row)
            }
        } else {
            count = 0;
        }
    }
    count = 0;
    for (int r = 0; r < array[0].length; r++) {
        if (array[row][r] == chipType) {
            count++;
            if (count == 4) {
                return true;
            }
        } else {
            count = 0;
        }
    }
    return false; //returns false if didnt win
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int rows, columns;
    while (true) { //prints out the prompts for the user
        System.out.print("What would you like the height of the board to be? ");
        rows = sc.nextInt();
        if (rows >= 4) { //if the rows aren't 4
        } else {
            System.out.println("Height should be at least 4. Please try again!");
        }
        break;
    }
while(true){
    System.out.print("What would you like the length of the board to be? ");
    columns = sc.nextInt();
    if(columns>=4){
        break;
        }
        else{ //if the length isnt at least 4
            System.out.println("Length should be at least 4. Please try again!");
        }
        }

    char board [][] = new char[rows][columns];
initializeBoard(board);
printBoard(board);
System.out.println("Player 1: x"); //establishes the players and how their represented
System.out.println("Player 2: o");

boolean player1 = true;
char player;
int choiceColumn = 0;
int result = 0;

boolean isGameOver = false; // if the game is not over
int totalPlay = 0;
while(true){
    if(player1){
        System.out.println("Player1: ");
        player = 'x'; //player 1 is x
    }
    else{
        System.out.println("Player 2:");
        player = 'o'; // player 2 is o
    }
    System.out.print("Which column would you like to choose?"); //lets user choose where they want to go/play
    choiceColumn = sc.nextInt();
    if(choiceColumn<0 || choiceColumn >= columns) {
        System.out.println("Please enter a choice between 0 and" + (columns - 1));
    }


        //if(result == 1) {
            //System.out.println("There is no room to insert. Please try again!!!");
        //}
        else{
        result = insertChip(board, choiceColumn, player);
            printBoard(board);
            isGameOver = checkIfWinner(board, choiceColumn, result, player);
            if(isGameOver){
                if(player1){
                    System.out.print("Player 1 won the game!"); //if player 1 gets 4
                }
                else{
                    System.out.print("Player 2 won the game!"); //if player 2 gets 4
                }
                break;
            }
            player1 = !player1;
            totalPlay++;
        }

    if(totalPlay == rows * columns){
        System.out.println("Draw. Nobody wins."); //if there is a tie
        break;
    }
}
sc.close();
}
}

