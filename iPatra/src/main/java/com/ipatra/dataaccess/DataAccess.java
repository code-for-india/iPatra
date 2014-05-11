package com.ipatra.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ipatra.IndentRequest;
import com.ipatra.IndentResponse;
import com.ipatra.Route;
import com.ipatra.School;

public class DataAccess {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public void readDataBase() throws Exception {
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// setup the connection with the DB.
			connect = DriverManager
					.getConnection("jdbc:mysql://192.168.147.69/ipatra?/user=root");

			// statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// resultSet gets the result of the SQL query
			resultSet = statement
					.executeQuery("select * from School");
			while (resultSet.next()) {
				// it is possible to get the columns via name
				// also possible to get the columns via the column number
				// which starts at 1
				// e.g., resultSet.getSTring(2);
				String user = resultSet.getString("ID");
				System.out.println("User: " + user);
			}


		} catch (Exception e) {
			throw e;
		} finally {
			//			close();
		}

	}
	//	// you need to close all three to make sure
	//	private void close() {
	//		close(resultSet);
	//		close(statement);
	//		close(connect);
	//	}
	//	private void close(Closeable c) {
	//		try {
	//			if (c != null) {
	//				c.close();
	//			}
	//		} catch (Exception e) {
	//			// don't throw now as it might leave following closables in undefined state
	//		}
	//	}
	public static void main(String[] args) {
		DataAccess obj = new DataAccess();
		try {
			//			System.out.println(	obj.getSchoolsOnRoute(98).get(0).getId());
			System.out.println(	obj.getSchoolLocation(567));
			System.out.println(	obj.getSchoolName(567));
			//			System.out.println(obj.getRouteList());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Route> getRouteList() {
		try {
			List<Route> rl = new ArrayList<Route>();
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// setup the connection with the DB.
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/ipatra?user=root");

			// statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// resultSet gets the result of the SQL query
			resultSet = statement
					.executeQuery(" select distinct Name,ID from Routes");
			StringBuilder routes= new StringBuilder();
			while (resultSet.next()) {
				Route r = new Route();
				r.setId(Integer.parseInt(resultSet.getString("ID")));
				r.setRouteName(resultSet.getString("Name"));
				rl.add(r);
			}
			return rl;
		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			//			close();
		}
		return null;
	}
	public  List<School> getSchoolsOnRoute(int routeId) {
		List<School> schools = new ArrayList<School>();
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// setup the connection with the DB.
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/ipatra?user=root");

			// statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// resultSet gets the result of the SQL query
			resultSet = statement
					.executeQuery("select * from  SchoolRouting where Route_ID="+routeId);
			while (resultSet.next()) {

				School s = new School();
				s.setId(Integer.parseInt(resultSet.getString("School_ID")));
				s.setName(getSchoolName(s.getId()));
				s.setLocation(getSchoolLocation(s.getId()));
				schools.add(s);
			}
			return schools;
		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			//			close();
		}
		return schools;

	}
	private String getSchoolLocation(int id) {
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// setup the connection with the DB.
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/ipatra?user=root");

			// statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// resultSet gets the result of the SQL query
			resultSet = statement
					.executeQuery(" select Location from School where ID = "+id);
			if( resultSet.next() ){
				return resultSet.getString("Location");

			}
		} catch (Exception e) {
			try {
				e.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			//			close();
		}
		return "";
	}
	private String getSchoolName(int id) {
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// setup the connection with the DB.
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/ipatra?user=root");

			// statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// resultSet gets the result of the SQL query
			resultSet = statement
					.executeQuery(" select Name from School where ID = "+id);
			if( resultSet.next() ){
				return resultSet.getString("Name");

			}
		} catch (Exception e) {
			try {
				e.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			//			close();
		}
		return "";	}
	public List<IndentResponse> getIndent(int sid, Calendar forDate) {

		List<IndentResponse> responses = new ArrayList<IndentResponse>();
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// setup the connection with the DB.
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/ipatra?user=root");

			// statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// resultSet gets the result of the SQL query
			resultSet = statement
					.executeQuery("select * from  DailyIndent where School_ID="+sid+" forDate="+forDate);
			while (resultSet.next()) {

				IndentResponse r= new IndentResponse();
				String menuName = getMenuName(resultSet.getString("Item_ID"));
				r.setMenuName(menuName);
				r.setRequestedServingQty(Integer.parseInt(resultSet.getString("RequestedServingQty")));
				int previousDaySevingQty = getPreviousDayServingQty(sid,forDate);
				r.setPreviousDayRequestedServingQty(previousDaySevingQty);
				responses.add(r);
			}
			return responses;
		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			//			close();
		}
		return null;
	}
	private int getPreviousDayServingQty(int sid, Calendar forDate) {
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// setup the connection with the DB.
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/ipatra?user=root");

			// statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// resultSet gets the result of the SQL query
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			resultSet = statement
					.executeQuery("select * from  DailyIndent where School_ID="+sid+" forDate="+df.format(subtractDay(forDate.getTime())));
			return Integer.parseInt(resultSet.getString("RequestedServingQty"));
		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			//			close();
		}
		return 0;
	}
	public static Date subtractDay(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}
	private String getMenuName(String string) {
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// setup the connection with the DB.
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/ipatra?user=root");

			// statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// resultSet gets the result of the SQL query
			resultSet = statement
					.executeQuery("select Name from  MenuItems where ID="+string);
			return resultSet.getString("Name");
		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			//			close();
		}
		return "";
	}
	public void updateIndent(int sid, Calendar date, int previousDayQty,
			int requestedQty) {
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// setup the connection with the DB.
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/ipatra?user=root");

			// statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// resultSet gets the result of the SQL query
			String values = System.currentTimeMillis()+","+sid+","+date.getTime()+","+requestedQty;
			String insertQuery = "insert into DailyIndent (Indent_ID,School_ID,forDate,requestedQty) values (+"+values;
			resultSet = statement
					.executeQuery(insertQuery);
			
		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			//			close();
		}
	}


}
