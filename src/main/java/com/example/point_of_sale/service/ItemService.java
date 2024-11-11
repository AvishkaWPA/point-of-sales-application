package com.example.point_of_sale.service;

import com.example.point_of_sale.dto.request.ItemSaveRequestDTO;

public interface ItemService {

    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);
}
