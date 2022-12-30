package swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer {
//	public static void main(String[] args) {
//		createTable();
//		createCustomer("Danny", "123456789", "Male", "23", "Random Note...");
//		ArrayList<String> list = getCustomers();
//		for(String item : list) {
//			System.out.println(item);
//		}
//		createCustomer("David", "987654321", "Female", "25", "Important Customer...");
//	}
	
	public static String[][] getCustomers() {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("select name, phone, gender from customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
					results.getString("name"),
					results.getString("phone"),
					results.getString("gender"),
					results.getString("age"),
					results.getString("note")
				});
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			
			return list.toArray(arr);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static void createCustomer(String name, String phone, String gender, String age, String note) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(
				"insert into customer(name, phone, gender, age, note) value('" + name + "' ,'" + phone + "', '" + gender + "', '" + age + "', '" + note + "')" 
			);
			insert.executeUpdate();
			System.out.println("The data has been saved");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement(
				"create table if not exists customer(id int not null, auto_increment, name varchar(255), phone varchar(255), gender varchar(255), age varchar(255), note varchar(255), primary key(id)"
			);
			create.execute();
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table Successfully created");
		}
	}
	
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://sq19.freemysqlhosting.net:3306/sql9264705";
			String user = "sql9264705";
			String pass = "BFhzgljJiJ";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("The Connection Successful");
			return con;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
