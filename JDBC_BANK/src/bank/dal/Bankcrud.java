package bank.dal;

import java.sql.SQLException;
import java.util.List;

import bank.pojo.Account;

public interface Bankcrud {
List<Account> getDetails() throws SQLException;

int addAccount( Account obj) throws SQLException;

int updateAccount(Account obj) throws SQLException;

int deleteAccount(int id) throws SQLException;


}
