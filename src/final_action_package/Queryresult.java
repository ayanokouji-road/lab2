package final_action_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class Queryresult
{
    private String queryAuthorID;
    private LinkedList<String> titleList;
    private LinkedList<Integer> isbnList;
    public String getQueryAuthorID() { return queryAuthorID; }
    public LinkedList<String> getTitleList() { return titleList; }
    public LinkedList<Integer> getIsbnList() { return isbnList; }
    public void setQueryAuthorID(String queryAuthorID) { this.queryAuthorID = queryAuthorID; }
    public void setTitleList(LinkedList<String> titleList) { this.titleList = titleList; }
    public void setIsbnList(LinkedList<Integer> isbnList) { this.isbnList = isbnList; }
    public String execute() throws Exception
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://hsxvehklmrty.mysql.sae.sina.com.cn:10605/test";//addigbwiurdb.mysql.sae.sina.com.cn:10664/test
            Connection conn = DriverManager.getConnection(url,"root","1997wddk");
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM book WHERE AuthorID = \"" + this.queryAuthorID + "\";";
            ResultSet rs = stmt.executeQuery(sql);
            this.titleList=new LinkedList<>();
            this.isbnList=new LinkedList<>();
            while (rs.next())
            {
                this.titleList.add(rs.getString("title"));
                this.isbnList.add(rs.getInt("ISBN"));
            }
            if(this.titleList.size()>0)
            {
                flag=true;
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if(flag)
            return "success";
        else
            return "fail";
    }
}
