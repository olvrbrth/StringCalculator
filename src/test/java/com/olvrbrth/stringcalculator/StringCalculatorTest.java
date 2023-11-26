package com.olvrbrth.stringcalculator;

import com.olvrbrth.stringcalculator.StringCalculator;
import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void shouldReturn0ForEmptyString() {
        StringCalculator s = new StringCalculator();

        int r = s.Add("");

        Assert.assertEquals(0, r);
    }

    @Test
    public void shouldReturnInputForSingleNumber() {
        StringCalculator s = new StringCalculator();

        int r = s.Add("1");

        Assert.assertEquals(1, r);
    }

    @Test
    public void shouldReturnSumForTwoNumbersSeparatedByComa() {
        StringCalculator s = new StringCalculator();

        int r = s.Add("1,2");

        Assert.assertEquals(3, r);
    }

    @Test
    public void shouldReturnSumAnyNumberOfArgumentsSeparatedByComa() {
        StringCalculator s = new StringCalculator();

        int r = s.Add("1,2,3,4,5");

        Assert.assertEquals(15, r);
    }

    @Test
    public void shouldReturnSumAnyNumberOfArgumentsSeparatedByNewLine() {
        StringCalculator s = new StringCalculator();

        int r = s.Add("1\n2\n3\n4\n5");

        Assert.assertEquals(15, r);
    }

    @Test
    public void shouldReturnSumAnyNumberOfArgumentsSeparatedByNewLineOrComa() {
        StringCalculator s = new StringCalculator();

        int r = s.Add("1,2\n3\n4,5");

        Assert.assertEquals(15, r);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfDelimiterIsAtEndOfLine() {
        StringCalculator s = new StringCalculator();

        s.Add("1,2\n3\n4,5,");
    }

    /*
    “//;\n1;3” should return “4”
    “//|\n1|2|3” should return “6”
    “//sep\n2sep5” should return “7”
    “//|\n1|2,3” is invalid and should return an error (or throw an exception) with the message “‘|’ expected but ‘,’ found at position 3.”
     */
    @Test
    public void shouldReturnSumWithCustomDelimiterSemicolon() {
        StringCalculator s = new StringCalculator();

        int r = s.Add("//;\n1;3");

        Assert.assertEquals(4, r);
    }

    /*
    @Test
    public void shouldReturnSumWithCustomDelimiterBorder() {
        StringCalculator s = new StringCalculator();

        int r = s.Add("//|\n1|2|3");

        Assert.assertEquals(6, r);
    }

    @Test
    public void shouldReturnSumWithCustomDelimiterWord() {
        StringCalculator s = new StringCalculator();

        int r = s.Add("//sep\n2sep5");

        Assert.assertEquals(7, r);
    }

     */

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfDelimiterHasChangedInText() {
        StringCalculator s = new StringCalculator();

        s.Add("//|\n1|2,3");
    }
}
