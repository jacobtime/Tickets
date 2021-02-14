package com.global;

import com.bean.*;
import com.dao.*;

import java.sql.SQLException;
import java.util.List;

public class Global_var {
    private static String user = "guest";
    private static final ItemDao itemDao = new ItemDao();
    private static final OrderDao orderDao = new OrderDao();
    private static final UserDao userDao = new UserDao();
    private static final StateDao stateDao = new StateDao();
    private static final TrainDao trainDao = new TrainDao();

    public static void setUser(String n) {
        user = n;
    }
    public static String getUser(){
        return user;
    }
    public static List<Item> getItem(String from, String to) throws SQLException {return itemDao.get(from, to);}
    public static void insert_order(Order order) throws SQLException {orderDao.create(order);trainDao.buy_one(order.getID());};
    public static List<Order> getOrder(String user) throws SQLException {return orderDao.get_one(user);}
    public static List<Order> getAllOrder() throws  SQLException{return orderDao.get_all();}
    public static List<User> getAllUser() throws  SQLException{return userDao.get_all();}
    public static List<State> getAllState(String train) throws  SQLException{return stateDao.get_all(train);}
    public static List<Train> getAllTrain() throws  SQLException{return trainDao.get_all();}
    public static void train_delete(String train) { trainDao.remove(train);}
    public static void train_add(Train train) { trainDao.create(train);}
    public static void train_modify(Train train){trainDao.update(train);}
    public static List<Train> train_find(Train train) throws SQLException {return trainDao.get(train);}
    public static void User_delete(String user) { userDao.remove(user);}
    public static void User_add(User user) { userDao.create(user);}
    public static void User_modify(User user){userDao.update(user.getUser(), user.getPass());}
    public static void State_add(State state) { stateDao.create(state);}
    public static void State_modify(State state){stateDao.update(state);}
}
