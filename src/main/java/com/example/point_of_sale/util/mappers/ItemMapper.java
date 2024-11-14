package com.example.point_of_sale.util.mappers;

import com.example.point_of_sale.dto.response.ItemGetResponseDTO;
import com.example.point_of_sale.entity.Item;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    // ItemList ->> ItemResponseDTO
    List<ItemGetResponseDTO> entityListToDTOList(List<Item> items);

}
