package com.dao;

import com.bean.Item;

import java.sql.SQLException;
import java.util.List;

public interface IItemDao {
    public List<Item> get(String from, String to) throws SQLException;
}
