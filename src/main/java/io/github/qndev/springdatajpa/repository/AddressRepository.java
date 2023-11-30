package io.github.qndev.springdatajpa.repository;

import io.github.qndev.springdatajpa.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Address addr WHERE addr.userId = :userId")
    void deleteAddressByUserIdUsingQuery(@Param("userId") String userId);

}
