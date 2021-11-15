import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class ReaderProfile {
    private String FirstName;
    private String LastName;
    private int Grade;
    private String GradeGroup;
    private String Phone;
    private ArrayList<Book> BorrowedBooks;
    private final String phoneRegEx = "^[+]?[(]?[0-9]{3}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$";

    public ReaderProfile(String firstName, String lastName, int grade, String gradeGroup, String phone) {
        setFirstName(firstName);
        setLastName(lastName);
        setGrade(grade);
        setGradeGroup(gradeGroup);
        setPhone(phone);
        BorrowedBooks = new ArrayList<>();
    }

    public ReaderProfile(){
        this("firstName", "lastName", 1, "a", "123-456-7890");
    }

    public ReaderProfile(String firstName, String lastName, int grade, String gradeGroup, String phone, ArrayList<Book> borrowedBooks) {
        this(firstName, lastName, grade, gradeGroup, phone);
        BorrowedBooks = borrowedBooks;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty() || firstName.isBlank()) throw new IllegalArgumentException("no first name provided");
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty() || lastName.isBlank()) throw new IllegalArgumentException("no last name provided");
        LastName = lastName;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        if(grade < 1 || grade > 12) throw new IllegalArgumentException("invalid grade");
        Grade = grade;
    }

    public String getGradeGroup() {
        return GradeGroup;
    }

    public void setGradeGroup(String gradeGroup) {
        if(gradeGroup == null || gradeGroup.isEmpty() || gradeGroup.isBlank()) throw new IllegalArgumentException("no grade group provided");
        GradeGroup = gradeGroup;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        if(phone == null || phone.isEmpty() || phone.isBlank()) throw new IllegalArgumentException("no phone provided");
        if(!Pattern.compile(phoneRegEx).matcher(phone).matches()) throw new IllegalArgumentException("invalid phone");
        Phone = phone;
    }

    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableList(BorrowedBooks);
    }

    public void addBorrowedBook(Book book){
        if(book ==  null) throw  new IllegalArgumentException("no book provided");
        if(BorrowedBooks.contains(book)) throw new IllegalArgumentException("book already in list");
        BorrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book){
        if(book ==  null) throw  new IllegalArgumentException("no book provided");
        if(!BorrowedBooks.contains(book)) throw new IllegalArgumentException("book not found in list");
        BorrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "ReaderProfile{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Grade=" + Grade +
                ", GradeGroup='" + GradeGroup + '\'' +
                ", Phone='" + Phone + '\'' +
                ", BorrowedBooks=" + BorrowedBooks.toString() +
                "}";
    }
}
