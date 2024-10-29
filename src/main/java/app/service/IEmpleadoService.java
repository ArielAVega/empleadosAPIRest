package app.service;

import java.util.List;

import app.service.dtos.EmpleadoDTO;

public interface IEmpleadoService {
	List<EmpleadoDTO> buscartodos();
	EmpleadoDTO buscarPorId(Long id);
	List<EmpleadoDTO> buscarPorNombre(String nombre);
	List<EmpleadoDTO> buscarPorArea(String area);
	EmpleadoDTO guardarEmpleado(EmpleadoDTO empleadoDTO);
	void eliminarEmpleado(Long id);
}
