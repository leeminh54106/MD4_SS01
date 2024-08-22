package com.ra.session01.controller;

import com.ra.session01.model.entity.Product;
import com.ra.session01.service.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }
    @PostMapping("/add")
    public String doAdd(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "add";
        }
        productService.save(product);
        return "redirect:/products/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String doEdit(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products/list";
    }
}
