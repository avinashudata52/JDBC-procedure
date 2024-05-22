package procedure;

import java.sql.Connection;

import java.sql.CallableStatement;

import DoctorPortal.DBUtil;

public class TestprocedureDemo3 {

	public static void main(String[] args) {
	
		try 
		{
			Connection con = DBUtil.getConnect();
			CallableStatement csmt = con.prepareCall("{ call insertINAcc2(?,?,?,?)}");
			csmt.setInt(1,106);
			csmt.setLong(2,70000);
			
			java.util.Date d = new java.util.Date();
			long currentDate = 0;
			csmt.setDate(3,new java.sql.Date(currentDate));  // Datatype is Long getTime() ---> java.util.Date
			csmt.setString(4, "Demo");
			
			boolean b = csmt.execute();
			
			if(b)
			{
				System.out.println("Date inserted");
			}
			else
			{
				System.out.println("not able to insert");
			}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
