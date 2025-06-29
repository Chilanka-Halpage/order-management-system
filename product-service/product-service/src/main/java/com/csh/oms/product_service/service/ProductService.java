package com.csh.oms.product_service.service;

import com.csh.oms.product_service.common.ActionResponse;
import com.csh.oms.product_service.dto.ProductRequestDTO;
import com.csh.oms.product_service.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ActionResponse<String> create(ProductRequestDTO productRequestDTO);
    ActionResponse<List<ProductResponseDTO>> getAllProducts();
}
