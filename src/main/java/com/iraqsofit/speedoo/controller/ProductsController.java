package com.iraqsofit.speedoo.controller;
import com.iraqsofit.speedoo.models.ProductsModel;
import com.iraqsofit.speedoo.models.Response;
import com.iraqsofit.speedoo.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/gemstone/v1")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping(value = {"/getProduct", "/getProduct/"})
    public ResponseEntity getListProducts(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity(productsService.getListProducts(pageNo, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping("/product/findByID/{id}")
    public ResponseEntity getProduct(@PathVariable long id) {

        return new ResponseEntity(productsService.getProduct(id), HttpStatus.OK);
    }

    @GetMapping("/products/findByName/{name}")
    public ResponseEntity findByName(@PathVariable String name) {
        return new ResponseEntity(
                new Response<ProductsModel>(
                        true,
                        productsService.findByName(name),
                        "Product found",
                        HttpStatus.OK.value()
                )
                , HttpStatus.OK
        );
    }

    /// change
    @PostMapping(
            value = "/product/create",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}
    )
    public ResponseEntity addProduct(@Valid ProductsModel productsModel) {
        productsModel.setCreatedAt();
        /*  Set<Media> mediaSet = new HashSet<Media>();
        mediaSet.add(new Media());
        productsModel.setMedia();*/
        return new ResponseEntity(productsService.addProduct(productsModel), HttpStatus.CREATED);
    }

    @PutMapping("/product/update")
    public ResponseEntity updateProduct(@RequestBody ProductsModel productsModel) {
        return new ResponseEntity(productsService.updateProduct(productsModel), HttpStatus.CREATED);
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable long id) {
        return new ResponseEntity(productsService.deleteProduct(id), HttpStatus.OK);
    }

}
