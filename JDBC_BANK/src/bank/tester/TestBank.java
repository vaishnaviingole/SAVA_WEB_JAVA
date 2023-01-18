package bank.tester;
import static bank.util.DButil.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import bank.dal.BankCrudImp;
import bank.pojo.Account;
import bank.util.DButil;
public class TestBank {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			Scanner sc=new Scanner(System.in);
		DButil.openConnection();
		BankCrudImp obj=new BankCrudImp();
		int ch=0;
		do {
			System.out.println("1 display 2.add 3.delete 4.update");
			System.out.println("Enter your choice:");
			 ch=sc.nextInt();
			 switch(ch) {
			 case 1:
				 List<Account> list = obj.getDetails();
					list.forEach(b -> System.out.println(b));
			 
					break;
			 case 2:
				 System.out.println("Enter id,name,type,amount");
				  Account obj1=new Account(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble());
				  int i=obj.addAccount(obj1);
					if(i>0)
					{
						System.out.println("Inserted");
						
					}
					break;
			 case 3:
				 System.out.println("Enter id to delete Account");
				 int delid=sc.nextInt();
				 int j=obj.deleteAccount(delid);
				 if(j>0) {
					 System.out.println("deleted!");
				 }
				 break;
			 case 4:
				 System.out.println("edit: id,name,type,amount");
				  Account obj2=new Account(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble());
				  int k=obj.addAccount(obj2);
					if(k>0)
					{
						System.out.println("Updated");
						
					}
					break;
			 }
			 
				 
		}
		while(ch!=0);
		
	}
		catch(Exception ee) {
			ee.printStackTrace();
		}
	}
 
}
