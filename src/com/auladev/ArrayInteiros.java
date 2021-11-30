package com.auladev;

import java.util.Arrays;

public class ArrayInteiros {
    private int[] vector;

    public ArrayInteiros(){
        this.vector = new int[0];
    }

    public ArrayInteiros(int [] valores){
        this.vector = copyFrom(valores);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayInteiros that = (ArrayInteiros) o;
        return Arrays.equals(vector, that.vector);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vector);
    }

    private int[] copyFrom(int[] from){
        int[] to = new int[from.length];
        for (int i = 0; i < from.length; i++) {
            to[i] = from[i];
        }
        return to;
    }



    public void addValue(int valor){
        int[] to = new int[this.vector.length +1];
        for (int i = 0; i < this.vector.length; i++) {
            to[i] = this.vector[i];
        }
        to[this.vector.length] = valor;
        this.vector = to;
    }

    public int[] getValues(){
        return copyFrom(this.vector);
    }

    // 1 d
    public boolean checkForNumInArr(int num) {

        for (int i = 0; i < this.vector.length; i++) {
            if (this.vector[i] == num) {
                return true;
            }
        }
        return false;
    }
    public void takeFirstIntGiven(int valor){

        if(checkForNumInArr(valor) == true){
                int[] to = new int[this.vector.length -1];

                int j = 0;
                while (this.vector[j] != valor){
                    to[j] = this.vector[j];
                    j++;
                }

                while(j < this.vector.length -1){
                    to[j] = this.vector[j +1];
                    j++;
                }

                this.vector = to;

            }
        }

    // 1 e
    public int valueFromIndex(int x){
        int res = this.vector[x];

        return res;
    }

    // 1 f
    public int numberOfElements(){
        return this.vector.length;
    }

    // 1 g
    public int biggestNumber(){

        int res = this.vector[0];

        for (int i = 0; i < this.vector.length; i++) {
            if(this.vector[i] > res){
                res = this.vector[i];
            }
        }
        return res;
    }

    // 1 h
    public int smallestNumber(){

        int res = this.vector[0];

        for (int i = 0; i < this.vector.length; i++) {
            if(this.vector[i] < res){
                res = this.vector[i];
            }
        }
        return res;
    }

    // 1 i
    public double getAverage(){

        int soma = 0;

        for (int i = 0; i < this.vector.length; i++) {
            soma += this.vector[i];
        }

        return (soma * 1.0) / this.vector.length;
    }

    // 1 j
    public double getEvenAverage(){

        int soma = 0;
        int counter = 0;

        for (int i = 0; i < this.vector.length; i++) {
            if(this.vector[i] % 2 == 0){
                soma += this.vector[i];
                counter++;
            }
        }

        return (soma * 1.0) / counter;
    }

    // 1 k
    public double getOddAverage(){

        int soma = 0;
        int counter = 0;

        for (int i = 0; i < this.vector.length; i++) {
            if(this.vector[i] % 2 != 0){
                soma += this.vector[i];
                counter++;
            }
        }

        return (soma * 1.0) / counter;
    }

    // 1 l
    public double getMultiplesAverage(int number){

        int soma = 0;
        int counter = 0;

        for (int i = 0; i < this.vector.length; i++) {
            if(this.vector[i] % number == 0){
                soma += this.vector[i];
                counter++;
            }
        }

        return (soma * 1.0) / counter;
    }

    // 1 m
    public void sortAscending(){

        int temp = 0;

        for (int i = 0; i < this.vector.length; i++) {
            for (int j = i + 1; j < this.vector.length; j++) {
                if(this.vector[j] < this.vector[i]){
                    temp = this.vector[i];
                    this.vector[i] = this.vector[j];
                    this.vector[j] = temp;
                }
            }
        }
    }

    public void sortDescending(){

        int temp = 0;

        for (int i = 0; i < this.vector.length; i++) {
            for (int j = i + 1; j < this.vector.length; j++) {
                if(this.vector[j] > this.vector[i]){
                    temp = this.vector[i];
                    this.vector[i] = this.vector[j];
                    this.vector[j] = temp;
                }
            }
        }
    }

    // 1 n
    public boolean checkIfEmpty(){
        return this.vector.length == 0;
    }

    // 1 o
    public boolean checkIfOnlyOneElement(){
        return this.vector.length == 1;
    }

    // 1 p
    public boolean checkIfOnlyEven(){

        if(this.vector.length == 0){
            return false;
        }

        for (int i = 0; i < this.vector.length; i++) {
            if(this.vector[i] % 2 != 0){
                return false;
            }
        }
        return true;
    }

    // 1 q
    public boolean checkIfOnlyOdd(){

        if(this.vector.length == 0){
            return false;
        }

        for (int i = 0; i < this.vector.length; i++) {
            if(this.vector[i] % 2 == 0){
                return false;
            }
        }
        return true;
    }

    //1 r
    public boolean checkForDuplicates(){

        for (int i = 0; i < this.vector.length; i++) {
            for (int j = i + 1; j < this.vector.length; j++) {
                if (this.vector[i] == this.vector[j]){
                    return true;
                }
            }
        }
        return false;
    }

    // 1 s
    private int[] resizeArray(int[] vec, int lim){

        int[] res = new int[lim];

        for(int i = 0; i < lim; i++){
            res[i] = vec[i];
        }
        return res;
    }

    private int getNumberOfDigits(int number){

        int algarismos = 0;
        int temp = number;

        while(temp != 0){
            temp/= 10;
            algarismos++;
        }
        return algarismos;
    }

    public int getAverageNumberOfDigits(int[] arr){

        int soma = 0;

        for (int i = 0; i < arr.length; i++) {
            soma += getNumberOfDigits(arr[i]);
        }

        return (int) Math.round(soma * 1.0 / arr.length);
    }

   public int[] getNumbersWithDigitsBiggerThanAverage(){

        int[] res = new int[this.vector.length];
        int counter = 0;

       for (int i = 0; i < this.vector.length; i++) {

           if(getNumberOfDigits(this.vector[i]) > getAverageNumberOfDigits(this.vector)){
               res[counter] = this.vector[i];
               counter++;
           }
       }
       return resizeArray(res, counter);
    }

    // 1 t
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

    public int percentagemAlgarismosParesVetor(){

        int soma = 0;

        for (int i = 0; i < this.vector.length; i++) {
            soma += percentagemAlgarismosPares(this.vector[i]);
        }

        return (int) Math.round(soma * 1.0 / this.vector.length);
    }

    public int[] getNumbersWithEvenDigitsBiggerThanPercentage(){

        int[] res = new int[this.vector.length];
        int counter = 0;

        for (int i = 0; i < this.vector.length; i++) {

            if(percentagemAlgarismosPares(this.vector[i]) > this.percentagemAlgarismosParesVetor()){
                res[counter] = this.vector[i];
                counter++;
            }
        }
        return resizeArray(res, counter);
    }

