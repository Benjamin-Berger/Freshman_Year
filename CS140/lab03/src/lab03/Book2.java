package lab03;
/**
 * Class Book2 stores the name and number of pages in a book. It also
 * tracks whether the book is a required textbook and how far into the 
 * book the reader has reached, by page number.
 * @author CS 140
 *
 */
public class Book2 {
    private String title;
    private int pageCount;
    private int bookmark;
    private boolean required;

    /**
     * Constructor that sets the title and number of pages of the book.
     * This constructor assumes the book is a required textbook and 
     * that the reader has not made any progress in the book.
     * @param title the title of the book
     * @param pageCount the number of pages in the book
     */
    public Book2(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
        this.required = true;
        this.bookmark = 0;
    }

    /**
     * Constructor for book that sets all the fields: title, number of pages,
     * whether the book is required and how far the reader has read.
     * @param title the title of the book
     * @param pageCount the number of pages in the book
     * @param required whether the book is a required textbook
     * @param bookmark the page the reader has reached.
     */
    public Book2(String title, int pageCount, boolean required, int bookmark) {
        this.title = title;
        this.pageCount = pageCount;
        this.required = required;
        this.bookmark = bookmark;
    }

    /**
     * Method that indicated whether the book has been completely read.
     * The assumption is that the reader has read all the pages up to 
     * the bookmark.
     * @return true if the whole book has been read.
     */
    public boolean hasBeenRead() {
        return bookmark == pageCount;
    }

    /** 
     * Getter method for the required field.
     * @return the value of the field required.
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * Getter method for the title field of the book.
     * @return the title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter method for the pageCount field of the book.
     * @return the number of pages in the book.
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Getter method for the bookmark field of the book
     * @return the current page number the reader has reached.
     */
    public int getBookmark() {
        return bookmark;
    }

    /**
     * Method to give the amount that the reader has read as 
     * a fraction of the total number of pages.
     * @return the fraction of the book that the reader has read.
     */
    public double computeCompleted() {
        double bookmark1 = bookmark;
        double pageCount1 = pageCount;
        return (bookmark1 / pageCount1);
    }

    /**
     * Setter method for the bookmark field of the book
     * @param newPageNumber the page number that the reader has reached.
     */
    public void setBookmark(int newPageNumber) {
        bookmark = newPageNumber;
    }

    /**
     * The toString method for this class, which gives all the information
     * about the book object in an explanatory form.
     * @return a string contain the values of the fields of the object.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(title);
        builder.append(", ");
        builder.append(pageCount);
        builder.append(", ");
        builder.append(isRequired() ? "" : "not "); // the section operator is described above
        builder.append("required, currently up to page ");
        builder.append(bookmark);
        builder.append(", ");
        builder.append(String.format("%.2f", computeCompleted() * 100));
        builder.append("% completed");
        return builder.toString();
    }

    /**
     * A summary version of toString, which gives the values of the fields
     * in a more condensed form.
     * @return condensed version of the toString method
     */
    public String outputLine() {
        return title + "\t" + pageCount + "\t" + required + "\t" + bookmark;       
    }

}