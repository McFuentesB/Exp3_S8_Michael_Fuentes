package com.example.demo.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Habitacion;
import com.example.demo.service.HabitacionService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping ("/habitaciones")
public class HabitacionController {

    private static final Logger log = LoggerFactory.getLogger(HabitacionController.class);

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping
    public List <Habitacion>getAllHabitacions() {
        log.info("retornando todas las habitaciones");
        return habitacionService.getAllHabitacions();
    }
    
    @GetMapping("/{id}")
    public Optional<Habitacion> getHabitacionById(@PathVariable Long id) {
        log.info("Buscando habitación con ID: {}", id);
        Optional<Habitacion> habitacion = habitacionService.getHabitacionById(id);
    
        if (habitacion.isEmpty()) {
            log.warn("No se encontró habitación con ID: {}", id);
        } else {
            log.info("Habitación encontrada: {}", habitacion.get());
        }
    
        return habitacion;
    }

    @PostMapping
    public Habitacion createHabitacion(@RequestBody Habitacion habitacion){
        log.info("habitacion creada correctamente");
        log.error("error al crear la habitacion");
        return habitacionService.createHabitacion(habitacion);
    }

    @PutMapping("/{id}")
    public Habitacion updateHabitacion(@PathVariable Long id, @RequestBody Habitacion habitacion) {
        log.info("habitacion actualizada correctamente");
        log.error("error al actualizar la habitacion");
        return habitacionService.updateHabitacion(id, habitacion);
    }
    
    @DeleteMapping("/{id}")
    public void deleteHabitacion(@PathVariable Long id){
        log.info("Intentando eliminar la habitacion id: ", id);
        log.error("error al eliminar la habitacion");
        habitacionService.deleteHabitacion(id);
    };
    
}