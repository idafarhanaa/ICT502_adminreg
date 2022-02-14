/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminregister.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import adminregister.db.ConnectionManager;
import adminregister.model.adminregister;

/**
 *
 * @author User
 */
public class adminregisterDAO {
    static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;

    public static Object getAlladminregistser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	private int id;
	private String fullname,username,phonenum,email,pass;
        
        
        //add glampingscape
        public void addgadminregister(adminregister bean) {
		fullname = bean.getadminname();
		username = bean.getadminusername();
                phonenum = bean.getadminphone();
                email = bean.getadminemail();
                pass = bean.getadminpass();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO taka3(fullname,username,phonenum,email,pass)VALUES(?,?,?,?,?)");
			ps.setString(1, fullname);
			ps.setString(2, username);
			ps.setString(3, phonenum);
                        ps.setString(4, email);
                        ps.setString(5, pass);
		
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			//close connection
			con.close();
			}catch(Exception e)
                        {
                            e.printStackTrace();
			}
        }
        
        //get all glampingscape
	public static List<adminregister> getAlladminregister(){
		List<adminregister> adminregister = new ArrayList<adminregister>();
		
		try {
			con = ConnectionManager.getConnection();
			
			stmt = con.createStatement();
			String sql = "SELECT * FROM taka3 ORDER BY id";
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				adminregister a = new adminregister();
				
				a.setId(rs.getInt("id"));
				a.setName(rs.getString("fullname"));
                                a.setUsername(rs.getString("username"));
                                a.setphoneNum(rs.getString("phonenum"));
                                a.setemail(rs.getString("email"));
                                a.setpass(rs.getString("pass"));
                              
				adminregister.add(a);
			}
			
			//close connection
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return adminregister;
		
	}
              //get all by id
	public static adminregister getadminregisterById(int id) {
		
		adminregister a = new adminregister();
		
		try {
		con = ConnectionManager.getConnection();
		
		//create statement
		ps = con.prepareStatement("SELECT * FROM taka3 where id = ?");
		ps.setInt(1, id);
		
		
		rs = ps.executeQuery();
		if(rs.next()) {
                            a.setId(rs.getInt("id"));
                            a.setName(rs.getString("fullname"));
                            a.setUsername(rs.getString("username"));
                            a.setphoneNum(rs.getString("phonenum"));
                            a.setemail(rs.getString("email"));
                            a.setpass(rs.getString("pass"));
		}
		
		//close connection
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
		
	}  
        
        //delete glampingscape
	public void deleteadminregister(int id) {
		
		try {
			
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM taka3 where id = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//update glampingscape
	public void updateadminregister(adminregister bean) {
		fullname = bean.getadminname();
		username = bean.getadminusername();
                phonenum = bean.getadminphone();
                email = bean.getadminemail();
                pass = bean.getadminpass();
		
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement("UPDATE taka3 set fullname=?, username=?, phonenum=?,email=?,pass=?");
			
			ps.setInt(1, id);
			ps.setString(2, fullname);
			ps.setString(3, username);
			ps.setString(4, phonenum);
                        ps.setString(4, email);
                        ps.setString(4, pass);
			
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully updated");
			
			//close connection
			con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
        }

    public void addaddminregister(adminregister a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    
    


   

