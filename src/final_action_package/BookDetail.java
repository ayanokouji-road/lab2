package final_action_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookDetail
{
    private String title;
    private String isbn;
    private String authorID;
    private String publisher;
    private String publishDate;
    private String price;
    private String name;
    private String age;
    private String country;
    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public String getAuthorID() { return authorID; }
    public String getPublisher() { return publisher; }
    public String getPublishDate() { return publishDate; }
    public String getPrice() { return price; }
    public String getName() { return name; }
    public String getAge() { return age; }
    public String getCountry() { return country; }
    public void setTitle(String title) { this.title=title; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setAuthorID(String authorID) { this.authorID = authorID; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setPublishDate(String publishDate) { this.publishDate = publishDate; }
    public void setPrice(String price) { this.price = price; }
    public void setName(String name) { this.name = name; }
    public void setAge(String age) { this.age = age; }
    public void setCountry(String country) { this.country = country; }
    public String execute() throws Exception
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://hsxvehklmrty.mysql.sae.sina.com.cn:10605/test";
            Connection conn = DriverManager.getConnection(url,"root","1997wddk");
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM book WHERE title = \"" + this.title + "\";";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next())
            {
                isbn = rs.getString("ISBN");
                authorID = rs.getString("AuthorID");
                publisher = rs.getString("Publisher");
                publishDate = rs.getString("PublishDate");
                price = rs.getString("Price");
            }
            rs.close();
            sql="SELECT * FROM author WHERE AuthorID = \"" + this.authorID + "\";";
            rs = stmt.executeQuery(sql);
            if (rs.next())
            {
                name=rs.getString("Name");
                age=rs.getString("Age");
                country=rs.getString("Country");
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "success";
    }
}
