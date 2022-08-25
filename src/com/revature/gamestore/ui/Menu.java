package com.revature.gamestore.ui;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

import com.revature.gamestore.dl.CustomerDAO;
import com.revature.gamestore.dl.DAO;
import com.revature.gamestore.dl.OrderDAO;
import com.revature.gamestore.dl.StoreDAO;
import com.revature.gamestore.models.Console;
import com.revature.gamestore.models.Customer;
import com.revature.gamestore.models.Game;
import com.revature.gamestore.models.LineItem;
import com.revature.gamestore.models.Merchandise;
import com.revature.gamestore.models.Merchandise.category;
import com.revature.gamestore.models.Order;
import com.revature.gamestore.models.Store;
import com.revature.gamestore.util.InvalidAgeException;

import java.util.logging.Logger;
import java.util.logging.*;
public class Menu {
	public static DAO<Customer> customerDAO = new CustomerDAO();
	public static DAO<Order> orderDAO = new OrderDAO();
	public static DAO<Store> storeDAO = new StoreDAO();
	
	public static void open() {
		Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		log.log(Level.INFO, "Starting App");
		String userInput = "";
		Scanner scanner = new Scanner(System.in);
		Customer customer = new Customer(0, null, 0,null, null);
		LineItem itemsAdded = new LineItem(0,0,0,0);
		double total = 0.00;
		do {
	ArrayList<Merchandise> Cart = new ArrayList<Merchandise>();
	System.out.println("Welcome to \"Play In, Play Out\". How can we help you?");
	System.out.println("[1] To view Merchandise");
	System.out.println("[2] Register new Customer");
	System.out.println("[3] Place on Order");
	System.out.println("[x] To exit store");
	
	userInput = scanner.nextLine();
	switch(userInput) {
	case "1":
		System.out.println("List of items");
		System.out.println(Merchandise.createConsoleList());
//		System.out.println(Merchandise.consoles);
		System.out.println("==========================================");
		System.out.println(Merchandise.createGameList());
//		System.out.println(Merchandise.games);
		System.out.println("==========================================");
		break;
	case "2":
		
		// register new customer
		System.out.println("Enter your First name");
		customer.setFirstName(scanner.nextLine());
		System.out.println("Enter your Last name");
		customer.setLastName(scanner.nextLine());
		System.out.println("Enter your age");
		customer.setAge(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Enter your Address");
		customer.setAddress(scanner.nextLine());
		System.out.println("Enter Email");
		customer.setEmail(scanner.nextLine());
		System.out.println("Enter your password ");
		customer.setPassword(scanner.nextLine());
		Customer newcustomer = new Customer(customer.getFirstName(), customer.getLastName(), customer.getAge(), customer.getEmail(), customer.getPassword(), customer.getAddress());
		System.out.println(newcustomer);
		customerDAO.addInstance(newcustomer);
		break;
	case "3":
		// create instance of store
		Store myStore = new Store(1,"Play In, Play Out","1234 Main St. Tampa, Florida");
		//create store inventory
		myStore.createInventory();
		searchByEmail();
			//select product 
		System.out.println("Enter the Product name you want to purchase");
		String name = scanner.nextLine();
		int index = myStore.merchandiseExists(name);
		System.out.println(Cart);
			if(index != -1) {
				System.out.println("Select Quantity");
//				try {
//					try {
//						// check if the product is a game or console
//						
//						//if customer's age is less than 13 cannot purchase games with Rating T
//						//if customer's age is less than 17 cannot purchase games with Rating M
//						if(customer.getAge()<13 && Merchandise.category().valueOfequals(Game));
//							//select quantity
//						System.out.println("Select Quantity");
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				} catch (InvalidAgeException e) {
//					
//					e.printStackTrace();
//					System.out.println("You are not old enough to buy this game");
//				}
			int quantity = scanner.nextInt();
			Merchandise item = myStore.getMerchandise(index);
			item.setQuantity(item.getQuantity()-quantity);
			myStore.setMerchandise(index, item);
			item.setQuantity(quantity);
						// product and quantity are added to the cart
			
			
			Cart.add(item);
//			for(Merchandise myCart: Cart) {
//				System.out.println(myCart.item.getName());
//			}
						// add the prices to get total price of order
			total+= item.getPrice() * item.getQuantity();
			System.out.println(Cart);
			System.out.println("Cart total: $"+total);
			
			Order newOrder = new Order(myStore.getStoreId(), customer.getCustomerId(), item.getItemId(), total);
			orderDAO.addInstance(newOrder);
//			itemsAdded.setItemId(index);
//			itemsAdded.setOrderId(newOrder.getOrderId());
//			itemsAdded.setPrice(index);
//			itemsAdded.setQuantity(quantity);
				}
			break;
	case "x": 
		System.out.println("Exiting Store App");
		break;
		default:
			System.out.println("Wrong input, Please use valid input.");
		
			}
	
			//select quantity
	      
			// product and quantity are added to the cart
			// add the prices to get total price of order
		}while(!userInput.equals("x"));
		log.log(Level.INFO, "Exiting App");
	scanner.close();
	}
	public static void searchByEmail() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your email ");
		Customer filteredCustomer = CustomerDAO.searchCustomerByEmail(scanner.nextLine());
		if(filteredCustomer == null) {
			System.out.println("No email found");
		} else {
		 System.out.println(filteredCustomer);
		}
	}

}
