package driver;

import java.util.ArrayList;

import databasecrud.ProductsCrud;
import property.Products;

public class ProductsDriver {
	public static void main(String[] args) {
		/*
		 * ArrayList<Products> list = new ArrayList<Products>();
		 
		Products p1 = new Products();
		p1.setId(107);
		p1.setName("Punch");
		p1.setBrand("TATA");
		p1.setType("Diesel");
		p1.setCost(1300000);
		
		Products p2 = new Products();
		p2.setId(108);
		p2.setName("Harrier");
		p2.setBrand("TATA");
		p2.setType("Diesel");
		p2.setCost(1100000);
		
		list.add(p1);
		list.add(p2);
		ProductsCrud productsCrud = new ProductsCrud();
		productsCrud.saveProducts(list);
		*/
		Products products = new Products();
		//products.setBrand("TATA");
		//products.setType("Petrol");
		ProductsCrud productsCrud = new ProductsCrud();
		//System.out.println(productsCrud.printProductsByBrand("TATA"));
		//System.out.println(productsCrud.printProductsByTypeAndBrand(products));
		System.out.println(productsCrud.printProductsById(103));
		
	}

}
