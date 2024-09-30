package com.example.demo.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Compra;
import com.example.demo.service.CompraService;


import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/compras")
public class CompraController {

    private static final Logger log = LoggerFactory.getLogger(CompraController.class);

    @Autowired
    private CompraService compraService;

    @GetMapping
    public List<Compra> getAllCompras(){
        log.info("retornando todas las compras");
        return compraService.getAllCompras();

    }

    @GetMapping("/{id}")
    public Optional<Compra> getCompraById(@PathVariable Long id) {
        log.info("retornando todas las compras por ID");
        return compraService.getCompraById(id);
    }
    

    @PostMapping
    public Compra createCompra(@RequestBody Compra pelicula){
        log.info("compra creada");
        log.error("error al crear la compra");
        return compraService.createCompra(pelicula);
        
    }

    @PutMapping("/{id}")
    public Compra updateCompra(@PathVariable Long id, @RequestBody Compra pelicula) {
        log.info("compra actualizada correctamente");
        log.error("error al actualizar la compra");
        return compraService.updateCompra(id, pelicula);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCompra(@PathVariable Long id){
        log.info("compra eliminada correctamente");
        log.error("error al eliminar la compra");
        compraService.deleteCompra(id);
    };
}