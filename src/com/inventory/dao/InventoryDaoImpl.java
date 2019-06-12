package com.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import com.inventory.model.Product;

public class InventoryDaoImpl implements InventoryDao {

	private static List<Product> inventory;
	private static int id = 1000;

	public InventoryDaoImpl() {
		inventory = new ArrayList<>();
	}

	@Override
	public void create(Product product) {
		product.setId(id++);
		inventory.add(product);

	}

	/**
	 * Returns all the products in the database
	 */
	@Override
	public List<Product> listAllProducts() {
		return inventory;
	}

	@Override
	public int update(Product product) {
		int numberOfUpdates = 0;
		for (Product p : inventory) {
			if (p.getId() == product.getId()) {
				p.setName(product.getName());
				p.setDescription(product.getDescription());
				numberOfUpdates++;
			}

		}

		return numberOfUpdates;
	}

	@Override
	public Product get(int id) {
		for (Product p : inventory) {
			if (p.getId() == id) {
				return p;
			}

		}

		return null;
	}

}
