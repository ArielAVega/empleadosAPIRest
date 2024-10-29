package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.entity.Empleado;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long>{
	List<Empleado> findByNombreContainingIgnoreCase(String nombre);  // Query Method

    @Query("SELECT e FROM Empleado e WHERE e.area = :area")
    List<Empleado> findByArea(@Param("area") String area);  // Query con JPQL
}
