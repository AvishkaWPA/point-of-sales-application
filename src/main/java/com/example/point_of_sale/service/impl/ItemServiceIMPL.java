package com.example.point_of_sale.service.impl;

import com.example.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.example.point_of_sale.dto.response.ItemGetResponseDTO;
import com.example.point_of_sale.entity.Item;
import com.example.point_of_sale.entity.enums.MeasuringUnitType;
import com.example.point_of_sale.repo.ItemRepo;
import com.example.point_of_sale.service.ItemService;
import com.example.point_of_sale.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
//        Item item = new Item(
//                1,
//                itemSaveRequestDTO.getItemName(),
//                itemSaveRequestDTO.getMeasuringUnitType(),
//                itemSaveRequestDTO.getBalanceQty(),
//                itemSaveRequestDTO.getSupplierPrice(),
//                itemSaveRequestDTO.getSellingPrice(),
//                true
//        );
//        itemRepo.save(item);
//        return item.getItemName();

        Item item = modelMapper.map(itemSaveRequestDTO,Item.class);
        item.setActiveState(true);
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return "successfully saved";

        }else {
            throw new DuplicateKeyException("Already existed");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {

        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,true);
        if(!items.isEmpty()){
            List<ItemGetResponseDTO> itemsDTOS = modelMapper.map(items,new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
            return itemsDTOS;
        }else {
            throw new RuntimeException("Not found!");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusWithMapstruct(String itemName) {
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,true);
        if(!items.isEmpty()){
            List<ItemGetResponseDTO> itemsDTOS = itemMapper.entityListToDTOList(items);
            return itemsDTOS;
        }else {
            throw new RuntimeException("Not found!");
        }
    }

}
