package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public class UserDaoImpl implements UserDao {
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void register(User user) {
String sql = "insert into users values(?,?,?,?,?,?,?)";
String sql2 = "insert into users2 values(?,?,?,?,?,?,?)";

StringBuilder sb = new StringBuilder(user.getPhone());
for (int i = 0; i < sb.length(); i++) {
	if (sb.charAt(i) == '(' || sb.charAt(i) == ')' || sb.charAt(i) == ' ' || sb.charAt(i) == '-') {
		sb.deleteCharAt(i);
	}
}

String s = sb.toString().replaceAll("\\s+","");
		
		jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
			    user.getLastname(), user.getEmail(), user.getAddress(), sb.toString() });
		
		jdbcTemplate.update(sql2, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
			    user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
		
	}

	public User validateUser(Login login) {
		String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
	    + "'";
		
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size()> 0 ? users.get(0) : null;
	}

	public List<User> getUsers() {
		String sql = "select * from users2";
		return jdbcTemplate.query(sql, new RowMapper<User>() {

			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				
				User u = new User();
				u.setUsername(rs.getString(1));
				u.setPassword(rs.getString(2));
				u.setFirstname(rs.getString(3));
				u.setLastname(rs.getString(4));
				u.setEmail(rs.getString(5));
				
				u.setAddress(rs.getString(6));
				u.setPhone(rs.getString(7));
				
				
				String phone = u.getPhone();
				String s = "(";
				for (int i = 0; i < phone.length(); i++) {
					if (s.length() == 4) {
						s= s+")";
					}
					else if (s.length() == 9) {
						s= s+"-";
					}
					
						s=s+ phone.charAt(i);
					
					
				}
				
				
				
				
				
				
				/*String ph;
				char chArr[] = phone.toCharArray();
				for (int i = 0; i < chArr.length; i++) {
					
				}*/
				System.out.println(s);
				
				
				return u;
			}
			
		});
	}

	public void delete(String username) {
		String sql="delete from users where username=?";  
	     jdbcTemplate.update(sql , new Object[] {username});
		
	}

	public int update(User user) {
		String sql="update users set username = ?, password = ?, firstname = ?, lastname = ?, email = ?, address = ?, phone= ? where username = ?" ;  
	    return jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
			    user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone(), user.getUsername() });   
		
	}

	public User getUserByUsername(String username) {
		String sql="select * from users where username=?";  
	    return jdbcTemplate.queryForObject(sql, new Object[]{username},new BeanPropertyRowMapper<User>(User.class));  
	}

}
