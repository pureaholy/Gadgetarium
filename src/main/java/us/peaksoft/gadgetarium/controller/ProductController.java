package us.peaksoft.gadgetarium.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import us.peaksoft.gadgetarium.dto.*;
import us.peaksoft.gadgetarium.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductResponse>AllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/saveMain")
    public ProductResponse save(@RequestBody ProductRequest productRequest){
       return productService.save(productRequest);
    }
    @PostMapping("/savePrice")
    public ProductResponse savePrice(@RequestBody ProductPriceAndQuantityRequest priceAndQuantityRequest){
        return productService.savePriceAndQuantity(priceAndQuantityRequest);
    }
    @PostMapping("/saveDescription")
    public ProductResponse saveDescription(@RequestBody ProductDescriptionRequest descriptionRequest){
        return productService.saveDescription(descriptionRequest);
    }

    @GetMapping("{id}")
    public ProductResponse getById (@PathVariable("id") Long id){
        return productService.getById(id);
    }

    @PutMapping("{id}")
    public  ProductResponse update(@PathVariable("id") Long id, @RequestBody ProductRequest productRequest, ProductPriceAndQuantityRequest priceAndQuantityReques, ProductDescriptionRequest descriptionRequest){
        return productService.update(id,productRequest, priceAndQuantityReques,descriptionRequest);
    }

    @DeleteMapping("{id}")
    public ProductDeleteResponse delete(@PathVariable("id") Long id){
        return productService.delete(id);
    }
}
