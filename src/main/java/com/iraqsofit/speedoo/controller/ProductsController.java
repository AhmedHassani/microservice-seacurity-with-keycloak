package com.iraqsofit.speedoo.controller;
import com.iraqsofit.speedoo.models.ProductsModel;
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

    @GetMapping(value = {"/getListProductsCategory", "/getListProductsCategory/"})
    public ResponseEntity getListProductsCategory(
            @RequestParam(defaultValue = "") String cate,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity(productsService.getListProductsCategory(cate,pageNo, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping("/product/findByID/{id}")
    public ResponseEntity getProduct(@PathVariable long id) {

        return new ResponseEntity(productsService.getProduct(id), HttpStatus.OK);
    }


    @GetMapping(value = {"/product/findByDiscount","/product/findByDiscount/"})
    public ResponseEntity getProductDiscount(
                                              @RequestParam(defaultValue = "0") Integer pageNo,
                                              @RequestParam(defaultValue = "10") Integer pageSize,
                                              @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity(productsService.getProductDiscount(0.1,pageNo,pageSize,sortBy), HttpStatus.OK);
    }


    /// change
    @PostMapping(
            value = "/product/create",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}
    )
    public ResponseEntity addProduct(@Valid ProductsModel productsModel) {
        productsModel.setCreatedAt();
        /* Set<Media> mediaSet = new HashSet<Media>();
        mediaSet.add(new Media());
        productsModel.setMedia(mediaSet);*/
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

    @GetMapping("/product/search/{q}")
    public ResponseEntity deleteProduct(@PathVariable String q,
                                        @RequestParam(defaultValue = "0") Integer pageNo,
                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                        @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity(productsService.search(q,pageNo,pageSize,sortBy), HttpStatus.OK);
    }







}
