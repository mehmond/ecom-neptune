package com.app.NeptuneDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.NeptuneDemo.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
