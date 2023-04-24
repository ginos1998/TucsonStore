package com.tucson.store.repository.implementations;

import com.tucson.store.entity.Marca;
import com.tucson.store.entity.Product;
import com.tucson.store.entity.Rubro;
import com.tucson.store.entity.tmp.TmpProduct;
import com.tucson.store.filters.BrandFilter;
import com.tucson.store.filters.IndustryFilter;
import com.tucson.store.filters.ProductFilter;
import com.tucson.store.repository.interfaces.IntProductRepository;
import com.tucson.store.utils.Constants;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
@Slf4j
public class ImpProductRepository implements IntProductRepository {
  @PersistenceContext
  private EntityManager entityManager;
  private List<Predicate> predicates;

  @Override
  public List<TmpProduct> getProductsWithFilter(ProductFilter filter) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<TmpProduct> criteriaQuery = criteriaBuilder.createQuery(TmpProduct.class);
    Root<TmpProduct> root = criteriaQuery.from(TmpProduct.class);
    predicates = new ArrayList<>();

    if (filter.getIdUser() > 0) {
      predicates.add(criteriaBuilder.equal(root.get("user"), filter.getIdUser()));
    }
    if (filter.getEnabled() != null) {
      predicates.add(criteriaBuilder.equal(root.get("habilitado"), filter.getEnabled()));
    }

    Predicate finalPredicate = criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

    criteriaQuery.where(finalPredicate);
    TypedQuery<TmpProduct> query = entityManager.createQuery(criteriaQuery);
    return query.getResultList();
  }

  @Override
  public void deleteProduct(int idProduct) {
    try {
      CriteriaBuilder builder = entityManager.getCriteriaBuilder();
      CriteriaDelete<Product> criteriaDelete = builder.createCriteriaDelete(Product.class);
      Root<Product> root = criteriaDelete.from(Product.class);

      Predicate predicate = builder.equal(root.get("idProduct"), idProduct);
      criteriaDelete.where(predicate);

      int deletedCount = entityManager.createQuery(criteriaDelete).executeUpdate();
      log.info("Criteria Delete: " + deletedCount + " item(s) deleted");

    } catch (Exception e) {
      log.info(e.getMessage());
    }
  }

  @Override
  public List<Marca> getBrandsWithFilter(BrandFilter brandFilter) {
    try {
      CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
      CriteriaQuery<Marca> brandCriteriaQuery = criteriaBuilder.createQuery(Marca.class);
      Root<Marca> brandRoot = brandCriteriaQuery.from(Marca.class);
      predicates = new ArrayList<>();

      if (brandFilter.getIdUser() > 0) {
        predicates.add(criteriaBuilder.equal(brandRoot.get("user"), brandFilter.getIdUser()));
      }
      if (brandFilter.getEnabled() != null) {
        predicates.add(criteriaBuilder.equal(brandRoot.get("habilitada"), brandFilter.getEnabled()));
      }

      Predicate finalPredicate = criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

      brandCriteriaQuery.where(finalPredicate);
      TypedQuery<Marca> query = entityManager.createQuery(brandCriteriaQuery);
      return query.getResultList();
    } catch (Exception e) {
      log.info(e.getMessage());
    }
    return Collections.emptyList();
  }

  @Override
  public List<Rubro> getIndustriesWithWilter(IndustryFilter filter) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Rubro> criteriaQuery = criteriaBuilder.createQuery(Rubro.class);
    Root<Rubro> root = criteriaQuery.from(Rubro.class);
    predicates = new ArrayList<>();

    if (filter.getIdUser() > 0) {
      predicates.add(criteriaBuilder.equal(root.get("user"), filter.getIdUser()));
    }
    if (filter.getEnabled() != null) {
      predicates.add(criteriaBuilder.equal(root.get("habilitado"), filter.getEnabled()));
    }

    Predicate finalPredicate = criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

    criteriaQuery.where(finalPredicate);
    TypedQuery<Rubro> query = entityManager.createQuery(criteriaQuery);
    return query.getResultList();
  }


}
