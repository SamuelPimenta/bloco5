package com.auladev;

import java.util.Arrays;

public class MatrizInteiros {

    int[][] matrix;

    //2a
    public MatrizInteiros(){
        this.matrix = new int[0][0];
    }

    //2b
    public MatrizInteiros(int[][] valores){
        this.matrix = copyMatrix(valores);
    }


    private int[][] copyMatrix (int[][] from){
        int[][] to = new int[from.length][];

        for (int i = 0; i < from.length; i++) {
            to[i] = new int[from[i].length];

            for (int j = 0; j < from[i].length; j++) {
                to[i][j] = from[i][j];
            }
        }
        return to;
    }

    public int[][] getValues(){
        return copyMatrix(this.matrix);
    }

    //2c
    public void addNumberV2(int num, int line){

        int[] res = new int[this.matrix[line].length + 1];
        for (int i = 0; i < this.matrix[line].length; i++) {
            res[i] = this.matrix[line][i];
        }
        res[res.length - 1] = num;

        this.matrix[line] = res;
    }

    public void addNumber(int num, int line) {

        int[][] to = new int[this.matrix.length][];

        for (int i = 0; i < this.matrix.length; i++) {

            if (i == line) {
                to[i] = new int[this.matrix[line].length + 1];

                for (int j = 0; j < this.matrix[line].length; j++) {
                    to[i][j] = this.matrix[i][j];
                }

                to[i][this.matrix[line].length] = num;
            } else {
                to[i] = new int[this.matrix[i].length];

                for (int k = 0; k < this.matrix[i].length; k++) {
                    to[i][k] = this.matrix[i][k];
                }
            }
        }

        this.matrix = to;
    }

