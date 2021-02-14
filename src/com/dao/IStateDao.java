package com.dao;

import com.bean.State;
import com.bean.Train;

import java.sql.SQLException;
import java.util.List;

public interface IStateDao {
    public abstract void create(State state);
    public abstract void update(State state);
    public abstract List<State> get_all(String state) throws SQLException;
}
