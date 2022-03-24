package mx.sep.sesi.servicios.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import mx.sep.sesi.dao.Tses001UsuariosMapper;
import mx.sep.sesi.dao.Tses003RolUsuarioMapper;
import mx.sep.sesi.dao.join.UsuariosJoinMapper;
import mx.sep.sesi.dao.join.SecuenciasJoinMapper;
import mx.sep.sesi.datos.vo.UsuarioVO;
import mx.sep.sesi.modelo.Tses001Usuarios;
import mx.sep.sesi.modelo.Tses001UsuariosExample;
import mx.sep.sesi.modelo.Tses003RolUsuario;
import mx.sep.sesi.servicios.CatUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 *
 * @author angel.adame
 */
@Service
public class CatUsuarioServiceImpl implements CatUsuarioService {

    @Autowired
    Tses001UsuariosMapper usuariosMapper;

    @Autowired
    Tses003RolUsuarioMapper rolUsuariosMapper;

    @Autowired
    SecuenciasJoinMapper secuenceMapper;

    @Autowired
    UsuariosJoinMapper daoUsuariosMapper;

    @Override
    public List<UsuarioVO> obtenerCatUsuario(Integer idRol, Integer idUr, Integer idInmueble) {

        List<UsuarioVO> listUsuario = daoUsuariosMapper.obtenerCatUsuario(idRol, idUr, idInmueble);
        return listUsuario;

    }

    /*public List<UsuarioVO> obtenerCatUsuario() {

     List<UsuarioVO> listUsuario = daoUsuariosMapper.obtenerCatUsuario();

     List<UsuarioVO> listUsuarioVO = new ArrayList();

     for (UsuarioVO nUsuario : listUsuario) {
     UsuarioVO usuarioVO = new UsuarioVO();
     usuarioVO.setIdUsuario(nUsuario.getIdUsuario());
     usuarioVO.setNombre(nUsuario.getNombre());
     usuarioVO.setApellido1(nUsuario.getApellido1());
     usuarioVO.setApellido2(nUsuario.getApellido2());
     usuarioVO.setNombreUsu(nUsuario.getNombreUsu());
     usuarioVO.setContrasena(nUsuario.getContrasena());
     usuarioVO.setDescInmueble(nUsuario.getDescInmueble());
     usuarioVO.setDescRol(nUsuario.getDescRol());
     usuarioVO.setDescRol(nUsuario.getDescRol());
     usuarioVO.setUnidadResponsable(nUsuario.getUnidadResponsable());
     usuarioVO.setDescAcceso(nUsuario.getDescAcceso());
     listUsuarioVO.add(nUsuario);
     }

     return listUsuarioVO;

     }*/
    private String encriptarpassword(String contrasena, String nombreUsu) {
        PasswordEncoder encoder = new ShaPasswordEncoder();
        return encoder.encodePassword(contrasena, nombreUsu);
    }

