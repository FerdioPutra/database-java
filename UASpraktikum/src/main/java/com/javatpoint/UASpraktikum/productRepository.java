package com.javatpoint.UASpraktikum;

import com.javatpoint.UASpraktikum.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<product, Long> {
}
