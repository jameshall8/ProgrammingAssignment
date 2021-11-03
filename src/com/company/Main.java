package com.company;
import java.util.Random; //importing java random
import java.util.*; //importing java util library
public class Main {
    static java.util.Scanner sc = new Scanner(System.in); // instantiating scanner to use in all methods in the class

    private static void PressEnter() { //This method allows the user to press enter before starting the application!
        System.out.println("Press enter to continue: ");
        sc.nextLine();
        sc.nextLine();
    }

    private static boolean CountCheckAnswer(int answer, int userAnswer){ //Check whether user answer is correct
        return userAnswer == answer; //returns boolean value of User answer compared to answer
    }
    private static void CalculateTime(long start){ //calculates the time in which they completed
        long elapsedTime = System.currentTimeMillis() - start; //finding the elapsed time by subtracting the start time from current time
        long elapsedSeconds = elapsedTime / 1000; //converting the elapsed time into seconds
        System.out.println("Well done, you completed the counting game in " + elapsedSeconds + " seconds\n"); //displaying the time take
    }
    private static void Counting() { // The first mini app as presented on the assignment brief
        String Message = """ 
                Keep Counting
                -------------
                You will be presented with 10 addition and subtraction questions.
                After the first question, the left-hand operand\s
                is the result of the previous addition.\s
                """;
        System.out.println(Message); //displaying the message to the screen so the user knows what iss going to happen
        PressEnter(); //calling the press enter function so the game does not start until enter is pressed1


        long startTime = System.currentTimeMillis(); //setting start time as the current time


        Random rand = new Random(); //instantiating a Random object
        String[] arr = {"+", "-"}; //creating an array of the available signs


        int Amount = 10; //setting the amount of questions
        int Num1 = rand.nextInt(11); //setting number 1 as random number between 1 and 10


        for (int i = 0; i <= Amount; i++) { //for loop to display 10 different questions
            int Num2 = rand.nextInt(11); // setting number 2 as random number (needs to be in for loop to change every time)

            int select = rand.nextInt(arr.length); //Selecting a random sign from the array using the array length
            String sign = arr[select]; // calling the sign from the appropriate array index

            if (sign.equals("-")) { //if the sign is a -
                System.out.println("Question " + i + ": " + Num1 + " " + sign + " " + Num2); //display the question with correct sign
                int answer = Num1 - Num2; //creating the answer variable
                try {
                    int UserAnswer = sc.nextInt(); //try to set user answer as an INT to ensure they entered an INT
                    if (CountCheckAnswer(answer, UserAnswer)) { //calling check answer function and passing answer and user answers
                        Num1 = answer; //setting number1 as the answer the previous question
                    }
                    else { //question wrong
                        System.out.println("Wrong!, the correct number was " + answer); //display correct answer
                        break; //end game
                    }
                } catch (Exception e) { // if they did not enter an integer
                    System.out.println("You did not enter a number! the answer was " + answer);
                    break;
                }
            }
            else { //if sign is not a - sign (+)
                System.out.println("Question " + i + ": " + Num1 + " " + sign + " " + Num2); //print out correct question with sign
                int answer = Num1 + Num2; // set the answer to the question using correct sign
                try {
                    int UserAnswer = sc.nextInt(); //setting user answer as user input
                    if (CountCheckAnswer(answer, UserAnswer)) { //calling check answer function and passing answer and user answers
                        Num1 = answer; //set num 1 as answer
                    }
                    else {
                        System.out.println("Wrong!, the correct number was " + answer); //incorrect answer displaying correct
                        break;
                    }
                } catch (Exception e) { //did not enter int
                    System.out.println("You did not enter a number! the answer was " + answer);
                    break;
                }
            }
            if (i == 10){
                CalculateTime(startTime); //calculating the time taken via the function and passing the start time
            }
        }
    }
    /*
    Test Plan For Check Digit Application
    error 1 = "You did not input a 5-digit number, or it included an invalid digit (0)"
    error 2 = "User input not an int"
    TEST_CASE#    INPUT       EXPECTED OUTPUT      ACTUAL OUTPUT                 REASON
        1         9999          error 1               error 1               below lower bound
        2         10000         error 1               error 1               number includes 0 (invalid digit)
        3         11111         111113                111113                number within the bounds
        4         99999         999997                999997                upper bound
        5         111111        error 1               error 1               above upper bound and too many digits
        6           0           error 1               error 1               a zero as input
        7         hello         error 2               error 2               not an integer entered
        8         0.12345       error 2               error 2               decimal number
        9         25687         256876                256876                number from assignment brief
     */
    private static boolean ContainsZero(int input){ //checking if number inputted includes a 0

        return !String.valueOf(input).contains("0"); //check number is 5 digits and doesn't include a 0

    }
    private static void CheckDigit() {
        String Message = """
                Check-Digit Calculator
                ----------------------
                This calculator will take a 5-digit number
                and generate a trailing 6th check digit
                Please enter 5-digit number to generate final code:\s
                """;
        List<Integer> NumList = new ArrayList<>(); //creating a new array for our number list
        boolean correct = true; //setting a boolean value for our while loop

        while (correct) {
            System.out.println(Message); //print message
            int length = 5;
            try { //try to catch the exceptions if bad input
                int UserInput = sc.nextInt(); //setting input as INT input
                if (ContainsZero(UserInput) && CheckLength(UserInput, length)) { //checking it's a 5-digit number and that it doesn't include 0
                    while (UserInput > 0) { //while the user input is larger than 0 (which it will be at the start as only allowing 5-digit numbers)
                        NumList.add(UserInput % 10); //modulo 10 will get us the last digit and then add it to our num-list array
                        UserInput = UserInput / 10; //divide the number by 10 to remove last digit
                    }
                    Collections.reverse(NumList); //the numbers will need to be reversed in the list as we added them back to front
                    int together = CalculateCheck(NumList); // calling to calculate check function and passing it our array

                    int CheckNumber = together % 10; //the check number is together modulo 10 (last digit)


                    if (CheckNumber != 0) { //if the check number is not 0
                        CheckNumber = 10 - CheckNumber; //check number is 10 - check number
                    }
                    NumList.add(CheckNumber); //add the check number to our list of integers
                    String FormattedString = NumList.toString().replace(",", "").replace("[", "").replace("]", "").trim().replaceAll("\\s", "");
                    //above line formats our array, so it just displays the numbers and not [] and ,
                    System.out.println("The 6 digit final number is: " + FormattedString); // displaying the formatted array
                    correct = false; //getting out of while loop
                } else { //user input is either not 5 digits or includes a 0 which is not allowed
                    System.out.println("You did not input a 5 digit number or it included a invalid digit (0)");
                    sc.nextLine();
                }
            } catch (Exception e) { //users input was not an integer
                System.out.println("User input not a int");
                sc.nextLine();
            }
        }
    }
    private static boolean CheckLength(int num, int wantedLength){ //checks the length of user input
        String stringValue = String.valueOf(num); //converts user input to a string so we can use built in string methods
        int length = stringValue.length(); //get the string length
        return length == wantedLength; //return the boolean value of if length is the same as the length wanted
    }
    private static int CalculateCheck(List<Integer> List){ //passing an integer list and calling it list

        int odds = (7 * (List.get(0) + List.get(2) + List.get(4))); //calculating the check digit as per formula in the brief
        int evens = (3 * (List.get(1) + (int) List.get(3)));
        return odds + evens;
    }
    private static void CheckChecker() {
        String Message = """
                Check-Digit Checker
                ------------------------------------
                Please enter 6-digit number to check:""";
        List<Integer> NumList = new ArrayList<>();
        boolean correct = true;
        int length = 6;
        while (correct) {
            System.out.println(Message);
            try {
                int UserInput = sc.nextInt();
                if (CheckLength(UserInput, length)&& !String.valueOf(UserInput).contains("0")) {
                    while (UserInput > 0) {
                        NumList.add(UserInput % 10);
                        UserInput = UserInput / 10;
                    }
                    Collections.reverse(NumList);
                    int together = CalculateCheck(NumList);
                    int CheckNumber = together % 10;
                    if (CheckNumber != 0) {
                        CheckNumber = 10 - CheckNumber;
                    }
                    NumList.add(CheckNumber);
                    correct = false;

                    if (NumList.get(5) == CheckNumber) {
                        System.out.println("The number is valid");
                    } else {
                        System.out.println("The number is invalid");
                    }
                } else {
                    System.out.println("You did not input a 5 digit number!");
                    sc.nextLine();
                }

            } catch (Exception e) {
                System.out.println("You did not enter a valid number!");
                sc.nextLine();
            }
        }
    }

