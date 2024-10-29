package app.service.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import app.entity.Empleado;
import app.service.dtos.EmpleadoDTO;

@Mapper(componentModel = "spring")
public interface IEmpleadoMapper {
	EmpleadoDTO toDTO(Empleado empleado);
	Empleado toEntity(EmpleadoDTO empleadoDTO);
    List<EmpleadoDTO> toDTOList(List<Empleado> empleados);

}
