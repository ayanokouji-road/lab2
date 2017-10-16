package final_action_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Deleteabook
{
    private Integer isbn;
    public Integer getIsbn() {
        return isbn;
    }
    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }
    public String execute()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://hsxvehklmrty.mysql.sae.sina.com.cn:10605/test";
            Connection conn = DriverManager.getConnection(url,"root","1997wddk");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM book WHERE ISBN = \"" + this.isbn + "\";");
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
