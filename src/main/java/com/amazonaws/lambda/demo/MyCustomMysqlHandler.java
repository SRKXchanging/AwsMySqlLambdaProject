package com.amazonaws.lambda.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class MyCustomMysqlHandler implements RequestHandler<RequestDetails, ResponseDetails> {

    @Override
    public ResponseDetails handleRequest(RequestDetails requestDtls, Context context) {
        context.getLogger().log("Input: " + requestDtls);
        
        ResponseDetails responseDtls = new ResponseDetails();
        
        try{
        	insertDetails(requestDtls,responseDtls);
        } catch(Exception exception) {
        	responseDtls.setMessageId("999");
        	responseDtls.setMessageReason("ERROR. Unable to insert, exception :  "+exception.getMessage());
        }
        
        System.out.println("Final response object is : "+responseDtls);
       
        return responseDtls;
    }

	private void insertDetails(RequestDetails requestDtls, ResponseDetails responseDtls) throws Exception {
		
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		String query = getQuery(requestDtls);
		int responseCode = statement.executeUpdate(query);
		if(responseCode == 1) {
			responseDtls.setMessageId("1");
        	responseDtls.setMessageReason("Record updated successfully ");
		}
	}

	private String getQuery(RequestDetails requestDtls) {
		System.out.println("Input RequestDetails is : "+ requestDtls);
		
		StringBuffer query = new StringBuffer("insert into employeeDB.employee(id,name,email,employeer) values (");
		query.append(requestDtls.getId()).append(",")
		.append("'").append(requestDtls.getName()).append("'").append(",")
		.append("'").append(requestDtls.getEmail()).append("'").append(",")
		.append("'").append(requestDtls.getEmployeer()).append("'").append(")");		
		
		
		System.out.println("query is : "+ query);
		
		return query.toString();
	}

	private Connection getConnection() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://mysqldb.cgohceilc7qj.ap-southeast-1.rds.amazonaws.com:3306/employeeDB","user1","password");  
		
		return con;
	}

}
