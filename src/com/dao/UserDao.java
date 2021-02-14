package com.dao;

import com.bean.User;
import com.dbc.DbOp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public void create(User user) {
        String CREAT_USER = "call account_insert(" + "\"" + user.getUser() + "\"," + "\"" + user.getPass() + "\"," +  "\"" + user.getSex() + "\"," + "\"" + user.getID_card() + "\");";
        DbOp.executeUpdate(CREAT_USER);
    }

    @Override
    public void remove(String user) {
        String DELETE_USER = "call account_delete(" +"\"" + user+ "\");";
        DbOp.executeUpdate(DELETE_USER);
    }

    @Override
    public void update(String user, String pass) {
        String UPDATE_USER = "call account_update(" + "\"" + user + "\"," + "\"" + pass + "\");";
        DbOp.executeUpdate(UPDATE_USER);
    }

    @Override
    public List<User> get_all() throws SQLException {
        String GET_ALL_USER = "call account_get()";
        ResultSet rs;
        List<User> UserList = new ArrayList<>();
        rs = DbOp.executeQuery(GET_ALL_USER);
        while (true)
        {
            assert rs != null;
            if (!rs.next()) break;
            User user = new User();
            user.setUser(rs.getString("user"));
            user.setIs_admin(rs.getString("is_admin"));
            user.setSex(rs.getString("sex"));
            user.setID_card(rs.getString("ID_card"));
            UserList.add(user);
        }
        return UserList;
    }
}
