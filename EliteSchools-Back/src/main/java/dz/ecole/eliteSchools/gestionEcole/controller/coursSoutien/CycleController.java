package dz.ecole.eliteSchools.gestionEcole.controller.coursSoutien;

import dz.ecole.eliteSchools.gestionEcole.dto.CycleDto;
import dz.ecole.eliteSchools.gestionEcole.entity.coursSoutien.CycleScolaire;
import dz.ecole.eliteSchools.gestionEcole.service.coursSoutien.CycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:1000")
@RestController
@RequestMapping("/administration")
public class CycleController {

    @Autowired
    private CycleService cycleService;

    public CycleController() {

    }

    private CycleDto convertEntityToDto(CycleScolaire niv) {
        CycleDto nivDto = new CycleDto();
        nivDto.setCode(niv.getCode());
        nivDto.setCycleSclr(niv.getCycleSclr());
        return nivDto;
    }


    // return list of niveaux
    @GetMapping("/cycles")
    public List<CycleDto> findAll() {
        return cycleService.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

}
