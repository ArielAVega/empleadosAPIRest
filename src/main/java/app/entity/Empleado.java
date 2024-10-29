package app.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empleados")
@Data
@NoArgsConstructor
public class Empleado {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long id;
	@Column(name = "emp_nombre")
	private String nombre;
	@Column(name = "emp_apellido")
	private String apellido;
	@Column(name = "emp_area")
	private String area;
	@Column(name = "emp_fecha_nac")
	private LocalDate fechaNacimiento;
}
