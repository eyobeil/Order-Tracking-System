package com.mum.Ocr.control;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.mum.Ocr.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mum.Ocr.model.Customer;
import com.mum.Ocr.model.Product;
import com.mum.Ocr.model.Orders;

import com.mum.Ocr.service.ICustomerService;
import com.mum.Ocr.service.IOrderLineService;
import com.mum.Ocr.service.IOrderService;
import com.mum.Ocr.service.IProductService;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IProductService productService;
	@Autowired
	private IOrderLineService orderLineService;
	
	@Autowired
	private IOrderService orderService;
	
	
	@RequestMapping(value="/customer", method=RequestMethod.GET)
	public String createProduct(Model model) {
		model.addAttribute("customer", new Customer());		
		return "customer/edit";
	}

	@RequestMapping(value="/customer", method=RequestMethod.POST)
	public String addCustomer(@Valid @ModelAttribute("customer") Customer customer, 
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			
			model.addAttribute("errors", result.getAllErrors());
			return "customer/edit";		
		}
		customerService.update(customer);
	    return "redirect:/customers";	
		
	}
	@RequestMapping(value="/customers",method=RequestMethod.GET)
	public ModelAndView getAllCustomers() {
		List<Customer> customers=customerService.getAllCustomers();
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("customers",customers);
		modelAndView.setViewName("customer/list");
		return modelAndView;
	}
			
	@RequestMapping(value="/customers/{id}",method=RequestMethod.GET)
	public String editCusomer(@PathVariable long id,Model model) {
		//model.addAttribute("customer",customerService.getCustomer(id));
		model.addAttribute("customer",customerService.findOne(id));
		return "customer/edit";
	}
	@RequestMapping(value="/customers/delete/{id}",method=RequestMethod.GET)
	public String deleteTopic(@PathVariable long id) {
		 customerService.deleteCustomer(id);
		 return "redirect:/customers";
	}
	@RequestMapping(value="/customers/{id}/purchase",method=RequestMethod.GET)
	public String purchaseCusomer(@PathVariable long id,Model model) {
		model.addAttribute("customer",customerService.findOne(id));
		model.addAttribute("products",productService.getAllProducts());
		return "customer/purchase";
	}
	//for purchase product
	@RequestMapping(value="/customers/email/purchase",method=RequestMethod.GET)
	public String purchase(@RequestParam String email,Model model) {
		
		model.addAttribute("customer",customerService.findByEmail(email));
		model.addAttribute("products",productService.getAllProducts());
		return "customer/purchase";
	}
	
	@RequestMapping(value="/customers/purchase",method=RequestMethod.GET)
	public String purchase(@Valid Model model) {
		/*model.addAttribute("customer",customerService.findOne(id));
		model.addAttribute("products",productService.getAllProducts());*/
		return "customer/customerEmail";
	}
	
	@RequestMapping(value="/customer/{id}/purchase/{pid}",method=RequestMethod.GET)
	public String addProduct2(@PathVariable long id, @PathVariable long pid, Model model,
							 HttpSession session) {


		Product product=productService.getProduct(pid);
		Product product1 = productService.getProductByProductId(pid);
		List<Product> cartProducts = addProductToCart(session,product);
		session.setAttribute("cartProducts",cartProducts);

		return "redirect:/customers/"+id+"/purchase";
	}

	//retrieve list of products from session
	@RequestMapping(value="/customers/{id}/retrieveProductFromSession",method=RequestMethod.GET)
	public String retrieveProductFromSession(Model model,@PathVariable long id,
							 HttpSession session) {
		List<Product> cartProducts = session.getAttribute("cartProducts")==null?
				new ArrayList<>() : (List<Product>) session.getAttribute("cartProducts");
        model.addAttribute("customer",customerService.findOne(id));
		model.addAttribute("cartProducts",cartProducts);
		return "product/cartlist"; //shows prod
	}



	//save in DB
	@RequestMapping(value="/customer/{id}/Order",method=RequestMethod.GET)
	public String addProduct(HttpSession session,@PathVariable long id) {
		List<Product> cartProducts = (List<Product>) session.getAttribute("cartProducts");
		Customer customer=customerService.getCustomer(id);
		assignOrderToCustomer(customer,cartProducts);
		customer=customerService.getCustomer(id);
		//System.out.print(customer.getOrders().get(1).getOrderId());

		return "redirect:/customers/"+id+"/purchase";
	}
	@RequestMapping(value="/customers/trackOrder",method=RequestMethod.GET)
	public String trackingAnOder(Model model) {
		//model.addAttribute("customer",customerService.getCustomer(id));
		//model.addAttribute("customer",customerService.findOne(id));
		return "customer/trackOrder";
	}
	@RequestMapping(value="/customers/getOrder",method=RequestMethod.GET)
	public String getAnOder(@RequestParam String order,Model model) {
	
		
		
		List<OrderLine> trackedorderLines=
				orderLineService.getAllOrderLine().stream()
				.filter(or->or.getOrders().getOrderId()==Long.parseLong(order))
				.collect(Collectors.toList());
		model.addAttribute("orderlist",trackedorderLines);
 	return "customer/trackedOrderDetail";
	}
	private void assignOrderToCustomer(Customer customer, List<Product> cartProducts) {
		Orders order=new Orders();
		customer.addOrders(order);
		order.setCustomer(customer);
		order.setDateOfOrder(LocalDate.now());
		List<OrderLine> orderLines=new ArrayList<>();
		boolean found=false;
		for(Product product:cartProducts){
			OrderLine orderLine=new OrderLine();
			for(OrderLine orL:orderLines) {
				if(orL.getProduct().getProductId()==product.getProductId()) {
					orL.setQuantity(orL.getQuantity()+1);
					found=true;
				}
			}
			if(found==true) {
				found=false;
				continue;	
			}
			orderLine.setQuantity(1);
			orderLine.setProduct(product);
			orderLine.setOrders(order);
			orderLines.add(orderLine);
			
		}
		//order.setOrderLines(orderLines);
		for(OrderLine orr:orderLines)
		orderLineService.add(orr);
		

	}
	


	private List<Product> addProductToCart(HttpSession session, Product product){
		List<Product> cartProducts = null;
		if(session.getAttribute("cartProducts")==null){
			cartProducts = new ArrayList<>();
			cartProducts.add(product);
		}else{
			cartProducts = (List<Product>) session.getAttribute("cartProducts");
			cartProducts.add(product);
		}
		return cartProducts;
	}
}
