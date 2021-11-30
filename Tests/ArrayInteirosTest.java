import com.auladev.ArrayInteiros;
import com.auladev.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayInteirosTest {

    @Test
    public void checkEmptyCondition(){
        ArrayInteiros x = new ArrayInteiros();
        int expected = 0;
        int[] values = x.getValues();
        assertEquals(expected, values.length);
    }

    @Test
    public void checkAddedNumber(){
        int[] test = {1, 2, 3, 4, 5};
        ArrayInteiros x = new ArrayInteiros(test);
        x.addValue(6);
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] result = x.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkForNumber(){
        int[] test = {1, 2, 3, 4, 5};
        ArrayInteiros y = new ArrayInteiros(test);
        boolean result = y.checkForNumInArr(3);
        assertTrue(result);
    }

    @Test
    public void checkForNumberFalse(){
        int[] test = {1, 2, 3, 4, 5};
        ArrayInteiros y = new ArrayInteiros(test);
        boolean result = y.checkForNumInArr(6);
        assertFalse(result);
    }

    @Test
    public void checkForNumberFalseEmpty(){
        ArrayInteiros y = new ArrayInteiros();
        boolean result = y.checkForNumInArr(6);
        assertFalse(result);
    }

    @Test
    public void checkRemoveNumber(){
        int[] test = {1, 2, 3, 4, 5};
        ArrayInteiros y = new ArrayInteiros(test);
        y.takeFirstIntGiven(4);
        int[] expected = {1, 2, 3, 5};
        int[] result = y.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkRemoveNumber2(){
        int[] test = {1, 2, 3, 4, 4, 5};
        ArrayInteiros y = new ArrayInteiros(test);
        y.takeFirstIntGiven(4);
        int[] expected = {1, 2, 3, 4, 5};
        int[] result = y.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkRemoveNumberNonExistent(){
        int[] test = {1, 2, 3, 5};
        ArrayInteiros y = new ArrayInteiros(test);
        y.takeFirstIntGiven(4);
        int[] expected = {1, 2, 3, 5};
        int[] result = y.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkNumberInIndex(){
        int[] test = {1, 2, 3, 4, 5};
        ArrayInteiros y = new ArrayInteiros(test);
        int expected = 2;
        int result = y.valueFromIndex(1);
        assertEquals(expected, result);
    }

    @Test
    public void checkNumberOfElements(){
        int[] test = {1, 2, 3, 4, 5};
        ArrayInteiros y = new ArrayInteiros(test);
        int expected = 5;
        int result = y.numberOfElements();
        assertEquals(expected, result);
    }

    @Test
    public void getBiggestNumber(){
        int[] test = {1, 2, 3, 4, 5};
        ArrayInteiros y = new ArrayInteiros(test);
        int expected = 5;
        int result = y.biggestNumber();
        assertEquals(expected, result);
    }

    @Test
    public void getSmallestNumber(){
        int[] test = {1, 2, 3, 4, 5, 0};
        ArrayInteiros y = new ArrayInteiros(test);
        int expected = 0;
        int result = y.smallestNumber();
        assertEquals(expected, result);
    }

    @Test
    public void getAverage(){
        int[] test = {1, 2, 3, 4, 5};
        ArrayInteiros y = new ArrayInteiros(test);
        double expected = 3;
        double result = y.getAverage();
        assertEquals(expected, result);
    }

    @Test
    public void getEvenAverage(){
        int[] test = {1, 2, 3, 4, 5, 6};
        ArrayInteiros y = new ArrayInteiros(test);
        double expected = 4;
        double result = y.getEvenAverage();
        assertEquals(expected, result);
    }

    @Test
    public void getOddAverage(){
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayInteiros y = new ArrayInteiros(test);
        double expected = 5;
        double result = y.getOddAverage();
        assertEquals(expected, result);
    }

    @Test
    public void getMultiplesAverage(){
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayInteiros y = new ArrayInteiros(test);
        double expected = 6;
        double result = y.getMultiplesAverage(3);
        assertEquals(expected, result);
    }

    @Test
    public void sorAscending() {
        int[] test = {5, 2, 4, 3, 1};
        ArrayInteiros y = new ArrayInteiros(test);
        y.sortAscending();
        int[] expected = {1, 2, 3, 4, 5};
        int[] result = y.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void sorDescending() {
        int[] test = {5, 2, 4, 3, 1};
        ArrayInteiros y = new ArrayInteiros(test);
        y.sortDescending();
        int[] expected = {5, 4, 3, 2, 1};
        int[] result = y.getValues();
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkIfEmptyTrue() {
        int[] test = {};
        ArrayInteiros y = new ArrayInteiros(test);
        boolean expected = true;
        boolean result = y.checkIfEmpty();
        assertEquals(expected, result);
    }

    @Test
    public void checkIfEmptyFalse() {
        int[] test = {3};
        ArrayInteiros y = new ArrayInteiros(test);
        boolean expected = false;
        boolean result = y.checkIfEmpty();
        assertEquals(expected, result);
    }

    @Test
    public void checkIfOneTrue() {
        int[] test = {6};
        ArrayInteiros y = new ArrayInteiros(test);
        boolean result = y.checkIfOnlyOneElement();
        assertTrue(result);
    }

    @Test
    public void checkIfOneFalseSeveral() {
        int[] test = {3, 5, 6};
        ArrayInteiros y = new ArrayInteiros(test);
        boolean result = y.checkIfOnlyOneElement();
        assertFalse(result);
    }

    @Test
    public void checkIfOneFalse0() {
        int[] test = {};
        ArrayInteiros y = new ArrayInteiros(test);
        boolean result = y.checkIfOnlyOneElement();
        assertFalse(result);
    }

    @Test
    public void checkIfOnlyEvenTrue() {
        int[] test = {2, 4, 6, 8, 0, 16};
        ArrayInteiros y = new ArrayInteiros(test);
        boolean result = y.checkIfOnlyEven();
        assertTrue(result);
    }

    @Test
    public void checkIfOnlyEvenFalse() {
        int[] test = {2, 6, 3, 8};
        ArrayInteiros y = new ArrayInteiros(test);
        boolean result = y.checkIfOnlyEven();
        assertFalse(result);
    }

    @Test
    public void checkIfOnlyEvenEmpty() {
        int[] test = {};
        ArrayInteiros y = new ArrayInteiros(test);
        boolean result = y.checkIfOnlyEven();
        assertFalse(result);
    }

    @Test
    public void checkIfOnlyOddTrue() {
        int[] test = {1, 7, 13, 9};
        ArrayInteiros y = new ArrayInteiros(test);
        boolean result = y.checkIfOnlyOdd();
        assertTrue(result);
    }

    @Test
    public void checkIfOnlyOddFalse() {
        int[] test = {1, 6, 3, 7, 13};
        ArrayInteiros y = new ArrayInteiros(test);
        boolean result = y.checkIfOnlyOdd();
        assertFalse(result);
    }

    @Test
    public void checkIfOnlyOddEmpty() {
        int[] test = {};
        ArrayInteiros y = new ArrayInteiros(test);
        boolean result = y.checkIfOnlyOdd();
        assertFalse(result);
    }

    @Test
    public void checkForDuplicatesTrue() {
        int[] test = {2, 6, 5, 3, 9, 6};
        ArrayInteiros y = new ArrayInteiros(test);
        boolean result = y.checkForDuplicates();
        assertTrue(result);
    }

    @Test
    public void checkForDuplicatesFalse() {
        int[] test = {2, 6, 5, 3, 9, 15};
        ArrayInteiros y = new ArrayInteiros(test);
        boolean result = y.checkForDuplicates();
        assertFalse(result);
    }

    @Test
    public void checkForDuplicatesEmpty() {
        int[] test = {};
        ArrayInteiros y = new ArrayInteiros(test);
        boolean result = y.checkForDuplicates();
        assertFalse(result);
    }

    @Test
    public void getNumbersWithDigitsBiggerThanAverage() {
        int[] test = {1, 20, 300, 5000, 652, 4, 856, 6546};
        ArrayInteiros y = new ArrayInteiros(test);
        int[] expected = {5000, 6546};
        int[] result = y.getNumbersWithDigitsBiggerThanAverage();
        assertArrayEquals(expected, result);
    }

    @Test
    public void getNumbersWithEvenDigitsBiggerThanPercentage() {
        int[] test = {1, 23, 45, 371, 42, 4, 4971};
        ArrayInteiros y = new ArrayInteiros(test);
        int[] expected = {23, 45, 42, 4};
        int[] result = y.getNumbersWithEvenDigitsBiggerThanPercentage();
        assertArrayEquals(expected, result);
    }

    @Test
    public void getNumbersWithEvenDigitsBiggerThanPercentage0() {
        int[] test = {1, 3, 71, 371, 93, 7, 7971};
        ArrayInteiros y = new ArrayInteiros(test);
        int[] expected = {};
        int[] result = y.getNumbersWithEvenDigitsBiggerThanPercentage();
        assertArrayEquals(expected, result);
    }

    @Test
    public void getNumbersWithEvenDigitsBiggerThanPercentageEmpty() {
        int[] test = {};
        ArrayInteiros y = new ArrayInteiros(test);
        int[] expected = {};
        int[] result = y.getNumbersWithEvenDigitsBiggerThanPercentage();
        assertArrayEquals(expected, result);
    }

    @Test
    public void getNumbersWithEvenDigits() {
        int[] test = {2, 51, 691, 22, 48, 246814826};
        ArrayInteiros y = new ArrayInteiros(test);
        int[] expected = {2, 22, 48};
        int[] result = y.getNumbersWithEvenDigits();
        assertArrayEquals(expected, result);
    }


    @Test
    public void getArrOfAscendingNumbers() {
        int[] test = {249, 51, 691, 22, 48, 67};
        ArrayInteiros y = new ArrayInteiros(test);
        int[] expected = {249, 48, 67};
        int[] result = y.getNumbersWithAscendingDigits();
        assertArrayEquals(expected, result);
    }

    @Test
    public void getCapicuas() {
        int[] test = {242, 55, 691, 27, 48484, 67};
        ArrayInteiros y = new ArrayInteiros(test);
        int[] expected = {242, 55, 48484};
        int[] result = y.getCapicuas();
        assertArrayEquals(expected, result);
    }

    @Test
    public void getCapicuas0() {
        int[] test = {247, 5, 691, 27, 47484, 67};
        ArrayInteiros y = new ArrayInteiros(test);
        int[] expected = {};
        int[] result = y.getCapicuas();
        assertArrayEquals(expected, result);
    }

    @Test
    public void getNumbersWithSameDigits() {
        int[] test = {222, 5, 691, 27, 47484, 66};
        ArrayInteiros y = new ArrayInteiros(test);
        int[] expected = {222, 5, 66};
        int[] result = y.getNumbersWithSameDigits();
        assertArrayEquals(expected, result);
    }

    @Test
    public void getNonArmstrongNumbers() {
        int[] test = {153, 5, 691, 1634, 47484, 66};
        ArrayInteiros y = new ArrayInteiros(test);
        int[] expected = {691, 47484, 66};
        int[] result = y.getNonArmstrongNumbersFromArr();
        assertArrayEquals(expected, result);
    }

    @Test
    public void getArrOfAscendingNumbersSizeAtLeast3() {
        int[] test = {249, 51, 691, 22, 48, 6789};
        ArrayInteiros y = new ArrayInteiros(test);
        int[] expected = {249, 6789};
        int[] result = y.getNumbersOfNDigitsWithAscendingDigits(3);
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkIfSameArrTrue() {
        int[] test = {249, 51, 691, 22, 48};
        ArrayInteiros y = new ArrayInteiros(test);
        int[] test2 = {249, 51, 691, 22, 48};
        boolean result = y.checkIfSameArr(test2);
        assertTrue(result);
    }

    @Test
    public void checkIfSameArrFalse() {
        int[] test = {249, 51, 691, 22, 48};
        ArrayInteiros y = new ArrayInteiros(test);
        int[] test2 = {2, 51, 691, 22, 48};
        boolean result = y.checkIfSameArr(test2);
        assertFalse(result);
    }

    @Test
    public void checkIfSameArrFalseForLength() {
        int[] test = {249, 51, 691, 22, 48};
        ArrayInteiros y = new ArrayInteiros(test);
        int[] test2 = {249, 51, 691, 22, 48, 7};
        boolean result = y.checkIfSameArr(test2);
        assertFalse(result);
    }

    @Test
    public void checkIfSameArrEmpty() {
        int[] test = {};
        ArrayInteiros y = new ArrayInteiros(test);
        int[] test2 = {};
        boolean result = y.checkIfSameArr(test2);
        assertTrue(result);
    }
}