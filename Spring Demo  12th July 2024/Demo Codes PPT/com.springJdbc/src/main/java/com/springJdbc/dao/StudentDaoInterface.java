package com.springJdbc.dao;

import com.springJdbc.entites.Student;

public interface StudentDaoInterface {
	public int insert(Student student);
	public void display();
	public int update(Student student);
	public Student findOne(int id);
}
