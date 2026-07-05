package com.example.BD_CU.repositories;

import com.example.BD_CU.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = " SELECT r.rol, count(u.Usuario_Id)\n" +
            " FROM Rol r\n" +
            " INNER JOIN Usuario u\n" +
            " ON r.user_id=u.usuario_id\n" +
            " GROUP BY r.rol", nativeQuery = true)
    List<Object[]> quantityUsuariosxRolNative();

    @Query(value = " SELECT u.Usuario_Id, r.rol, u.username, Sum(r.Sueldo+u.Extras)\n" +
            " FROM Usuario u\n" +
            " INNER JOIN Rol r\n" +
            " ON r.user_id=u.usuario_id\n" +
            " GROUP BY r.Rol_Id,u.Usuario_Id", nativeQuery = true)
    List<Object[]> buscarPagoUsuariosNative();

    Usuario findOneByUsername(String username);

    @Query("select count(u.email) from Usuario u where lower(u.email) = lower(:email)")
    int buscarEmail(@Param("email") String email);

    @Query("select count(u.username) from Usuario u where u.username = :username")
    int buscarUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "insert into rol (descripcion, fecha_creacion, permisos, rol, sueldo, user_id) " +
            "VALUES (:descripcion, :fechaCreacion, :permisos, :rol, :sueldo, :user_id)", nativeQuery = true)
    void insRol(
            @Param("descripcion") String descripcion,
            @Param("fechaCreacion") java.time.LocalDate fechaCreacion,
            @Param("permisos") String permisos,
            @Param("rol") String authority,
            @Param("sueldo") int sueldo,
            @Param("user_id") Long user_id
    );
}