/**
 * 
 */
package com.baobaotao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;

/**
 * @author chenguangjian 2015年3月24日 下午11:27:52
 */
@Repository
public class LoginLogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 * @param loginLog
	 */
	public void insertLoginLog(LoginLog loginLog) {
		String sql = " insert into t_login_log(user_id,ip,login_datetime) values(?,?,?) ";
		Object[] params = { loginLog.getUserID(), loginLog.getIp(),
				loginLog.getLoginDate()

		};

		jdbcTemplate.update(sql, params);
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	public List<LoginLog> findLoginLogByUser(User user) {
		int userId = user.getUserId();
		String sql = " select user_id,ip,login_datetime from t_login_log where user_id = ? ";

		List<LoginLog> loginLogs = new ArrayList<LoginLog>();
		LoginLog loginLog = new LoginLog();

		jdbcTemplate.query(sql, new Object[] { userId },
				new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						loginLog.setUserID(userId);
						loginLog.setIp(rs.getString("ip"));
						loginLog.setLoginDate(rs.getDate("login_datetime"));

						loginLogs.add(loginLog);

					}

				});

		return loginLogs;

	}

}
