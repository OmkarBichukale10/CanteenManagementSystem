package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="category")
public class Category 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cat_id;
	@Column(length = 20)
	private String cat_name;
	@OneToMany(mappedBy = "cat_id",cascade = CascadeType.ALL)
	private List<Item> items=new ArrayList<>();
	
	public Category(Integer cat_id, String cat_name, List<Item> items)
	{
		super();
		this.cat_id = cat_id;
		this.cat_name = cat_name;
		this.items = items;
	}
	public Category()
	{
		System.out.println("in category const");
	}

	public Integer getCat_id() {
		return cat_id;
	}

	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}
	
	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	
	public Category(String catname,List<Item> al) {
		super();
		this.cat_name = catname;
		this.items = al;
	}

	@Override
	public String toString() {
		return "Category [cat_id=" + cat_id + ", cat_name=" + cat_name + ", items=" + items + "]";
	}

	
}
