package DAL;

import java.sql.SQLException;

import pojo.user;

public interface userDal {
user ValidateUser(String email,String password) throws SQLException;
}
