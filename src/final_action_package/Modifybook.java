package final_action_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Modifybook
{
    private Integer isbn;
    public Integer getIsbn() { return isbn; }
    public void setIsbn(Integer isbn) { this.isbn = isbn; }
    private String modifybookAuthorID;
    private String modifybookPublisher;
    private String modifybookPublishDate;
    private double modifybookPrice;
    public String getModifybookAuthorID() { return modifybookAuthorID; }
    public String getModifybookPublisher() { return modifybookPublisher; }
    public String getModifybookPublishDate() { return modifybookPublishDate; }
    public double getModifybookPrice() { return modifybookPrice; }
    public void setModifybookAuthorID(String modifybookAuthorID) { this.modifybookAuthorID = modifybookAuthorID; }
    public void setModifybookPublisher(String modifybookPublisher) { this.modifybookPublisher = modifybookPublisher; }
    public void setModifybookPublishDate(String modifybookPublishDate) { this.modifybookPublishDate = modifybookPublishDate; }
    public void setModifybookPrice(double modifybookPrice) { this.modifybookPrice = modifybookPrice; }
    public String execute()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://hsxvehklmrty.mysql.sae.sina.com.cn:10605/test";
            Connection conn = DriverManager.getConnection(url,"root","1997wddk");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM author WHERE AuthorID = \"%s\";", this.modifybookAuthorID));
            if (!rs.next())
            {
                return "success";
            }
            rs.close();
            stmt.close();//"UPDATE bookorg SET Author = \"%s\", " + "AuthorID = \"%s\", Publisher = \"%s\", PublishDate = \"%s\", " +"Price = \"%s\" WHERE ISBN = \"%s\";", this.authorName, this.authorId ,this.publisher, this.publishDate, this.price, this.isbn
            stmt = conn.createStatement();
            stmt.executeUpdate(String.format("UPDATE book SET AuthorID = \"%s\", Publisher = \"%s\", PublishDate = \"%s\", Price = \"%f\" WHERE ISBN = \"%d\";", this.modifybookAuthorID , this.modifybookPublisher, this.modifybookPublishDate, this.modifybookPrice, this.isbn));
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
