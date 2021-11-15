public class Book {
    private String Name;
    private String Author;
    private String Publisher;
    private String ISBN;

    public Book() {
        setName("name");
        setAuthor("author");
        setPublisher("publisher");
        setISBN("ISBN: 978-1-1463-6238-2");
    }

    public Book(String name, String author, String publisher, String ISBN) {
        setName(name);
        setAuthor(author);
        setPublisher(publisher);
        setISBN(ISBN);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty() || name.isBlank()) throw new IllegalArgumentException("no name provided");
        this.Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        if(author == null || author.isEmpty() || author.isBlank()) throw new IllegalArgumentException("no author name provided");
        Author = author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        if(publisher == null || publisher.isEmpty() || publisher.isBlank()) throw new IllegalArgumentException("no publisher name provided");
        Publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        if(ISBN == null || ISBN.isEmpty() || ISBN.isBlank()) throw new IllegalArgumentException("no ISBN provided");
        if(!isISBNValid(ISBN)) throw new IllegalArgumentException("invalid ISBN");
        this.ISBN = ISBN;
    }

    private boolean isISBNValid(String ISBN) {
        ISBN = ISBN.replaceAll("[^0-9]", "");
        if(ISBN.length() != 13) return false;

        int sum=0;

        for(int i = 0; i < ISBN.length(); i++) {
            sum += (ISBN.codePointAt(i) - 48) *
                    ((i % 2 == 0) ? 3 : 1);
        }

        return sum % 10 == 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + Name + '\'' +
                ", Author='" + Author + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()) return false;
        return ((Book) obj).ISBN.equals(this.ISBN);
    }
}
