package com.dao;

import com.bean.State;
import com.bean.User;
import com.dbc.DbOp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StateDao implements IStateDao {
    @Override
    public void create(State state) {
        String CREAT_STATE = "call state_insert(" + "\"" + state.getID() + "\"," + "\"" + state.getState_ID() + "\"," +  "\"" + state.getCost() + "\"," + "\"" + state.getState_name() + "\"," + "\"" + state.getArrive_time() + "\");";
        DbOp.executeUpdate(CREAT_STATE);
    }

    @Override
    public void update(State state) {
        String UPDATE_STATE = "call state_update(" + "\"" + state.getID() + "\","  + "\"" + state.getState_ID() + "\"," +  "\"" + state.getCost() + "\"," + "\"" + state.getState_name() + "\"," + "\"" + state.getArrive_time() + "\");";
        DbOp.executeUpdate(UPDATE_STATE);
    }

    @Override
    public List<State> get_all(String train) throws SQLException {
        String GET_ALL_STATE = "call state_get(" + train +"\");";
        ResultSet rs;
        List<State> StateList = new ArrayList<>();
        rs = DbOp.executeQuery(GET_ALL_STATE);
        while (true)
        {
            assert rs != null;
            if (!rs.next()) break;
            State state = new State();
            state.setID(rs.getString("ID"));
            state.setState_ID(rs.getInt("state_id"));
            state.setCost(rs.getInt("pay_from_start"));
            state.setState_name(rs.getString("state_name"));
            state.setArrive_time(rs.getString("arrive_name"));
            StateList.add(state);
        }
        return StateList;
    }
}
