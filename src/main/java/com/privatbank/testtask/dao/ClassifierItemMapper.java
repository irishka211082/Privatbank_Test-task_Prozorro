package com.privatbank.testtask.dao;

import com.privatbank.testtask.domain.ClassifierItem;
import com.privatbank.testtask.domain.ClassifierType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassifierItemMapper implements RowMapper<ClassifierItem> {
    public ClassifierItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ClassifierItem.builder()
                .id(rs.getString("id"))
                .name(rs.getString("name"))
                .type(ClassifierType.values()[Integer.parseInt(rs.getString("type"))])
                .parentId(rs.getString("parent_id"))
                .build();
    }
}
