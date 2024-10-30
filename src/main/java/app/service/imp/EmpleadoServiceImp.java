package app.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import app.repository.IEmpleadoRepository;
import app.service.IEmpleadoService;
import app.service.dtos.EmpleadoDTO;
import app.service.mappers.IEmpleadoMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImp implements IEmpleadoService{
	private final IEmpleadoRepository empleadoRepository;
	private final IEmpleadoMapper empleadoMapper;
	
	@Override
	public List<EmpleadoDTO> buscartodos() {
		return empleadoMapper.toDTOList(empleadoRepository.findAll());
	}
	@Override
	public EmpleadoDTO buscarPorId(Long id) {
		return empleadoMapper.toDTO(empleadoRepository.findById(id)
							.orElseThrow(()->new RuntimeException("Empleado no encontrado")));
	}
	@Override
	public List<EmpleadoDTO> buscarPorNombre(String nombre) {
		return empleadoMapper.toDTOList(empleadoRepository.findByNombreContainingIgnoreCase(nombre));
	}
	@Override
	public List<EmpleadoDTO> buscarPorArea(String area) {
		return empleadoMapper.toDTOList(empleadoRepository.findByArea(area));
	}
	@Override
	public EmpleadoDTO guardarEmpleado(EmpleadoDTO empleadoDTO) {
		var empleado = empleadoMapper.toEntity(empleadoDTO);
		return empleadoMapper.toDTO(empleadoRepository.save(empleado));
	}
	@Override
	public void eliminarEmpleado(Long id) {
		empleadoRepository.deleteById(id);
	}
	@Override
	public EmpleadoDTO actualizarEmpleado(Long id, EmpleadoDTO empleadoDTO) {
		var empleadoExistente = empleadoRepository.findById(id)
				.orElseThrow(()->new RuntimeException("Empleado no encontrado"));
		empleadoExistente.setApellido(empleadoDTO.getApellido());
		empleadoExistente.setArea(empleadoDTO.getArea());
		empleadoExistente.setFechaNacimiento(empleadoDTO.getFechaNacimiento());
		empleadoExistente.setNombre(empleadoDTO.getNombre());
		
		return empleadoMapper.toDTO(empleadoRepository.save(empleadoExistente));
	}

	
}
