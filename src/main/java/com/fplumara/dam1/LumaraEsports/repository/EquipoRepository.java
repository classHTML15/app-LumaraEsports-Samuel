package com.fplumara.dam1.LumaraEsports.repository;

import com.fplumara.dam1.LumaraEsports.model.Equipos;

import java.util.List;

public interface EquipoRepository {

    List<Equipos> obtenerTodos();

    Equipos buscarPorId(Long id);

    void guardar(Equipos equipo);

    void actualizar(Equipos equipo);

    void borrar(Long id);

    boolean existePorNombre(String nombre);

    boolean existePorNombreDistintoId(String nombre, Long id);
}
