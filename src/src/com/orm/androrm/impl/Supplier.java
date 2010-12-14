package com.orm.androrm.impl;

import java.util.List;

import android.content.Context;

import com.orm.androrm.CharField;
import com.orm.androrm.FilterSet;
import com.orm.androrm.ManyToManyField;
import com.orm.androrm.Model;

public class Supplier extends Model {

	protected CharField mName;
	protected ManyToManyField<Supplier, Product> mProducts;
	
	public static final Supplier get(Context context, int id) {
		return get(context, Supplier.class, id);
	}
	
	public static final List<Supplier> filter(Context context, FilterSet filter) {
		return filter(context, Supplier.class, filter);
	}
	
	public Supplier() {
		super();
		
		mName = new CharField(50);
		mProducts = new ManyToManyField<Supplier, Product>(Supplier.class, Product.class);
	}
	
	public void setName(String name) {
		mName.set(name);
	}
	
	public List<Product> getProducts(Context context) {
		return mProducts.get(context, this);
	}
	
	public void addProduct(Product p) {
		mProducts.add(p);
	}
	
	public void addProducts(List<Product> products) {
		mProducts.addAll(products);
	}
	
	public int productCount(Context context) {
		return mProducts.count(context, this);
	}
}