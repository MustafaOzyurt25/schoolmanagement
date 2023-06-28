package com.schoolmanagement.controllers;

import com.schoolmanagement.domain.ContactMessage;
import com.schoolmanagement.dto.ReqContactMessgDto;
import com.schoolmanagement.dto.RespContactMessageDto;
import com.schoolmanagement.services.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contactMessages")//http://localhost:8080/contactMessages
public class ContactMessageController {

    @Autowired
    private ContactMessageService contactMessageService;


    //1-yeni bir ContactMessage CREATE etme
    //http://localhost:8080//contactMessages/save + POST + RequestBody(JSON)
    // Save Contact Message
    @PostMapping("/save")
    public ResponseEntity<Map<String,String>> createContactMessage(@Valid @RequestBody ReqContactMessgDto reqContactMessgDto) {
        contactMessageService.createContactMessage(reqContactMessgDto);
       Map<String,String> map = new HashMap<>();
        map.put("status: ","succesfull");
       map.put("kayit: ","Mesaj kayit islemi basarili!");
       return ResponseEntity.ok(map);
    }


    //2-tüm contactMessages lari  listeleyelim:READ
    //http://localhost:8080/contactMessages/getAll + GET
    @GetMapping("/getAll")
    public ResponseEntity<List<RespContactMessageDto>> getAllContactMessages() {
        List<RespContactMessageDto> respContactMessageDtos = contactMessageService.getAllContactMessages();

        
        return ResponseEntity.ok(respContactMessageDtos);
    }


    //3- Search Contact Message By Email Address With Pageable
    // /contactMessages/searchByEmail

    @GetMapping("/searchByEmail")
    public ResponseEntity<Page<RespContactMessageDto>> searchContactMessagesByEmail
            (@RequestParam(value = "page",defaultValue ="0",required = false) Integer page,
             @RequestParam(value = "size",required = false,defaultValue = "3") Integer size,
             @RequestParam("sort") String prop,
             @RequestParam("direction") Sort.Direction direction) {

        Pageable pageable =PageRequest.of(page,size,Sort.by(direction,prop));
        Page<RespContactMessageDto> respContactMessageDtos =contactMessageService.searchContactMessagesByEmailWithPageable(pageable);
        return ResponseEntity.ok(respContactMessageDtos);
    }

    // 4-Search Contact Message By Subject With Pageable
    // /contactMessages/searchBySubject

    @GetMapping("/searchBySubject")

    public ResponseEntity<Page<RespContactMessageDto>> searchContactMessagesBySubject
            (@RequestParam(value = "page",defaultValue ="0",required = false) Integer page,
             @RequestParam(value = "size",required = false,defaultValue = "3") Integer size,
             @RequestParam("sort") String prop,
             @RequestParam("direction") Sort.Direction direction) {

        Pageable pageable =PageRequest.of(page,size,Sort.by(direction,prop));
        Page<RespContactMessageDto> respContactMessageDtos =contactMessageService.searchContactMessagesBySubjectWithPageable(pageable);
        return ResponseEntity.ok(respContactMessageDtos);
    }
    


}
    
    



