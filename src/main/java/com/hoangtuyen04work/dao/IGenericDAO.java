package com.hoangtuyen04work.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.hoangtuyen04work.mapper.RowMapper;

public interface IGenericDAO<T> {
    T findById(String sql,  RowMapper<T> rowMapper, Object...parameters);
    Connection getConnection();
    void setParameters(PreparedStatement statement, Object...parameters);
    T getById(String sql, RowMapper<T> rowMapper, Object...parameters);
    T set(String sql, RowMapper<T> rowMapper, Object...parameters);
    List<T> getList(String sql, RowMapper<T> rowMapper, Object...parameters);
}
