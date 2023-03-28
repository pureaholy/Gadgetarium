package us.peaksoft.gadgetarium.service;

import us.peaksoft.gadgetarium.dto.*;
import us.peaksoft.gadgetarium.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse save(ProductRequest productRequest);
    ProductResponse savePriceAndQuantity(Long id, ProductRequest productRequest);
    ProductResponse saveDescription(Long id,ProductRequest productRequest);
    ProductResponse update(Long id, ProductRequest productRequest);
    ProductResponse getById(Long id);
    ProductDeleteResponse delete(Long id);
}
