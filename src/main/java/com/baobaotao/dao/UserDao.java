/**
 * 
 */
package com.baobaotao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.User;
import com.baobaotao.result.Result;
import com.baobaotao.utils.MD5Utils;

/**
 * @author chenguangjian 2015年3月23日 下午10:23:13
 */
@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("#{salt['baotao.password.salt']}")
	private String salt;

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public Result<String> regist(String userName, String password)
			throws Exception {
		String sql = " insert into t_user(user_name,password) values( ?, ? ) ";

		String enPassword = MD5Utils.encryptWithSalt(password, salt);
		Object[] params = { userName, enPassword };

		jdbcTemplate.update(sql, params);

		return new Result<String>(userName);

	}

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public int getMatchCount(String userName, String password) throws Exception {
		String sql = " select count(*) from t_user "
				+ " where user_name = ? and password = ? ";
		String enPassword = MD5Utils.encryptWithSalt(password, salt);
		return jdbcTemplate.queryForInt(sql, new Object[] { userName,
				enPassword });
	}

	/**
	 * @final userName
	 * @return User
	 */
	public User findUserByUserName(final String userName) {

		String sql = " select user_id,user_name,credit "
				+ " from t_user where user_name = ? ";

		final User user = new User();

		jdbcTemplate.query(sql, new Object[] { userName },

		new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(userName);
				user.setCredit(rs.getInt("credit"));

			}
		});

		return user;
	}

	/**
	 * 
	 * @param user
	 */
	public void updateLoginInfo(User user) {
		String sql = " update t_user set last_visit=?,last_ip=?,credit=? "
				+ " where user_id=? ";
		jdbcTemplate.update(
				sql,
				new Object[] { user.getLastVisit(), user.getLastIP(),
						user.getCredit(), user.getUserId() });
	}

}
