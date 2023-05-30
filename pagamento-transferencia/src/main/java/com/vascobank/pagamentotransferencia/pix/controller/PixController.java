package com.vascobank.pagamentotransferencia.pix.controller;

@RestController
@RequestMapping("/pix")
public class PixController {
    private PixService pixService;
    private ClienteService clienteService;

    public PixController(PixService pixService, ClienteService clienteService) {
        this.pixService = pixService;
        this.clienteService = clienteService;
    }
    
    public ResponseEntity<Pix> criarPix(@RequestBody PixRequestDTO pixRequest) {
        Pix pix = pixService.criarPix(
            pixRequest.getChave(),
            pixRequest.getValor(),
            pixRequest.getPagador(),
            pixRequest.getBeneficiario()
        );
        
        return ResponseEntity.status(HttpStatus.CREATED).body(pix);
    }
    
    public ResponseEntity<Pix> obterPixPorId(@PathVariable Long id) {
        Optional<Pix> optionalPix = pixService.obterPixPorId(id);
        
        if (optionalPix.isPresent()) {
            Pix pix = optionalPix.get();
            return ResponseEntity.ok(pix);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    public ResponseEntity<PixKey> criarPixKey(@RequestBody PixKeyCreationDTO pixKeyDTO) {
        Cliente cliente = clienteService.obterClientePorId(pixKeyDTO.getClienteId());

        if (cliente == null) {
            return ResponseEntity.badRequest().build();
        }

        PixKey pixKey = pixService.criarPixKey(pixKeyDTO.getChave(), cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(pixKey);
    }

    public ResponseEntity<List<PixKey>> listarPixKeys() {
        List<PixKey> pixKeys = pixService.listarPixKeys();
        return ResponseEntity.ok(pixKeys);
    }

}