package com;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

/**
 * @Author Meredith
 * @Date 2018/9/7 23:20
 * @Param
 * @Return
 * @Description:  工具类, 包括sql的连接,执行,返回结果以及通用方法等
 **/
public class SQL {

    public String sqlLines;//sql语句
    public static String result[][] = new String[100][100];//返回的结果
    public int effectedLines = 0;//影响行数
    public int row = 0;//行数
    public int col = 1;//列数
    public ResultSet rs = null;
    public PreparedStatement preparedStatement = null;
    Connection connection = null;

    public void pre() {
        /**
         * @description: 预编译 以及连接数据库
         * @param []
         * @return void
         * @date: 2018/11/15 20:54
         */
        String url = "jdbc:sqlserver://localhost:1433;databaseName=船只资料;user=user01;password=123456";//登陆字符串
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url);
            preparedStatement = connection.prepareStatement(sqlLines);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exe(int num) {
        /**
         * @description: 用于执行事务
         * @param []
         * @return void
         * @date: 2018/12/2 23:34
         */
        try {
            //执行sql语句
            preparedStatement.execute();
            //获取4个结果集的影响行数和
            for (int i = 0; i < num; i++) {
                effectedLines += preparedStatement.getUpdateCount();
                preparedStatement.getMoreResults();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatAndConnAndResultSet(preparedStatement, connection, rs);
        }
    }

    public void exeSelect() {
        /**
         * @description: 用于执行select语句
         * @param []
         * @return void
         * @date: 2018/11/15 20:54
         */
        try {
            col = 1;
            row = 0;
            rs = preparedStatement.executeQuery(); //执行sql
            //获取结果
            row = rs.getMetaData().getColumnCount();//获取行数
            //清空数组
            for (int t = 0; t < result.length - 1; t++) {
                for (int t1 = 0; t1 < result[t].length; t1++)
                    result[t][t1] = null;
            }
            //将结果集转换为二维数组
            while (rs.next()) {
                for (int i = 1; i <= row; i++) {
                    result[i][col] = rs.getString(i);
                }
                col++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
             // closeStatAndConnAndResultSet(preparedStatement, connection, rs);
        }
    }

    public void exeSql() {
        /**
         * @description: 用于执行不返回结果集的语句
         * @param []
         * @return void
         * @date: 2018/11/15 20:55
         */
        try {
            effectedLines = preparedStatement.executeUpdate(); //执行sql
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatAndConnAndResultSet(preparedStatement, connection, rs);
        }
    }

    public boolean islegal(String name,String num) {
        /**
         * @description:  检查船名,船舶登记号是否合法
         * @param [name, num] name为船名, num为船舶登记号
         * @return boolean
         * @date: 2018/12/7 22:51
         */
        SQL db = new SQL();
        db.sqlLines = "select * from 船舶所有权登记证书 where 船名=? and 船检登记号=?";
        db.pre();
        try
        {
            db.preparedStatement.setString(1, name);
            db.preparedStatement.setString(2, num);
        } catch (SQLException e1)
        {
            e1.printStackTrace();
        }
        db.exeSelect();
        if (db.result[1][1] == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public void toTable(SQL db,JTable table) {
        /**
         * @description:  打表方法
         * @param [db, table]  db为传入的SQL对象  table为传入的表
         * @return void
         * @date: 2018/11/29 20:33
         */
        //将列名插入到Vector
        Vector columnNames;
        columnNames = new Vector();
        //获取列名
        try {
            for (int i = 1; i < db.rs.getMetaData().getColumnCount() +1; i++) {
                columnNames.add(db.rs.getMetaData().getColumnName(i));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        //二维容器
        Vector rowData = new Vector();
        for (int i = 1; i < db.col; i++)//遍历列
        {
            Vector row = new Vector();
            for (int j = 1; j <= db.row; j++)//遍历行
            {
                row.add(db.result[j][i]);
            }
            rowData.add(row);//将行添加到Vector
        }
        table.setModel(new DefaultTableModel(rowData, columnNames));//打表
        closeStatAndConnAndResultSet(preparedStatement, connection, rs);
    }

    private static void closeStatAndConn(Statement stat, Connection conn) {
        /**
         * @description: 关闭stmt和连接
         * @param [stat, conn]
         * @return void
         * @date: 2018/11/15 20:55
         */
        if (null != stat) {
            try {
                stat.close(); // 关闭statement对象
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (null != conn) {
            try {
                conn.close(); // 关闭连接
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeStatAndConnAndResultSet(Statement stat, Connection conn, ResultSet rs) {
        /**
         * @description: 关闭ResultSet对象, 关闭statement对象, 关闭连接
         * @param [stat, conn, rs]
         * @return void
         * @date: 2018/11/15 20:55
         */
        if (null != rs) {
            try {
                rs.close(); // 关闭ResultSet对象
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (null != stat) {
            try {
                stat.close(); // 关闭statement对象
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (null != conn) {
            try {
                conn.close(); // 关闭连接
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}