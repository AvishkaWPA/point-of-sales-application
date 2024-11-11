package com.example.point_of_sale.controller;

import com.example.point_of_sale.dto.ItemDTO;
import com.example.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.example.point_of_sale.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save")
    public String SaveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String response = itemService.saveItem(itemSaveRequestDTO);
        return response;

    }
}
