package us.peaksoft.gadgetarium.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import us.peaksoft.gadgetarium.dto.*;
import us.peaksoft.gadgetarium.service.BasketService;

import java.util.List;

@RestController
@RequestMapping("api/cart")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @PostMapping("save-product-to-cart/{id}")
    public ProductResponse saveProduct(@PathVariable("id") Long id, @RequestBody ProductRequest productRequest){
        return basketService.saveProductIntoBasket(id,productRequest);
    }

    @PutMapping ("remove-product-from-cart/{id}")
    public SimpleResponse deleteProduct(@PathVariable("id") Long id,@RequestBody ProductRequest productRequest){
        return basketService.removeProductFromBasket(id,productRequest);
    }

    @GetMapping("products-of-cart/{id}")
    public List<ProductResponse> productsOfCart(@PathVariable(name = "id", required = false) Long id, @RequestParam(value = "page", required = false)
    int page, @RequestParam(name = "size", required = false) int size){
        return basketService.getProductsByBasketId(id,page,size);
    }

}
