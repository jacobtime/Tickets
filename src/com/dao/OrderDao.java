package com.dao;

import com.bean.Order;
import com.dbc.DbOp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IOrderDao{
    @Override
    public void create(Order order) {
        String CREAT_ORDER = "call orders_insert(" + "\"" + order.getUser() + "\"," + "\"" + order.getID() + "\"," + "\"" + order.getState_from() + "\"," + "\"" + order.getState_to() + "\");";
        DbOp.executeUpdate(CREAT_ORDER);
    }

    @Override
    public void remove(String ID, int state) {
        String DELETE_ORDER = "call orders_delete(" + "\"" + ID + "\","+"\"" + state+ "\");";
        DbOp.executeUpdate(DELETE_ORDER);
    }

    @Override
    public void update(Order order) {
        String UPDATE_ORDER = "call orders_update(" + "\"" + order.getUser() + "\"," + "\"" + order.getID() +  "\"" + "\"" + order.getState_from() +  "\"" + order.getState_to()+ "\");";
        DbOp.executeUpdate(UPDATE_ORDER);
    }

    @Override
    public List<Order> get_all() throws SQLException {
        String GET_ALL_ORDER = "call order_get()";
        ResultSet rs;
        List<Order> OrderList = new ArrayList<>();
        rs = DbOp.executeQuery(GET_ALL_ORDER);
        while (true)
        {
            assert rs != null;
            if (!rs.next()) break;
            Order order = new Order();
            order.setUser(rs.getString("user"));
            order.setID(rs.getString("ID"));
            order.setState_from(rs.getString("state_from"));
            order.setState_to(rs.getString("state_to"));
            order.setFrom_time(rs.getString("start_time"));
            order.setTo_time(rs.getString("arrive_time"));
            order.setCost(rs.getInt("cost"));
            OrderList.add(order);
        }
        return OrderList;
    }

    @Override
    public List<Order> get_one(String user) throws SQLException {
        String GET_ALL_ORDER = "call order_get_one(\"" + user + "\")";
        ResultSet rs;
        List<Order> OrderList = new ArrayList<>();
        rs = DbOp.executeQuery(GET_ALL_ORDER);
        while (true)
        {
            assert rs != null;
            if (!rs.next()) break;
            Order order = new Order();
            order.setUser(rs.getString("user"));
            order.setID(rs.getString("ID"));
            order.setState_from(rs.getString("state_from"));
            order.setState_to(rs.getString("state_to"));
            order.setFrom_time(rs.getString("start_time"));
            order.setTo_time(rs.getString("arrive_time"));
            order.setCost(rs.getInt("cost"));
            OrderList.add(order);
        }
        return OrderList;
    }
}
