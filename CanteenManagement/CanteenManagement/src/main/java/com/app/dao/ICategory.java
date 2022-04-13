package com.app.dao;

import java.util.List;

import com.app.pojos.*;

public interface ICategory {
	List<String> getAllCategory();
	   List<Item> ItemCategory(String cat_name);	
	   Item getDish(int code);
}
