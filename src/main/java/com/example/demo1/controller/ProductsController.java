package com.example.demo1.controller;

import com.example.demo1.model.Product;
import com.example.demo1.service.impl.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/products")
    public String listAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "productsPage";
    }

    @GetMapping(value = "/product/productPage")
    public String productPage(@RequestParam(name = "id") int productId, Model model) {
        if(productService.productExists(productId)) {
            model.addAttribute("product", productService.getProductById(productId));
        }
        return "productPage";
    }

    @GetMapping(value = "/product/{id}")
    public String edit_product_form(@PathVariable(name = "id") int productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "updateProductPage";
    }

    @PostMapping(value = "/product/update")
    public String updateProduct(@RequestParam(name = "id") int productId, @ModelAttribute("product") Product newProduct,  RedirectAttributes redirectAttributes) {

        if(productService.productExists(productId)) {
            Product oldProduct = productService.getProductById(productId);

            oldProduct.setId(newProduct.getId());
            oldProduct.setName(newProduct.getName());
            oldProduct.setPrice(newProduct.getPrice());
            oldProduct.setStock(newProduct.getStock());
            oldProduct.setDescription(newProduct.getDescription());

            productService.updateProduct(oldProduct, newProduct);
            redirectAttributes.addFlashAttribute("updateMessage", "Successful update!");

        } else {
            redirectAttributes.addFlashAttribute("updateMessage", "Product does not exist!");
        }


        return "redirect:/products";
    }

    @PostMapping(value = "/product/create_product")
    public String createProduct(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        if(!productService.productExists(Integer.parseInt(request.getParameter("id")))) {

            Product product =
                    Product.builder()
                    .id(Integer.parseInt(request.getParameter("id")))
                    .name(request.getParameter("name"))
                    .price(Integer.parseInt(request.getParameter("price")))
                    .stock(Integer.parseInt(request.getParameter("stock")))
                    .description(request.getParameter("description"))
                    .build();

            product.setId(Integer.parseInt(request.getParameter("id")));
            product.setName((request.getParameter("name")));
            product.setPrice(Integer.parseInt(request.getParameter("price")));
            product.setStock(Integer.parseInt(request.getParameter("stock")));
            product.setDescription((request.getParameter("description")));

            redirectAttributes.addFlashAttribute("createMessage", "Product created!");
            productService.createProduct(product);
        } else {
            redirectAttributes.addFlashAttribute("createMessage", "A product with this id already exists!");
        }
        return "redirect:/products";
    }

    @GetMapping(value = "/product/delete_product")
    public String deleteProduct(@RequestParam(name = "id") int productId, RedirectAttributes redirectAttributes) {
        if(productService.productExists(productId)) {
            redirectAttributes.addFlashAttribute("deleteMessage", "Deleted product: " + productService.getProductById(productId).getName() + " | ID: " + productId);
            productService.deleteById(productId);
        } else {
            redirectAttributes.addFlashAttribute("deleteMessage", "Product does not exist!");
        }
        return "redirect:/products";
    }

}
