package tranxuanbinh.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tranxuanbinh.net.model.Product;
import tranxuanbinh.net.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("view")
	public String viewProduct(Model model) {
			model.addAttribute("listProducts",productService.getAllProducts());
			return "view_products";
	}
	
	@GetMapping("addnew")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product",product);
		return "new_product";
	}
	
	@PostMapping("save")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		return "redirect:/product/view";
	}
}
