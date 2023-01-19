package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.user;
import utils.DButils;

public class userDALImp implements userDal{
private Connection con;
private PreparedStatement st;

public userDALImp() {
	try {
		con=DButils.getCon();
		st=con.prepareStatement("select * from user where email=? and password=?");
		System.out.println("---inside UserDalImpl---");
		
		
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
}

@Override
public user VaidateUser(String userName, String pass) throws SQLException {
	System.out.println("inside validate user");
	st.setString(1,userName);
	st.setString(2, pass);
    ResultSet rset=st.executeQuery();
    user us=null;
    while(rset.next())
    {
    	us= new user(rset.getInt("userid"),
    			     rset.getString("custName"),
    			     rset.getString("city"),
    			     rset.getString("email"))
    }
	return null;
}

}
