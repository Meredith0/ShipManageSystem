package com;

import java.sql.*;

/**
 * @Author Meredith
 * @Date 2018/9/7 23:20
 * @Param
 * @Return
 * @Description:
 **/
public class SQL
{
    public String sqlLines;
    public static String result[][] = new String[100][100];
    public int effectedLines = 0;
    public ResultSet rs = null;
    public PreparedStatement preparedStatement = null;
    Connection connection = null;
    public int row=0;//行数
    public int col=1;//列数
    public void pre()
    {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=船只资料数据库;user=user01;password=123456";
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url);
            preparedStatement = connection.prepareStatement(sqlLines);
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public void exeSelect()
    {
        try
        {
            col=1;
            row=0;
            rs = preparedStatement.executeQuery(); //执行sql
            //获取结果
            row = rs.getMetaData().getColumnCount();//获取行数
            //清空数组
            for (int t = 0; t < result.length - 1; t++)
            {
                for (int t1 = 0; t1<result[t].length; t1++)
                    result[t][t1] = null;
            }

            while (rs.next())
            {
                for (int i = 1; i <= row; i++)
                {
                    result[i][col] = rs.getString(i);
                }
                col++;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            closeStatAndConnAndResultSet(preparedStatement, connection, rs);
        }

    }

    public void exeSql()
    {
        try
        {
            effectedLines = preparedStatement.executeUpdate(); //执行sql
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            closeStatAndConnAndResultSet(preparedStatement, connection, rs);
        }
    }

    private static void closeStatAndConn(Statement stat, Connection conn)
    {
        if (null != stat)
        {
            try
            {
                stat.close(); // 关闭statement对象
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if (null != conn)
        {
            try
            {
                conn.close(); // 关闭连接
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }


    private static void closeStatAndConnAndResultSet(Statement stat, Connection conn, ResultSet rs)
    {
        if (null != rs)
        {
            try
            {
                rs.close(); // 关闭ResultSet对象
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if (null != stat)
        {
            try
            {
                stat.close(); // 关闭statement对象
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if (null != conn)
        {
            try
            {
                conn.close(); // 关闭连接
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}