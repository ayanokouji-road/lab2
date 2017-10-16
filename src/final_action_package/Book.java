package final_action_package;

import java.sql.Date;

public class Book
{
    public int ISBN;
    public String Title;
    public String AuthorID;
    public String Publisher;
    public Date PublishDate;
    public double Price;
    public Book(int ISBN, String Title, String AuthorID, String Publisher, Date PublishDate, double Price)
    {
        this.ISBN=ISBN;
        this.Title=Title;
        this.AuthorID=AuthorID;
        this.Publisher=Publisher;
        this.PublishDate=PublishDate;
        this.Price=Price;
    }
}
