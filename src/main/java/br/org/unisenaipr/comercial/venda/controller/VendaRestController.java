package br.org.unisenaipr.comercial.venda.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import br.org.unisenaipr.comercial.venda.entity.Venda;
import br.org.unisenaipr.comercial.venda.service.VendaService;

@RestController
@RequestMapping("/api/venda")
@CrossOrigin(origins = "*") 
public class VendaRestController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> queryVendas(@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date data) {
        if (data == null) {
            return vendaService.findAll();
        } else {
            return vendaService.findAllInDate(data);
        }
    }

    @PostMapping("/novo")
    public Venda createNew(@RequestBody Venda venda) {
        return vendaService.saveVenda(venda);
    }

    @GetMapping("/{id}")
    public Venda getById(@PathVariable Long id) {
        return vendaService.findById(id);
    }

    @PutMapping("/atualizar/{id}")
    public Venda updateVenda(@PathVariable Long id, @RequestBody Venda updatedVenda) {
        if (vendaService.findById(id) == null) {
            throw new RuntimeException("Venda com ID " + id + " não encontrada.");
        }
        updatedVenda.setId(id);
        return vendaService.updateVenda(updatedVenda);
    }

    @DeleteMapping("/remover/{id}")
    public void deleteVenda(@PathVariable Long id) {
        if (vendaService.findById(id) == null) {
            throw new RuntimeException("Venda com ID " + id + " não encontrada.");
        }
        vendaService.deleteVenda(id);
    }
}
