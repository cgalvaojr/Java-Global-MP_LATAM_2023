package com.epam.training.testing.isbntools;

import org.junit.Assert;
import org.junit.Test;

public class ValidateISBNTest {

    // 014044116
//        ISBN-10 ‏ : ‎ 1913330001
//        ISBN-13 ‏ : ‎ 978-1913330002
//        ISBN-10 ‏ : ‎ 1668001225
//        ISBN-13 ‏ : ‎ 978-1668001226
    @Test
    public void checkAValida10DigitISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        Assert.assertTrue("First value", result);
        result = validator.checkISBN("0140449117");
        Assert.assertFalse("Second value", result);
    }

    @Test
    public void checkAnInvalida10DigitISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("1140449116");
        Assert.assertFalse(result);
    }
    @Test
    public void checkAnInvalida13DigitISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116111");
        Assert.assertFalse(result);
    }

    @Test
    public void TenDigitISBNNumbersEndingInAnXAreValid() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        Assert.assertTrue(result);
    }

    @Test
    public void checkAValida13DigitISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781853260087");
        Assert.assertTrue(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNsAreNotAllowedTest() {
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("123456789");
    }

    @Test(expected = NumberFormatException.class)
    public void nonNumbericISBNsAreNotAllowedTest() {
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("helloworld");
    }

}
