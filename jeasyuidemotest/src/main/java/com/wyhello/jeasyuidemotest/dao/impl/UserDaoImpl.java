package com.wyhello.jeasyuidemotest.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.wyhello.jeasyuidemotest.dao.UserDao;
import com.wyhello.jeasyuidemotest.db.RsMappingObject;
import com.wyhello.jeasyuidemotest.db.SQLTemplate;
import com.wyhello.jeasyuidemotest.db.SQLTemplateImpl;
import com.wyhello.jeasyuidemotest.pojo.User;

public class UserDaoImpl implements UserDao {
	
private SQLTemplate sqlT = null;
	
	
	
	public UserDaoImpl() {
		sqlT = new SQLTemplateImpl();
	}

	@SuppressWarnings("unchecked")
	public List<User> queryAll() {
		return (List<User>) sqlT.query("select * from users", null, new UserRsMappingObject());
	}


	public void add(User u) {
		sqlT.update("insert into users (firstname,lastname,phone,email) values (?,?,?,?)", 
				new Object[]{u.getFirstname(),u.getLastname(),u.getPhone(),u.getEmail()});
	}
	
	public void update(User u) {
		sqlT.update("update users set firstname=?,lastname=?,phone=?,email=? where id = ?", 
				new Object[]{u.getFirstname(),u.getLastname(),u.getPhone(),u.getEmail(),u.getId()});
	}
	
	public void remove(User u) {
		sqlT.update("delete from users where id=?", 
				new Object[]{u.getId()});
	}

	
	
	class UserRsMappingObject implements RsMappingObject{

		public Object mapper2Obj(ResultSet rs) {
			User user = null;
			try {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user;
		}
		
	}


	
}
