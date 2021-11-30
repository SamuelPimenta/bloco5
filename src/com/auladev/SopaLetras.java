package com.auladev;

import java.util.Random;

public class SopaLetras {

    private char[][] tabuleiro;
    String[] palavras;

    public SopaLetras(int n){
        this.tabuleiro = new char[n][n];
    }

    public char[][] copyFrom(char[][] from){
        char[][] to = new char[from.length][];

        for (int i = 0; i < from.length; i++) {
            to[i] = new char[from[i].length];
            for (int j = 0; j < from[i].length; j++) {
                to[i][j] = from[i][j];
            }
        }
        return to;
    }

    public char[][] getCopy() {return copyFrom(this.tabuleiro);}

    private char getRandomLetter(){

        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        return c;
    }

    public void fillSopa(){

        for (int i = 0; i < this.tabuleiro.length; i++) {
            for (int j = 0; j < this.tabuleiro[i].length; j++) {
                this.tabuleiro[i][j] = getRandomLetter();
            }
        }
    }

    private char[] wordToArr(String a){return a.toCharArray();}

    private boolean checkIfInBounds(int[] start){
        if(start[0] < 0 || start[0] > this.tabuleiro.length){
            return false;
        }
        if(start[1] < 0 || start[1] > this.tabuleiro.length){
            return false;
        }
        return true;
    }
    public boolean placeWordHorizontal(String word, int[] start) {
        if (!checkIfInBounds(start)){return false;}

        char[] temp = wordToArr(word);
        if (temp.length + start[1] <= this.tabuleiro[start[0]].length) {
            for (int i = 0; i < temp.length; i++) {
                if(this.tabuleiro[start[0]][start[1] + i] == 0 || this.tabuleiro[start[0]][start[1] + i] == temp[i]) {
                    this.tabuleiro[start[0]][start[1] + i] = temp[i];
                }
            }
            return true;
        }else{
            return false;
        }
    }

    private char[] reverseCharArr(char[] from){
        char[] to = new char[from.length];
        for (int i = 0; i < from.length; i++) {
            to[i] = from[from.length -1 -i];
        }
        return to;
    }

    public boolean placeWordHorizontalReverse(String word, int[] start) {
        char[] temp = wordToArr(word);
    }

    public boolean placeWordVertical(String word, int[] start){
        if (!checkIfInBounds(start)){return false;}

        char[] temp = wordToArr(word);
        if (temp.length + start[0] <= this.tabuleiro.length){
            for (int i = 0; i < temp.length; i++) {
                if(this.tabuleiro[start[0] + i][start[1]] == 0 || this.tabuleiro[start[0] + i][start[1]] == temp[i]) {
                    this.tabuleiro[start[0] + i][start[1]] = temp[i];
                }
            }
            return true;
        }else{
            return false;
        }
    }
}

