package us.peaksoft.gadgetarium.service;

import us.peaksoft.gadgetarium.dto.*;
import us.peaksoft.gadgetarium.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse save(ProductRequest productRequest);
    ProductResponse savePriceAndQuantity(Long id, ProductPriceAndQuantityRequest productPriceAndQuantityRequest);
    ProductResponse saveDescription(ProductDescriptionRequest productDescriptionRequest);
    ProductResponse update(Long id, ProductRequest productRequest, ProductPriceAndQuantityRequest priceAndQuantityReques, ProductDescriptionRequest descriptionRequest);
    ProductResponse getById(Long id);
    ProductDeleteResponse delete(Long id);
}
