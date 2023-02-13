package com.ajith.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajith.model.ProfilePhoto;

public interface Profilerepo extends JpaRepository<ProfilePhoto, Integer> {

}
