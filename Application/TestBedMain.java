package application;


/**
 * <p> Title: TestBedMain Class. </p>
 * 
 * <p> Description: A Java implementation for semi-automated tests for the Answer class </p>
 * 
 * <p> Copyright: Matthew Thomas Brummund © 2025 </p>
 * 
 * @author Matthew Thomas Brummund
 * 
 * @version 1.00	2025-03-26 A set of semi-automated test cases for the Answer and class
 * 
 */
public class TestBedMain {
	
	/** Counter of the number of passed tests */
	static int numPassed = 0;
	
	/** Counter of the number of failed tests */
	static int numFailed = 0;

	/**
	 * This mainline displays a header to the console, performs a sequence of
	 * test cases, and then displays a footer with a summary of the results
	 * 
	 * @param args Command line arguments (not used)
	 */
	public static void main(String[] args) {
		/************** Test cases semi-automation report header **************/
		System.out.println("______________________________________");
		System.out.println("\nTesting Automation");

		/************** Start of the test cases **************/
		
	
		// All of these are the positive versions
		
		// Perform the test cases for the searchQuestions Method
		performTestCaseSetText(1, "Demo text", true);
		
		// Perform the test cases for the upvote Method
		performTestCaseUpvote(2, 7, true);
		
		// Perform the test cases for the downvote Method
		performTestCaseDownvote(3, 5, true);
		
		// Perform the test cases for the markAsCorrect Method
		performTestCaseMarkAsCorrect(4, true, true);
		
		// Perform the test cases for the setAnsweredBy Method
		performTestCaseSetAnsweredBy(5, "MatthewBrummund", true);
		
		
		/************** End of the test cases **************/
		
		/************** Test cases semi-automation report footer **************/
		System.out.println("____________________________________________________________________________");
		System.out.println();
		System.out.println("Number of tests passed: "+ numPassed);
		System.out.println("Number of tests failed: "+ numFailed);
	}
	
	
	
	/**
	 * This method implements a testcase for the getText Method in the Answer class.
	 * The purpose of the method is to set the answer text if needed, and here this is implemented.
	 * The test works by displaying the header, doing the test, and then interpreting and displaying the results.
	 * 
	 * @param testCase The test case number for reporting purposes
	 * @param inputText The text to set for the answer
	 * @param expectedPass Whether the test is expected to pass or fail
	 */
	private static void performTestCaseSetText(int testCase, String inputText, boolean expectedPass) {
		/************** Display an individual test case header **************/
		System.out.println("____________________________________________________________________________\n\nTest case: " + testCase);
		System.out.println("Input: \"" + inputText + "\"");
		System.out.println("______________");
		
		/************** Set up the test answer, set the text and check the result **************/
		
		// Set up the test answer, set the text and check the result
		Answer testAnswer = new Answer("text", "User");
		testAnswer.setText(inputText);
		String realSetText = testAnswer.getText();
		
		/************** Interpret the result and display that interpreted information **************/
		System.out.println();
		
		// If they don't match it's a failure
		if (inputText != realSetText) {
			 // If the test case expected the test to pass then this is a failure
			if (expectedPass) {
				System.out.println("***Failure*** The Name <" + inputText + "> is invalid." + 
						"\nBut it was supposed to be valid, so this is a failure!\n");
				System.out.println("Error message: " + realSetText);
				numFailed++;
			}
			// If the test case expected the test to fail then this is a success
			else {			
				System.out.println("***Success*** The Name <" + inputText + "> is invalid." + 
						"\nBut it was supposed to be invalid, so this is a pass!\n");
				System.out.println("Error message: " + realSetText);
				numPassed++;
			}
		}
		
		// If the resulting text is empty, the recognizer accepted the input
		else {	
			// If the test case expected the test to pass then this is a success
			if (expectedPass) {	
				System.out.println("***Success*** The Name <" + inputText + 
						"> is valid, so this is a pass!");
				numPassed++;
			}
			// If the test case expected the test to fail then this is a failure
			else {
				System.out.println("***Failure*** The Name <" + inputText + 
						"> was judged as valid" + 
						"\nBut it was supposed to be invalid, so this is a failure!");
				numFailed++;
			}
		}
	}
	
