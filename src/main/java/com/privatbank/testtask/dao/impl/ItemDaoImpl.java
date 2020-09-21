package com.privatbank.testtask.dao.impl;

import com.privatbank.testtask.dao.ClasiifierItemMapper;
import com.privatbank.testtask.dao.ItemDao;
import com.privatbank.testtask.domain.ClassifierItem;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ClassifierItem createItem(String id, String itemName, int itemType, String parentId) {
        String SQL = "INSERT INTO ITEMS (id, itemName, itemType, parentId) VALUES (?,?,?,?)";
        jdbcTemplate.update(SQL, id, itemName, itemType, parentId);
        return getItemById(id);
    }

    @Override
    public ClassifierItem getItemById(String id) {
        String SQL = "SELECT * FROM ITEMS WHERE id = ?";
        ClassifierItem item = jdbcTemplate.queryForObject(
                SQL,
                new Object[]{id},
                new ClasiifierItemMapper()
        );
        return item;
    }

    @Override
    public List<ClassifierItem> getAllItems() {
        String SQL = "SELECT * FROM ITEMS";
        List<ClassifierItem> items = jdbcTemplate.query(SQL, new ClasiifierItemMapper());
        return items;
    }

    @Override
    public List<ClassifierItem> getChildrenOfItem(String parentId) {
        String SQL = "SELECT * FROM ITEMS WHERE parent_id = ?";
        List<ClassifierItem> items = jdbcTemplate.query(
                SQL,
                new Object[]{parentId},
                new ClasiifierItemMapper()
        );
        return items;
    }

    @Override
    public void removeItem(String id) {
        String SQL = "DELETE FROM ITEMS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }
}
