/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.SanamedAccountSystem.model;

/**
 *
 * @author Esteban Chablay EMCL. Java ESPE-DCCO
 */
public class CreditCard {
    
    private long numberOfCard;

    @Override
    public String toString() {
        return "CreditCard{" + "numberOfCard=" + numberOfCard + '}';
    }
    

    public CreditCard() {
        numberOfCard=0000;
    }

    public CreditCard(long numberOfCard) {
        this.numberOfCard = numberOfCard;
    }

    /**
     * @return the numberOfCard
     */
    public long getNumberOfCard() {
        return numberOfCard;
    }

    /**
     * @param numberOfCard the numberOfCard to set
     */
    public void setNumberOfCard(int numberOfCard) {
        this.numberOfCard = numberOfCard;
    }
      
    
}
/*import java.util.Scanner;
public class CreditCardValidation {
      public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
        int count = 0;
        long array[] = new long [16];
       do
       {
        count = 0;
       array = new long [16];
        System.out.print("Enter your Credit Card Number : ");
        long number = in.nextLong();
        for (int i = 0; number != 0; i++) {
        array[i] = number % 10;
        number = number / 10;
        count++;
        }
       }
        while(count < 13); 
        if ((array[count - 1] == 4) || (array[count - 1] == 5) || (array[count - 1] == 3 && array[count - 2] == 7)){
            if (isValid(array) == true) {
                System.out.println("\n The Credit Card Number is Valid. ");
        } else {
            System.out.println("\n The Credit Card Number is Invalid. ");
        }
        } else{
          System.out.println("\n The Credit Card Number is Invalid. ");
        }
    }

    public static boolean isValid(long[] array) {
        int total = sumOfDoubleEvenPlace(array) + sumOfOddPlace(array);        
        if ((total % 10 == 0)) {
         for (int i=0; i< array.length; i++){
            //System.out.println(array[i]);
         }
            return true;
        } else {
          for (int i=0; i< array.length; i++){
            //System.out.println(array[i]);
          }
            return false;
        }
    }

    public static int getDigit(int number) {
        if (number <= 9) {
            return number;
        } else {
            int firstDigit = number % 10;
            int secondDigit = (int) (number / 10);
            return firstDigit + secondDigit;
        }
    }

    public static int sumOfOddPlace(long[] array) {
        int result = 0;
        for (int i=0; i< array.length; i++)
        {
        while (array[i] > 0) {
            result += (int) (array[i] % 10);
            array[i] = array[i] / 100;
         }}
         //System.out.println("\n The sum of odd place is " + result);
        return result;
    }

    public static int sumOfDoubleEvenPlace(long[] array) {
        int result = 0;
        long temp = 0;
        for (int i=0; i< array.length; i++){
        while (array[i] > 0) {
             temp = array[i] % 100;
             result += getDigit((int) (temp / 10) * 2);
            array[i] = array[i] / 100;
           }
        }
        //System.out.println("\n The sum of double even place is " + result);
        return result;
    }
     }*/
