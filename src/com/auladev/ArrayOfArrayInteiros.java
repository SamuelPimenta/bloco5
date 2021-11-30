package com.auladev;

import java.util.Arrays;

public class ArrayOfArrayInteiros {

   private ArrayInteiros[] arrOfArrI;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayOfArrayInteiros that = (ArrayOfArrayInteiros) o;
        return Arrays.equals(arrOfArrI, that.arrOfArrI);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arrOfArrI);
    }

    //3a
    public ArrayOfArrayInteiros(){
        this.arrOfArrI = new ArrayInteiros[0];
    }

    //3b
    /*public ArrayOfArrayInteiros (ArrayInteiros[] arr) {
        this.arrOfArrI = new ArrayInteiros[arr.length];
        for (int i = 0; i < arr.length; i++) {
            this.arrOfArrI[i] = new ArrayInteiros(arr[i].getValues());
        }

        public ArrayInteiros[] getValuesOfMat() {
        ArrayInteiros[] newMat = new ArrayInteiros[this.arrOfArrI.length];
        for (int i = 0; i < newMat.length; i++) {
            newMat[i] = new ArrayInteiros(this.arrOfArrI[i].getValues());
        }
        return newMat;
    }
    }*/
    public ArrayOfArrayInteiros(ArrayInteiros[] valores){
        this.arrOfArrI = copyFrom(valores);
    }

    private ArrayInteiros[] copyFrom(ArrayInteiros[] from){
        ArrayInteiros[] to = new ArrayInteiros[from.length];
        for (int i = 0; i < from.length; i++) {
            to[i] = new ArrayInteiros(from[i].getValues());
        }
        return to;
    }

    public ArrayInteiros[] getCopy(){
        return copyFrom(this.arrOfArrI);
    }

    //3c
    public void addValue(int num, int line){
        this.arrOfArrI[line].addValue(num);
    }

    //3d
    public void removeFirstValueN(int num){


        for (int i = 0; i < this.arrOfArrI.length; i++) {
            if(this.arrOfArrI[i].checkForNumInArr(num)) {
               this.arrOfArrI[i].takeFirstIntGiven(num);
                break;
            }
        }
    }

    //3e
    public boolean checkIfEmpty(){
        for (int i = 0; i < this.arrOfArrI.length; i++) {
            if(!this.arrOfArrI[i].checkIfEmpty()){
                return false;
            }
        }
        return true;
    }

    //3f
    public int getBiggestNumber() throws Exception {

        if(checkIfEmpty()){
            throw new Exception("Empty array");
        }

        int res = this.arrOfArrI[0].biggestNumber();
        for (int i = 1; i < this.arrOfArrI.length; i++) {
            if(this.arrOfArrI[i].biggestNumber() > res){
                res = this.arrOfArrI[i].biggestNumber();
            }
        }
        return res;
    }

    //3g
    public int getSmallestNumber() throws Exception {

        if(checkIfEmpty()){
            throw new Exception("Empty array");
        }

        int res = this.arrOfArrI[0].smallestNumber();
        for (int i = 1; i < this.arrOfArrI.length; i++) {
            if(this.arrOfArrI[i].smallestNumber() < res){
                res = this.arrOfArrI[i].smallestNumber();
            }
        }
        return res;
    }

    //3h
    public int getAverage(){
        int sum = 0;
        for (int i = 0; i < this.arrOfArrI.length; i++) {
            sum += this.arrOfArrI[i].getAverage();
        }
        return sum / this.arrOfArrI.length;
    }

    //3i
    public ArrayInteiros getArrOfSums() throws Exception {

        int[] res = new int[this.arrOfArrI.length];

        for (int i = 0; i < this.arrOfArrI.length; i++) {
          res[i] = this.arrOfArrI[i].getSum();
        }
        return new ArrayInteiros(res);
    }

    //3j
    private int getLengthOfBiggestRow(){
        int res = 0;
        for (int i = 0; i < this.arrOfArrI.length; i++) {
            if(this.arrOfArrI[i].numberOfElements() > res){
                res = this.arrOfArrI[i].numberOfElements();
            }
        }
        return res;
    }
    public ArrayInteiros getArrOfSumsOfColumns(){
        int[] res = new int[this.getLengthOfBiggestRow()];

        for (int i = 0; i < this.arrOfArrI.length; i++) {
            for (int j = 0; j < this.arrOfArrI[i].numberOfElements(); j++) {
                res[j] += this.arrOfArrI[i].getValueAtIndexN(j);
            }
        }
        return new ArrayInteiros(res);
    }

    //3k
    public int getIndexOfRowWithBiggestSum() throws Exception {
        ArrayInteiros tempArr = this.getArrOfSums();
        int tempNum = tempArr.getValueAtIndexN(0);
        int res = 0;
        for (int i = 1; i < tempArr.numberOfElements(); i++) {
            if(tempArr.getValueAtIndexN(i) > tempNum){
                tempNum = tempArr.getValueAtIndexN(i);
                res = i;
            }
        }
        return res;
    }

    //3l
    public boolean checkIfSquare(){
        if(this.arrOfArrI.length == 0){
            return false;
        }
        for (int i = 0; i < this.arrOfArrI.length; i++) {
            if(this.arrOfArrI[i].numberOfElements() != this.arrOfArrI.length){
                return false;
            }
        }
        return true;
    }

    //3m
    private ArrayInteiros getColumn(int column){
        int[] res = new int[this.arrOfArrI.length];

        for (int i = 0; i < this.arrOfArrI.length; i++) {
            res[i] = this.arrOfArrI[i].getValueAtIndexN(column);
        }

        return new ArrayInteiros(res);
    }

    public boolean checkIfSymmetric(){
        if(!checkIfSquare()){
            return false;
        }


        for (int i = 0; i < this.arrOfArrI.length; i++) {
            ArrayInteiros temp = this.getColumn(i);
            for (int j = 0; j < this.arrOfArrI[i].numberOfElements(); j++) {
                if (this.arrOfArrI[i].getValueAtIndexN(j) != temp.getValueAtIndexN(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    //3n
    public int getNumberOfNon0ElementsInMainDiagonal(){
        if(!checkIfSquare()){
            return -1;
        }

        int res = 0;

        for (int i = 0; i < this.arrOfArrI.length; i++) {
            if(this.arrOfArrI[i].getValueAtIndexN(i) != 0){
                 res++;
            }
        }
        return res;
    }

    //3o
    public boolean checkIfDiagonalsAreSame(){

        for (int i = 0; i < this.arrOfArrI.length; i++) {
            if(this.arrOfArrI[i].getValueAtIndexN(i) != this.arrOfArrI[i].getValueAtIndexN(this.arrOfArrI[i].numberOfElements() - 1 -i)){
                return false;
            }
        }
        return true;
    }

    //3p

    private int getNumberOfDigits(int number){

        int algarismos = 0;
        int temp = number;

        while(temp != 0){
            temp/= 10;
            algarismos++;
        }
        return algarismos;
    }

    private int getNumberOfElements(){
        int res = 0;
        for (int i = 0; i < this.arrOfArrI.length; i++) {
            res += this.arrOfArrI[i].numberOfElements();
        }
        return res;
    }

    private int getAverageNumberOfDigits(){
        int sum = 0;

        for (int i = 0; i < this.arrOfArrI.length; i++) {
            for (int j = 0; j < this.arrOfArrI[i].numberOfElements(); j++) {
                sum += getNumberOfDigits(this.arrOfArrI[i].getValueAtIndexN(j));
            }
        }
        return sum / this.getNumberOfElements();
    }

    public ArrayInteiros getNumberWithDigitsBiggerThanAverage(){

        ArrayInteiros res = new ArrayInteiros();

        for (int i = 0; i < this.arrOfArrI.length; i++) {
            for (int j = 0; j < this.arrOfArrI[i].numberOfElements(); j++) {
                if(getNumberOfDigits(this.arrOfArrI[i].getValueAtIndexN(j)) > this.getAverageNumberOfDigits()){
                    res.addValue(this.arrOfArrI[i].getValueAtIndexN(j));
                }
            }
        }
        return res;
    }

    //3q
    private int percentagemAlgarismosParesMatriz(){
        int soma = 0;

        for (int i = 0; i < this.arrOfArrI.length; i++) {
            soma += this.arrOfArrI[i].percentagemAlgarismosParesVetor();
        }
        return soma / this.arrOfArrI.length;
    }

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

    public ArrayInteiros getNumberWithEvenDigitsBiggerThanAverage(){
        ArrayInteiros res = new ArrayInteiros();

        for (int i = 0; i < this.arrOfArrI.length; i++) {
            for (int j = 0; j < this.arrOfArrI[i].numberOfElements(); j++) {
                if(percentagemAlgarismosPares(this.arrOfArrI[i].getValueAtIndexN(j)) > this.percentagemAlgarismosParesMatriz()){
                    res.addValue(this.arrOfArrI[i].getValueAtIndexN(j));
                }
            }
        }
        return res;
    }

    //3r
    public void invertRows(){
        for (int i = 0; i < this.arrOfArrI.length; i++) {
            ArrayInteiros temp = new ArrayInteiros();
            for (int j = this.arrOfArrI[i].numberOfElements() - 1; j >= 0; j--) {
                temp.addValue(this.arrOfArrI[i].getValueAtIndexN(j));
            }
            this.arrOfArrI[i] = temp;
        }
    }

    //3s
    public void invertColumns(){

        for (int i = 0; i < this.arrOfArrI.length / 2; i++) {
            int[] temp = arrOfArrI[i].getValues();
            this.arrOfArrI[i] = this.arrOfArrI[this.arrOfArrI.length -1 -i];
            this.arrOfArrI[this.arrOfArrI.length -1 -i] = new ArrayInteiros(temp);
        }
    }

    //3t
    public void turn90degrees(){
        ArrayInteiros [] res = copyFrom(this.arrOfArrI);

        for (int i = 0; i < this.arrOfArrI.length; i++) {
            int[] temp = new int[this.arrOfArrI[i].numberOfElements()];
            for (int j = 0; j < this.arrOfArrI[i].numberOfElements(); j++) {
                temp[j] = this.arrOfArrI[this.arrOfArrI.length - 1 - j].getValueAtIndexN(i);
            }
            res[i] = new ArrayInteiros(temp);
        }
        this.arrOfArrI = res;
    }

    public void turn180degrees(){
        ArrayInteiros [] res = copyFrom(this.arrOfArrI);

        for (int i = 0; i < this.arrOfArrI.length; i++) {
            int[] temp = new int[this.arrOfArrI[i].numberOfElements()];
            for (int j = 0; j < this.arrOfArrI[i].numberOfElements(); j++) {
                temp[j] = this.arrOfArrI[this.arrOfArrI.length - 1 - i].getValueAtIndexN(this.arrOfArrI.length - 1 - j);
            }
            res[i] = new ArrayInteiros(temp);
        }
        this.arrOfArrI = res;
    }

    public void turnMinus90degrees(){
        ArrayInteiros [] res = copyFrom(this.arrOfArrI);

        for (int i = 0; i < this.arrOfArrI.length; i++) {
            int[] temp = new int[this.arrOfArrI[i].numberOfElements()];
            for (int j = 0; j < this.arrOfArrI[i].numberOfElements(); j++) {
                temp[j] = this.arrOfArrI[j].getValueAtIndexN(this.arrOfArrI.length - 1 - i);
            }
            res[i] = new ArrayInteiros(temp);
        }
        this.arrOfArrI = res;
    }
}
