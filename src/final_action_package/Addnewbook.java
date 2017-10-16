package final_action_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Addnewbook
{
    private String newbookTitle;
    private String newbookAuthorID;
    private String newbookPublisher;
    private String newbookPublishDate;
    private double newbookPrice;
    private String newbookName;
    private Integer newbookAge;
    private String newbookCountry;
    public String getNewbookTitle() { return newbookTitle; }
    public String getNewbookAuthorID() { return newbookAuthorID; }
    public String getNewbookPublisher() { return newbookPublisher; }
    public String getNewbookPublishDate() { return newbookPublishDate; }
    public double getNewbookPrice() { return newbookPrice; }
    public String getNewbookName() { return newbookName; }
    public Integer getNewbookAge() { return newbookAge; }
    public String getNewbookCountry() { return newbookCountry; }
    public void setNewbookTitle(String newbookTitle) { this.newbookTitle = newbookTitle; }
    public void setNewbookAuthorID(String newbookAuthorID) { this.newbookAuthorID = newbookAuthorID; }
    public void setNewbookPublisher(String newbookPublisher) { this.newbookPublisher = newbookPublisher; }
    public void setNewbookPublishDate(String newbookPublishDate) { this.newbookPublishDate = newbookPublishDate; }
    public void setNewbookPrice(double newbookPrice) { this.newbookPrice = newbookPrice; }
    public void setNewbookName(String newbookName) { this.newbookName = newbookName; }
    public void setNewbookAge(Integer newbookAge) { this.newbookAge = newbookAge; }
    public void setNewbookCountry(String newbookCountry) { this.newbookCountry = newbookCountry; }
    public String execute()
    {
        end:try
        {
            int new_isbn=0;
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://hsxvehklmrty.mysql.sae.sina.com.cn:10605/test";//hsxvehklmrty.mysql.sae.sina.com.cn:10605
            Connection conn = DriverManager.getConnection(url,"root","1997wddk");
            Statement stmt = conn.createStatement();
            String sql = "select * from book";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                if(rs.getString("Title").equals(getNewbookTitle()))
                {
                    break end;
                }
            }
            rs.close();

            boolean flag_isbn=true;
            while(flag_isbn)
            {
                new_isbn=(int)(Math.random()*(9999-1000+1))+1000;
                sql="SELECT * FROM book WHERE ISBN = \"" + new_isbn + "\";";
                rs=stmt.executeQuery(sql);
                if(!rs.next())
                {
                    flag_isbn=false;
                }
                rs.close();
            }

            sql=String.format("INSERT INTO book (ISBN, Title, " +
                            "Publisher, PublishDate, Price, " +
                            "AuthorID) VALUES (\"%d\", \"%s\", \"%s\", \"%s\", \"%f\", \"%s\");", new_isbn, this.newbookTitle, this.newbookPublisher,this.newbookPublishDate,this.newbookPrice,this.newbookAuthorID);
            stmt.executeUpdate(sql);
            stmt.close();

            stmt = conn.createStatement();
            sql="SELECT * FROM author WHERE AuthorID = \"" + this.newbookAuthorID + "\";";
            rs=stmt.executeQuery(sql);
            if(!rs.next())
            {
                stmt.close();
                stmt = conn.createStatement();
                sql=String.format("INSERT INTO author (AuthorID, Name" +
                                ", Age, Country) VALUES (\"%s\", \"%s\", \"%d\", \"%s\")", this.newbookAuthorID, this.newbookName,
                        this.newbookAge, this.newbookCountry);
                stmt.executeUpdate(sql);
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
