package bank.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bank.pojo.Account;
import  bank.util.DButil;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import bank.util.DButil;

public class BankCrudImp implements Bankcrud {
	private Connection connect;
	private Statement st;
	private ResultSet resSet;
	private PreparedStatement Ps1,Ps2,Ps3;
	
	 public BankCrudImp() throws SQLException {
		 connect=DButil.getCon();
		 
		 st=connect.createStatement();
		 System.out.println("statement created");
		 Ps1=connect.prepareStatement("insert into Account values(?,?,?,?)");
		 Ps2=connect.prepareStatement("update Account set name=?,type=?,balance=?");
		 Ps3=connect.prepareStatement("delete from Account where id=?");
		 System.out.println("prepare statement done");
		 
	 }
	public  List<Account> getDetails() throws SQLException{
		List <Account> accDetails= new ArrayList<>();
		
		resSet=st.executeQuery("select*from Account");
		while(resSet.next()) {
			accDetails.add(new Account(resSet.getInt("id"),
					resSet.getString("name"),
					resSet.getString("type"),
					resSet.getDouble("balance")));
			}
		
		 
		return accDetails;
	 }
	@Override
	public int addAccount(Account obj) throws SQLException {
		
		Ps1.setInt(1,obj.getId());
		Ps1.setString(2,obj.getName() );
		Ps1.setString(3, obj.getType());
		Ps1.setDouble(4, obj.getBalance());
		int i= Ps1.executeUpdate();
		
		System.out.println("Account created!");
		
		return i;
	}
	@Override
	public int updateAccount(Account obj) throws SQLException {
		Ps2.setInt(1,obj.getId());
		Ps2.setString(2,obj.getName() );
		Ps2.setString(3, obj.getType());
		Ps2.setDouble(4, obj.getBalance());
		int i= Ps2.executeUpdate();
		
		System.out.println("Account created!");
		
		return i;
	}
	@Override
	public int deleteAccount(int id) throws SQLException {
		Ps3.setInt(1, id);
		int i=Ps3.executeUpdate();
		
		
		return i;
	}

}
