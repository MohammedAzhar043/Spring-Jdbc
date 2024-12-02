package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		System.out.println("My program started.......");
		/* spring jdbc->jdbc template */

		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		 */

		/*
		 * JdbcTemplate template = context.getBean("jdbctemplate", JdbcTemplate.class);
		 * 
		 * // insert query String query =
		 * "insert into student(id,name,city) values(?,?,?)";
		 * 
		 * // fire the query int result = template.update(query, 15, "anas",
		 * "banglore"); System.out.println("The number of records inserted " + result);
		 */
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		StudentDao studentDao = context.getBean("studentdaoimpl", StudentDao.class);

		/* inserting the data */
		/*
		 * Student student = new Student(); student.setId(565);
		 * student.setName("Mukram Pasha"); student.setCity("Mysoore");
		 * 
		 * int count = studentDao.insert(student);
		 * System.out.println("The number of rows are inserted are " + count);
		 */

		/* updating the data */
		/*
		 * Student student = new Student(); student.setId(1);
		 * student.setName("Abu bakar"); student.setCity("Maka"); int change =
		 * studentDao.change(student);
		 * System.out.println("The number of rows are updated is " + change);
		 */

		/* deleting the data */
		/*
		 * Student student = new Student(); student.setId(11); int delete =
		 * studentDao.delete(student);
		 * System.out.println("The number of rows deleted is " + delete);
		 */
		/* getting the details of the single student */
		/*
		 * Student student = studentDao.getStudent(10); System.out.println(student);
		 */
		/* getting all the details */
		List<Student> students = studentDao.getStudentDetails();
		for (Student s : students) {
			System.out.println(s);
		}
	}

}
