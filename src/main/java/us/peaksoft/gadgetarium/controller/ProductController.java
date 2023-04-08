package us.peaksoft.gadgetarium.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import us.peaksoft.gadgetarium.dto.*;
import org.springframework.web.bind.annotation.*;
import us.peaksoft.gadgetarium.dto.ProductDetailsResponse;
import us.peaksoft.gadgetarium.dto.ProductRequest;
import us.peaksoft.gadgetarium.dto.ProductResponse;
import us.peaksoft.gadgetarium.dto.SimpleResponse;
import us.peaksoft.gadgetarium.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    @Operation(description = "All users and admin can see a list of products ")
    public List<ProductResponse> AllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/saveMain")
    @Operation(description = "Only admin can add a product")
    @PostMapping("save-main")
    public ProductResponse save(@RequestBody ProductRequest productRequest) {
        return productService.save(productRequest);
    }

    @PostMapping("/savePrice/{id}")
    @Operation(description = "Only admin can add a price to product")
    @PostMapping("save-price/{id}")
    public ProductResponse savePrice(@PathVariable("id") Long id,
                                     @RequestBody ProductRequest priceRequest) {
        return productService.savePriceAndQuantity(id, priceRequest);
    }

    @PostMapping("/saveDescription/{id}")
    @Operation(description = "Only admin can add a description to product" )
    @PostMapping("save-description/{id}")
    public ProductResponse saveDescription(@PathVariable("id") Long id, @RequestBody ProductRequest descriptionRequest) {
        return productService.saveDescription(id, descriptionRequest);
    }

    @GetMapping("{id}")
    @Operation(description = "All users and admin can get product by id")
    public ProductResponse getById(@PathVariable("id") Long id) {
        return productService.getById(id);
    }

    @PutMapping("{id}")
    @Operation(description = "Only admin can update a product")
    public ProductResponse update(@PathVariable("id") Long id, @RequestBody ProductRequest productRequest) {
        return productService.update(id, productRequest);
    }

    @DeleteMapping("{id}")
    @Operation(description = "Only admin can delete a product")
    public SimpleResponse delete(@PathVariable("id") Long id) {
        return productService.delete(id);
    }

    @GetMapping("product-details")
    public List<ProductDetailsResponse> productDetails() {
        return productService.productDetails();
    }
}
