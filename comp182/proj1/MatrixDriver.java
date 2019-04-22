/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass.proj_1;

import java.util.Scanner;

/**
 *
 * @author chris
 */
public class MatrixDriver {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Matrix A = getMatrix("first");
        System.out.println(A.toString());

        Matrix B = getMatrix("second");
        System.out.println(B.toString());

        Matrix C = calculate(A, B);
        System.out.println("Result");
        System.out.print(C.toString());
    }

    static Matrix getMatrix(String name) {
        System.out.println("Enter parameters for the " + name + " Matrix");
        System.out.print("Enter row : ");
        int row = scan.nextInt();
//      System.out.println();
        System.out.print("Enter the number of columns: ");
        int col = scan.nextInt();

        return new Matrix(row, col);
    }

    static boolean Validate(Matrix A, Matrix B) {
        return (A.row == B.row && A.col == B.col);
    }

    static boolean validateDot(Matrix A, Matrix B) {
        return (A.col == B.row);
    }

    static int printOptions() {
        System.out.print("Select an operation ");
        System.out.print("\n 1) Add" + "\n 2)Subtract" + "\n 3) DotProduct" + "\n4)Hadamard  \n");

        int result = scan.nextInt();

        return result;

    }

    static boolean isValidOp(int selection, Matrix A, Matrix B) {

        switch (selection) {
            case 1:
            case 2:
            case 4:
                return Validate(A, B);
            case 3:
                return validateDot(A, B);
            default:
                return false;
        }
    }

    static Matrix performOperation(Matrix A, Matrix B, int selection) {
        switch (selection) {
            case 1:
                return A.add(B);
            case 2:
                return A.subtract(B);
            case 3:
                return A.dot(B);
            default:
                return A.Hadamard(B);
        }

    }

    static Matrix calculate(Matrix A, Matrix B) {
        boolean isValid;
        int selection;
        selection = printOptions();

        do {

            isValid = isValidOp(selection, A, B);

            if (!isValid) {
                System.out.println("invalid");
                A = getMatrix("first");

                System.out.println(A.toString());

                B = getMatrix("second");
                System.out.println(B.toString());
                selection = printOptions();
            }

        } while (!isValid);

        return performOperation(A, B, selection);
    }

}
