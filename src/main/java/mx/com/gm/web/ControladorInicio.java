package mx.com.gm.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.ClienteDao;
import mx.com.gm.dao.ProyectoDao;
import mx.com.gm.dao.TipoDao;
import mx.com.gm.dao.UsuarioDao;
import mx.com.gm.dao.ViaticoDao;
import mx.com.gm.domain.Proyecto;
import mx.com.gm.domain.Usuario;
import mx.com.gm.domain.UsuarioRol;
import mx.com.gm.domain.Viatico;
import mx.com.gm.servicio.ClienteService;
import mx.com.gm.servicio.DepartamentoService;
import mx.com.gm.servicio.ProyectoService;
import mx.com.gm.servicio.RolService;
import mx.com.gm.servicio.UsuarioRolService;
import mx.com.gm.servicio.UsuarioService;
import mx.com.gm.servicio.UsuarioServicio;
import mx.com.gm.servicio.ViaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private TipoDao tipoDao;

    @Autowired
    private ProyectoDao proyectoDao;

    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private ViaticoDao viaticoDao;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ViaticoService viaticoService;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private UsuarioRolService usuarioRolService;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private RolService rolService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        log.info("ejecutando el controlador rest");
        log.info("Usuario que hizo login: " + user);
        var viaticos = viaticoService.listarViaticos();
        model.addAttribute("viaticos", viaticos);
        var tipos = tipoDao.findAll();
        model.addAttribute("tipos", tipos);
        var proyectos = proyectoService.listarProyectos();
        model.addAttribute("proyectos", proyectos);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String nombreUsuario = authentication.getName();
        System.out.println("nombreUsuario = " + nombreUsuario);
        System.out.println("user:  = " + user);
        var usuarioAutentificado = usuarioDao.findByUsername(nombreUsuario).getIdUsuario();
        System.out.println("usuarioAutentificado = " + usuarioAutentificado);
        model.addAttribute("idUsuario", usuarioAutentificado);
        var gastoTotal = 0D;
        for (var v:viaticos){
            gastoTotal += v.getMonto();
        }
        model.addAttribute("gastoTotal",gastoTotal);
        model.addAttribute("totalViaticos",viaticos.size());
        return "index";

    }

    @GetMapping("/editar")
    public String editar() {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Viatico viatico, Errors errores) {
        if (errores.hasErrors()) {
            for (ObjectError error : errores.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            return "error";
        }
        viaticoService.guardar(viatico);
        return "redirect:/";
    }

    @GetMapping("/editar/{idViatico}")
    public String editar(Viatico viatico, Model model) {
        viatico = viaticoService.encontrarViatico(viatico);
        model.addAttribute("viatico", viatico);
        var tipos = tipoDao.findAll();
        model.addAttribute("tipos", tipos);
        var proyectos = proyectoDao.findAll();
        model.addAttribute("proyectos", proyectos);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Viatico viatico) {
        viaticoService.eliminar(viatico);
        return "redirect:/";
    }

    @GetMapping("/editarProyecto/{idProyecto}")
    public String editarProyecto(Proyecto proyecto, Model model) {
        proyecto = proyectoService.encontrarProyecto(proyecto);
        model.addAttribute("proyecto", proyecto);
        var clientes = clienteService.listarClientes();
        model.addAttribute("clientes", clientes);
        return "modificarProyecto";
    }

    //****************//
    //SECCION PROYECTOS//
    //****************//
    @GetMapping("/mostrarProyectos")
    public String mostrarProyectos(Proyecto proyecto, Model model) {
        proyectoService.actualizarGastos();
        var proyectos = proyectoService.listarProyectos();
        model.addAttribute("proyectos", proyectos);
        var clientes = clienteService.listarClientes();
        model.addAttribute("clientes", clientes);
        return "proyectos";
    }

    @PostMapping("/guardarProyecto")
    public String guardarProyecto(@Valid Proyecto proyecto, Errors errores) {
        if (errores.hasErrors()) {
            for (ObjectError error : errores.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            return "error";
        }
        proyectoService.guardar(proyecto);
        return "redirect:/";
    }

    @GetMapping("/eliminarProyecto")
    public String eliminar(Proyecto proyecto) {
        proyectoService.eliminar(proyecto);
        return "redirect:/";
    }

    //****************//
    //SECCION USUARIOS//
    //****************//
    @GetMapping("/mostrarUsuarios")
    public String mostrarUsuarios(Model model, @AuthenticationPrincipal User user) {
        log.info("Ejecutando la lista de usuarios");
        var usuarios = usuarioServicio.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        var usuarioRol = usuarioRolService.listarRelaciones();
        model.addAttribute("usuarioRol", usuarioRol);
        var departamentos = departamentoService.listarDepartamentos();
        model.addAttribute("departamentos", departamentos);
        var roles = rolService.listarRoles();
        model.addAttribute("roles", roles);
        return "usuarios";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, Errors errores) {
        if (errores.hasErrors()) {
            for (ObjectError error : errores.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            return "error";
        }
        if (usuarioServicio.esPasswordEncriptada(usuario.getPassword())) {
            System.out.println("La contrasena esta incriptada");
        } else {
            String passwordEncriptada = usuarioServicio.encriptarPassword(usuario.getPassword());
            usuario.setPassword(passwordEncriptada);
        }
        System.out.println("Roles: " + usuario.getRoles());
        
        
        usuarioServicio.guardar(usuario);

        System.out.println("idUsuario: " + usuario.getIdUsuario());;
        if (usuarioRolService.asignacionUser(usuario.getIdUsuario())){
            System.out.println("idUsuario: " + usuario.getIdUsuario());;
            log.info("Modificando usuario");
        } else{
            log.info("Nuevo Usuario");
            UsuarioRol nuevaRelacion = new UsuarioRol();
            nuevaRelacion.setUsuario(usuario);
            nuevaRelacion.setRol(rolService.buscarPorId((long)3));
            usuarioRolService.guardar(nuevaRelacion);
        }
        

        return "redirect:/"; 
    }

    @GetMapping("/editarUsuario/{idUsuario}")
    public String editarUsuario(Usuario usuario, Model model) {
        usuario = usuarioServicio.encontrarUsuario(usuario);
        model.addAttribute("usuario", usuario);
        var departamentos = departamentoService.listarDepartamentos();
        model.addAttribute("departamentos", departamentos);
        return "modificarUsuario";
    }

    @GetMapping("/eliminarUsuario")
    public String eliminarUsuario(Usuario usuario) {
        usuarioServicio.eliminar(usuario);
        return "redirect:/";
    }

    //****************//
    //SECCION Relacion//
    //****************//
    @PostMapping("/guardarRelacion")
    public String guardarRelacion(@Valid UsuarioRol usuarioRol, Errors errores) {
        if (errores.hasErrors()) {
            for (ObjectError error : errores.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            return "error";
        }
        if (usuarioRolService.existeAsignacion(usuarioRol.getUsuario().getIdUsuario(), usuarioRol.getRol().getIdRol())) {
            System.out.println("La asignacion ya existe");
        } else {
            usuarioRolService.guardar(usuarioRol);
        }
        return "redirect:/";

    }

    @GetMapping("/eliminarRelacion")
    public String eliminarRelacion(UsuarioRol usuarioRol) {
        usuarioRolService.eliminar(usuarioRol);
        return "redirect:/";

    }

}
