package com.ajith.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajith.model.DocterModel;

public interface DocterRepo extends JpaRepository<DocterModel, Integer> {

}
