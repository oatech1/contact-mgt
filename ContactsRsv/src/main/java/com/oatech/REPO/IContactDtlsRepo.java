package com.oatech.REPO;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oatech.entity.ContactEntity;

public interface IContactDtlsRepo extends JpaRepository<ContactEntity, Serializable> {

}
