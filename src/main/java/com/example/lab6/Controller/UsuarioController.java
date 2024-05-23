package com.example.lab6.Controller;

import com.example.lab6.Entity.Dispositivos;
import com.example.lab6.Entity.Usuario;
import com.example.lab6.Repository.DispositivosRepository;
import com.example.lab6.Repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class UsuarioController {

    final
    UsuarioRepository usuarioRepository;
    DispositivosRepository dispositivosRepository;

    public UsuarioController(UsuarioRepository usuarioRepository, DispositivosRepository dispositivosRepository) {
        this.usuarioRepository = usuarioRepository;
        this.dispositivosRepository = dispositivosRepository;
    }

    @GetMapping("/dispositivos")
    public String listaDispositivos(@ModelAttribute("usuario") Usuario usuario, Model model){
        model.addAttribute("listaDispositivos", dispositivosRepository.findAll());
        return "usuario/dispositivo";
    }

    @GetMapping("/dispositivos/new")
    public String nuevoDispositivoFrm(@ModelAttribute("dispositivos") Dispositivos dispositivos) {
        return "usuario/newFrm";
    }

    @PostMapping("/dispositivos/save")
    public String guardarDispositivo(Dispositivos dispositivos, RedirectAttributes attr){
        dispositivosRepository.save(dispositivos);
        attr.addFlashAttribute("msg", "dispositivo agregado exitosamente");
        return "redirect:/dispositivos";
    }

    @GetMapping("/dispositivos/edit")
    public String editarDispositivo(Model model, @RequestParam("id") int id, RedirectAttributes attr) {
        Optional<Dispositivos> optional = dispositivosRepository.findById(id);

        if (optional.isPresent()) {
            model.addAttribute("dispositivos", optional.get());
            attr.addFlashAttribute("msg", "dispositivo editado exitosamente");
            return "dispositivos/newFrm";
        } else {
            return "redirect:/dispositivos";
        }

    }

    @GetMapping("/dispositivos/delete")
    public String borrarDispositivo(@RequestParam("id") int id, RedirectAttributes attr) {
        Optional<Dispositivos> optional = dispositivosRepository.findById(id);

        if (optional.isPresent()) {
            dispositivosRepository.deleteById(id);
        }
        attr.addFlashAttribute("msg", "dispositivo borrado exitosamente");
        return "redirect:/dispositivos";
    }


}
