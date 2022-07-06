package dz.ecole.eliteSchools.gestionEcole.controller.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.dto.CycleDto;
import dz.ecole.eliteSchools.gestionEcole.dto.WilayaDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.CycleScolaire;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.Wilaya;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.WilayaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:1000")
@RestController
@RequestMapping("/administration")
public class WilayaController {

    @Autowired
    private WilayaService wilayaService;

    public WilayaController() {
    }

    private WilayaDto convertEntityToDto(Wilaya wil) {
        WilayaDto wilDto = new WilayaDto();
        wilDto.setCodeWilaya(wil.getCodeWilaya());
        wilDto.setNomWilaya(wil.getNomWilaya());
        return wilDto;
    }




    // return list of wilayas
    @GetMapping("/wilayas")
    public List<WilayaDto> findAll() {
        return wilayaService.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

}