	/**
	 * This method sets up everything needed to test the upvotes method, and then tests it.
	 * It does this through displaying the header, testing, interpreting and displaying the results.
	 * 
	 * @param testCase The test case number for reporting purposes
	 * @param numUpvotes The number of times to upvote the answer
	 * @param expectedPass Whether the test is expected to pass or fail
	 */
	private static void performTestCaseUpvote(int testCase, int numUpvotes, boolean expectedPass) {
		/************** Display an individual test case header **************/
		System.out.println("____________________________________________________________________________\n\nTest case: " + testCase);
		System.out.println("Starting Upvote test: " + numUpvotes + " Times" );
		System.out.println("______________");
		
		/************** Create the answer instance and upvote it a given number of times, then get the current number of upvotes **************/
		
		// Create the answer, loop through upvoting it, then get number of upvotes
		Answer testAnswer = new Answer("test", "user");
		for (int i = 0; i < numUpvotes; i++) {
			testAnswer.upvote();
		}
		int realNumUpvotes = testAnswer.getUpvotes();
		
		
		/************** Interpret the result and display that interpreted information **************/
		System.out.println();
		
		// If they're not equal it fails (The real and expected)
		if (realNumUpvotes != numUpvotes) {
			 // If the test case expected the test to pass then this is a failure
			if (expectedPass) {
				System.out.println("***Failure*** The value <" + numUpvotes + "> is invalid." + 
						"\nBut it was supposed to be valid, so this is a failure!\n");
				System.out.println("Error message: " + realNumUpvotes);
				numFailed++;
			}
			// If the test case expected the test to fail then this is a success
			else {			
				System.out.println("***Success*** The value <" + numUpvotes + "> is invalid." + 
						"\nBut it was supposed to be invalid, so this is a pass!\n");
				System.out.println("Error message: " + realNumUpvotes);
				numPassed++;
			}
		}
		
		// If they're equal it passes (the given and expected)
		else {	
			// If the test case expected the test to pass then this is a success
			if (expectedPass) {	
				System.out.println("***Success*** The value <" + numUpvotes + 
						"> is valid, so this is a pass!");
				numPassed++;
			}
			// If the test case expected the test to fail then this is a failure
			else {
				System.out.println("***Failure*** The value <" + numUpvotes + 
						"> was judged as valid" + 
						"\nBut it was supposed to be invalid, so this is a failure!");
				numFailed++;
			}
		}
	}
	
	/**
	 * This method sets up everything needed to test the downvote method, and then tests it.
	 * It does this through displaying the header, testing, interpreting and displaying the results.
	 * 
	 * @param testCase The test case number for reporting purposes
	 * @param numdownvotes The number of times to downvote the answer
	 * @param expectedPass Whether the test is expected to pass or fail
	 */
	private static void performTestCaseDownvote(int testCase, int numdownvotes, boolean expectedPass) {
		/************** Display an individual test case header **************/
		System.out.println("____________________________________________________________________________\n\nTest case: " + testCase);
		System.out.println("Starting Downvote test: " + numdownvotes + " Times" );
		System.out.println("______________");
		
		/************** Create the answer instance and downvote it a given number of times, then get the current number of downvotes **************/
		
		// Create the answer, loop through downvoting it, then get number of downvotes
		Answer testAnswer = new Answer("test", "user");
		for (int i = 0; i < numdownvotes; i++) {
			testAnswer.downvote();
		}
		int realNumDownvotes = testAnswer.getDownvotes();
		
		
		/************** Interpret the result and display that interpreted information **************/
		System.out.println();
		
		// If they're not equal it fails (The real and expected)
		if (realNumDownvotes != numdownvotes) {
			 // If the test case expected the test to pass then this is a failure
			if (expectedPass) {
				System.out.println("***Failure*** The value <" + numdownvotes + "> is invalid." + 
						"\nBut it was supposed to be valid, so this is a failure!\n");
				System.out.println("Error message: " + realNumDownvotes);
				numFailed++;
			}
			// If the test case expected the test to fail then this is a success
			else {			
				System.out.println("***Success*** The value <" + numdownvotes + "> is invalid." + 
						"\nBut it was supposed to be invalid, so this is a pass!\n");
				System.out.println("Error message: " + realNumDownvotes);
				numPassed++;
			}
		}
		
		// If the two fields are equal it passes
		else {	
			// If the test case expected the test to pass then this is a success
			if (expectedPass) {	
				System.out.println("***Success*** The value <" + numdownvotes + 
						"> is valid, so this is a pass!");
				numPassed++;
			}
			// If the test case expected the test to fail then this is a failure
			else {
				System.out.println("***Failure*** The value <" + numdownvotes + 
						"> was judged as valid" + 
						"\nBut it was supposed to be invalid, so this is a failure!");
				numFailed++;
			}
		}
	}
	
	
	
