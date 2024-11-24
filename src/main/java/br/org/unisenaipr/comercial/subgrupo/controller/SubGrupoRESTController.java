package br.org.unisenaipr.comercial.subgrupo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.org.unisenaipr.comercial.subgrupo.entity.SubGrupo;
import br.org.unisenaipr.comercial.subgrupo.service.SubGrupoService;

@Controller
@RequestMapping("/subgrupoREST")
public class SubGrupoRESTController {

    @Autowired
    private SubGrupoService subGrupoService;

    private final Gson gson = new Gson();

    @RequestMapping("/listSubGrupo")
    @ResponseBody
    public ResponseEntity<String> listSubGrupo() {
        try {
            List<SubGrupo> list = subGrupoService.findAll();
            String jsonResponse = gson.toJson(list);
            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            String errorResponse = gson.toJson("Error processing request: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
