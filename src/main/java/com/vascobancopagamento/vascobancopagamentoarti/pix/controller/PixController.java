package com.vascobancopagamento.vascobancopagamentoarti.pix.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vascobancopagamento.vascobancopagamentoarti.pix.model.Pix;
import com.vascobancopagamento.vascobancopagamentoarti.pix.model.PixKey;



@RestController
@RequestMapping("/pix")
public class PixController {
     // @Autowired
    // private PixService pixService;
    // @Autowired
   // private ClienteService clienteService;
    
    public ResponseEntity<?> criarPix(@RequestBody Pix pixRequest) {
        // Pix pix = pixService.criarPix(
        //     pixRequest.getChave(),
        //     pixRequest.getValor(),
        //     pixRequest.getPagador(),
        //     pixRequest.getBeneficiario()
        // );
        
        return ResponseEntity.status(HttpStatus.CREATED).body(pixRequest);
    }
    
    public ResponseEntity<?> obterPixPorId(@PathVariable Long id) {
        // Optional<Pix> optionalPix = pixService.obterPixPorId(id);
        
        // if (optionalPix.isPresent()) {
        //     Pix pix = optionalPix.get();
        //     return ResponseEntity.ok(pix);
        // } else {
        //     return ResponseEntity.notFound().build();
        // }

        return ResponseEntity.ok(id);
    }
    
    public ResponseEntity<?> criarPixKey(@RequestBody PixKey pixKeyDTO) {
     //   Cliente cliente = clienteService.obterClientePorId(pixKeyDTO.getClienteId());

        // if (cliente == null) {
        //     return ResponseEntity.badRequest().build();
        // }

        // PixKey pixKey = pixService.criarPixKey(pixKeyDTO.getChave(), cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(pixKeyDTO);
    }

    public ResponseEntity<?> listarPixKeys() {
        //List<PixKey> pixKeys = pixService.listarPixKeys();
        return ResponseEntity.ok("[]");
    }

}