package com.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.inventory.controllers.InventoryController;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public String error = "Invalid Credentials.";

	private JButton loginBtn;
	
	private JButton forgetBtn;
	
	private JPanel buttonsPanel1;

	public JButton getLoginBtn() {
		return loginBtn;
	}
	
	public JButton getForgetBtn() {
		return forgetBtn;
	}
	
	public JPanel getButtonsPanel1() {
		return buttonsPanel1;
	}

	private JTextField username;
	private JPasswordField password;
	private JLabel imagebox;

	private void buildGui() throws IOException {
		this.setPreferredSize(new Dimension(1000, 1000));
	    Image image = null;
	    URL url = null;
	    try {
	        url = new URL("https://i.imgur.com/NV6QmjH.png"); //works
	        image = ImageIO.read(url);
	    } catch (MalformedURLException ex) {
	        System.out.println("Malformed URL"); 
	    } catch (IOException iox) {
	        System.out.println("Can not load file");
	    }
	    JLabel label = new JLabel(new ImageIcon(image));
	    
		JLabel title = new JLabel("Rosa Shoe Retail Inc.");
		title.setFont(new Font("Helvetica", Font.BOLD, 50));
		JLabel space = new JLabel("  ");
		space.setFont(new Font("Helvetica", Font.BOLD, 50));
		JLabel space1 = new JLabel("                                                                                                          ");
		space1.setFont(new Font("Helvetica", Font.BOLD, 100));
		JLabel space2 = new JLabel("                        ");
		space2.setFont(new Font("Helvetica", Font.BOLD, 50));
		JLabel space3 = new JLabel("");
		space3.setFont(new Font("Helvetica", Font.BOLD, 50));
		JLabel space4 = new JLabel("              ");
		space4.setFont(new Font("Helvetica", Font.BOLD, 50));
		JLabel space5 = new JLabel("                            ");
		space4.setFont(new Font("Helvetica", Font.BOLD, 50));
		JLabel space6 = new JLabel("                                          ");
		space4.setFont(new Font("Helvetica", Font.BOLD, 50));
		JLabel space7 = new JLabel("                                                                                        ");
		space4.setFont(new Font("Helvetica", Font.BOLD, 100));
		JLabel space8 = new JLabel("                                                                                                               ");
		space4.setFont(new Font("Helvetica", Font.BOLD, 50));
		JLabel space9 = new JLabel("                                                                                                            ");
		
		imagebox = new JLabel("");
		@SuppressWarnings("unused")
		java.awt.Image myImage = javax.imageio.ImageIO.read(url);
       // imagebox.setIcon(new ImageIcon(loadImage("https://i.imgur.com/NV6QmjH.png")));

		JLabel productNameLabel = new JLabel(" Username ");
		username = new JTextField(20);
		productNameLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
		productNameLabel.setForeground(Color.DARK_GRAY);
		password = new JPasswordField(20);
		JLabel productDescLabel = new JLabel("Password       ");
		productDescLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
		productDescLabel.setForeground(Color.DARK_GRAY);

		
		forgetBtn = new JButton("Forget Password");
		loginBtn = new JButton(new ImageIcon("login.png"));
		
		JPanel buttonsPanel1 = new JPanel();
		this.add(space1);
		this.add(label);
		//new line
		this.add(space2);
		this.add(productNameLabel);
		this.add(space);
		this.add(username);
		username.setSize(150,20);
		username.setFont(new Font("Helvetica", Font.ITALIC, 50));
		username.setForeground(Color.GRAY);
		//new line
		this.add(space3);
		this.add(productDescLabel);
		this.add(password);
		password.setSize(150,20);
		password.setFont(new Font("Helvetica", Font.ITALIC, 50));

		add(buttonsPanel1, BorderLayout.NORTH);
		
		this.add(space5);
		JPanel buttonsPanel2 = new JPanel();
		//buttons

		this.add(forgetBtn);
		this.add(space6);
		this.add(space7);
		this.add(space8);
		this.add(loginBtn);
		loginBtn.setFont(new Font("Helvetica", Font.BOLD, 50));
		loginBtn.setPreferredSize(new Dimension(200, 200));
		add(buttonsPanel2, BorderLayout.CENTER);
	}

	public LoginPanel() throws IOException {
		
		buildGui();
	}

	public boolean isValidlogin() {
		if (username.getText().equalsIgnoreCase("admin") && password.getText().equalsIgnoreCase("123456")) {
			return true;
		}
		return false;
	};
}
