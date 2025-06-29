package com.csh.oms.product_service;

import com.csh.oms.product_service.common.ActionResponse;
import com.csh.oms.product_service.dto.ProductRequestDTO;
import com.csh.oms.product_service.dto.ProductResponseDTO;
import com.csh.oms.product_service.model.Product;
import com.csh.oms.product_service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/product/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ActionResponse<String>> create(@RequestBody ProductRequestDTO productRequestDTO) {
        ActionResponse<String> actionResponse = productService.create(productRequestDTO);
        return new ResponseEntity<>(actionResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ActionResponse<List<ProductResponseDTO>>> getAllProducts() {
        ActionResponse<List<ProductResponseDTO>> actionResponse = productService.getAllProducts();
        return new ResponseEntity<>(actionResponse, HttpStatus.OK);
    }
}
