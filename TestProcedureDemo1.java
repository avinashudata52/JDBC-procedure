package procedure;

import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.util.Scanner;

import java.sql.CallableStatement;

import DoctorPortal.DBUtil;

public class TestProcedureDemo1 {
	
	public static void main(String ars[]) throws SQLException
	{
			Connection con = DBUtil.getConnect();
			CallableStatement csmt = con.prepareCall("{call calculate(?,?,?)}");
		
//		I have to link with db
//		I need to get the object Connection
//		based connection object I can  create object Collablestatement and I can call procedure  
		
		// I have to set input parameters
		csmt.setInt(1, 10);
		csmt.setInt(2, 20);
		
		//JDBCTYpe is the one of the Enum type provides several constants like
		//(INTERGER,CHAR,VARCHAR,BIGINT,DOUBLE)
		csmt.registerOutParameter(3, JDBCType.INTEGER);
		//executing stored procedure by calling execute method
		csmt.execute();
		//I am fetching result from out paramter which is available in 3 rd paramter 
		int result = csmt.getInt(3);
		System.out.println("The multiplication result is :"+" "+result);

		// I have to register OUT parameter 
	}
}
