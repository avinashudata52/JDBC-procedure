package procedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.util.Scanner;

import java.sql.CallableStatement;

public class FetchprocedureDemo {

	public static void main(String[] args) {
		
		try(Connection con=DriverManager.
				getConnection("jdbc:mysql://localhost:3306/JDBC","root","root");
		CallableStatement csmt = con.prepareCall("{call fetchProcedure2(?,?,?)}");
		Scanner sc = new Scanner(System.in);)
		{
			System.out.println("Enter account number to fetch");
			long num=sc.nextLong();
			csmt.setLong(1, num);
			
			csmt.registerOutParameter(2, JDBCType.DOUBLE);
			csmt.registerOutParameter(3, JDBCType.VARCHAR);
			
			csmt.execute();
			double amount = csmt.getDouble(2);
			String name = csmt.getString(3);
			
			System.out.println(amount+" "+name);
		
		} 
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}