	/**
	 * This method sets up an answer and sets it as correct or not based on the input.
	 * Then it will check if the correct value has been assigned to the answer.
	 * Lastly it will do all of this through displaying a header, interpreting the results, and displaying them.
	 * 
	 * @param testCase The test case number for reporting purposes
	 * @param correct Whether the answer should be marked as correct
	 * @param expectedPass Whether the test is expected to pass or fail
	 */
	private static void performTestCaseMarkAsCorrect(int testCase, Boolean correct, boolean expectedPass) {
		/************** Display an individual test case header **************/
		System.out.println("____________________________________________________________________________\n\nTest case: " + testCase);
		System.out.println("Conducting test for markAsCorrect");
		System.out.println("______________");
		
		/************** Set up the Answer and mark it if needed then see if it shows up as **************/

		//Set up the answer, mark it and check it
		Answer testAnswer = new Answer("test", "User");
		testAnswer.markAsCorrect();
		boolean realCorrect = testAnswer.isCorrect();
		
		/************** Interpret the result and display that interpreted information **************/
		System.out.println();
		
		// If the result doesn't match the input it failed
		if (correct != realCorrect) {
			 // If the test case expected the test to pass then this is a failure
			if (expectedPass) {
				System.out.println("***Failure*** The value <" + correct + "> is invalid." + 
						"\nBut it was supposed to be valid, so this is a failure!\n");
				System.out.println("Error message: " + realCorrect);
				numFailed++;
			}
			// If the test case expected the test to fail then this is a success
			else {			
				System.out.println("***Success*** The value <" + correct + "> is invalid." + 
						"\nBut it was supposed to be invalid, so this is a pass!\n");
				System.out.println("Error message: " + realCorrect);
				numPassed++;
			}
		}
		
		// If the resulting text is empty, the recognizer accepted the input
		else {	
			// If the test case expected the test to pass then this is a success
			if (expectedPass) {	
				System.out.println("***Success*** The value <" + correct + 
						"> is valid, so this is a pass!");
				numPassed++;
			}
			// If the test case expected the test to fail then this is a failure
			else {
				System.out.println("***Failure*** The value <" + correct + 
						"> was judged as valid" + 
						"\nBut it was supposed to be invalid, so this is a failure!");
				numFailed++;
			}
		}
	}
	
	/**
	 * This method sets up the value to have as the username, and assigns it to an example answer.
	 * It will then check if the assigned username was the correct one, and if so
	 * then it will display the output in the correct way.
	 *
	 * @param testCase The test case number for reporting purposes
	 * @param userName The username to set for the answer
	 * @param expectedPass Whether the test is expected to pass or fail
	 */
	private static void performTestCaseSetAnsweredBy(int testCase, String userName, boolean expectedPass) {
		/************** Display an individual test case header **************/
		System.out.println("____________________________________________________________________________\n\nTest case: " + testCase);
		System.out.println("Input Username: \"" + userName + "\"");
		System.out.println("______________");
		
		/************** Create the test Answer and assign the name **************/
		
		// Create the test Answer and assign the name
		Answer testAnswer = new Answer("Test", "User");
		testAnswer.setAnsweredBy(userName);
		String realUserName = testAnswer.getAnsweredBy();

		
		/************** Interpret the result and display that interpreted information **************/
		System.out.println();
		
		// If the names don't match this is a failure
		if (userName != realUserName) {
			 // If the test case expected the test to pass then this is a failure
			if (expectedPass) {
				System.out.println("***Failure*** The name <" + userName + "> is invalid." + 
						"\nBut it was supposed to be valid, so this is a failure!\n");
				System.out.println("Error message: " + realUserName);
				numFailed++;
			}
			// If the test case expected the test to fail then this is a success
			else {			
				System.out.println("***Success*** The name <" + userName + "> is invalid." + 
						"\nBut it was supposed to be invalid, so this is a pass!\n");
				System.out.println("Error message: " + realUserName);
				numPassed++;
			}
		}
		
		// if the names match this is a pass
		else {	
			// If the test case expected the test to pass then this is a success
			if (expectedPass) {	
				System.out.println("***Success*** The name <" + userName + 
						"> is valid, so this is a pass!");
				numPassed++;
			}
			// If the test case expected the test to fail then this is a failure
			else {
				System.out.println("***Failure*** The name <" + userName + 
						"> was judged as valid" + 
						"\nBut it was supposed to be invalid, so this is a failure!");
				numFailed++;
			}
		}
	}
}