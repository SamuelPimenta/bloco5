package com.auladev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrizInteirosTest {

    @Test
    public void checkEmptyCondition(){
        MatrizInteiros x = new MatrizInteiros();
        int expected = 0;
        int[][] values = x.getValues();
        assertEquals(expected, values.length);
    }

    @Test
    public void checkAddedNumber(){
        int[][] test = {{1, 5}, {6}, {1, 2, 3, 4}};
        MatrizInteiros y = new MatrizInteiros(test);
        y.addNumber(4, 1);
        int[][] expected = {{1, 5}, {6, 4}, {1, 2, 3, 4}};
        int[][] result = y.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkAddedNumberEmpty(){
        int[][] test = {{}, {6}, {1, 2, 3, 4}};
        MatrizInteiros y = new MatrizInteiros(test);
        y.addNumber(4, 0);
        int[][] expected = {{4}, {6}, {1, 2, 3, 4}};
        int[][] result = y.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkAddedNumberV2(){
        int[][] test = {{1, 5}, {6}, {1, 2, 3, 4}};
        MatrizInteiros y = new MatrizInteiros(test);
        y.addNumberV2(4, 1);
        int[][] expected = {{1, 5}, {6, 4}, {1, 2, 3, 4}};
        int[][] result = y.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkAddedNumberV2Empty(){
        int[][] test = {{}, {6}, {1, 2, 3, 4}};
        MatrizInteiros y = new MatrizInteiros(test);
        y.addNumberV2(4, 0);
        int[][] expected = {{4}, {6}, {1, 2, 3, 4}};
        int[][] result = y.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkRemovedNumber(){
        int[][] test = {{2, 5}, {6}, {1, 2, 3, 4}};
        MatrizInteiros y = new MatrizInteiros(test);
        y.takeFirstNumberNFromMatrix(1);
        int[][] expected = {{2, 5}, {6}, {2, 3, 4}};
        int[][] result = y.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkRemovedNumberV2(){
        int[][] test = {{2, 5}, {6}, {1, 2, 3, 4}};
        MatrizInteiros y = new MatrizInteiros(test);
        y.takeFirstNumberNV2(1);
        int[][] expected = {{2, 5}, {6}, {2, 3, 4}};
        int[][] result = y.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkRemovedNumberNonExistantV2(){
        int[][] test = {{2, 5}, {6}, {1, 2, 3, 4}};
        MatrizInteiros y = new MatrizInteiros(test);
        y.takeFirstNumberNV2(98);
        int[][] expected = {{2, 5}, {6}, {1, 2, 3, 4}};
        int[][] result = y.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkRemovedNumberNonExistant(){
        int[][] test = {{2, 5}, {6}, {1, 2, 3, 4}};
        MatrizInteiros y = new MatrizInteiros(test);
        y.takeFirstNumberNFromMatrix(98);
        int[][] expected = {{2, 5}, {6}, {1, 2, 3, 4}};
        int[][] result = y.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkIfMatrixIsEmptyTrue(){
        int[][] test = {};
        MatrizInteiros x = new MatrizInteiros(test);
        boolean result = x.checkIfEmpty();
        assertTrue(result);
    }

    @Test
    public void checkIfMatrixIsEmptyTrueV2(){
        MatrizInteiros x = new MatrizInteiros();
        boolean result = x.checkIfEmpty();
        assertTrue(result);
    }

    @Test
    public void checkIfMatrixIsEmptyFalse(){
        int[][] test = {{0}};
        MatrizInteiros x = new MatrizInteiros(test);
        boolean result = x.checkIfEmpty();
        assertFalse(result);
    }

    @Test
    public void getBiggestNumber(){
        int[][] test = {{2, 5}, {88, 3}, {1, 2, 3, 4}};
        MatrizInteiros x = new MatrizInteiros(test);
        int expected = 88;
        int result = x.getBiggestNumber();
        assertEquals(expected, result);
    }

    @Test
    public void getSmallestNumber(){
        int[][] test = {{2, -5}, {88, 3}, {1, 2, 3, 4}};
        MatrizInteiros x = new MatrizInteiros(test);
        int expected = -5;
        int result = x.getSmallestNumber();
        assertEquals(expected, result);
    }

    @Test
    public void getMatrixAverage(){
        int[][] test = {{2, -5}, {88, 3}, {1, 2, 3, 4}};
        MatrizInteiros x = new MatrizInteiros(test);
        int expected = 12;
        int result = x.getMatrixAverage();
        assertEquals(expected, result);
    }

    @Test
    public void getSumOfEachRow(){
        int[][] test = {{2, -5}, {88, 3}, {1, 2, 3, 4}};
        MatrizInteiros x = new MatrizInteiros(test);
        int[] expected = {-3, 91, 10};
        int[] result = x.getSumOfEachRow();
        assertArrayEquals(expected, result);
    }

    @Test
    public void getIndexOfRowWithLargestSum(){
        int[][] test = {{2, -5}, {88, 3}, {1, 2, 3, 4}};
        MatrizInteiros x = new MatrizInteiros(test);
        int expected = 1;
        int result = x.getIndexRowWithLargestSum();
        assertEquals(expected, result);
    }

    @Test
    public void getSumOfEachColumn(){
        int[][] test = {{2, -5}, {88, 3, 5}, {1, 2, 3, 4}};
        MatrizInteiros x = new MatrizInteiros(test);
        int[] expected = {91, 0, 8, 4};
        int[] result = x.getSumOfEachColumn();
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkIfMatrixIsSquareFalse(){
        int[][] test = {{2, -5}, {88, 3, 5}, {1, 2, 3, 4}};
        MatrizInteiros x = new MatrizInteiros(test);
        boolean result = x.checkForSquareMatrix();
        assertFalse(result);
    }

    @Test
    public void checkIfMatrixIsSquareTrue(){
        int[][] test = {{2, -5, 98}, {88, 3, 5}, {1, 2, 3}};
        MatrizInteiros x = new MatrizInteiros(test);
        boolean result = x.checkForSquareMatrix();
        assertTrue(result);
    }

    @Test
    public void checkIfMatrixIsSquareEmpty(){
        int[][] test = {};
        MatrizInteiros x = new MatrizInteiros(test);
        boolean result = x.checkForSquareMatrix();
        assertFalse(result);
    }

    @Test
    public void checkIfMatrixIsSymmetricTrue(){
        int[][] test = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        MatrizInteiros x = new MatrizInteiros(test);
        boolean result = x.checkForSymmetricMatrix();
        assertTrue(result);
    }

    @Test
    public void checkIfMatrixIsSymmetricFalse(){
        int[][] test = {{1, 1, 3}, {1, 1, 1}, {1, 1, 1}};
        MatrizInteiros x = new MatrizInteiros(test);
        boolean result = x.checkForSymmetricMatrix();
        assertFalse(result);
    }

    @Test
    public void getNumberOfNonNullElementsInDiagonal2(){
        int[][] test = {{1, 4, 3}, {1, 0, 1}, {1, 1, 1}};
        MatrizInteiros x = new MatrizInteiros(test);
        int expected = 2;
        int result = x.nonNullElementsInDiagonal();
        assertEquals(expected, result);
    }

    @Test
    public void getNumberOfNonNullElementsInDiagonal0(){
        int[][] test = {{0, 4, 3}, {1, 0, 1}, {1, 1, 0}};
        MatrizInteiros x = new MatrizInteiros(test);
        int expected = 0;
        int result = x.nonNullElementsInDiagonal();
        assertEquals(expected, result);
    }

    @Test
    public void getNumberOfNonNullElementsInDiagonalNonSquare(){
        int[][] test = {{0, 4, 3}, {1, 0, 1}, {1, 1, 0, 6}};
        MatrizInteiros x = new MatrizInteiros(test);
        int expected = -1;
        int result = x.nonNullElementsInDiagonal();
        assertEquals(expected, result);
    }

    @Test
    public void checkIfDiagonalsAreEqualTrue(){
        int[][] test = {{1, 4, 1}, {5, 1, 9}, {8, 10, 8}};
        MatrizInteiros x = new MatrizInteiros(test);
        boolean result = x.checkIfDiagonalsAreEqual();
        assertTrue(result);
    }

    @Test
    public void checkIfDiagonalsAreEqualFalse(){
        int[][] test = {{1, 4, 1}, {5, 1, 9}, {8, 10, 1}};
        MatrizInteiros x = new MatrizInteiros(test);
        boolean result = x.checkIfDiagonalsAreEqual();
        assertFalse(result);
    }

    @Test
    public void getArrayFromMatrixDigitsBiggerThanAverageOne(){
        int[][] test = {{1, 4, 1}, {5, 1, 9}, {8, 10, 1}};
        MatrizInteiros x = new MatrizInteiros(test);
        int[] expected = {10};
        int[] result = x.getElementsWithNumberOfDigitsBiggerThanAverage();
        assertArrayEquals(expected, result);
    }

    @Test
    public void getArrayFromMatrixDigitsBiggerThanAverageNone(){
        int[][] test = {{1, 4, 1}, {5, 1, 9}, {8, 1, 1}};
        MatrizInteiros x = new MatrizInteiros(test);
        int[] expected = {};
        int[] result = x.getElementsWithNumberOfDigitsBiggerThanAverage();
        assertArrayEquals(expected, result);
    }
    @Test
    public void getArrayFromMatrixDigitsBiggerThanAverageAllButOne(){
        int[][] test = {{1, 47, 14}, {58, 10, 94}, {88, 12, 17}};
        MatrizInteiros x = new MatrizInteiros(test);
        int[] expected = {47, 14, 58, 10, 94, 88, 12, 17};
        int[] result = x.getElementsWithNumberOfDigitsBiggerThanAverage();
        assertArrayEquals(expected, result);
    }

    @Test
    public void getArrayFromMatrixEvenDigitsBiggerThanAverageOne(){
        int[][] test = {{1, 9, 1}, {5, 1, 9}, {8, 19, 1}};
        MatrizInteiros x = new MatrizInteiros(test);
        int[] expected = {8};
        int[] result = x.getElementsWithPercentageOfEvenDigitsBiggerThanAverage();
        assertArrayEquals(expected, result);
    }

    @Test
    public void getArrayFromMatrixEvenDigitsBiggerThanAverageNone(){
        int[][] test = {{1, 9, 1}, {5, 1, 9}, {71, 19, 1}};
        MatrizInteiros x = new MatrizInteiros(test);
        int[] expected = {};
        int[] result = x.getElementsWithPercentageOfEvenDigitsBiggerThanAverage();
        assertArrayEquals(expected, result);
    }
    @Test
    public void getArrayFromMatrixEvenDigitsBiggerThanAverageAllButOne(){
        int[][] test = {{1, 10, 28}, {46, 8, 20}, {22, 44, 88}};
        MatrizInteiros x = new MatrizInteiros(test);
        int[] expected = {28, 46, 8, 20, 22, 44, 88};
        int[] result = x.getElementsWithPercentageOfEvenDigitsBiggerThanAverage();
        assertArrayEquals(expected, result);
    }

    @Test
    public void reverseRows(){
        int[][] test = {{1, 10, 28}, {46, 8, 20}, {22, 44, 88}};
        MatrizInteiros x = new MatrizInteiros(test);
        x.reverseRows();
        int[][] expected = {{28, 10, 1}, {20, 8, 46}, {88, 44, 22}};
        int[][] result = x.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void reverseColumns(){
        int[][] test = {{1, 10, 28, 7}, {46, 8, 20}, {22, 44, 88}};
        MatrizInteiros x = new MatrizInteiros(test);
        x.reverseColumnsV2();
        int[][] expected = {{22, 44, 88}, {46, 8, 20}, {1, 10, 28, 7}};
        int[][] result = x.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void turn90Degrees(){
        int[][] test = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MatrizInteiros x = new MatrizInteiros(test);
        x.turn90Degrees();
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        int[][] result = x.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void turn180Degrees(){
        int[][] test = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MatrizInteiros x = new MatrizInteiros(test);
        x.turn180Degrees();
        int[][] expected = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        int[][] result = x.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void turnMinus90Degrees(){
        int[][] test = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MatrizInteiros x = new MatrizInteiros(test);
        x.turnMinus90Degrees();
        int[][] expected = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        int[][] result = x.getValues();
        assertArrayEquals(expected, result);
    }
}