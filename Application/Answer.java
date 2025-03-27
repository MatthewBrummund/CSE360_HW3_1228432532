package application;

/**
 * <p>Title: Answer Class.</p>
 * 
 * <p>Description: Represents an answer in a Q&A system with voting and correctness functionality</p>
 * 
 * @author Matthew Thomas Brummund
 * @version 1.00 2025-03-26
 */
public class Answer {
    /** The text content of the answer */
    private String text;
    
    /** The username of the person who provided this answer */
    private String answeredBy;

    /** The number of upvotes this answer has received */
    private int upVote;
    
    /** The number of downvotes this answer has received */
    private int downVote;
    
    /** Whether this answer has been marked as correct */
    private boolean isCorrect;

    /**
     * Constructor to create a new Answer with initial values
     * 
     * @param text The text content of the answer
     * @param answeredBy The username of the person who provided this answer
     */
    public Answer(String text, String answeredBy) {
        this.text = text;
        this.answeredBy = answeredBy;
        this.upVote = 0;
        this.downVote = 0;
        this.isCorrect = false;
    }

    /**
     * Gets the text content of this answer
     * 
     * @return The text content of the answer
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text content of this answer
     * 
     * @param text The new text content for the answer
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets the username of the person who provided this answer
     * 
     * @return The username of the answerer
     */
    public String getAnsweredBy() {
        return answeredBy;
    }

    /**
     * Sets the username of the person who provided this answer
     * 
     * @param answeredBy The new username to associate with this answer
     */
    public void setAnsweredBy(String answeredBy) {
        this.answeredBy = answeredBy;
    }

    /**
     * Gets the number of upvotes this answer has received
     * 
     * @return The upvote count
     */
    public int getUpvotes() {
        return upVote;
    }

    /**
     * Gets the number of downvotes this answer has received
     * 
     * @return The downvote count
     */
    public int getDownvotes() {
        return downVote;
    }

    /**
     * Increments the upvote count for this answer by one
     */
    public void upvote() {
        upVote++;
    }

    /**
     * Increments the downvote count for this answer by one
     */
    public void downvote() {
        downVote++;
    }

    /**
     * Checks if this answer has been marked as correct
     * 
     * @return true if the answer is marked as correct, false otherwise
     */
    public boolean isCorrect() {
        return isCorrect;
    }

    /**
     * Marks this answer as the correct answer
     */
    public void markAsCorrect() {
        this.isCorrect = true;
    }
}