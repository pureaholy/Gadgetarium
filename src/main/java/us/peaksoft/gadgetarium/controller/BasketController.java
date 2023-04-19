package us.peaksoft.gadgetarium.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import us.peaksoft.gadgetarium.dto.*;
import us.peaksoft.gadgetarium.service.BasketService;

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


}
