package com.medicare.repo;

import com.medicare.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("SELECT e FROM Product e WHERE e.productAvailability = TRUE")
    public List<Product> availableProductList();


    @Modifying
    @Transactional
    @Query("update Product p set p.productAvailability=FALSE where p.productId=:Id")
    public void disableProduct(@Param("Id") int id);

    @Modifying
    @Transactional
    @Query("update Product p set p.productAvailability=TRUE where p.productId=:Id")
    public void enableProduct(@Param("Id") int id);

}