    private static double FindSquare(double number, double accuracy) { //find square function and passing in the number and accuracy
        double lowBound = 0; //declaring lower bound
        double upBound = number; //declaring upper bound as the number
        double average = 0; //declaring a double for the average


        while (upBound - lowBound > accuracy) {
            average = lowBound + (upBound - lowBound) / 2; // finding the middle value
            if (average * average > number) { //the averages times is greater than the number
                upBound = average; //setting the upper bound as the output
            } else {
                lowBound = average; //setting the lower bound as average
            }
        }
        return average;
    }

    private static void SquareRoot() {
        double decimalPlaces; //setting variable for decimal places
        boolean correct = true;
        while (correct) { //while boolean value above is true
            System.out.println("Please Enter A Positive Number: "); //ask user for a positive number
            try { //try to set UserAnswer as a double
                int UserAnswer = sc.nextInt();
                if (UserAnswer > 0) { //if it's not a negative number inputtedSystem.out.println("How many decimal places do you want the solution calculated to: 1-7");//ask user for input for accuracy
                    try {// to set accuracy variable as input
                        System.out.println("Please Enter How many decimal places: "); //ask user for a positive number for decimal places

                        int accuracy = sc.nextInt();
                        if (accuracy >= 1 && accuracy <= 7) { //if number inputted is between 1 and 7
                            switch (accuracy) { //switch statement for declaring accuracy depending on number input
                                case 1 -> decimalPlaces = 0.1;
                                case 2 -> decimalPlaces = 0.01;
                                case 3 -> decimalPlaces = 0.001;
                                case 4 -> decimalPlaces = 0.0001;
                                case 5 -> decimalPlaces = 0.00001;
                                case 6 -> decimalPlaces = 0.000001;
                                case 7 -> decimalPlaces = 0.0000001;
                                default -> throw new IllegalStateException("Unexpected value: " + accuracy); //if value is unexpected throw exception
                            }
                            String decimal;//setting decimal string for when formatting
                            double squareNumber = (FindSquare(UserAnswer, decimalPlaces)); //setting square number variable as return value of find square function

                            decimal = "%." + accuracy + "f"; //setting the format string to accuracy

                            Formatter f = new Formatter(); //instantiating a new formatting object
                            System.out.println(f.format(decimal, squareNumber)); //print the formatted squareNumber to decimal places using method for f
                            correct = false;
                        } else {//input incorrect
                            System.out.println("Incorrect Input");
                        }
                    }
                    catch (Exception e) { //number not valid therefore throws exception
                        System.out.println("You did not enter a valid number!");
                        sc.nextLine();

                    }
                }
            } catch (Exception e) { //number not valid so throws exception
                System.out.println("You did not enter a valid number!");
                sc.nextLine();
            }}
    }


    public static void main(String[] args){
        String Menu = "\nP4CS Mini Applications\n----------------------\nPlease Select an option:\n1) Keep Counting game\n2) Square root calculator\n3) Check Digit Generator\n4) Check Digit Checker\n9) Quit\n\nPlease Select An Option:";

        boolean MenuVisible = true; //boolean for if menu is visible
        while (MenuVisible) { //while menu visible is true
            System.out.println(Menu); //print menu string


            try { //try to assign users input to answer
                int answer = sc.nextInt();
                switch (answer) { //switch statement and pull in variable answer
                    case 1 -> Counting(); //call function for counting game
                    case 2 -> SquareRoot(); //call function for square root game
                    case 3 -> CheckDigit(); //call function to check digit
                    case 4 -> CheckChecker(); //call function for check digit checker
                    case 9 -> MenuVisible = false; // set menu visible too false to end the program
                }
            } catch (Exception e) { //users input not a valid integer and therefore throws exception
                System.out.println("You did not enter a valid number\nTry Again\n");
            }
            sc.nextLine();// next line to clear the scanner to allow user to input a new number
        }

    }
}




















