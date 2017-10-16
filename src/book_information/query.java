package book_information;

import final_action_package.Book;
import com.opensymphony.xwork2.ActionContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

public class query
{
    private ArrayList<Book> booklist;
    private String queryAuthorID;

    Map<String,Object> session;

    public ArrayList<Book> getBooklist() {
        return booklist;
    }
    public void setBooklist(ArrayList<Book> booklist)
    {
        this.booklist=booklist;
    }
    public String getQueryAuthorID()
    {
        return queryAuthorID;
    }
    public void setQueryAuthorID(String queryAuthorID)
    {
        this.queryAuthorID=queryAuthorID;
    }
    public String execute()
    {
        boolean flag=false;
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/test";    //JDBC的URL
            Connection conn = DriverManager.getConnection(url,"root","1997wddk");
            Statement stmt = conn.createStatement(); //创建Statement对象
            String sql = "select * from author";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next())
            {
                if(rs.getString(1).equals(getQueryAuthorID()))
                {
                    flag=true;
                    break;
                }
            }
            rs.close();

            sql = "select * from book";
            rs = stmt.executeQuery(sql);
            booklist=new ArrayList<Book>();
            while (rs.next())
            {
                if(rs.getString(3).equals(getQueryAuthorID()))
                {
                    booklist.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getDouble(6)));
                }
            }
            rs.close();

            stmt.close();
            conn.close();

            ActionContext context=ActionContext.getContext();
            session=context.getSession();
//            ArrayList<Integer> ISBNlist=new ArrayList<Integer>();
//            ArrayList<Integer> ISBNlist=new ArrayList<Integer>();
//            ArrayList<Integer> ISBNlist=new ArrayList<Integer>();
//            ArrayList<Integer> ISBNlist=new ArrayList<Integer>();
//            ArrayList<Integer> ISBNlist=new ArrayList<Integer>();
            session.put("booklist",booklist);

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        if(flag)
        {
            setBooklist(booklist);
            return "success";
        }
        else
        {
            return "fail";
        }
    }
//    public String execute2()
//    {
//        Class.forName("com.mysql.jdbc.Driver");
//        String url="jdbc:mysql://localhost:3306/test";    //JDBC的URL
//        Connection conn = DriverManager.getConnection(url,"root","1997wddk");
//        Statement stmt = conn.createStatement(); //创建Statement对象
//        String sql = "select * from final_action_package.Book";
//        ResultSet rs = stmt.executeQuery(sql);
//        ArrayList<final_action_package.Book> booklist=new ArrayList<final_action_package.Book>();
//        while (rs.next())
//        {
//            if(rs.getString(3).equals(getQueryAuthorID()))
//            {
//                booklist.add(new final_action_package.Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getDouble(6)));
//            }
//        }
//        rs.close();
//        stmt.close();
//        conn.close();
//        return "s";
//    }
}
