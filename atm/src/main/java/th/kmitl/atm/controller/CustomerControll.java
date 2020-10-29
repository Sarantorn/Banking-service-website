package th.kmitl.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.kmitl.atm.model.Customer;
import th.kmitl.atm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerControll {

    private final CustomerService customerService;

    public CustomerControll(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getCustomerpage(Model model) {
        model.addAttribute("allCustomers",customerService.getCustomers());
        return "customer"; //customer.html
    }

    @PostMapping
    public String registerCustomer(Customer customer, Model model){
        customerService.createCustomer(customer);
        model.addAttribute("allCustomers",customerService.getCustomers());
        return "redirect:customer";
    }
}
