package co.develhope.bugtracker.controller.dto;

import java.util.List;

public class UserAspirapolvereResponseDto {

    private  String username;
    private List<Integer> listaID;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getListaID() {
        return listaID;
    }

    public void setListaID(List<Integer> listaID) {
        this.listaID = listaID;
    }
}
