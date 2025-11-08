package Collections;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogicsTest {

    @Test
    public void testReverseNumber() {
        int num = 1234;
        int remainder, reverse = 0;

        while (num != 0) {
            remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num = num / 10;
        }

        Assert.assertEquals(reverse, 4321, "Reversed number should be 4321");
    }

    @Test
    public void testCountDigits() {
        int num1 = 423423;
        int count = 0;

        while (num1 > 0) {
            num1 = num1 / 10;
            count++;
        }

        Assert.assertEquals(count, 6, "Number of digits should be 6");
    }

    @Test
    public void testConvertPriceStringToDouble() {
        String price = "$4325.90";
        double dprice = Double.parseDouble(price.substring(1));

        Assert.assertEquals(dprice, 4325.90, 0.001, "Price should be parsed correctly as double");
    }

    @Test
    public void testFindLowestPriceFromList() {
        List<String> pricesArray = new ArrayList<>(Arrays.asList(
                "$5678.23", "$8543", "$7654", "$6587", "$4325.90"
        ));

        // Convert to numeric list
        List<Double> numericPrices = new ArrayList<>();
        for (String price : pricesArray) {
            numericPrices.add(Double.parseDouble(price.replace("$", "")));
        }

        // find the minimum
        double lowestPrice = numericPrices.get(0);
        for (double p : numericPrices) {
            if (p < lowestPrice) {
                lowestPrice = p;
            }
        }

        Assert.assertEquals(lowestPrice, 4325.90, 0.001, "Lowest price should be 4325.90");
    }

    @Test
    public void testFindOccurrenceOfDigit() {
        int num = 223432244;
        int digitToFind = 2;
        int count = 0;

        int temp = num;
        while (temp > 0) {
            int remainder = temp % 10;
            if (remainder == digitToFind) {
                count++;
            }
            temp = temp / 10;
        }

        Assert.assertEquals(count, 4, "Digit '2' should occur 4 times in 223432244");
    }
}
