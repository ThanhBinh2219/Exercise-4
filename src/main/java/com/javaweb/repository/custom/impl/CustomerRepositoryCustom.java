package com.javaweb.repository.custom.impl;

import com.javaweb.model.entity.CustomerEntity;
import com.javaweb.repository.ICustomerRepository;
import com.javaweb.repository.custom.ICustomerRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;
@Repository
public class CustomerRepositoryCustom implements ICustomerRepositoryCustom {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public List<CustomerEntity> getAttributes(Map<String, Object> attributes) {
//        String sql = "SELECT c FROM CustomerEntity c WHERE ";
//        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
//            if (entry.getValue() != null) {
//                if (entry.getKey().equals("name")) {
//                    sql += "c.name = :name AND ";
//                } else if (entry.getKey().equals("customerPhone")) {
//                    sql += "c.customerPhone = :customerPhone AND ";
//                } else if (entry.getKey().equals("email")) {
//                    sql += "c.email = :email AND ";
//                }
//            }
//        }
//        sql = sql.substring(0, sql.lastIndexOf(" AND "));
//        System.out.println("Final sql: " + sql);
//        Query query = entityManager.createQuery(sql, CustomerEntity.class);
//        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
//            if (entry.getValue() != null) {
//                query.setParameter(entry.getKey(), entry.getValue());
//            }
//        }
//        return query.getResultList();
//    }
}
