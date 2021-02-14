package com.dao;

import com.bean.Order;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDao {
    public abstract void create(Order order);
    public abstract void remove(String ID, int state);
    public abstract void update(Order order);
    public abstract List<Order> get_all() throws SQLException;
    public abstract List<Order> get_one(String user) throws SQLException;
}
