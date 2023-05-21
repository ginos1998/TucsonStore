package com.tucson.store.controller;

import com.tucson.store.delegators.ProductDelegator;
import com.tucson.store.entity.*;
import com.tucson.store.entity.tmp.TmpProduct;
import com.tucson.store.filters.BrandFilter;
import com.tucson.store.filters.IndustryFilter;
import com.tucson.store.utils.Constants;
import com.tucson.store.utils.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class ProductController {
  private User currentUser;
  private List<TmpProduct> listProducts;
  private List<Marca> listMarcas;
  private List<Rubro> listRubros;
  private List<SubRubro> listSubRubro;
  private String thisPage = "redirect:/productsPage";

  @GetMapping("/productsPage")
  public String productsPage(Model model) {
    initController(model);
    return "products";
  }

  @PostMapping("/productsPage/addNewProduct")
  public String addNewProduct(@ModelAttribute("newProduct") TmpProduct newProduct) {
    Product product = mapNewProduct(newProduct);
    ProductDelegator.saveProduct(product);
    return thisPage;
  }

  private Product mapNewProduct(TmpProduct aux) {
    Product prod = new Product();
    // default values
    prod.setIdProduct(aux.getIdProduct());
    prod.setUser(currentUser);
    prod.setHabilitado(Constants.CHAR_S);
    // created/edited values
    prod.setProducto(aux.getProducto());
    prod.setCtdDisponible(aux.getCtdDisponible());
    prod.setPrecio(aux.getPrecio());
    prod.setDescripcion(aux.getDescripcion());

    if (aux.getMarca() == null || aux.getMarca().equals(Constants.STRING_ELEGIR)) {
      prod.setIdMarca(1); // should throw an exception
    } else {
      for (Marca m: listMarcas) {
        if (m.getMarca().equals(aux.getMarca())) {
          prod.setIdMarca(m.getIdMarca());
          break;
        }
      }
    }

    if (aux.getRubro() == null || aux.getRubro().equals(Constants.STRING_ELEGIR)) {
      prod.setIdRubro(1); // should throw an exception
    } else {
      for (Rubro r: listRubros) {
        if (r.getRubro().equals(aux.getRubro())) {
          prod.setIdRubro(r.getIdRubro());
          break;
        }
      }
    }

    if (aux.getSubrubro() == null || aux.getSubrubro().equals(Constants.STRING_ELEGIR)) {
      prod.setIdSubrubro(1); // should throw an exception
    } else {
      for (SubRubro r: listSubRubro) {
        if (r.getSubrubro().equals(aux.getSubrubro())) {
          prod.setIdSubrubro(r.getIdSubRubro());
          break;
        }
      }
    }

    return prod;
  }

  @GetMapping("/productsPage/deleteProduct")
  public String deleteProduct(TmpProduct deletedProduct) {
    ProductDelegator.deleteProduct(deletedProduct.getIdProduct());
    return thisPage;
  }

  @PostMapping("/productsPage/editProduct")
  public String editProduct(TmpProduct editedProduct) {
    Product product = mapNewProduct(editedProduct);
    ProductDelegator.saveProduct(product);
    return thisPage;
  }

  private void initController(Model model){
    currentUser = UserSession.getCurrentUser();
    initListProducts();
    initListMarcas();
    initListRubros();
    initListSubRubros();
    initModels(model);
  }

  private void initListProducts() {
    try {
      listProducts = ProductDelegator.fGetEnabledProducts(currentUser.getIdUser());
    } catch (Exception e) {
      log.info(e.getMessage());
    }
  }

  private void initListMarcas() {
    try {
      BrandFilter brandFilter = new BrandFilter(currentUser.getIdUser(), Constants.CHAR_S);
      listMarcas = ProductDelegator.getBrandsWithFilter(brandFilter);
    } catch (Exception e) {
      log.info(e.getMessage());
    }
  }

  private void initListRubros() {
    try {
      IndustryFilter filter = new IndustryFilter(currentUser.getIdUser(), Constants.CHAR_S);
      listRubros = ProductDelegator.getIndustriesWithFilter(filter);
    } catch (Exception e) {
      log.info(e.getMessage());
    }
  }

  private void initListSubRubros() {
    try {
      IndustryFilter filter = new IndustryFilter(listRubros, Constants.CHAR_S);
      listSubRubro = ProductDelegator.getSubIndustriesWithFilter(filter);
    } catch (Exception e) {
      log.info(e.getMessage());
    }
  }

  private void initModels(Model model) {
    model.addAttribute("newProduct", new TmpProduct());
    model.addAttribute("editedProduct", new TmpProduct());
    model.addAttribute("products", listProducts);
    model.addAttribute("listMarcas", listMarcas);
    model.addAttribute("listRubros", listRubros);
    model.addAttribute("listSubRubros", listSubRubro);
  }

}
