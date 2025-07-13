package com.example.TheArtifact;


import com.example.TheArtifact.Formulario;
import com.example.TheArtifact.FormularioRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final FormularioRepository formularioRepo;

    public UserDetailsServiceImpl(FormularioRepository formularioRepo) {
        this.formularioRepo = formularioRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Formulario usuario = formularioRepo.findByCorreo(correo);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con el correo: " + correo);
        }

        return new User(
                usuario.getCorreo(),
                usuario.getContrasena(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
