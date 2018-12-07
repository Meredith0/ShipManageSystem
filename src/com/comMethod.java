package com;

import java.sql.SQLException;

/**
 * @author: Meredith
 * @date: 2018-12-07 22:44
 * @project: ShipManageSystem
 * @package: com
 * @description: 通用的方法
 */
public class comMethod {

    SQL db = new SQL();
    public boolean islegal(String name,String num) {
        /**
         * @description:  关联船名,船舶登记号
         * @param [name, num] name为船名, num为船舶登记号
         * @return boolean
         * @date: 2018/12/7 22:51
         */
        db.sqlLines = "select * from 船舶所有权登记证书 where 船名=? and 船舶登记号=?";
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
}
