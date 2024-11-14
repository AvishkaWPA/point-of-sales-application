package com.example.point_of_sale.service;

import com.example.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.example.point_of_sale.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {

    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);
}
