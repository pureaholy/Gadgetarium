package us.peaksoft.gadgetarium.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import us.peaksoft.gadgetarium.dto.*;
import us.peaksoft.gadgetarium.service.BasketService;
import java.util.List;

@RestController
@RequestMapping("api/cart")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @PostMapping("save-product/{id}")
    public ProductResponse saveProduct(@PathVariable("id") Long id, @RequestBody ProductRequest productRequest) {
        return basketService.saveProductIntoBasket(id, productRequest);
    }

    @PutMapping("remove-product/{id}")
    public SimpleResponse deleteProduct(@PathVariable("id") Long id, @RequestBody ProductRequest productRequest) {
        return basketService.removeProductFromBasket(id, productRequest);
    }


    @PutMapping("remove-products/{id}")
    public SimpleResponse deleteAllProduct(@PathVariable("id") Long id, @RequestBody ProductRequest productRequest){
        return basketService.removeAllProductFromBasket(id,productRequest);
    }

    @GetMapping("products/{id}")
    public List<ProductResponse> productsOfCart(@PathVariable(name = "id", required = false) Long id, @RequestParam(value = "page", required = false)
    int page, @RequestParam(name = "size", required = false) int size) {
        return basketService.getProductsByBasketId(id, page, size);
    }
}
