# ProgrammingAssignment

this is my assignment for programming for computer science. This is my first assignment from university so was fairly simple.
It involves a menu system alongside 4 other applications that manipulate / calculate certain things.

below i will add the assignment brief...

Assessment Brief 
In this task you will develop a series of mini applications that are designed to get you thinking logically about constructing code in Java.  The concepts required to implement these applications form only a small and introductory selection of features found in the language, although you will need to carefully consider how to put those building blocks together. Alongside the code, you will need to provide a testing plan for one of the mini-apps.
This task can be tackled using the techniques covered in class, however aspects can be better coded with more advanced features, such as arrays (which we will look at in due course).  If you choose to research and deploy those advanced features of the language, then you will receive higher marks (please refer to the assessment criteria).
There are four mini applications to create, and all accessed via a menu system.  An example of the complete application is available on the module Blackboard site as a video.  The following sections outline the core details and requirements for each of the applications.

Menu System
•	Create a top-level menu system that allows the user to select which of the mini applications to run when the application is launched.
•	If the user presses a number not in the list of options, display a message and show the menu again
•	Once the selected application has finished, the menu should be displayed, and the user asked which app to run (or exit)
•	When the user selects the quit option, your code should naturally terminate.  Do not use System.exit(0) to end your application but do allow control paths to naturally converge at the end of the main method
•	Do not use any form of recursion to implement the menu system.  Use appropriate loops and methods to help split up your code and create a sensible iterative control flow

Mini App 1: Keep Counting
•	Starting from two random numbers, the user is presented with 10 addition or subtraction questions
•	The answer to the previous question becomes the first operand of the next question.  The type of question (plus or minus) and the second operand to the next question are randomly generated
•	You can assume the user enters valid input for the data type expected
•	The game is timed, however, the player needs to correctly answer all questions correctly for their time to be displayed at the end
•	As soon as the player gets a wrong answer, the correct answer is displayed and the game finishes without any timings
•	The randomly generated operands of the mathematical questions presented to the user should be in the whole number range of 1 and 10 inclusive (answers can be outside of this range though)
•	The choice of presenting the user with addition or subtraction should be done randomly for each question.


2) Square Root Calculator
•	The user enters a whole, positive number (as an integer) and your app will calculate its square root using numerical methods
•	The user enters the number of decimal places for the precision square root result (as an integer).  This should be in the range of 1 to 7 decimal places
•	The square root of the input is calculated iterative using a lower and upper bound that represent guesses towards the solution.  The lower bound is the last known value that the true square root must be above and the upper bound is the last know value that the true square root must be below.  You will need to initialise these with sensible values
•	You refine your lower and upper bounds by: 
o	taking the average of the upper and lower bounds
o	squaring that average 
o	compare the square of the average against the number we are calculating the square root for
o	update the lower or upper bound accordingly using the average 
•	You will repeatedly refine your lower and upper bounds until the different between the two bounds is less than your decimal place precision.  
o	if the user asks for a precision of 1 decimal place, then your accuracy can be taken as 0.1., for two decimal places, it would be 0.01, for three decimal places, it would be 0.001, and so on.
•	Once the level of precision has been reached, output the value of the square root, formatted to the specified number of decimal places
•	Do not use the built-in square root function for this at any point; you must implement this the numerical recipe given above
•	This might seem like a complex task at first but work it through on paper a few times to make sure you know what you are coding.  The implementation is reasonably small.  You just need to think about this first.  Here is a partial worked example (purposely not including the initial values).
Input	5	Decimal Places	3
				
lower	upper	average	average * average	[action]
…	…	…	…	
2.1875	2.34375	2.265625	5.133056640625	Update upper
2.1875	2.265625	2.2265625	4.95758056640625	Update lower
2.2265625	2.24609375	2.236328125	5.001163482666016	Update upper
…	…	…	…	…



Mini-App 3: Check-Digit Generator
•	Input a single 5-digit whole number from the user.  You must read this in as a single integer value and use numerical methods to decompose it into individual elements.  Do not read individual integer values from the user and do not read in as or convert to a string and reconvert back to integer values.  Use math to decompose into individual digits.
•	Your application will create a 6th check digit using the rules outlined below. This check-digit is appended to the original input and displayed as a 6-digit code.  For example, the user input “12345” number will become “12345?” with the ‘?’ indicating the check digit.
•	All individual digits of input must be in the range of 1 and 9 inclusive, else an error message is displayed to the user, and they are asked to input again
•	Check that the input number is valid, else display an error message and ask the user to enter again
•	Use the following rules to determine the check digit:
o	Add the digits in the odd-numbered positions together (working left to right where the 1st position is the left-most digit and excluding the check digit) and multiply by seven
o	Add the digits in the even-numbered positions together and multiply by three
o	Take the remainder of the result when divided by 10 (modulo). 
	If the remainder is equal to 0 then use 0 as the check digit
	If the remainder is not equal to 0 then subtract the remainder from 10 to derive the check digit
•	Display the 6-digit number that includes the check digit.  For example:
o	Input “25687” -> (7 * (2 + 6 + 7)) + (3 * (5 + 8)) = 144
o	Remainder of 144 when divided by 10 is 4
o	10 – 4 = 6
o	Check digit is 6 and thus the UPC output is “256876”

Mini-App 4: Check-Digit Checker
•	Provide a check-digit checker that allows the user to enter a 6-digit code and validate the check digit for correctness using the rules outlined in the generator for mini-app 3
•	Sensibly refactor and reusing code between this mini-app and the generator that is common between the two applications.


Testing
Provide a test plan for the Check-Digit Generator app.  Put this above the main function for that app as a comment block.  The test plan should include inputs, expected outputs, actual outputs, and should be sufficient to ensure your code is tested to a suitable level.

