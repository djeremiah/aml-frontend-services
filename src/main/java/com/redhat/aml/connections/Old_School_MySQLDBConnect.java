package com.redhat.aml.connections;

import java.sql.*;

public class Old_School_MySQLDBConnect {
	private Connection con; 
	private Statement st;
	private ResultSet rs;
	public Old_School_MySQLDBConnect() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/AMLDB?",
				                                   "root","");
			st  = con.createStatement();
		}catch(Exception ex) {
			System.out.println("MySQLDBConnectError:"+ex);
		}
	}
	
	 public static void main(String[] args){
		 Old_School_MySQLDBConnect connect = new Old_School_MySQLDBConnect();
		 System.out.println("MySQLDBConnect:"+connect);
	 }
	 
	 public  void getTransactionsByAccountNo(String accountNo){
		 try{
			 String query = "Select * from transaction "+ accountNo;
			  rs = st.executeQuery(query);
			 
		 }catch(Exception ex) {
				System.out.println("getTransactionsByAccountNoError:"+ex);
			}
	 }
	 
	 public  void putTransactionsForAccount(String accountNo){
		 try{
			 String query = "INSERT INTO transaction(firstname, lastname,accountNo, amount, transactiontype, fromloc, toloc, ipaddress, devicelocation, country, state, datetime) VALUES ('$firstName','$lastName','$accountNo','$amount','$trnsType','$frmLoc','$toLoc','$ipAddress','$deviceLocation','$country','$state',NOW())";
			  rs = st.executeQuery(query);
			 
		 }catch(Exception ex) {
				System.out.println("getTransactionsByAccountNoError:"+ex);
			}
	 }
}
