package com.dao;

import com.bean.Item;
import com.bean.Train;
import com.dbc.DbOp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDao implements IItemDao {
    @Override
    public List<Item> get(String from, String to) throws SQLException {
        List<Item> ItemList = new ArrayList<>();
        String sql = "call search_check(" + "\"" + from + "\"" +  ",\"" + to + "\");";
        ResultSet rs = DbOp.executeQuery(sql);
        while (true) {
            assert rs != null;
            if (!rs.next()) break;
            Item item = new Item();
            item.setID(rs.getString("ID"));
            item.setType(rs.getString("type"));
            item.setStart_time(rs.getString("start_time"));
            item.setEnd_time(rs.getString("end_time"));
            item.setRemain(rs.getInt("remain"));
            item.setCost(rs.getInt("cost"));
            item.setTime(rs.getInt("time"));
            ItemList.add(item);
        }
        return ItemList;
    }
}
