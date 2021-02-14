package com.dao;

import com.bean.Train;
import com.dbc.DbOp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainDao implements ITrainDao{

    @Override
    public void create(Train train) {
        String CREAT_TRAIN = "call train_insert(" + "\"" + train.getID() + "\"," + "\"" + train.getSeat() + "\"," +  "\"" + train.getType() + "\");";
        DbOp.executeUpdate(CREAT_TRAIN);
    }

    @Override
    public void remove(String train) {
        String DELETE_TRAIN = "call train_delete(" +"\"" + train + "\");";
        DbOp.executeUpdate(DELETE_TRAIN);
    }

    @Override
    public void update(Train train) {
        String UPDATE_TRAIN = "call train_update(" + "\"" + train.getID() + "\"," + "\"" + train.getSeat() + "\"," +  "\"" + train.getType() + "\");";
        DbOp.executeUpdate(UPDATE_TRAIN);
    }

    @Override
    public List<Train> get_all() throws SQLException {
        String GET_ALL_TRAIN = "call train_get()";
        ResultSet rs;
        List<Train> TrainList = new ArrayList<>();
        rs = DbOp.executeQuery(GET_ALL_TRAIN);
        while (true)
        {
            assert rs != null;
            if (!rs.next()) break;
            Train train = new Train();
            train.setID(rs.getString("ID"));
            train.setSeat(rs.getString("seats"));
            train.setRemain(rs.getString("remain"));
            train.setType(rs.getString("type"));
            TrainList.add(train);
        }
        return TrainList;
    }

    @Override
    public boolean buy_one(String train) throws SQLException{
        String BUY_ONE = "call train_decrease(\"" + train + "\");";
        ResultSet rs = DbOp.executeQuery(BUY_ONE);
        assert rs != null;
        if(rs.next())
            return rs.getBoolean(0);
        return false;
    }

    @Override
    public List<Train> get(Train trains) throws SQLException {
        String GET_TRAIN = "call get_train(" + "\"" + trains.getID() + "%\"," + "\"" + trains.getType() + "%\");";
        ResultSet rs;
        List<Train> TrainList = new ArrayList<>();
        rs = DbOp.executeQuery(GET_TRAIN);
        while (true) {
            assert rs != null;
            if (!rs.next()) break;
            Train train = new Train();
            train.setID(rs.getString("ID"));
            train.setSeat(rs.getString("seats"));
            train.setRemain(rs.getString("remain"));
            train.setType(rs.getString("type"));
            TrainList.add(train);
        }
        return TrainList;
    }
}
