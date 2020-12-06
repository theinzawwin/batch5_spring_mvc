package com.best.spring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.best.spring.model.Item;

public class ItemDao {

	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	public int saveItem(Item e){  
	   String query="insert into items(name,price,qty,color) values('"+e.getName()+"','"+e.getPrice()+"','"+e.getQty()+"','"+e.getColor()+"')";
	    return jdbcTemplate.update(query);  
	}  
	
	public Boolean saveItemWithPrepared(Item item) {
		String query="insert into items(name,price,qty,color) values(?,?,?,?)";
		return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setString(1, item.getName());
				ps.setDouble(2, item.getPrice());
				ps.setInt(3, item.getQty());
				ps.setString(4, item.getColor());
				return ps.execute();
			}
		} );
	}
	public List<Item> getAllItemList(){
		String query="select * from items";
		return jdbcTemplate.query(query, new RowMapper<Item>() {
			@Override
			public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Item i=new Item();
				i.setName(rs.getString("name"));
				i.setPrice(rs.getDouble("price"));
				i.setQty(rs.getInt("qty"));
				i.setColor(rs.getString("color"));
				return i;
			}
		});
	}
}
