package com.dao;

import com.bean.Train;

import java.sql.SQLException;
import java.util.List;

public interface ITrainDao {
    public abstract void create(Train train);
    public abstract void remove(String train);
    public abstract void update(Train train);
    public abstract List<Train> get_all() throws SQLException;
    public abstract boolean buy_one(String user) throws SQLException;
    public abstract List<Train> get(Train train)throws SQLException;
}
