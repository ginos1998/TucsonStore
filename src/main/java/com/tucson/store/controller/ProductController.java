package com.tucson.store.controller;

import com.tucson.store.delegators.ProductDelegator;
import com.tucson.store.entity.Marca;
import com.tucson.store.entity.Product;
import com.tucson.store.entity.Rubro;
import com.tucson.store.entity.User;
import com.tucson.store.entity.tmp.TmpProduct;
import com.tucson.store.filters.BrandFilter;
import com.tucson.store.filters.IndustryFilter;
import com.tucson.store.filters.ProductFilter;
import com.tucson.store.repository.RepositoryFactory;
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

  @GetMapping("/productsPage")
  public String productsPage(Model model) {
    initController(model);
    return "products";
  }

  @PostMapping("/productsPage/addNewProduct")
  public String addNewProduct(@ModelAttribute("newProduct") TmpProduct newProduct) {
    Product product = mapNewProduct(newProduct);
    ProductDelegator.saveProduct(product);
    return "redirect:/productsPage";
  }

  private Product mapNewProduct(TmpProduct aux) {
    Product prod = new Product();
    prod.setIdProduct(aux.getIdProduct());
    prod.setUser(currentUser);
    prod.setProducto(aux.getProducto());
    prod.setCtdDisponible(aux.getCtdDisponible());
    prod.setPrecio(aux.getPrecio());
    prod.setIdSubrubro(1);
    prod.setDescripcion(aux.getDescripcion());

    if (aux.getMarca() == null) {
      prod.setIdMarca(1);
    } else {
      for (Marca m: listMarcas) {
        if (m.getMarca().equals(aux.getMarca())) {
          prod.setIdMarca(m.getIdMarca());
          break;
        }
      }
    }

    if (aux.getRubro() == null) {
      prod.setIdRubro(1);
    } else {
      for (Rubro r: listRubros) {
        if (r.getRubro().equals(aux.getRubro())) {
          prod.setIdRubro(r.getIdRubro());
          break;
        }
      }
    }

    return prod;
  }

  @GetMapping("/productsPage/deleteProduct")
  public String deleteProduct(TmpProduct deletedProduct) {
    ProductDelegator.deleteProduct(deletedProduct.getIdProduct());
    return "redirect:/productsPage";
  }

  private void initController(Model model){
    currentUser = UserSession.getCurrentUser();
    initListProducts();
    initListMarcas();
    initListRubros();
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

  private void initModels(Model model) {
    model.addAttribute("newProduct", new TmpProduct());
    model.addAttribute("products", listProducts);
    model.addAttribute("listMarcas", listMarcas);
    model.addAttribute("listRubros", listRubros);
  }

}
