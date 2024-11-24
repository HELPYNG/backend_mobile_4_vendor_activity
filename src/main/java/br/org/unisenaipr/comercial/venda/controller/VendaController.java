package br.org.unisenaipr.comercial.venda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.unisenaipr.comercial.produto.service.ProdutoService;
import br.org.unisenaipr.comercial.venda.entity.Venda;
import br.org.unisenaipr.comercial.venda.service.VendaService;

@Controller
@RequestMapping("/venda")
public class VendaController {

    private final VendaService vendaService;
    private final ProdutoService produtoService;

    @Autowired
    public VendaController(VendaService vendaService, ProdutoService produtoService) {
        this.vendaService = vendaService;
        this.produtoService = produtoService;
    }

    // Exibe a lista de vendas
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("vendas", vendaService.findAll());
        return "venda/list";
    }

    // Exibe o formulário para criar uma nova venda
    @GetMapping("/novo")
    public String formularioNovoExibir(Model model) {
        model.addAttribute("produtos", produtoService.findAll());
        model.addAttribute("venda", new Venda());
        return "venda/novo";
    }

    // Processa a criação de uma nova venda
    @PostMapping("/novo")
    public String formularioNovoSubmit(@ModelAttribute("venda") Venda venda) {
        vendaService.saveVenda(venda);
        return "redirect:/venda/";
    }

    // Exibe o formulário para atualizar uma venda existente
    @GetMapping("/atualizar/{id}")
    public String formularioAtualizarExibir(Model model, @PathVariable("id") long id) {
        model.addAttribute("produtos", produtoService.findAll());
        Venda venda = vendaService.findById(id);
        model.addAttribute("venda", venda);
        return "venda/atualizar";
    }

    // Processa a atualização de uma venda
    @PostMapping("/atualizar/{id}")
    public String formularioAtualizarSalvar(@PathVariable("id") long id, @ModelAttribute("venda") Venda venda) {
        venda.setId(id);  // Certificando-se de que a venda com o ID correto será atualizada
        vendaService.updateVenda(venda);
        return "redirect:/venda/";
    }

    // Exclui uma venda
    @GetMapping("/remover/{id}")
    public String remover(@PathVariable("id") long id) {
        vendaService.deleteVenda(id);
        return "redirect:/venda/";
    }
}
