package com.projectcodingdojo.petjoy_shop.petjoy_shop.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.Product;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.ProductAnimal;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.ProductBrand;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.ProductType;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.services.ProductAnimalService;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.services.ProductBrandService;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.services.ProductService;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.services.ProductTypeService;

import jakarta.validation.Valid;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/dashboard")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductBrandService productBrandService;

    @Autowired
    private ProductAnimalService productAnimalService;

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("")
    public String showDashboard(Model model) {
        List<Product> products = productService.findActive();
        model.addAttribute("products", products);
        return "dashProducts";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());

        List<ProductBrand> productsBrands = productBrandService.findActive();
        model.addAttribute("productsBrands", productsBrands);

        List<ProductAnimal> productsAnimals = productAnimalService.findActive();
        model.addAttribute("productsAnimals", productsAnimals);

        List<ProductType> productsTypes = productTypeService.findActive();
        model.addAttribute("productsTypes", productsTypes);

        return "dashAddProduct";
    }

    @PostMapping("/add")
    public String saveProduct(@Valid @ModelAttribute("product") Product product,
            BindingResult result,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        System.out.println("saveProduct method called");
        System.out.println("Image received: " + imagenFile.getOriginalFilename());
        System.out.println(imagenFile.getOriginalFilename());
        System.out.println("GetName: " + imagenFile.getName());

        if (result.hasErrors()) {
            return "dashAddProduct";
        }

        Product existingActiveProduct = productService.findByNombreAndActive(product.getNombre(), 1);
        if (existingActiveProduct != null) {
            result.rejectValue("nombre", "duplicate", "Ya existe un producto con el mismo nombre.");
            return "dashAddProduct";
        }

        Product existingActiveProductByCodigo = productService.findByCodigoAndActive(product.getCodigo(), 1);
        if (existingActiveProductByCodigo != null) {
            result.rejectValue("codigo", "duplicate", "Ya existe un producto con el mismo código.");
            return "dashAddProduct";
        }

        if (!imagenFile.isEmpty()) {
            String contentType = imagenFile.getContentType();

            if (contentType != null && (contentType.equals("image/png") || contentType.equals("image/jpeg"))) {
                try {

<<<<<<< HEAD
                    product = productService.save(product);

=======
>>>>>>> dc8a9435121ea3520508544c1b8287abb38b864d
                    String originalFileName = imagenFile.getOriginalFilename();
                    String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
                    String fileName = product.getId() + extension;
                    File imagenFileDestino = new File("src/main/resources/static/img/products", fileName);

                    System.out.println("Image save path: " + imagenFileDestino.getAbsolutePath());

                    byte[] bytes = imagenFile.getBytes();
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(imagenFileDestino));
                    stream.write(bytes);
                    stream.close();

                    product.setImagen(fileName);
                    productService.save(product);

                } catch (Exception e) {
                    System.out.println("Error al subir el archivo");
                }
            } else {
                result.rejectValue("imagenFile", "invalidFormat", "Solo se admiten formatos PNG o JPEG");
                return "dashAddProduct";
            }
        } else {
            product.setImagen("default.png");
            productService.save(product);
        }

<<<<<<< HEAD
        productService.save(product);
=======
        product = productService.save(product);
>>>>>>> dc8a9435121ea3520508544c1b8287abb38b864d
        System.out.println("producto: " + product);

        return "redirect:/dashboard";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
<<<<<<< HEAD
        List<ProductBrand> productsBrands = productBrandService.findActive();
        model.addAttribute("productsBrands", productsBrands);
        List<ProductAnimal> productsAnimals = productAnimalService.findActive();
        model.addAttribute("productsAnimals", productsAnimals);
=======

        List<ProductBrand> productsBrands = productBrandService.findActive();
        model.addAttribute("productsBrands", productsBrands);

        List<ProductAnimal> productsAnimals = productAnimalService.findActive();
        model.addAttribute("productsAnimals", productsAnimals);

>>>>>>> dc8a9435121ea3520508544c1b8287abb38b864d
        List<ProductType> productsTypes = productTypeService.findActive();
        model.addAttribute("productsTypes", productsTypes);

        return "dashEditProduct";
    }

    @PutMapping("/{id}/editProduct")
    public String editProduct(@PathVariable("id") Long id, @Valid @ModelAttribute("product") Product product,
            @RequestParam("imagenFile") MultipartFile imagenFile, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "dashEditProduct";
        }

        Product existingProduct = productService.findById(id);
        if (existingProduct == null) {
<<<<<<< HEAD
            return "redirect:/dashboard";
        }

=======
            // Manejo de error si no se encuentra el producto a editar
            return "redirect:/dashboard"; // O redireccionar a una página de error
        }

        // Actualizar los campos del producto existente con los nuevos valores
>>>>>>> dc8a9435121ea3520508544c1b8287abb38b864d
        existingProduct.setNombre(product.getNombre());
        existingProduct.setCodigo(product.getCodigo());
        existingProduct.setPrecio(product.getPrecio());
        existingProduct.setStock(product.getStock());
        existingProduct.setMarca_producto(product.getMarca_producto());
        existingProduct.setProducto_animal(product.getProducto_animal());
        existingProduct.setTipo_producto(product.getTipo_producto());
        existingProduct.setFechaElaboracion(product.getFechaElaboracion());
        existingProduct.setFechaVencimiento(product.getFechaVencimiento());
        existingProduct.setDescripcion(product.getDescripcion());

        if (!imagenFile.isEmpty()) {
            String contentType = imagenFile.getContentType();

            if (contentType != null && (contentType.equals("image/png") || contentType.equals("image/jpeg"))) {
                try {
                    String originalFileName = imagenFile.getOriginalFilename();
                    String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
                    String fileName = existingProduct.getId() + extension;
                    File imagenFileDestino = new File("src/main/resources/static/img/products", fileName);

                    System.out.println("Image save path: " + imagenFileDestino.getAbsolutePath());

                    byte[] bytes = imagenFile.getBytes();
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(imagenFileDestino));
                    stream.write(bytes);
                    stream.close();

                    existingProduct.setImagen(fileName);
                } catch (Exception e) {
                    System.out.println("Error al subir el archivo");
                }
            } else {
                result.rejectValue("imagenFile", "invalidFormat", "Solo se admiten formatos PNG o JPEG");
                return "dashEditProduct";
            }
        }

        productService.save(existingProduct);
        return "redirect:/dashboard";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteProduct(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            product.setActive(0);
            productService.update(product);
        }
        return "redirect:/dashboard";
    }

    // Facturación

    @GetMapping("/bills")
    public String showBills() {
        return "dashBills";
    }

    @GetMapping("/bills/1")
    public String showBillsDetail() {
        return "dashBillDetail";
    }

    // @GetMapping("/bills/{id}")
    // public String showBillsDetail(@PathVariable("id") Long id){
    // return "dashBillDetail";
    // }

}
