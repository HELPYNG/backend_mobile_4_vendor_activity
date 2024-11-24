package br.org.unisenaipr.comercial.venda.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.unisenaipr.comercial.venda.entity.Venda;
import br.org.unisenaipr.comercial.venda.repositorio.VendaRepository;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    @Autowired
    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Venda saveVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public Venda updateVenda(Venda venda) {
        if (!vendaRepository.existsById(venda.getId())) {
            throw new IllegalArgumentException("Venda com ID " + venda.getId() + " não encontrada.");
        }
        return vendaRepository.save(venda);
    }

    public void deleteVenda(long id) {
        if (!vendaRepository.existsById(id)) {
            throw new IllegalArgumentException("Venda com ID " + id + " não encontrada.");
        }
        vendaRepository.deleteById(id);
    }

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public List<Venda> findAllInDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date startOfDay = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date endOfDay = calendar.getTime();

        return vendaRepository.findAllByDateTimeBetween(startOfDay, endOfDay);
    }

    public Venda findById(long id) {
        return vendaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Venda com ID " + id + " não encontrada."));
    }
}
