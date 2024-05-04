package com.hoangtuyen04work.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hoangtuyen04work.dao.IGenericDAO;
import com.hoangtuyen04work.mapper.RowMapper;

public class GenericDAO<T> implements IGenericDAO<T> {

	@Override
	public Connection getConnection() {
		try {
			String url = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;trustServerCertificate=true";
			String user = "sa";
			String password = "12345678";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void setParameters(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if (parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				} else if (parameter == null) {
					statement.setNull(index, java.sql.Types.NULL);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public T findById(String sql, RowMapper<T> rowMapper, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Long id = null;
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return rowMapper.mapRow(resultSet);
			}
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
		return null;
	}

	@Override
	public T getById(String sql, RowMapper<T> rowMapper, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			resultSet = statement.executeQuery();
			Long id = null;
			if (resultSet.next()) {
				connection.commit();
				return rowMapper.mapRow(resultSet);
			}
			connection.commit();
			return null;
		} catch (Exception e) {
			// Log the exception or handle it appropriately
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException ee) {
					return null;
				}
			}
		} finally {
			// Close resources in reverse order of creation
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// Log the exception or handle it appropriately
				e.printStackTrace();
			}
		}

		return null; // Return null if no result or error occurred
	}

	@Override
	public T set(String sql, RowMapper<T> rowMapper, Object... parameters) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameters(preparedStatement, parameters);
			preparedStatement.executeUpdate(); // Thực thi truy vấn INSERT và trả về số lượng bản ghi được thêm vào
			// Lấy ra kết quả từ truy vấn và ánh xạ sang đối tượng User
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				connection.commit();
				return rowMapper.mapRow(resultSet);
			}
			connection.commit();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException ee) {
					return null;
				}
			}
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	@Override
	public List<T> getList(String sql, RowMapper<T> rowMapper, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameters(statement, parameters);
			resultSet = statement.executeQuery(); // Thực hiện truy vấn và nhận kết quả
			List<T> list = new ArrayList<>();
			while (resultSet.next()) {
				System.out.println(resultSet.getString("content"));
				list.add(rowMapper.mapRow(resultSet));
			}
			connection.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException ee) {
					return null;
				}
			}
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

}
