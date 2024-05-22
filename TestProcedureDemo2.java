package procedure;

import java.sql.Connection;
import java.sql.JDBCType;
import java.util.Scanner;

import java.sql.CallableStatement;

import DoctorPortal.DBUtil;

public class TestProcedureDemo2 {

	public static void main(String[] args) {
		
		try 
		{
			Connection con = DBUtil.getConnect();
			CallableStatement csmt = con.prepareCall("{call BillCalculator2(?,?,?,?)}");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter month in number");
			int month= sc.nextInt();
			System.out.println("enter the number of products");
			int  nop = sc.nextInt();
			System.out.println("Enter the product price");
			double price= sc.nextDouble();
			csmt.setInt(1, month);
			csmt.setInt(2,nop);
			csmt.setDouble(3, price);
	
		
		csmt.registerOutParameter(4, JDBCType.DOUBLE);
		//executing stored procedure by calling execute method
		csmt.execute();
		//I am fetching result from out paramter which is available in 3 rd paramter 
		double res = csmt.getDouble(4);
		System.out.println("The product price is :"+" "+res);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
}
