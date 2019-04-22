/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass.proj_1;

/**
 *
 * @author chris
 */
import java.util.*;
import java.util.stream.*;

class Matrix {
    //fields

    final int row;
    final int col;
    final int[][] myArr;

    //constructor
    Matrix() {
        this(2, 2);
    }

    Matrix(int row, int col) {
        this.row = row;
        this.col = col;

        myArr = IntStream.range(0, row)
                .mapToObj(x -> new Random()
                        .ints(-100, 100)
                        .limit(col)
                        .toArray() )
                .toArray(int[][]::new);
    }

    Matrix(int[][] input) {
        this.row = input.length;
        this.col = input.length;
        this.myArr = Arrays.stream(input)
                .map(x -> Arrays.copyOf(x, x.length))
                .toArray(int[][]::new);
    }

    public Matrix subtract(Matrix input) {
        return new Matrix(IntStream.range(0, this.row)
                .mapToObj(x -> IntStream.range(0, this.col)
                        .map(y -> this.myArr[x][y] - input.myArr[x][y])
                        .toArray())
                .toArray(int[][]::new));
    }

    public Matrix add(Matrix input) {
        return new Matrix(IntStream.range(0, this.row)
                .mapToObj(x -> IntStream.range(0, this.col)
                        .map(y -> this.myArr[x][y] + input.myArr[x][y])
                        .toArray())
                .toArray(int[][]::new));
    }

    public Matrix dot(Matrix input) {
        return new Matrix(IntStream.range(0, this.row)
                .mapToObj( i -> IntStream.range(0, input.col)
                            .map(j -> IntStream.range(0, this.col)
                            .map(k -> this.myArr[i][k] * input.myArr[k][j])
                            .reduce(0, (a, b) -> a + b) )
                            .toArray() )
                .toArray(int[][]::new)
        );
    }

    public Matrix Hadamard(Matrix input) {
        return new Matrix(IntStream.range(0, this.row)
                .mapToObj(x 
                        -> IntStream.range(0, this.col)
                        .map(y -> this.myArr[x][y] * input.myArr[x][y])
                        .toArray() )
                .toArray(int[][]::new));
    }

    @Override
    public String toString() {
        return Arrays.stream(this.myArr)
                     .map(r -> Arrays.stream(r)
                     .mapToObj(e -> String.format("%10d", e))
                     .reduce(" ", (a, b) -> a + b))
                     .reduce(" ", (a, b) -> a + b + '\n');

    }

    boolean isEqual(Object in) {
        if (in instanceof Matrix) {
            //return true;
            Matrix input = (Matrix) in;

            return Arrays.deepEquals(this.myArr, input.myArr);
        }

        return false;
    }

    Object Clone() {

        return (Object) new Matrix(this.myArr);
    }

}
