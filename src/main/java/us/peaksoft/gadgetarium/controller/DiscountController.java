package us.peaksoft.gadgetarium.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import us.peaksoft.gadgetarium.dto.DiscountRequest;
import us.peaksoft.gadgetarium.dto.DiscountResponse;
import us.peaksoft.gadgetarium.dto.ProductResponse;
import us.peaksoft.gadgetarium.dto.SimpleResponse;
import us.peaksoft.gadgetarium.service.DiscountService;

import java.util.List;

@RestController
@RequestMapping("api/discounts")
@Tag(name = "DiscountController", description = "API endpoints for managing discount")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;

    @GetMapping
    @Operation(description = "All user and admin can see")
    public List<DiscountResponse> discounts() {
        return discountService.getAllDiscounts();
    }

    @PostMapping
    @Operation(description = "Only admin can add a discount for product")
    public DiscountResponse save(@RequestBody DiscountRequest discountRequest) {
        return discountService.save(discountRequest);
    }

    @PutMapping("{id}")
    @Operation(description = "Only admin can update a discount")
    public DiscountResponse update(@PathVariable("id") Long id, @RequestBody DiscountRequest discountRequest) {
        return discountService.update(id, discountRequest);
    }

    @GetMapping("{id}")
    @Operation(description = "All users and admin can get discount by id ")
    public DiscountResponse getById(@PathVariable("id") Long id) {
        return discountService.getById(id);
    }

    @DeleteMapping("{id}")
    @Operation(description = "Only admin can delete a discount")
    public SimpleResponse delete(@PathVariable("id") Long id) {
        return discountService.delete(id);
    }

    @GetMapping("products/{id}")
    @Operation(description = "All user and admin can get a product")
    public List<ProductResponse> getProducts(@PathVariable(name = "id", required = false) Long id, @RequestParam(value = "page", required = false)
    int page, @RequestParam(name = "size", required = false) int size) {
        return discountService.getProductsByDiscountId(id, page, size);
    }
}
