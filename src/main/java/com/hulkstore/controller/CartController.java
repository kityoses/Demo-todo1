package com.hulkstore.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hulkstore.form.SelectedProductForm;
import com.hulkstore.model.Cart;
import com.hulkstore.model.Employee;
import com.hulkstore.model.Product;
import com.hulkstore.model.ProductPurchase;
import com.hulkstore.service.CartService;
import com.hulkstore.service.EmployeeService;
import com.hulkstore.service.ProductService;

/**
 * @author coses
 *
 */
@Controller
public class CartController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	/** Show first method, also when click in Clear Cart
	 * @param cart
	 * @param selectedProductForm
	 * @param model
	 * @param request
	 * @return
	 */
	@GetMapping("/showCart")
	public String showCart(Cart cart, SelectedProductForm selectedProductForm, Model model, HttpServletRequest request) {
		Employee employee = employeeService.getEmployeeSession();
		cart.setEmployee(employee);
		cart.setProductPurchases(new ArrayList<ProductPurchase>());
		cart.setTotal(0.00);
		cart.setStatusCart("PROCESSING");

		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		model.addAttribute("cart", cart);
		request.getSession().setAttribute("cart", cart);
		return "/cart/saveCart";
	}
	
	/** Validations form, check stock and control
	 * @param selectedProductForm
	 * @param bindingResult
	 * @param model
	 * @param request
	 * @return
	 */
	@PostMapping("/addToCart")
	public String addToCart(@Valid SelectedProductForm selectedProductForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
		List<Product> products = productService.findAll();
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if (bindingResult.hasErrors()) {
			model.addAttribute("products", products);
			model.addAttribute("productPurchases", cart.getProductPurchases());
			return "/cart/saveCart";
		}
		
		boolean existProductInCart = false;
		Integer quantityTotal = selectedProductForm.getQuantity();
		Product product = productService.findById(selectedProductForm.getId());
		int stock = product.getStock().intValue();
		Iterator<ProductPurchase> it = cart.getProductPurchases().iterator();
		while (it.hasNext() && !existProductInCart) {
			ProductPurchase prodPurchase = it.next();
			if(prodPurchase.getProduct().getId()  == selectedProductForm.getId()) {
				quantityTotal += prodPurchase.getQuantity();
				Double subtotal = prodPurchase.getSubTotal() + (product.getPrice() * selectedProductForm.getQuantity());
				if ((stock - quantityTotal) >= 0) {				
					prodPurchase.setQuantity(quantityTotal);
					prodPurchase.setSubTotal(subtotal);
				}	
				existProductInCart = true;
			}
		}
		
        if ((stock - quantityTotal) < 0) {
            bindingResult.rejectValue("quantity", "error.quantity", "Product out of stock. You can buy up to " + product.getStock() + " units");
			model.addAttribute("products", products);
			model.addAttribute("productPurchases", cart.getProductPurchases());
            return "/cart/saveCart";
        }
        
		if (!existProductInCart) {
	        ProductPurchase prodPurchase = new ProductPurchase();
	        prodPurchase.setName(product.getName());
	        prodPurchase.setQuantity(selectedProductForm.getQuantity());
	        prodPurchase.setProduct(product);
	        prodPurchase.setCategory(product.getCategory());
	        prodPurchase.setCart(cart);
	        prodPurchase.setSubTotal(product.getPrice() * selectedProductForm.getQuantity());
			cart.getProductPurchases().add(prodPurchase);
		}
		
		model.addAttribute("products", products);
		model.addAttribute("productPurchases", cart.getProductPurchases());
		return "/cart/saveCart";
	}
	
	/** Delete product from cart
	 * @param idProduct
	 * @param selectedProductForm
	 * @param model
	 * @param request
	 * @return
	 */
	@GetMapping("/deleteProductPurchase")
	public String deleteProductPurchase(@RequestParam(name = "idProduct",required = true) Integer idProduct, SelectedProductForm selectedProductForm, Model model, HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		List<ProductPurchase> productPurchasesList = new ArrayList<ProductPurchase>();
		Iterator<ProductPurchase> it = cart.getProductPurchases().iterator();
		while (it.hasNext()) {
			ProductPurchase productPurchase = it.next();
			if(productPurchase.getProduct().getId() != idProduct) {
				productPurchasesList.add(productPurchase);
			}
		}
		
		cart.setProductPurchases(productPurchasesList);
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		model.addAttribute("productPurchases", cart.getProductPurchases());
		return "/cart/saveCart";
	}
	
	/** Finish the purchase
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping("/saveCart")
	public String saveCart(HttpServletRequest request, Model model) {
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart.getProductPurchases().size() == 0) {
			model.addAttribute("message", "You have finished your purchase without products. ¡Try again later!");
			return "/cart/finish";
		}

		double total = 0;
		Iterator<ProductPurchase> it = cart.getProductPurchases().iterator();
		while (it.hasNext()) {
			ProductPurchase productPurchase = it.next();
			Product product = productPurchase.getProduct();
			product.setStock(product.getStock() - productPurchase.getQuantity());
			productService.save(product);
			total += productPurchase.getSubTotal();
		}
		cart.setStatusCart("FINISHED");
		cart.setTotal(total);
		cartService.save(cart);

		model.addAttribute("message", "¡Congratulations! You purchase for a total of $" + cart.getTotal() + " was succesful");
		return "/cart/finish";
	}
		
		
}
