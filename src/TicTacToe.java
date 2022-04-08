
import java.util.Scanner;

public class TicTacToe {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int playerOne = 1;
        int playerTwo = 2;
        int[][] field = new int[3][3];
        printField(field);

        while (true) {

                System.out.println("Игрок один{Крестик} -ваш ход!");
            if (isDraw(field)) {
                move(field, playerOne);
            } else {
                System.out.println("Победителей нет! Ничья");
                break;
            }

                printField(field);
                if (isWinner(field, playerOne)) {
                    System.out.println("Игрок один {Крестик} победил");
                    break;
                }

                System.out.println("Игрок два {Нолик} -ваш ход!");

            if (isDraw(field)) {
                move(field, playerTwo);
            } else {
                System.out.println("Победителей нет! Ничья");
                break;
            }


                printField(field);
                if (isWinner(field, playerTwo)) {
                    System.out.println("Игрок два {Нолик} победил");
                    break;
                }
            }
        }


    public static int[][] move(int[][] arr, int mark) {
        int a;
        int b;
        System.out.println("Введите столбец: ");
        while (((a = sc.nextInt()) < 1 || a > 3)) {
            System.out.println("Введите столбец повторно. Допустимое число от 1 до 3");
        }
        System.out.println("Введите ряд: ");
        while (((b = sc.nextInt()) < 1 || b > 3)) {
            System.out.println("Введите ряд повторно. Допустимое число от 1 до 3");
        }
         if(arr[b - 1][a - 1] ==1 || arr[b - 1][a - 1] ==2){
             System.out.println("Эта клетка уже занята");
             move(arr, mark);

         }else {
             arr[b - 1][a - 1] = mark;

         }
        return arr;
    }


    public static void printField(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    System.out.print("X");
                } else if (arr[i][j] == 2) {
                    System.out.print("0");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }

    public static boolean isWinner(int[][] arr, int player) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == player && arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
                return true;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[0][i] == player && arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
                return true;
            }

        }
        if (arr[1][1] == player) {
            if ((arr[0][0] == arr[2][2] && arr[0][0] == player) || (arr[0][2] == arr[2][0] && arr[0][2] == player)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDraw(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
