package com.example.TheArtifact;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FormularioRepository extends JpaRepository<Formulario, Long> {
    Formulario findByCorreo(String correo);
    
}

