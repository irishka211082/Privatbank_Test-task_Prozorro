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
    public ClassifierItem createItem(String id, String itemName, int itemType, String parentId) {
        log.info("Try to add new item to database.");
        String SQL = "INSERT INTO ITEMS (id, itemName, itemType, parentId) VALUES (?,?,?,?)";
        int update = jdbcTemplate.update(SQL, id, itemName, itemType, parentId);
        if (update == 1) {
            log.debug("Item with id {} was added.", id);
        }
        return getItemById(id);
    }

    @Override
    public ClassifierItem getItemById(String id) {
        log.info("Try to get an item with id {] from database", id);
        String SQL = "SELECT * FROM ITEMS WHERE id = ?";
        ClassifierItem item = jdbcTemplate.queryForObject(
                SQL,
                new Object[]{id},
                new ClassifierItemMapper()
        );
        if (Objects.nonNull(item)) {
            log.debug("Item with id {] was found.", id);
        }
        return item;
    }

    @Override
    public List<ClassifierItem> getAllItems() {
        log.info("Try to get all items from database.");
        String SQL = "SELECT * FROM ITEMS";
        List<ClassifierItem> items = jdbcTemplate.query(SQL, new ClassifierItemMapper());
        if (Objects.nonNull(items)) {
            log.debug("{} items was found in database", items.size());
        }
        return items;
    }

    @Override
    public List<ClassifierItem> getChildrenOfItem(String parentId) {
        log.info("Try to get children of item with id {}.", parentId);
        String SQL = "SELECT * FROM ITEMS WHERE parent_id = ?";
        List<ClassifierItem> items = jdbcTemplate.query(
                SQL,
                new Object[]{parentId},
                new ClassifierItemMapper()
        );
        if (Objects.nonNull(items)) {
            log.debug("{} child-items were received from database for item with id {}",
                    items.size(), parentId);
        }
        return items;
    }

    @Override
    public void removeItem(String id) {
        log.debug("Try to delete item with id {}.", id);
        String SQL = "DELETE FROM ITEMS WHERE id = ?";
        int update = jdbcTemplate.update(SQL, id);
        if (Objects.nonNull(update)) {
            log.debug("The item with id {} was removed ftom database successfully!", id);
        }
    }
}