    //2d
    private boolean checkIfNumberIsInMatrix(int num){

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                if(this.matrix[i][j] == num){
                    return true;
                }
            }
        }
        return false;
    }

    private int[] getIndexOfFirstNumber(int num){

        int[] res = new int[2];

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                if(this.matrix[i][j] == num){
                    res[0] = i;
                    res[1] = j;
                    i = this.matrix.length;
                    break;
                }
            }
        }
        return res;
    }

    private int[] takeFirstNumberNFromArr(int[] arr, int num){

        int[] res = new int[arr.length -1];
        int i = 0;
        while(arr[i] != num){
            res[i] = arr[i];
            i++;
        }

        while(i < res.length){
            res[i] = arr[i + 1];
            i++;
        }
        return res;
    }

    public void takeFirstNumberNFromMatrix(int num) {

        if(checkIfNumberIsInMatrix(num)) {

            int[][] to = new int[this.matrix.length][];

            int[] location = getIndexOfFirstNumber(num);

            for (int i = 0; i < this.matrix.length; i++) {

                if (i == location[0]) {

                    to[i] = takeFirstNumberNFromArr(this.matrix[i], num);

                } else {

                    to[i] = new int[this.matrix[i].length];

                    for (int j = 0; j < this.matrix[i].length; j++) {
                        to[i][j] = this.matrix[i][j];
                    }
                }
            }

            this.matrix = to;
        }
    }

    public void takeFirstNumberNV2(int num){

        if(checkIfNumberIsInMatrix(num)) {
            int line = getIndexOfFirstNumber(num)[0];

           this.matrix[line] = takeFirstNumberNFromArr(this.matrix[line], num);
        }
    }

    //2e
    public boolean checkIfEmpty(){
        return this.matrix.length == 0;
    }

    //2f
    public int getBiggestNumber(){

        int res = this.matrix[0][0];

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                if(this.matrix[i][j] > res){
                    res = this.matrix[i][j];
                }
            }
        }
        return res;
    }

    //2g
    public int getSmallestNumber(){

        int res = this.matrix[0][0];

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                if(this.matrix[i][j] < res){
                    res = this.matrix[i][j];
                }
            }
        }
        return res;
    }

    //2h
    private int getNumberOfValuesFromMatrix(int[][] arr2d){
        int res = 0;

        for (int i = 0; i < arr2d.length; i++) {
            res += arr2d[i].length;
        }
        return res;
    }

    public int getMatrixAverage(){

        int soma = 0;

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                soma += this.matrix[i][j];
            }
        }
        return (int) Math.round(soma * 1.0 / getNumberOfValuesFromMatrix(this.matrix));
    }

    //2i
    public int[] getSumOfEachRow(){

        int[] res = new int[this.matrix.length];

        for (int i = 0; i < this.matrix.length; i++) {
            int soma = 0;

            for (int j = 0; j < this.matrix[i].length; j++) {
                soma += this.matrix[i][j];
            }
            res[i] = soma;
        }
        return res;
    }


    //2j
    private int getLengthOfBiggestColumn(){

        int res = this.matrix[0].length;

        for (int i = 1; i < this.matrix.length; i++) {
            if(this.matrix[i].length > res){
                res = this.matrix[i].length;
            }
        }
        return res;
    }

    public int[] getSumOfEachColumn(){

        int[] res = new int[this.getLengthOfBiggestColumn()];

        for (int i = 0; i < this.matrix.length; i++) {

            for (int j = 0; j < this.matrix[i].length; j++) {
                res[j] += this.matrix[i][j];
            }
        }
        return res;
    }

    //2k
    public int getIndexRowWithLargestSum(){

        int[] sum = this.getSumOfEachRow();
        int temp = sum[0];
        int res = 0;

        for (int i = 0; i < sum.length; i++) {
            if(sum[i] > temp){
                temp = sum[i];
                res = i;
            }
        }
        return res;
    }

    //2l
    public boolean checkForSquareMatrix(){

        if(this.matrix.length == 0){
            return false;
        }

        for (int i = 0; i < this.matrix.length; i++) {
            if(this.matrix[i].length != this.matrix.length){
                return false;
            }
        }
        return true;
    }

    //2m
    private int[][] transposeMatrix(){
        int[][] res = new int[this.matrix.length][this.matrix.length];

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                res[i][j] = this.matrix[j][i];
            }
        }
        return res;
    }

    public boolean checkForSymmetricMatrix(){
        return Arrays.deepEquals(this.matrix, this.transposeMatrix());
    }

    //2n
    public int nonNullElementsInDiagonal(){

        if(!this.checkForSquareMatrix()){
            return -1;
        }
        else{
            int res = 0;
            for (int i = 0; i < this.matrix.length; i++) {
                if(this.matrix[i][i] != 0){
                    res++;
                }
            }
            return res;
        }
    }

    //2o
    public boolean checkIfDiagonalsAreEqual(){

        for (int i = 0; i < this.matrix.length; i++) {
                if(this.matrix[i][i] != this.matrix[i][this.matrix.length - 1 - i]){
                    return false;
                }
        }
        return true;
    }

    //2p
    private int getNumberOfDigits(int number){

        int algarismos = 0;
        int temp = number;

        while(temp != 0){
            temp/= 10;
            algarismos++;
        }
        return algarismos;
    }

    private int getAverageNumberOfDigitsInMatrix(){
        int counter = 0;
        int soma = 0;

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                soma += getNumberOfDigits(this.matrix[i][j]);
                counter ++;
            }

        }
        return soma / counter;
    }

    private int getNumberOfElementsIn2DArray(){
        int res = 0;

        for (int i = 0; i < this.matrix.length; i++) {
            res += this.matrix[i].length;
        }
        return res;
    }

    private int[] resizeArray(int[] vec, int lim){

        int[] res = new int[lim];

        for(int i = 0; i < lim; i++){
            res[i] = vec[i];
        }
        return res;
    }

    public int[] getElementsWithNumberOfDigitsBiggerThanAverage(){

        int[] res = new int[this.getNumberOfElementsIn2DArray()];
        int counter = 0;

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                if(getNumberOfDigits(this.matrix[i][j]) > this.getAverageNumberOfDigitsInMatrix()){
                    res[counter] = this.matrix[i][j];
                    counter++;
                }
            }
        }
        return resizeArray(res, counter);
    }

    //2q
    private double percentagemAlgarismosPares (int num){

        int temp = num;
        int pares = 0;

        while(temp != 0){
            if(temp % 10 % 2 == 0){
                pares++;
            }
            temp /= 10;
        }

        return Math.round( ( (pares * 1.0) / getNumberOfDigits(num) ) * 100);
    }

    private int getAverageNumberOfEvenDigits(){
        int sum = 0;

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                sum += percentagemAlgarismosPares(this.matrix[i][j]);
            }

        }
        return sum / this.getNumberOfElementsIn2DArray();
    }
    public int[] getElementsWithPercentageOfEvenDigitsBiggerThanAverage(){

        int[] res = new int[this.getNumberOfElementsIn2DArray()];
        int counter = 0;

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                if(percentagemAlgarismosPares(this.matrix[i][j]) > this.getAverageNumberOfEvenDigits()){
                    res[counter] = this.matrix[i][j];
                    counter++;
                }
            }
        }
        return resizeArray(res, counter);
    }

    //1r
    private int[] reverseElements(int[] arr){
        int[] res = new int[arr.length];
        int counter = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            res[counter] = arr[i];
            counter++;
        }
        return res;
    }

    public void reverseRows(){

        for (int i = 0; i < this.matrix.length; i++) {
            this.matrix[i] = reverseElements(this.matrix[i]);
        }
    }

    //1s
    public void reverseColumnsV2(){
        int[][] res = copyMatrix(this.matrix);

        for (int i = 0; i < this.matrix.length; i++) {
            res[i] = this.matrix[this.matrix.length - 1 - i];
        }
        this.matrix = res;
    }

    public void reverseColumnsSquareMatrix(){

        int[][] res = copyMatrix(this.matrix);

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                res[i][j] = this.matrix[this.matrix.length - 1 - i][j];
            }
        }
        this.matrix = res;
    }

    //2t
    public void turn90Degrees(){

        int[][] res = copyMatrix(this.matrix);

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                res[i][j] = this.matrix[this.matrix.length - 1 - j][i];
            }
        }
        this.matrix = res;
    }

    //2u
    public void turn180Degrees(){

        int[][] res = copyMatrix(this.matrix);

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                res[i][j] = this.matrix[this.matrix.length - 1 - i][this.matrix.length - 1 - j];
            }
        }
        this.matrix = res;
    }

    //2v
    public void turnMinus90Degrees(){

        int[][] res = copyMatrix(this.matrix);

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                res[i][j] = this.matrix[j][this.matrix.length - 1 - i];
            }
        }
        this.matrix = res;
    }
}
