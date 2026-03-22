package com.fplumara.dam1.LumaraEsports.repository;


import com.fplumara.dam1.LumaraEsports.model.Equipos;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class EquipoRepositoryImpl implements EquipoRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Equipos> obtenerTodos() {
        String sql = "SELECT * FROM equipos ORDER BY id";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Equipos(
                        rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getString("juego"),
                        rs.getString("pais")
                )
        );
    }

    public Equipos buscarPorId(Long id) {
        String sql = "SELECT * FROM equipos WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Equipos(
                        rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getString("juego"),
                        rs.getString("pais")
                ), id
        );
    }

    public void guardar(Equipos equipo) {
        String sql = "INSERT INTO equipos (nombre, juego, pais) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, equipo.getNombre(), equipo.getJuego(), equipo.getPais());
    }

    public void actualizar(Equipos equipo) {
        String sql = "UPDATE equipos SET nombre = ?, juego = ?, pais = ? WHERE id = ?";
        jdbcTemplate.update(sql, equipo.getNombre(), equipo.getJuego(), equipo.getPais(), equipo.getId());
    }

    public void borrar(Long id) {
        String sql = "DELETE FROM equipos WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public boolean existePorNombre(String nombre) {
        String sql = "SELECT COUNT(*) FROM equipos WHERE LOWER(nombre) = LOWER(?)";
        Integer total = jdbcTemplate.queryForObject(sql, Integer.class, nombre);
        return total != null && total > 0;
    }

    public boolean existePorNombreDistintoId(String nombre, Long id) {
        String sql = "SELECT COUNT(*) FROM equipos WHERE LOWER(nombre) = LOWER(?) AND id <> ?";
        Integer total = jdbcTemplate.queryForObject(sql, Integer.class, nombre, id);
        return total != null && total > 0;
    }
}