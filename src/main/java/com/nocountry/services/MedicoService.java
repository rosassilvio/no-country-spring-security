package com.nocountry.services;


import com.nocountry.models.Medico;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MedicoService {

    public Medico saveMedico(Medico medico);

   public void deleteMedico(Long medicoId);

    public List<Medico> getAllMedicos();

    public Medico getMedicoEsp(String especialidad);

    public Medico getMedicoApellido(String apellido);

    public ResponseEntity<Medico> updateMedico (Medico medico );
}
