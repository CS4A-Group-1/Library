import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Compartment implements Serializable {

    // Due Date Constant
    private final long DUE_DATE_OFFSET = 14L * 24 * 60 * 60 * 1000; // set to 14 days

    private Item item;
    private boolean isCheckedOut;
    private String currentBorrower;
    private Date checkoutDate;

    // You must create a compartment with a valid item in it
    public Compartment(Item i) {
        if (i == null)
            throw new IllegalStateException("Item cannot be null.");

        this.isCheckedOut = false;
        this.currentBorrower = null;
        this.checkoutDate = null;
        this.item = i;
    }

    // If item is already checked out, return false.
    public boolean checkOut(String borrower) {
        if (isCheckedOut) return false;

        this.isCheckedOut = true;
        this.currentBorrower = borrower;
        this.checkoutDate = new Date();

        return this.isCheckedOut;
    }

    // If item is already checked in, return false
    public boolean checkIn() {
        if (!isCheckedOut) return false;

        this.isCheckedOut = false;
        this.currentBorrower = null;
        this.checkoutDate = null;

        return this.isCheckedOut;
    }

    // GETTERS
    public Item getItem() {
        return new Item(this.item); //Assumes Item has defined a 'copy constructor'
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public String getCurrentBorrower() {
        return currentBorrower;
    }

    public Date getCheckoutDate() {
        return new Date(checkoutDate.getTime());
    }

    public Date getDueDate() {
        if (checkoutDate == null) return null;

        return new Date(checkoutDate.getTime() + DUE_DATE_OFFSET);
    }

    public long getDueDateOffset(){
        return DUE_DATE_OFFSET;
    }

}
