package com.mum.Ocr.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.View;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mum.Ocr.model.Product;
import com.mum.Ocr.service.IProductService;


@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping(value = {"/products", "/products/", "/products/index"})
    public ModelAndView products() {
        ModelAndView mav = new ModelAndView();
        List<Product> products = productService.getAllProducts();
        mav.addObject("products", products);
        mav.setViewName("product/list");
        return mav;
    }

    @GetMapping(value = "/product")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/edit";
    }

   

  @RequestMapping(value = "/product", method=RequestMethod.POST)
  public String editProduct(@Valid @ModelAttribute("product") Product product,
          BindingResult bindingResult, Model model) {
	  if (bindingResult.hasErrors()) {
          model.addAttribute("errors", bindingResult.getAllErrors());
          return "product/edit";
      }
	  
	  product = productService.update( product);
       return "redirect:products";
   }

   
    @RequestMapping(value= "/eproduct/{id}",method=RequestMethod.GET)
    public String view(@PathVariable Long id, Model model) {
    	model.addAttribute("product",productService.getProduct(id));
    	return "product/edit";
    	
    }
    
    @RequestMapping(value="/cproducts/delete/{id}",method=RequestMethod.GET)
	public String deleteTopic(@PathVariable long id) {
    	productService.deleteProduct(id);
		 return "redirect:/products";
	}
}