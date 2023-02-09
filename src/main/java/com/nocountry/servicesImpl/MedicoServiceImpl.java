package com.nocountry.servicesImpl;

import com.nocountry.models.Medico;
import com.nocountry.repository.MedicoRepository;
import com.nocountry.services.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository repository;

    public MedicoServiceImpl(MedicoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Medico saveMedico(Medico medico) {
        return repository.save(medico);
    }

    @Override
    public void deleteMedico(Long medicoId) {
        repository.deleteById(medicoId);
    }

    @Override
    public List<Medico> getAllMedicos() {
        return repository.findAll();
    }

    @Override
    public Medico getMedicoEsp(String especialidad) {
        return repository.findByEspecialidad(especialidad);
    }

    @Override
    public Medico getMedicoApellido(String apellido) {
        return repository.findByApellido(apellido);
    }

    @Override
    public ResponseEntity<Medico> updateMedico(Medico medico) {
        Medico med = repository.save(medico);
        return new ResponseEntity<Medico>(med, HttpStatus.OK);

    }
}
