/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libarary_management_syste.controller;

import java.util.ArrayList;
import libarary_management_syste.dto.DvdDto;
import libarary_management_syste.model.DvdModel;

/**
 *
 * @author LENOVO
 */
public class DvdController {

    private final DvdModel dvdmodel;

    public DvdController() throws Exception {
        this.dvdmodel = new DvdModel();
    }

    public String saveDVD(DvdDto dvddto) throws Exception {
        return dvdmodel.saveDvD(dvddto);
    }

    public ArrayList<DvdDto> getAllDvd() throws Exception {
        return dvdmodel.getAllDvd();
    }

    public DvdDto serchDvd(Integer DvdId) throws Exception {
        return dvdmodel.serchDvd(DvdId);
    }

    public String UpdateDvd(DvdDto dvddto) throws Exception {
        return dvdmodel.UpdateDvd(dvddto);
    }

    public String DeleteDvd(Integer Id) throws Exception {
        return dvdmodel.DELETEDvd(Id);
    }
}
