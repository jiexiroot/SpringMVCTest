package com.springmvc.mapper;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.StatementType;

import java.util.Map;

/**
 * @author GOU
 * @Date 2020-05-19 17:21
 */
public interface UserMapper {
    /**
     * 登陆方法
     * @param name
     * @param password
     * @return
     */
    @Select("select count(*) from users where LoginId=#{user} and LoginPwd=#{pass}")
    int dologin(@Param("user") String name,@Param("pass") String password);

    /**
     *用来注册用户的代理类方法
     * @param dataMap map对象由{"user",user}与{"result",resultId}组成
     */
    @Select({ " {call sp_register(\n" +
            "             #{user.loginId,mode=IN,jdbcType=VARCHAR},\n" +
            "             #{user.loginPwd,mode=IN,jdbcType=VARCHAR},\n" +
            "             #{user.name,mode=IN,jdbcType=VARCHAR},\n" +
            "             #{user.address,mode=IN,jdbcType=VARCHAR},\n" +
            "             #{user.phone,mode=IN,jdbcType=VARCHAR},\n" +
            "             #{user.mail,mode=IN,jdbcType=VARCHAR},\n" +
            "             #{flag,mode=OUT,jdbcType=INTEGER})}"
    })
    @Options(statementType= StatementType.CALLABLE)
    void doRegister(Map<String,Object> dataMap);

}
