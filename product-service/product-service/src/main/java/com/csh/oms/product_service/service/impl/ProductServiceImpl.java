package com.csh.oms.product_service.service.impl;

import com.csh.oms.product_service.common.ActionResponse;
import com.csh.oms.product_service.dao.ProductRepository;
import com.csh.oms.product_service.dto.ProductRequestDTO;
import com.csh.oms.product_service.dto.ProductResponseDTO;
import com.csh.oms.product_service.exception.ProductServiceRuntimeException;
import com.csh.oms.product_service.model.Product;
import com.csh.oms.product_service.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ActionResponse<String> create(ProductRequestDTO productRequestDTO) {
        try {
            Product product = new Product.ProductResponseDtoBuilder()
                    .setName(productRequestDTO.getName())
                    .setDescription(productRequestDTO.getDescription())
                    .setPrice(productRequestDTO.getPrice())
                    .build();
            productRepository.save(product);

            logger.info("{} product created", product.getId());

            return new ActionResponse<>("Product Created Successfully", product.getId());
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new ProductServiceRuntimeException("Product creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ActionResponse<List<ProductResponseDTO>> getAllProducts() {
        try {
            List<ProductResponseDTO> products = productRepository.findAll().stream().map(this::getProductDto).toList();
            return new ActionResponse<>(products);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new ProductServiceRuntimeException("Products retrieving failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ProductResponseDTO getProductDto(Product product) {
        return new ProductResponseDTO.ProductResponseDTOBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setDescription(product.getDescription())
                .setPrice(product.getPrice())
                .build();
    }
}
