package com.javaweb.repository;

import com.javaweb.model.entity.CustomerEntity;
import com.javaweb.repository.custom.ICustomerRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long>, ICustomerRepositoryCustom {
    Page<CustomerEntity> findAll(Pageable pageable);

    @Query("SELECT c FROM CustomerEntity c WHERE " +
            "(:name IS NULL OR c.name = :name) " +
            "AND (:customerPhone IS NULL OR c.customerPhone = :phone) " +
            "AND (:email IS NULL OR c.email = :email)")
    List<CustomerEntity> findByNameAndCustomerPhoneAndEmail(@Param("name") String name, @Param("phone") String customerPhone, @Param("email") String email);
    void deleteByIdIn(List<Long> ids);

//    Optional<CustomerEntity> findById(Long id);
}
