package com.springmvc.dao.impl;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springmvc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import com.springmvc.pojo.User;

/**
 * UserDaoImpl实现UserDao接口
 * 通过JdbcTem
 * @author GOU
 *
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//普通用户登陆
	@Override
	public boolean dologin(String name, String password) {

		//定义SQL语句
		String sql = "select * from users where LoginId=? and LoginPwd=?";
		//第二种：通过BeanPropertyRowMapper直接获得List对象，并且其对象可以使用实体类的get方法获取结果集中的数据，但需要结果集中的数据列要与实体类字段与名字一一对应
		List<User> rows1 = jdbcTemplate.query(sql, new java.lang.Object[]{name, password}, new BeanPropertyRowMapper<>(User.class));

		if (rows1.size() != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean doregister(String name, String password, String nickname, String adress, String phone, String mail) {
		//创建存储过程，如果存在旧的存储过程，则重新创建
		jdbcTemplate.execute("DROP PROCEDURE IF EXISTS sp_register;");
		jdbcTemplate.execute("create procedure sp_register(in loginId2 VARCHAR(50),in loginPwd2 VARCHAR(50),in nickName varchar(50),in address2 VARCHAR(200),in phone2 varchar(200),in mail2 varchar(100),out flag int)\n" +
									"BEGIN\n" +
									"\tdeclare name_null varchar(50);\n" +
									"\tdeclare userRoledId2 int;\n" +
									"\tdeclare userStateId2 int;\n" +
									"\tset flag=0,userRoledId2=1,userStateId2=1;\n" +
									"\tselect  `LoginId` into name_null from users where LoginId=loginId2;\n" +
									"\tif ISNULL(name_null) then\n" +
									"\t\tinsert into users(LoginId,LoginPwd,Name,Address,Phone,Mail,UserRoleId,UserStateId) values (loginId2,loginPwd2,nickName,address2,phone2,mail2,userRoledId2,userStateId2);\n" +
									"\t\tset flag=1;\n" +
									"\tend if;\n" +
									"END");
		int flag=rtflag(name, password, nickname, adress, phone, mail);
		if(flag==1){
			return true;
		}else{
			return false;
		}

	}
	public int rtflag(final String username,final String password,final String nickname,final String adress,final String phone,final String mail) {
		int outResult=0;

		SimpleJdbcCall siCall=new SimpleJdbcCall(jdbcTemplate);
		//withoutProcedureColumnMetaDataAccess()意思是不需要数据库存储过程中的变量名与Parameter名字一样
		siCall.withProcedureName("sp_register").withoutProcedureColumnMetaDataAccess();
		siCall.declareParameters(
				new SqlParameter("username",Types.VARCHAR),
				new SqlParameter("password",Types.VARCHAR),
				new SqlParameter("nickname",Types.VARCHAR),
				new SqlParameter("adress",Types.VARCHAR),
				new SqlParameter("phone",Types.VARCHAR),
				new SqlParameter("mail",Types.VARCHAR),
				new SqlOutParameter("flag", Types.INTEGER));
		Map<String, Object> inParamsValue = new HashMap<String, Object>();
		inParamsValue.put("username", username);
		inParamsValue.put("password", password);
		inParamsValue.put("nickname", nickname);
		inParamsValue.put("adress", adress);
		inParamsValue.put("phone", phone);
		inParamsValue.put("mail", mail);
		Map<String, Object> resultMap=siCall.execute(inParamsValue);
		outResult=(int) resultMap.get("flag");
		return outResult;
	}
}
