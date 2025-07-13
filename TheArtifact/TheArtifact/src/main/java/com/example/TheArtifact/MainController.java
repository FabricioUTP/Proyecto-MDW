package com.example.TheArtifact;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Controller
public class MainController {

    private final ComentariosRepository comentarioRepo;
    private final FormularioRepository formularioRepo;
    private final BCryptPasswordEncoder passwordEncoder;



    public MainController(ComentariosRepository comentarioRepo, FormularioRepository formularioRepo, BCryptPasswordEncoder passwordEncoder) {
        this.comentarioRepo = comentarioRepo;
        this.formularioRepo = formularioRepo;
         this.passwordEncoder = passwordEncoder;

    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("titulo", "CATEGORÍAS DESTACADAS");
        model.addAttribute("reviewTitulo", "REVIEWS");
        model.addAttribute("reviewSubtitulo", "Conoce lo que dice nuestra comunidad");
        model.addAttribute("nombre1", "Felipe Pruzzo");
        model.addAttribute("nombre2", "Noemi Zelada");
        model.addAttribute("nombre3", "Juaquin Herrera");
        model.addAttribute("nombre4", "Francisco Vergara");
        return "index";
    }

    @GetMapping("/productos")
    public String mostrarProductos(Model model) {
        model.addAttribute("producto1", "Z210");
        model.addAttribute("producto2", "Correlona x-20");
        model.addAttribute("producto3", "Flash Tomphson Modelo aqua");
        model.addAttribute("producto4", "Bicicleta Pro Luther");
        model.addAttribute("producto5", "Spinning one Sonic Pro");
        model.addAttribute("producto6", "Corredora Wireless");
        model.addAttribute("producto7", "Bicicleta Supraduplex");
        return "productos";
    }

    // --- Contacto ---
    @GetMapping("/contacto")
    public String mostrarFormularioContacto(Model model) {
        model.addAttribute("tituloContacto", "Contáctanos");
        model.addAttribute("comentario", new Comentarios()); // Esto es fundamental para el form
        return "contacto";
    }

    @PostMapping("/contacto")
    public String guardarComentario(@ModelAttribute Comentarios comentario) {
        comentario.setFecha(LocalDateTime.now());
        comentarioRepo.save(comentario);
        return "redirect:/contacto"; // Rediriges a la página principal tras enviar el formulario
    }

    // --- Formularios ---

   // --- Formularios ---
@GetMapping("/registro")
public String mostrarFormularioRegistro(Model model) {
    model.addAttribute("tituloFormulario", "Registro de nuevo usuario");
    model.addAttribute("formulario", new Formulario()); // clave para el form
    return "registro";
}

@PostMapping("/registro")
public String guardarFormulario(@ModelAttribute Formulario formulario) {
    String claveCodificada = passwordEncoder.encode(formulario.getContrasena());
    formulario.setContrasena(claveCodificada);
    formularioRepo.save(formulario);
    return "redirect:/login";  // Redirige a login después del registro
}
@GetMapping("/login")
public String mostrarFormularioLogin(Model model) {
    model.addAttribute("login", new Formulario()); // usa la misma clase que contiene correo y contraseña
    return "login"; // esto carga login.html
}


}