    /* @Override
     public String crearUsuarioCat(UsuarioVO cusuarioVO) {

     Tses001Usuarios usuario = new Tses001Usuarios();
     Tses003RolUsuario rolUsuario = new Tses003RolUsuario();
        
     Integer idUsuario = secuenceMapper.nextIdUsuario();
     usuario.setIdUsuario(new BigDecimal(idUsuario));
     usuario.setIdInmueble(cusuarioVO.getIdInmueble());
     usuario.setIdAcceso(cusuarioVO.getIdAcceso());
     usuario.setIdUr(cusuarioVO.getIdUr());
     usuario.setApellido1(cusuarioVO.getApellido1());
     usuario.setApellido2(cusuarioVO.getApellido2());
     usuario.setNombre(cusuarioVO.getNombre());
     usuario.setNombreUsu(cusuarioVO.getNombreUsu());
     usuario.setContrasena(encriptarpassword(cusuarioVO.getContrasena(),cusuarioVO.getNombreUsu()));
     usuario.setActivo(cusuarioVO.getActivo());
     usuariosMapper.insertSelective(usuario);
        
     //Integer idRolUsuario = secuenceMapper.nextIdRolUsuario();
     Short idRol = cusuarioVO.getIdRol();
     rolUsuario.setIdRol(new BigDecimal(idRol));
     rolUsuario.setIdUsuario(new BigDecimal(idUsuario));
     //rolUsuario.setIdRolUsuario(new BigDecimal (idRolUsuario));
     rolUsuariosMapper.insert(rolUsuario);
         
     return cusuarioVO;
     }*/
    @Override
    public String crearUsuarioCat(UsuarioVO cusuarioVO) {
        Tses001Usuarios usuario = new Tses001Usuarios();
        Tses003RolUsuario rolUsuario = new Tses003RolUsuario();

        try {
            System.out.println("ENTRANDO A SERVICIO");
            Integer idUsuario = cusuarioVO.getIdUsuario();
            System.out.println("idUsuario---" + idUsuario);
            usuario.setIdInmueble(cusuarioVO.getIdInmueble());
            usuario.setIdAcceso(cusuarioVO.getIdAcceso());
            usuario.setIdUr(cusuarioVO.getIdUr());
            usuario.setApellido1(cusuarioVO.getApellido1());
            usuario.setApellido2(cusuarioVO.getApellido2());
            usuario.setNombre(cusuarioVO.getNombre());
            usuario.setNombreUsu(cusuarioVO.getNombreUsu());
            usuario.setCurp(cusuarioVO.getCurp());
            if(cusuarioVO.getContrasena()!=null&& !cusuarioVO.getContrasena().trim().equals(""))
                {
            //usuario.setContrasena(encriptarpassword(cusuarioVO.getContrasena(), cusuarioVO.getNombreUsu()));
            usuario.setContrasena(encriptarpassword(cusuarioVO.getContrasena(), null));
                }
            usuario.setActivo(cusuarioVO.getActivo());

            Integer idRol = cusuarioVO.getIdRol();
            rolUsuario.setIdRol(idRol);
            rolUsuario.setIdUsuario(idUsuario);
            if (idUsuario != null) {
                System.out.println("Entrando a update");
                usuario.setIdUsuario(idUsuario);
                usuariosMapper.updateByPrimaryKeySelective(usuario);
                rolUsuariosMapper.updateByPrimaryKey(rolUsuario);
                System.out.println("update exitoso");
                return "Se han registrado los datos correctamente";
            } else {
                Tses001UsuariosExample tses001example = new Tses001UsuariosExample();
                tses001example.createCriteria().andNombreUsuEqualTo(cusuarioVO.getNombreUsu());
                List<Tses001Usuarios> registrado = usuariosMapper.selectByExample(tses001example);
                if (registrado.isEmpty()) {
                    System.out.println("Entrando a Insert");
                    Integer idUsuar = secuenceMapper.nextIdUsuario();
                    usuario.setIdUsuario(idUsuar);
                    System.out.println("idUsuario----" + idUsuar);
                    Integer idRolUsuario = secuenceMapper.nextIdRolUsuario();
                    rolUsuario.setIdRolUsuario(idRolUsuario);
                    rolUsuario.setIdUsuario(idUsuar);
                    usuariosMapper.insertSelective(usuario);
                    rolUsuariosMapper.insert(rolUsuario);
                    return "Se han registrado los datos correctamente";

                } else {
                    System.out.println("Ya existe ese nombre de usuario.");
                    return "2";
                }
            }
        } catch (Exception exc) {
            System.out.println("error : " + exc.getMessage());
            return ("Error al insertar usuario.");
        }
    }
    
//    @Override
//    public Tses001Usuarios obtenerUsuario(BigDecimal idUsuario) {
//        Tses001Usuarios tses001Usuarios = new Tses001Usuarios();
//        tses001Usuarios = usuariosMapper.selectByPrimaryKey(idUsuario);
//        return tses001Usuarios;
//    }

     @Override
   public UsuarioVO obtenerUsuario(Integer idUsuario) {
      UsuarioVO nusuarioVO = new UsuarioVO();
      nusuarioVO = daoUsuariosMapper.obtenerUsuarioporID(idUsuario);
      return nusuarioVO;
       
       
   }
   
    public String verificaCurp(String curp) {
        Tses001UsuariosExample tses001UsuariosExample = new Tses001UsuariosExample();
        tses001UsuariosExample.createCriteria().andCurpEqualTo(curp);
        List<Tses001Usuarios> registrado = usuariosMapper.selectByExample(tses001UsuariosExample);
        if (registrado.isEmpty()) {
            return " ";
        } else {
            return "Ya se encuentra registrado el usuario.";
        }
    }
    
}
