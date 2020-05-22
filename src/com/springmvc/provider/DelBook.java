package com.springmvc.provider;

import org.apache.ibatis.annotations.Param;

/**
 * @author GOU
 * @Date 2020-05-20 10:56
 */
public class DelBook {
    public static String delBooksByIds(@Param("ids")int []bids){
        StringBuffer sql=new StringBuffer();
        sql.append("delete from books where Id in (");
        for (int i=0;i<bids.length;i++){
            sql.append(bids[i]);
            if(i<bids.length-1){
                sql.append(",");
            }
        }
        sql.append(")");
        return sql.toString();
    }
}