// 1 u
    public int[] getNumbersWithEvenDigits(){

        int[] res = new int[this.vector.length];
        int counter = 0;

        for (int i = 0; i < this.vector.length; i++) {

            if(percentagemAlgarismosPares(this.vector[i]) == 100){
            res[counter] = this.vector[i];
            counter++;
            }
        }
        return resizeArray(res, counter);
    }

    //1 v
    private boolean checkIfAscending(int num){

        int temp = num;

        if(num >= 0 && num <10){
            return false;
        }

        while(temp / 10 != 0){
            if(temp % 10 <= (temp / 10) % 10){
                return false;
            }
            temp /= 10;
        }


        return true;
    }

    public int[] getNumbersWithAscendingDigits(){

        int[] res = new int[this.vector.length];
        int counter = 0;

        for (int i = 0; i < this.vector.length; i++) {
            if(checkIfAscending(this.vector[i])){
                res[counter] = this.vector[i];
                counter++;
            }
        }

        return resizeArray(res, counter);
    }

    // 1 w
    private int invertNum(int num){

        int res = 0;
        while(num != 0) {

            int digit = num % 10;
            res = res * 10 + digit;

            num /= 10;
        }
        return res;
    }

    private boolean capicua(int num){

        if(getNumberOfDigits(num) == 1){
            return false;
        }

        return num == invertNum(num);
    }

    public int[] getCapicuas(){

        int[] res = new int[this.vector.length];
        int counter = 0;

        for (int i = 0; i < this.vector.length; i++) {
            if(capicua(this.vector[i])){
                res[counter] = this.vector[i];
                counter++;
            }
        }

        return resizeArray(res, counter);
    }

    //1x
    private boolean checkForSameDigits(int num){

        int temp = num;

        while(temp/10 != 0){
            if(temp % 10 != (temp / 10) % 10){
                return false;
            }
            temp /= 10;
        }
        return true;
    }

    public int[] getNumbersWithSameDigits(){

        int[] res = new int[this.vector.length];
        int counter = 0;

        for (int i = 0; i < this.vector.length; i++) {
            if(checkForSameDigits(this.vector[i])){
                res[counter] = this.vector[i];
                counter++;
            }
        }

        return resizeArray(res, counter);
    }

    //1 y
    private boolean checkIfArmstrongNumber (int num){

        int temp = num;
        int soma = 0;

        while (temp != 0){
            soma += Math.pow(temp % 10, getNumberOfDigits(num));
            temp /= 10;
        }
        if (num == soma){
            return true;
        }
        return false;
    }

    public int[] getNonArmstrongNumbersFromArr(){

        int[] res = new int[this.vector.length];
        int counter = 0;

        for (int i = 0; i < this.vector.length; i++) {
            if(!checkIfArmstrongNumber(this.vector[i])){
                res[counter] = this.vector[i];
                counter++;
            }
        }
        return resizeArray(res, counter);
    }

    // 1 z
    public int[] getNumbersOfNDigitsWithAscendingDigits(int numberDigits){

        int[] res = new int[this.vector.length];
        int counter = 0;

        for (int i = 0; i < this.vector.length; i++) {
            if(getNumberOfDigits(this.vector[i]) >= numberDigits) {
                if (checkIfAscending(this.vector[i])) {
                    res[counter] = this.vector[i];
                    counter++;
                }
            }
        }

        return resizeArray(res, counter);
    }

    //1 aa
    public boolean checkIfSameArr(int[] arr){

        if(this.vector.length != arr.length) { return false; }

        for (int i = 0; i < this.vector.length; i++) {
            if(this.vector[i] != arr[i]){
                return false;
            }
        }
        return true;
    }

    public int getSum() throws Exception {

        if(this.vector.length == 0){
            throw new Exception("Empty array");
        }
        int res = 0;
        for (int i = 0; i < this.vector.length; i++) {
            res += this.vector[i];
        }
        return res;
    }

    public int getValueAtIndexN(int num){
        int res = this.vector[num];
        return res;
    }
}
