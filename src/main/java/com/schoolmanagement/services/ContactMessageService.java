package com.schoolmanagement.services;

import com.schoolmanagement.domain.ContactMessage;

import com.schoolmanagement.dto.ReqContactMessgDto;
import com.schoolmanagement.dto.RespContactMessageDto;
import com.schoolmanagement.repositories.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    //1./contactMessages/save

    public void createContactMessage(ReqContactMessgDto reqContactMessgDto) {
        ContactMessage contactMessage = new ContactMessage(reqContactMessgDto);
        contactMessageRepository.save(contactMessage);
    }

    //2./contactMessages/getAll   DTO<-->Entity arasinda burda donusum icin bazi bazi yaklasimlar var
    public List<RespContactMessageDto> getAllContactMessages() {
        List<RespContactMessageDto> respContactMessageDtoList = contactMessageRepository.findAllContactMessage();
        //  List<RespContactMessageDto> respContactMessageDtos = contactMessageRepository.mapToDTOList(contactMessages);


        return respContactMessageDtoList;
    }


    //3.Search Contact Message By Email Address With Pageable

    public Page<RespContactMessageDto> searchContactMessagesByEmailWithPageable(Pageable pageable) {
        Page<RespContactMessageDto> contactMessageDTOS = contactMessageRepository.findAllWithPage(pageable);
        return contactMessageDTOS;
    }
    

    //4.Search Contact Message By Subject With Pageable

    public Page<RespContactMessageDto> searchContactMessagesBySubjectWithPageable(Pageable pageable) {
        // contactMessageRepository.findAll(pageable);  burda donusum icin bazi bazi yaklasimlar var 

        Page<RespContactMessageDto> respContactMessageDtos = contactMessageRepository.searchContactMessagesBySubjectWithPageable(pageable);
        return respContactMessageDtos;
    }


}//class
