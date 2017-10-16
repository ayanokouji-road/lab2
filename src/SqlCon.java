import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlCon
{
    public static void main(String[] args)throws Exception
    {
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/test";    //JDBC的URL
            Connection conn = DriverManager.getConnection(url,    "root","1997wddk");
            Statement stmt = conn.createStatement(); //创建Statement对象
            String sql = "select * from book";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()){
                System.out.print(rs.getInt(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.print(rs.getString(4) + "\t");
                System.out.print(rs.getDate(5) + "\t");
                System.out.print(rs.getDouble(6) + "\t");
                System.out.println();
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
        Connection con =null;
        Statement stat=null;
        ResultSet rs=null;

    public SqlCon()
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");//连接驱动
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1997wddk");//连接数据库
                stat=con.createStatement();
            }
            catch(Exception e)
            {
                con=null;
        }
    }

    public ResultSet executeQuery(String sql)
    {
        try
        {
            rs=stat.executeQuery(sql);
        }

        catch(Exception e)
        {
            rs=null;
        }
        return rs;
    }

    public int executeUpdate(String sql)
    {
        try
        {
            stat.executeUpdate(sql);
            return 0;
        }
        catch(Exception e)
        {
            return -1;
        }
    }
}
//<action name="querysuccess_information" class="book_information.query" method="execute">

//</action>
