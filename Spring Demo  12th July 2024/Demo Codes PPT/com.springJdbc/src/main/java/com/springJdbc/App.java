package com.springJdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.springJdbc.dao.DAO;
import com.springJdbc.entites.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springJdbc/config.xml");

		DAO dao= context.getBean("studentdao", DAO.class);
		
		Student student=new Student();
		
		student.setId(600100);
		student.setName("Softeon");
		student.setCity("Chennai");
		
//		dao.insert(student);
		
//		dao.update(student);

		dao.display();
		
//		Student res=dao.findOne(41);
//		System.out.println(res);
		
		
		System.out.println("=======================");
		
		List<Student> students = dao.display2();
		for(Student s:students) {
			System.out.println(s);
		}

		/*
		 * // Insert Query String
		 * query="insert into ZZ_E2297_Student(id,name,city) values(?,?,?)";
		 * 
		 * //Fire Query
		 *  int result=template.update(query,49,"Arav Aryan","Kanpur");
		 * 
		 * System.out.println("Number of record Inserted...:"+result);
		 * 
		 * System.out.println("Data Inserted...........");
		 * 
		 * System.out.println(template.queryForList("select * from ZZ_E2297_Student"));
		 * 
		 */
	}
}
