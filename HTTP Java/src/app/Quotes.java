package app;

public class Quotes {
    private String Author;
    private String Quote;

    public Quotes(String author, String quote) {
        Author = author;
        Quote = quote;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getQuote() {
        return Quote;
    }

    public void setQuote(String quote) {
        Quote = quote;
    }
}
