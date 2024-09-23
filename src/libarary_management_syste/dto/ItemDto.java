/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libarary_management_syste.dto;

/**
 *
 * @author LENOVO
 */
public class ItemDto {

    private Integer ItemId;
    private String ItemName;
    private String Avilibilty;

    public ItemDto(){
        
    }
    
    public Integer getItemId() {
        return ItemId;
    }

    public void setItemId(Integer ItemId) {
        this.ItemId = ItemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getAvilibilty() {
        return Avilibilty;
    }

    public void setAvilibilty(String Avilibilty) {
        this.Avilibilty = Avilibilty;
    }

    @Override
    public String toString() {
        return "ItemDto{" + "ItemId=" + ItemId + ", ItemName=" + ItemName + ", Avilibilty=" + Avilibilty + '}';
    }

}
