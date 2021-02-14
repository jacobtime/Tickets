package com.dao;

import com.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    public abstract void create(User user);
    public abstract void remove(String user);
    public abstract void update(String user, String pass);
    public abstract List<User> get_all() throws SQLException;
}
