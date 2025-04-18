package com.springJdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springJdbc.entites.Student;

public class DAO implements StudentDaoInterface {
	JdbcTemplate jdbcTemplate;

	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		// TODO Auto-generated method stub
		int res=0;
		String query="insert into ZZ_E2297_Student(id,name,city) values(?,?,?)";
		try {
			res=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
			System.out.println("Data inserted......."+res);
		
		}
		catch(Exception E) {
			System.out.println(E.getLocalizedMessage());
		}
		
		return res;	
	}
	
	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		int res=0;
		String query="update ZZ_E2297_Student set name=? , city=? where id=?";
		try {
			res=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
			System.out.println("Data Updated......."+res);
		
		}
		catch(Exception E) {
			System.out.println(E.getLocalizedMessage());
		}
		return res;	
	}
	

	@Override
	public Student findOne(int id) {
		String query="select * from ZZ_E2297_Student where id = ?";
		RowMapper<Student> mapRow=new MyRowMapper();
		try {
			Student result = this.jdbcTemplate.queryForObject(query,mapRow,id );
			return result;
		}
		catch(Exception e) {
			
		}
		return null;
	}
	
	
	
	

	@Override
	public void display() {
	    // TODO Auto-generated method stub
	    List<Map<String, Object>> data = jdbcTemplate.queryForList("select * from ZZ_E2297_Student");
	    
	    for (Map<String, Object> row : data) {
	        for (Map.Entry<String, Object> entry : row.entrySet()) {
	            String key = entry.getKey();
	            Object value = entry.getValue();
	            System.out.println(key + ": " + value);
	        }
	        System.out.println("=========================");
	    }
	}
	
	
	public List<Student> display2() {
	    String query="select * from ZZ_E2297_Student";
	   List<Student> students=this.jdbcTemplate.query(query,new MyRowMapper());
	    
	   return students;
	}

	

}
