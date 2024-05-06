package com.example.demo1.controller;

import com.example.demo1.model.Product;
import com.example.demo1.model.dto.ProductDto;
import com.example.demo1.repository.ProductsRepository;
import com.example.demo1.service.impl.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class ProductsController {

    @Autowired
    private final ProductService productService;
    @Autowired
    private final ProductsRepository productsRepository;

    @GetMapping(value = "/productList")
    public String listAllProducts(Model model) {
        model.addAttribute("products", productsRepository.findAll());
        return "products/productListPage";
    }

    @GetMapping(value = "/product/productPage")
    public String productPage(@RequestParam(name = "id") int productId, Model model) {
        if(productsRepository.findById(productId) != null) {
            model.addAttribute("product", productsRepository.findById(productId));
        }
        return "products/productPage";
    }

    @GetMapping(value = "/product/updateProduct/{id}")
    public String edit_product_form(@PathVariable(name = "id") int productId, Model model) {
        if(productsRepository.findById(productId) != null) {
            model.addAttribute("product", productsRepository.findById(productId));
            return "products/updateProductPage";
        } else {
            return "redirect:/productList";
        }
    }

    @PostMapping(value = "/product/update")
    public String updateProduct(@RequestParam(name = "id") int productId, @ModelAttribute("product") ProductDto productDto,  RedirectAttributes redirectAttributes) {
        if(productsRepository.findById(productId) != null) {
            productService.updateProduct(productId, productDto);
            redirectAttributes.addFlashAttribute("updateMessage", "Successful update!");
        } else {
            redirectAttributes.addFlashAttribute("updateMessage", "Product does not exist!");
        }
        return "redirect:/productList";
    }

    @PostMapping(value = "/product/create_product")
    public String createProduct(HttpServletRequest request, Model model, BindingResult bindingResult) {
            if(bindingResult.hasErrors()) {
                model.addAttribute("errors", bindingResult.getFieldErrors());
            } else {
                ProductDto productDto =
                        ProductDto.builder()
                                .name(request.getParameter("name"))
                                .price(Integer.parseInt(request.getParameter("price")))
                                .stock(Integer.parseInt(request.getParameter("stock")))
                                .description(request.getParameter("description"))
                                .build();

                model.addAttribute("createMessage", "Product created!");
                productService.createProduct(productDto);
            }

        return "redirect:/productList";
    }

    @GetMapping(value = "/product/delete_product")
    public String deleteProduct(@RequestParam(name = "id") int productId, RedirectAttributes redirectAttributes) {
        if(productsRepository.findById(productId) != null) {
            redirectAttributes.addFlashAttribute("deleteMessage", "Deleted product: [" + productsRepository.findById(productId).getName() + "] with id: [" + productId + "]");
            productService.deleteProduct(productId);
        } else {
            redirectAttributes.addFlashAttribute("deleteMessage", "Product does not exist!");
        }
        return "redirect:/productList";
    }

}
