package com.spring.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.spring.pojo.Student;

public class AdminModel {

	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/";
	public static final String DB_NAME = "springDB";
	public static final String USER_NAME = "root";
	public static final String PASSWORD = "root";

	public Connection createConnection() {
		Connection con = null;

		try {
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(URL + DB_NAME, USER_NAME, PASSWORD);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

	public int checkLogin(String user, String pwd) {
		int i = 0;
		Connection con = null;
		try {
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("select * from adminlogin where username = ? and password = ?");
			ps.setString(1, user);
			ps.setString(2, pwd);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				i = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int insertStudent(Student std) {
		int i = 0;
		Connection con = null;
		try {
			con = createConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into student(name,rollno,marks,address) values(?,?,?,?)");
			ps.setString(1, std.getName());
			ps.setInt(2, std.getRollno());
			ps.setInt(3, std.getMarks());
			ps.setString(4, std.getAddress());

			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> li = new ArrayList<>();
		Connection con = null;

		try {
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("select * from student");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student st = new Student(rs.getString("name"), rs.getInt("rollno"), rs.getInt("marks"),
						rs.getString("address"));

//				Student st = new Student();
//				st.setName(rs.getString("name"));
//				st.setRollno(rs.getInt("rollno"));
//				st.setMarks(rs.getInt("marks"));
//				st.setAddress(rs.getString("address"));
//				System.out.println(st);

				li.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}
	
	public int deleteStudent(int rr) {
		int i = 0;
		Connection con = null;
		try {
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("delete from student where rollno = ?");
			
			ps.setInt(1, rr);
			i = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public Student getAStudent(int rr) {
		
		Student ss = null;
		Connection con = null;
		try {
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("select * from student where rollno = ?");
			ps.setInt(1, rr);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ss = new Student(rs.getString("name"), rs.getInt("rollno"), rs.getInt("marks"),
						rs.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ss;
		
	}

	public int updateStudent(Student std) {
		int i = 0;
		Connection con = null;
		try {
			con = createConnection();
			PreparedStatement ps = con
					.prepareStatement("update student set name=?, marks=?, address=? where rollno = ?");
			ps.setString(1, std.getName());
			ps.setInt(2, std.getMarks());
			ps.setString(3, std.getAddress());
			ps.setInt(4, std.getRollno());

			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
}
