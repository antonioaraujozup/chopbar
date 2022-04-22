package br.com.zup.edu.nossosistemadebares.bar;

import javax.validation.constraints.NotBlank;

public class ReservaMesaRequest {

    @NotBlank
    private String reservadoPara;

    public ReservaMesaRequest(String reservadoPara) {
        this.reservadoPara = reservadoPara;
    }

    public ReservaMesaRequest() {
    }

    public String getReservadoPara() {
        return reservadoPara;
    }
}
