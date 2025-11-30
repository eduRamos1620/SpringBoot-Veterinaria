package com.ramos.Veterinaria.controllers;

import com.ramos.Veterinaria.controllers.dto.PagoDTO;
import com.ramos.Veterinaria.entities.Cita;
import com.ramos.Veterinaria.entities.Pago;
import com.ramos.Veterinaria.services.ICitaService;
import com.ramos.Veterinaria.services.IPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pago")
public class PagoController {

    @Autowired
    private IPagoService pagoService;

    @Autowired
    private ICitaService citaService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<PagoDTO> pagos = pagoService.findAll().stream()
                .map( pago -> PagoDTO.builder()
                        .idPago(pago.getIdPago())
                        .tipoPago(pago.getTipoPago())
                        .fechaPago(pago.getFechaPago())
                        .monto(pago.getMonto())
                        .cita(pago.getCita())
                        .build())
                .toList();

        return ResponseEntity.ok(pagos);
    }

    @GetMapping("/find/{idPago}")
    public ResponseEntity<?> findById(@PathVariable Long idPago){
        Optional<Pago> pagoOptional = pagoService.findById(idPago);

        if (pagoOptional.isPresent()){
            Pago pago = pagoOptional.get();
            PagoDTO pagoDTO = PagoDTO.builder()
                    .idPago(pago.getIdPago())
                    .tipoPago(pago.getTipoPago())
                    .fechaPago(pago.getFechaPago())
                    .monto(pago.getMonto())
                    .cita(pago.getCita())
                    .build();

            return ResponseEntity.ok(pagoDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save (@RequestBody PagoDTO pagoDTO){

        Cita cita = citaService.findById(pagoDTO.getCita().getIdCita())
                .orElseThrow(() -> new RuntimeException("La cita no existe"));

        pagoService.save(Pago.builder()
                .tipoPago(pagoDTO.getTipoPago())
                .fechaPago(pagoDTO.getFechaPago())
                .monto(pagoDTO.getMonto())
                .cita(cita)
                .build());

        return ResponseEntity.ok("Pago guardada con exito");
    }

    @PutMapping("/update/{idPago}")
    public ResponseEntity<?> update(@RequestBody PagoDTO pagoDTO, @PathVariable Long idPago){
        Optional<Pago> pagoOptional = pagoService.findById(idPago);

        if (pagoOptional.isPresent()){
            Pago pago = pagoOptional.get();
            pago.setTipoPago(pagoDTO.getTipoPago());
            pago.setFechaPago(pagoDTO.getFechaPago());
            pago.setMonto(pagoDTO.getMonto());
            pago.setCita(pagoDTO.getCita());

            pagoService.save(pago);
            return ResponseEntity.ok("Pago actualizado");
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{idPago}")
    public String deleteById(@PathVariable Long idPago){
        if (idPago != null){
            pagoService.deleteById(idPago);
            return "Pago eliminado";
        }
        return "Error al eliminar el pago";
    }
}
