package org.grupo2.modelos;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

public class Reserva {
    private int id;
    private Livro livro;
    private Cliente cliente;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public Reserva() {
    }

    public Reserva(int id, Livro livro, LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.id = id;
        this.livro = livro;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return id == reserva.id && Objects.equals(livro, reserva.livro) && Objects.equals(dataInicio, reserva.dataInicio) && Objects.equals(dataFim, reserva.dataFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, livro, dataInicio, dataFim);
    }

    public boolean existeReserva(Livro livro, Cliente cliente) {
        return Biblioteca.procurarReserva(livro, cliente).isPresent();
    }
}
