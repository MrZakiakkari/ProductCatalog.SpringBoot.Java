package com.example.springbootsecurity;

/**
 *
 * @author M.Zaki Al Akkari <https://github.com/MrZakiakkari>
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService
{
	static final List<Product> productList = new ArrayList();

	static
	{
		productList.add(new Product("XG809", "Contemporary Office Desk", "Concentrating on the job is a lot easier when everyone has a place that’s comfortable to work at.", 25.00, 69.00, 18));
		productList.add(new Product("BG565", "Bed Frame With Storage", "With the comfort and quality you get from our sturdy single beds, you’ll wake up refreshed and ready to roll. ", 139.00, 175.00, 5));
		productList.add(new Product("PO262", "TV Stand", "Our TV stands and TV cabinets are there to cut the clutter and get things organised.", 69.99, 89.99, 120));
		productList.add(new Product("MC342", "Kitchen Unit", "They make the most of your wall by giving you extra storage, and the right kitchen shelf can boost the style of your decor too", 23.00, 65.99, 89));
		productList.add(new Product("WS341", "Folding Chair", "You can fold the chair, so it takes less space when you're not using it.", 12.00, 35.99, 30));
		productList.add(new Product("TF875", "Berkant Kitchen", "Express yourself in the place where all of life’s daily activities take place.in our stylish, yet personalised kitchen..", 8900.00, 12200.99, 4));
	}

	/**
	 * Gets all Products
	 *
	 * @return List of Products
	 */
	public List<Product> getProducts()
	{
		return productList;
	}// end getAllProducts

	public boolean addProduct(Product product)
	{
		return productList.add(product);
	}

	public boolean deleteProductByCode(String code)
	{
		Iterator<Product> iterator = productList.iterator();
		while (iterator.hasNext())
		{
			Product product = iterator.next();
			if (product.getCode().equalsIgnoreCase(code))
			{
				iterator.remove();
				return true;
			}
		}
		return false;
	}
	public Product getProductByCode(String code)
	{
		for (Product product : productList)
		{
			if (product.getCode().equalsIgnoreCase(code))
			{
				return product;
			}
		}
		return null;
	}
	public void updateProduct(Product product)
	{
		deleteProductByCode(product.getCode());
		addProduct(product);
	}
}
