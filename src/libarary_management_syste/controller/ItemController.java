/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libarary_management_syste.controller;

import java.util.ArrayList;
import libarary_management_syste.dto.ItemDto;
import libarary_management_syste.model.ItemModel;

/**
 *
 * @author LENOVO
 */
public class ItemController {

    private final ItemModel itemModel;

    public ItemController() throws Exception {
        this.itemModel = new ItemModel();
    }

    public String saveItem(ItemDto itemdto) throws Exception {
        return itemModel.saveItem(itemdto);
    }

    public ArrayList<ItemDto> getAllItem() throws Exception {
        return itemModel.getAllItem();
    }

    public ItemDto serchItem(Integer ItemId) throws Exception {
        return itemModel.serchItem(ItemId);
    }

    public String updateItem(ItemDto itemdto) throws Exception {
        return itemModel.updateItem(itemdto);
    }

    public String deleteItem(Integer Id) throws Exception {
        return itemModel.deleteItem(Id);
    }
}
