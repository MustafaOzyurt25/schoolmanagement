package com.schoolmanagement.repositories;

import com.schoolmanagement.domain.ContactMessage;

import com.schoolmanagement.dto.RespContactMessageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage,Long> {

  // 1. sadece ,yeni bir ContactMessage CREATE etmede, repository interface'nin icinde custom bir metod/jpql kullanmadim!
  
  
    //2./contactMessages/getAll
    @Query("SELECT new com.schoolmanagement.dto.RespContactMessageDto(c) FROM ContactMessage c")
    List<RespContactMessageDto> findAllContactMessage();

    
    //3.Search Contact Message By Email Address With Pageable
    @Query("SELECT new com.schoolmanagement.dto.RespContactMessageDto(c) FROM ContactMessage c")
    Page<RespContactMessageDto> findAllWithPage(Pageable pageable);


    
    //4.Search Contact Message By Subject With Pageable
    @Query("SELECT new com.schoolmanagement.dto.RespContactMessageDto(c) FROM ContactMessage c")
    Page<RespContactMessageDto> searchContactMessagesBySubjectWithPageable(Pageable pageable);
}
