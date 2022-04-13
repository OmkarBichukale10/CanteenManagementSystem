package com.app.dao;

import com.app.pojos.Account;

public interface IAccountDao 
{
		Account auntheticateUser(String username, String password);
		String addNewAccount(Account a);
}
