/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libarary_management_syste.dto;

/**
 *
 * @author LENOVO
 */
public class DvdDto {

    private Integer ItemId;
    private Integer DvdId;
    private String Dvdname;
    private String Director;
    private String Duration;

    public DvdDto() {

    }

    public Integer getItemId() {
        return ItemId;
    }

    public void setItemId(Integer ItemId) {
        this.ItemId = ItemId;
    }

    public Integer getDvdId() {
        return DvdId;
    }

    public void setDvdId(Integer DvdId) {
        this.DvdId = DvdId;
    }

    public String getDvdname() {
        return Dvdname;
    }

    public void setDvdname(String Dvdname) {
        this.Dvdname = Dvdname;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    @Override
    public String toString() {
        return "DvdDto{" + "ItemId=" + ItemId + ", DvdId=" + DvdId + ", Dvdname=" + Dvdname + ", Director=" + Director + ", Duration=" + Duration + '}';
    }

}
