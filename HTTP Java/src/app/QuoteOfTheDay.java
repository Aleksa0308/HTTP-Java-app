package app;

public class QuoteOfTheDay {
    private String Author;
    private String Quote;

    public QuoteOfTheDay(String author, String quote) {
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

    @Override
    public String toString() {
        return "<label>" + getAuthor() + "</label> <br>" + "<label>" + getQuote() + "</label>";
    }
}
