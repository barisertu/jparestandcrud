package com.uebeung3.jparestandcrud.repository;

import com.uebeung3.jparestandcrud.model.Verein;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VereinRepository extends JpaRepository<Verein, Long> {

}
