package com.example.point_of_sale.controller;

import com.example.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.example.point_of_sale.dto.response.ItemGetResponseDTO;
import com.example.point_of_sale.service.ItemService;
import com.example.point_of_sale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> SaveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String message= itemService.saveItem(itemSaveRequestDTO);
//
//        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
//                new StandardResponse(200,"Success",message), HttpStatus.CREATED
//        );
//        return response;

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Sucsess",message),
                HttpStatus.CREATED);
    }

    @GetMapping(
            path = "/getByName",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getItemByNameAndStatus(@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatus(itemName);
        return new ResponseEntity<StandardResponse>(new StandardResponse(
                200,
                "Success",
                itemDTOS
        ),HttpStatus.OK);
    }

    @GetMapping(
            path = "/getByName2",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getItemByNameAndStatusWithMapstruct(@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatusWithMapstruct(itemName);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success",itemDTOS),HttpStatus.OK);
    }
}
