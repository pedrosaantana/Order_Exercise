package application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Order;
import entities.OrderItem;
import entities.enums.OrderStatus;

public class Program {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter cliente data: ");
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		System.out.println("Birth date (DD/MM/YYYY): ");
		LocalDate birthDate = LocalDate.parse(sc.nextLine(), fmt);
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		String status = sc.nextLine();
		Order order = new Order(LocalDate.now(), OrderStatus.valueOf(status), name, email, birthDate);
		
		System.out.println("How many items to this order?");
		int items = sc.nextInt();
		sc.nextLine();
		
		for(int i = 1; i<=items; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.println("Product name: ");
			String product_name = sc.nextLine();
			System.out.println("Product price: ");
			double price = sc.nextDouble();
			sc.nextLine();
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			
			order.addItem(new OrderItem(quantity, price, product_name));
		}
		sc.close();
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println("Order moment: " + order.getMoment());
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + order.getClient().getName() + " (" + order.getClient().getBirthDate().format(fmt) + ") - " + order.getClient().getEmail());
		System.out.println("Order items: ");
		for(int i=0;i<items;i++) {
			List<OrderItem> list = order.getItems();
			OrderItem current = list.get(i);
			
			System.out.printf("%s, $%.2f, Quantity: %d, Subtotal: $%.2f %n", current.getProduct().getName(), current.getPrice(), current.getQuantity(), current.subTotal());
		}
		System.out.printf("Total price: $%.2f", order.total());
	}
}
