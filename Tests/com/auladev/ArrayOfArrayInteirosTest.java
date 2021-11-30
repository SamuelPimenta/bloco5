package com.auladev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayOfArrayInteirosTest {

    @Test
    public void checkemptyArray(){
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros();
        int expected = 0;
        assertEquals(expected, x.getCopy().length);
    }

    @Test
    public void checkAddedValue() {
        ArrayInteiros[] test = new ArrayInteiros[3];
        test[0] = new ArrayInteiros(new int[]{1, 2, 3, 4});
        test[1] = new ArrayInteiros(new int[]{10, 85, 9});
        test[2] = new ArrayInteiros(new int[]{61, 100, 4, 10});
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        ArrayInteiros[] expected = new ArrayInteiros[3];
        expected[0] = new ArrayInteiros(new int[]{1, 2, 3, 4});
        expected[1] = new ArrayInteiros(new int[]{10, 85, 9, 50});
        expected[2] = new ArrayInteiros(new int[]{61, 100, 4, 10});
        x.addValue(50, 1);
        assertArrayEquals(expected, x.getCopy());
    }

    @Test
    public void checkAddedValueV2() {
        ArrayInteiros a = new ArrayInteiros(new int[]{1, 2, 3, 4});
        ArrayInteiros b = new ArrayInteiros(new int[]{10, 85, 9});
        ArrayInteiros c = new ArrayInteiros(new int[]{61, 100, 4, 10});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        x.addValue(50, 1);
        ArrayInteiros d = new ArrayInteiros(new int[]{10, 85, 9, 50});
        ArrayInteiros[] expected = {a, d, c};
        assertArrayEquals(expected, x.getCopy());
    }

    @Test
    public void checkRemovedValue() {
        ArrayInteiros a = new ArrayInteiros(new int[]{1, 2, 3, 4});
        ArrayInteiros b = new ArrayInteiros(new int[]{10, 85, 9});
        ArrayInteiros c = new ArrayInteiros(new int[]{61, 100, 4, 10});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        x.removeFirstValueN(61);
        ArrayInteiros d = new ArrayInteiros(new int[]{100, 4, 10});
        ArrayInteiros[] expected = {a, b, d};
        assertArrayEquals(expected, x.getCopy());
    }

    @Test
    public void checkRemovedValueNonExistent() {
        ArrayInteiros a = new ArrayInteiros(new int[]{1, 2, 3, 4});
        ArrayInteiros b = new ArrayInteiros(new int[]{10, 85, 9});
        ArrayInteiros c = new ArrayInteiros(new int[]{61, 100, 4, 10});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        x.removeFirstValueN(2000);
        ArrayInteiros[] expected = {a, b, c};
        assertArrayEquals(expected, x.getCopy());
    }

    @Test
    public void checkIfEmptyTrue(){
        ArrayInteiros a = new ArrayInteiros(new int[]{});
        ArrayInteiros b = new ArrayInteiros(new int[]{});
        ArrayInteiros c = new ArrayInteiros(new int[]{});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        assertTrue(x.checkIfEmpty());
    }

    @Test
    public void checkIfEmptyFalse(){
        ArrayInteiros a = new ArrayInteiros(new int[]{});
        ArrayInteiros b = new ArrayInteiros(new int[]{});
        ArrayInteiros c = new ArrayInteiros(new int[]{0});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        assertFalse(x.checkIfEmpty());
    }

    @Test
    public void getBiggestNumber() throws Exception {
        ArrayInteiros a = new ArrayInteiros(new int[]{1, 2, 3, 4});
        ArrayInteiros b = new ArrayInteiros(new int[]{10, 85, 9});
        ArrayInteiros c = new ArrayInteiros(new int[]{61, 100, 4, 10});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        int expected = 100;
        assertEquals(expected, x.getBiggestNumber());
    }

    @Test
    public void getBiggestNumberFirst() throws Exception {
        ArrayInteiros a = new ArrayInteiros(new int[]{101, 2, 3, 4});
        ArrayInteiros b = new ArrayInteiros(new int[]{10, 85, 9});
        ArrayInteiros c = new ArrayInteiros(new int[]{61, 100, 4, 10});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        int expected = 101;
        assertEquals(expected, x.getBiggestNumber());
    }

    @Test
    public void getBiggestNumberEmpty() throws Exception{
        ArrayInteiros a = new ArrayInteiros(new int[]{});
        ArrayInteiros b = new ArrayInteiros(new int[]{});
        ArrayInteiros c = new ArrayInteiros(new int[]{});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        boolean excecao = false;
        try {
           x.getBiggestNumber();
        } catch (Exception e){
            excecao = true;
        }
        assertTrue(excecao);
    }
    @Test
    public void getSmallestNumber() throws Exception {
        ArrayInteiros a = new ArrayInteiros(new int[]{101, 2, 3, 4});
        ArrayInteiros b = new ArrayInteiros(new int[]{10, 85, 9});
        ArrayInteiros c = new ArrayInteiros(new int[]{61, 100, 4, 10});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        int expected = 2;
        assertEquals(expected, x.getSmallestNumber());
    }

    @Test
    public void getSmallestNumberEmpty() throws Exception{
        ArrayInteiros a = new ArrayInteiros(new int[]{});
        ArrayInteiros b = new ArrayInteiros(new int[]{});
        ArrayInteiros c = new ArrayInteiros(new int[]{});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        boolean excecao = false;
        try {
            x.getSmallestNumber();
        } catch (Exception e){
            excecao = true;
        }
        assertTrue(excecao);
    }

    @Test
    public void getAverage(){
        ArrayInteiros a = new ArrayInteiros(new int[]{1, 2, 3, 4, 5});
        ArrayInteiros b = new ArrayInteiros(new int[]{5, 10, 0});
        ArrayInteiros c = new ArrayInteiros(new int[]{4, 8, 0});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        int expected = 4;
        assertEquals(expected, x.getAverage());
    }

    @Test
    public void getArrayOfSums() throws Exception {
        ArrayInteiros a = new ArrayInteiros(new int[]{1, 2, 3, 4, 5});
        ArrayInteiros b = new ArrayInteiros(new int[]{5, 10, 0});
        ArrayInteiros c = new ArrayInteiros(new int[]{4, 8, 0});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        ArrayInteiros expected = new ArrayInteiros(new int[]{15, 15, 12});
        assertEquals(expected, x.getArrOfSums());
    }

    @Test
    public void getArrayOfSums1Empty() throws Exception {
        ArrayInteiros a = new ArrayInteiros(new int[]{1, 2, 3, 4, 5});
        ArrayInteiros b = new ArrayInteiros(new int[]{});
        ArrayInteiros c = new ArrayInteiros(new int[]{4, 8, 0});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        int[] expected = {15, 0, 12};
        boolean excecao = false;
        try {
            x.getSmallestNumber();
        } catch (Exception e){
            excecao = true;
        }
        assertTrue(excecao);
    }

    @Test
    public void getArrayOfSumsOfColumns()  {
        ArrayInteiros a = new ArrayInteiros(new int[]{1, 2, 3, 4, 5});
        ArrayInteiros b = new ArrayInteiros(new int[]{5, 10});
        ArrayInteiros c = new ArrayInteiros(new int[]{4, 8, 1});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        ArrayInteiros expected = new ArrayInteiros(new int[]{10, 20, 4, 4, 5});
        assertEquals(expected, x.getArrOfSumsOfColumns());
    }

    @Test
    public void getIndexOfRowWithBiggestSum() throws Exception {
        ArrayInteiros a = new ArrayInteiros(new int[]{1, 2, 3, 4, 5});
        ArrayInteiros b = new ArrayInteiros(new int[]{5, 11});
        ArrayInteiros c = new ArrayInteiros(new int[]{4, 8, 1});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        int expected = 1;
        assertEquals(expected, x.getIndexOfRowWithBiggestSum());
    }

    @Test
    public void checkIfSquareFalse() {
        ArrayInteiros a = new ArrayInteiros(new int[]{1, 2, 3, 4, 5});
        ArrayInteiros b = new ArrayInteiros(new int[]{5, 11});
        ArrayInteiros c = new ArrayInteiros(new int[]{4, 8, 1});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        assertFalse(x.checkIfSquare());
    }

    @Test
    public void checkIfSquareTrue() {
        ArrayInteiros a = new ArrayInteiros(new int[]{1, 2, 3});
        ArrayInteiros b = new ArrayInteiros(new int[]{5, 11, 16});
        ArrayInteiros c = new ArrayInteiros(new int[]{4, 8, 1});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        assertTrue(x.checkIfSquare());
    }

    @Test
    public void checkIfSymmetricTrue() {
        ArrayInteiros a = new ArrayInteiros(new int[]{2, 3, 6});
        ArrayInteiros b = new ArrayInteiros(new int[]{3, 4, 5});
        ArrayInteiros c = new ArrayInteiros(new int[]{6, 5, 9});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        assertTrue(x.checkIfSymmetric());
    }
    @Test
    public void checkIfSymmetricFalse() {
        ArrayInteiros a = new ArrayInteiros(new int[]{2, 3, 6});
        ArrayInteiros b = new ArrayInteiros(new int[]{3, 4, 10});
        ArrayInteiros c = new ArrayInteiros(new int[]{6, 5, 9});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        assertFalse(x.checkIfSymmetric());
    }

    @Test
    public void getNumberOfNon0ElementsInMainDiagonal() {
        ArrayInteiros a = new ArrayInteiros(new int[]{2, 3, 6});
        ArrayInteiros b = new ArrayInteiros(new int[]{3, 4, 10});
        ArrayInteiros c = new ArrayInteiros(new int[]{6, 5, 9});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        int expected = 3;
        assertEquals(expected, x.getNumberOfNon0ElementsInMainDiagonal());
    }

    @Test
    public void getNumberOfNon0ElementsInMainDiagonalNone() {
        ArrayInteiros a = new ArrayInteiros(new int[]{0, 3, 6});
        ArrayInteiros b = new ArrayInteiros(new int[]{3, 0, 10});
        ArrayInteiros c = new ArrayInteiros(new int[]{6, 5, 0});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        int expected = 0;
        assertEquals(expected, x.getNumberOfNon0ElementsInMainDiagonal());
    }

    @Test
    public void getNumberOfNon0ElementsInMainDiagonalIrregular() {
        ArrayInteiros a = new ArrayInteiros(new int[]{2, 3, 6});
        ArrayInteiros b = new ArrayInteiros(new int[]{3, 4, 10});
        ArrayInteiros c = new ArrayInteiros(new int[]{6, 5, 9});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        int expected = -1;
        assertEquals(expected, x.getNumberOfNon0ElementsInMainDiagonal());
    }

    @Test
    public void checkIfDiagonalsAreSame() {
        ArrayInteiros a = new ArrayInteiros(new int[]{2, 3, 2});
        ArrayInteiros b = new ArrayInteiros(new int[]{3, 4, 5});
        ArrayInteiros c = new ArrayInteiros(new int[]{6, 5, 6});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        assertTrue(x.checkIfDiagonalsAreSame());
    }

    @Test
    public void checkIfDiagonalsAreSameFalse() {
        ArrayInteiros a = new ArrayInteiros(new int[]{2, 3, 2});
        ArrayInteiros b = new ArrayInteiros(new int[]{3, 4, 5});
        ArrayInteiros c = new ArrayInteiros(new int[]{6, 5, 7});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        assertFalse(x.checkIfDiagonalsAreSame());
    }

    @Test
    public void getNumberWithDigitsBiggerThanAverage() {
        ArrayInteiros a = new ArrayInteiros(new int[]{34, 3, 2});
        ArrayInteiros b = new ArrayInteiros(new int[]{3, 4, 5});
        ArrayInteiros c = new ArrayInteiros(new int[]{6, 5, 17});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        ArrayInteiros expected = new ArrayInteiros((new int[]{34, 17}));
        assertEquals(expected, x.getNumberWithDigitsBiggerThanAverage());
    }

    @Test
    public void getNumbersWithEvenDigitsBiggerThanAverage() {
        ArrayInteiros a = new ArrayInteiros(new int[]{766, 5, 1});
        ArrayInteiros b = new ArrayInteiros(new int[]{3, 5, 5});
        ArrayInteiros c = new ArrayInteiros(new int[]{5, 5, 22});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        ArrayInteiros expected = new ArrayInteiros((new int[]{766, 22}));
        assertEquals(expected, x.getNumberWithEvenDigitsBiggerThanAverage());
    }

    @Test
    public void invertRows() {
        ArrayInteiros a = new ArrayInteiros(new int[]{76, 5, 1});
        ArrayInteiros b = new ArrayInteiros(new int[]{3, 54, 5});
        ArrayInteiros c = new ArrayInteiros(new int[]{5, 5, 22});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        x.invertRows();
        ArrayInteiros d = new ArrayInteiros(new int[]{1, 5, 76});
        ArrayInteiros e = new ArrayInteiros(new int[]{5, 54, 3});
        ArrayInteiros f = new ArrayInteiros(new int[]{22, 5, 5});
        ArrayInteiros[] expected = {d, e, f};
        assertArrayEquals(expected, x.getCopy());
    }

    @Test
    public void invertColumns() {
        ArrayInteiros a = new ArrayInteiros(new int[]{76, 5, 1});
        ArrayInteiros b = new ArrayInteiros(new int[]{3, 54, 5});
        ArrayInteiros c = new ArrayInteiros(new int[]{5, 5, 22});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        x.invertColumns();
        ArrayInteiros d = new ArrayInteiros(new int[]{5, 5, 22});
        ArrayInteiros e = new ArrayInteiros(new int[]{3, 54, 5});
        ArrayInteiros f = new ArrayInteiros(new int[]{76, 5, 1});
        ArrayInteiros[] expected = {d, e, f};
        assertArrayEquals(expected, x.getCopy());
    }

    @Test
    public void turn90Degrees() {
        ArrayInteiros a = new ArrayInteiros(new int[]{76, 5, 1});
        ArrayInteiros b = new ArrayInteiros(new int[]{3, 54, 5});
        ArrayInteiros c = new ArrayInteiros(new int[]{5, 5, 22});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        x.turn90degrees();
        ArrayInteiros d = new ArrayInteiros(new int[]{5, 3, 76});
        ArrayInteiros e = new ArrayInteiros(new int[]{5, 54, 5});
        ArrayInteiros f = new ArrayInteiros(new int[]{22, 5, 1});
        ArrayInteiros[] expected = {d, e, f};
        assertArrayEquals(expected, x.getCopy());
    }

    @Test
    public void turn180Degrees() {
        ArrayInteiros a = new ArrayInteiros(new int[]{76, 5, 1});
        ArrayInteiros b = new ArrayInteiros(new int[]{3, 54, 5});
        ArrayInteiros c = new ArrayInteiros(new int[]{5, 5, 22});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        x.turn180degrees();
        ArrayInteiros d = new ArrayInteiros(new int[]{22, 5, 5});
        ArrayInteiros e = new ArrayInteiros(new int[]{5, 54, 3});
        ArrayInteiros f = new ArrayInteiros(new int[]{1, 5, 76});
        ArrayInteiros[] expected = {d, e, f};
        assertArrayEquals(expected, x.getCopy());
    }

    @Test
    public void turnMinus90Degrees() {
        ArrayInteiros a = new ArrayInteiros(new int[]{76, 5, 1});
        ArrayInteiros b = new ArrayInteiros(new int[]{3, 54, 5});
        ArrayInteiros c = new ArrayInteiros(new int[]{5, 5, 22});
        ArrayInteiros[] test = {a, b, c};
        ArrayOfArrayInteiros x = new ArrayOfArrayInteiros(test);
        x.turnMinus90degrees();
        ArrayInteiros d = new ArrayInteiros(new int[]{1, 5, 22});
        ArrayInteiros e = new ArrayInteiros(new int[]{5, 54, 5});
        ArrayInteiros f = new ArrayInteiros(new int[]{76, 3, 5});
        ArrayInteiros[] expected = {d, e, f};
        assertArrayEquals(expected, x.getCopy());
    }
}