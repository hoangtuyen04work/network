package com.hoangtuyen04work.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
	// this method will mapping result set with any model i past for it
	T mapRow(ResultSet resultSet);
}
