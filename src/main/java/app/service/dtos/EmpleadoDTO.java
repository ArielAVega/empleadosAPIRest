package app.service.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpleadoDTO {
	private Long id;
    private String nombre;
    private String apellido;
    private String area;
    private LocalDate fechaNacimiento;
}
