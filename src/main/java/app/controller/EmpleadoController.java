package app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.service.IEmpleadoService;
import app.service.dtos.EmpleadoDTO;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoController {
	private final IEmpleadoService empleadoService;

	@GetMapping
    public ResponseEntity<List<EmpleadoDTO>> listar() {
        List<EmpleadoDTO> empleados = empleadoService.buscartodos();
        return ResponseEntity.ok(empleados);
    }

    // Buscar empleado por ID
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> buscarPorId(@PathVariable Long id) {
        EmpleadoDTO empleado = empleadoService.buscarPorId(id);
        return empleado != null 
               ? ResponseEntity.ok(empleado)
               : ResponseEntity.notFound().build();
    }

    // Buscar empleados por nombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<EmpleadoDTO>> buscarPorNombre(@PathVariable String nombre) {
        List<EmpleadoDTO> empleados = empleadoService.buscarPorNombre(nombre);
        return empleados.isEmpty() 
               ? ResponseEntity.noContent().build() 
               : ResponseEntity.ok(empleados);
    }

    // Buscar empleados por área
    @GetMapping("/area/{area}")
    public ResponseEntity<List<EmpleadoDTO>> buscarPorArea(@PathVariable String area) {
        List<EmpleadoDTO> empleados = empleadoService.buscarPorArea(area);
        return empleados.isEmpty() 
               ? ResponseEntity.noContent().build() 
               : ResponseEntity.ok(empleados);
    }

    // Guardar un nuevo empleado
    @PostMapping
    public ResponseEntity<EmpleadoDTO> guardar(@RequestBody EmpleadoDTO empleadoDTO) {
        EmpleadoDTO nuevoEmpleado = empleadoService.guardarEmpleado(empleadoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEmpleado);
    }

    // Eliminar un empleado por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        empleadoService.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> actualizarEmpleado(@PathVariable Long id, @RequestBody EmpleadoDTO empleadoDTO) {
        EmpleadoDTO empleadoActualizado = empleadoService.actualizarEmpleado(id, empleadoDTO);
        return empleadoActualizado != null 
               ? ResponseEntity.ok(empleadoActualizado) 
               : ResponseEntity.notFound().build();
    }
}
