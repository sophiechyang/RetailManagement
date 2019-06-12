package com.views;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.inventory.controllers.InventoryController;
import com.inventory.controllers.InventoryControllerImpl;
import com.inventory.model.Product;

@SuppressWarnings("serial")
public class InventoryView extends JFrame {

	private InventoryController controller;
	private AddInventoryPanel addInventory;
	private UpdateInventoryPanel updateInventory;
	private ListInventoryPanel listInventory;
	private LoginPanel loginPanel;

	public InventoryView(InventoryController controller) throws IOException {
		this.setController(controller);
		addInventory = new AddInventoryPanel(controller);
		updateInventory = new UpdateInventoryPanel(controller);
		listInventory = new ListInventoryPanel(controller);
		loginPanel = new LoginPanel();
		buildGui();
	}

	public void setController(InventoryControllerImpl controller) {
		this.controller = controller;
	}

	private void buildGui() {
		//this.setPreferredSize(new Dimension(1000, 1000));
		this.setSize(1000, 1000);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);

		JPanel topPanel = new JPanel();
		JTabbedPane tabMenu = new JTabbedPane();
		tabMenu.addTab("Login", loginPanel);
		topPanel.add(tabMenu);
		getContentPane().add(topPanel);
		setVisible(true);

		loginPanel.getLoginBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (loginPanel.isValidlogin()) {
					topPanel.setVisible(false);
					showInventoryPanel();
				} else {
					JOptionPane.showMessageDialog(null, loginPanel.error);
				}

			}
		});

	}

	private void showInventoryPanel() {
		JPanel topPanel = new JPanel();
		JTabbedPane tabMenu = new JTabbedPane();

		tabMenu.addTab("List Item", listInventory);
		tabMenu.addTab("Add Item", addInventory);
		tabMenu.addTab("Update Item", updateInventory);

		tabMenu.setSelectedComponent(addInventory);
		topPanel.add(tabMenu);
		getContentPane().add(topPanel);

	}

	public void updateListeners() {
		updateListeners(this.controller.listItems());
	}

	public void updateListeners(List<Product> products) {
		listInventory.buildGui(products);
	}

	public InventoryController getController() {
		return controller;
	}

	public void setController(InventoryController controller) {
		this.controller = controller;
	}

}
