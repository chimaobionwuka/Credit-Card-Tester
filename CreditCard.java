/* Name: Chimaobi Onwuka
Date: 2/20/22
File Name: CreditCard.java
Purpose: Create a Credit Card class
*/

public class CreditCard
{
        //Declaring and initilaizing primary variables
        private String cardNumber = "";
        private int errorCode = 0;
        private boolean validity = true;

        //The Constructor
        public CreditCard(String creditCardNumber)
        {
            cardNumber = creditCardNumber;
        }

        //Developement-Period Variables
        int digitSum3;
        int digitSum2;
        String cardNumberDashless = cardNumber.replace("-", "");
       
        //Calls 6 total sumchecks to determermine if the the cardnumber is valid
        public void check()
        {
            check1();
            check2();
            check3();
            check4();
            check5part1(); 
            check5part2();
            check5part3();
            check6();
        }

        public void check1()
        {
           //Checksum #1
            if ((Character.getNumericValue(cardNumber.charAt(0))) != 4)
            {
                validity = false;
                if (errorCode == 0)
                {
                    errorCode = 1;
                }
            } 
        }

        public void check2()
        {
            //Checksum #2
            int a = Character.getNumericValue(cardNumber.charAt(3));
            int b = Character.getNumericValue(cardNumber.charAt(5));
            if ((a-b) != 1)
            {
                validity = false;
                if (errorCode == 0)
                {
                    errorCode = 2;
                }
            }
        }

        public void check3()
        {
            //Check sum #3
            int holder = 0;
            holder = 
            (Character.getNumericValue(cardNumber.charAt(0))
            *Character.getNumericValue(cardNumber.charAt(5)));
            if (holder * Character.getNumericValue(cardNumber.charAt(10)) != 24 )
            {
                validity = false;
                if (errorCode == 0)
                {
                    errorCode = 3;
                }
            }
        }

        public void check4()
        {
            //Check sum #4
            int digitSum1 = 0;
            int start1 = 0;
            int end1 = 1;
            String cardNumberDashless = cardNumber.replace("-", "");
            for (int counter = 0; counter < cardNumberDashless.length(); counter++)
            {
                int currentCardDigit = 
                Integer.parseInt(cardNumberDashless.substring(start1, end1));
                digitSum1 = digitSum1 + currentCardDigit;
                start1++;
                end1++;
            }
            if ((digitSum1 % 4) != 0)
            {
                validity = false;
                if (errorCode == 0)
                {
                    errorCode = 4;
                }
            }
        }

        public void check5part1()
        {
            //Check sum #5
            digitSum2 = 0;
            String cardNumberDashless = cardNumber.replace("-", "");

            //For loop for first sum
            for (int count2=0; count2<cardNumberDashless.substring(0, 4).length(); count2++)
            {
                int currentCardDigit2 = 
                Character.getNumericValue(cardNumberDashless.charAt(count2));
                digitSum2 = digitSum2 + currentCardDigit2;
            }
        }

        public void check5part2()
        {
            //For loop for the second sum
            digitSum3 = 0;
            String cardNumberDashless = cardNumber.replace("-", "");

            for (int counter3 = 8; counter3 < 12; counter3++)
            {
                int currentCardDigit3 = 
                Character.getNumericValue(cardNumberDashless.charAt(counter3));
                digitSum3 = digitSum3 + currentCardDigit3;
            }
        }

        public void check5part3()
        {
            //Difference between sums of first 4 and last 4 digits and validity test
            if ((digitSum3 - digitSum2) != 1)
            {
                validity = false;
                if (errorCode == 0)
                {
                    errorCode = 5;
                }
            }
        }

        public void check6()
        {   
            //Check sum #6
            String cardNumberDashless = cardNumber.replace("-", "");
            int firstTwo= Integer.parseInt(cardNumberDashless.substring(0, 2));
            int lastTwo = Integer.parseInt(cardNumberDashless.substring(6, 8));
            if ((firstTwo + lastTwo) != 100)
            {
                validity = false;
                if (errorCode == 0)
                {
                    errorCode = 6;
                }
            }
        }

        //Return errorCode value
        public int getErrorCode()
        {
            return errorCode;
        }

        //Return validity state
        public boolean isValid()
        {
            return validity;
        }
}



