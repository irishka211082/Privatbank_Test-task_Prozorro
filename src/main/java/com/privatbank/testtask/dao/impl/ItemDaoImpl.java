package com.privatbank.testtask.dao.impl;

import com.privatbank.testtask.dao.ClassifierItemMapper;
import com.privatbank.testtask.dao.ItemDao;
import com.privatbank.testtask.domain.ClassifierItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ClassifierItem createItem(String id, String name, int type, String parentId) {
        log.debug("Try to add new item to database.");
        String sql = "INSERT INTO ITEMS (id, item_name, item_type, parent_id) VALUES (?,?,?,?)";
        int update = jdbcTemplate.update(sql, id, name, type, parentId);
        if (update == 1) {
            log.debug("Item with id {} was added.", id);
        }
        return getItemById(id);
    }

    @Override
    public ClassifierItem getItemById(String id) {
        log.info("Try to get an item with id {} from database", id);
        String sql = "SELECT * FROM ITEMS WHERE id = ?";
        ClassifierItem item = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new ClassifierItemMapper()
        );
        if (Objects.nonNull(item)) {
            log.debug("Item with id {} was found.", id);
        }
        return item;
    }

    @Override
    public List<ClassifierItem> getAllItems() {
        log.info("Try to get all items from database.");
        String sql = "SELECT * FROM ITEMS";
        List<ClassifierItem> items = jdbcTemplate.query(sql, new ClassifierItemMapper());

        return items;
    }

    @Override
    public List<ClassifierItem> getChildrenOfItem(String parentId) {
        log.info("Try to get children of item with id {}.", parentId);
        String sql = "SELECT * FROM ITEMS WHERE parent_id = ?";
        return jdbcTemplate.query(
                sql,
                new Object[]{parentId},
                new ClassifierItemMapper()
        );
    }

    @Override
    public void truncateTable() {
        jdbcTemplate.execute("TRUNCATE items");
    }
}