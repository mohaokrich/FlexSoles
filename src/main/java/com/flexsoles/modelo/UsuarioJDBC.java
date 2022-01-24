package com.flexsoles.modelo;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.flexsoles.persistencia.Usuario;

@Repository
public class UsuarioJDBC extends DaoGenericoImpl<Usuario> implements UsuarioDAO {

	@Override
	public Usuario getUsuarios(String nombre) {
		Query query = this.em.createQuery("FROM Producto WHERE nombre = :nombre");
		query.setParameter("nombre", "%"+nombre+"%");
		return (Usuario) query.getSingleResult();
	
	}


//	@Override
//	public List<Rol> findUserRoles(long id) {
//		return jdbcTemplate.query("select r.id as 'id', r.nombre_rol as 'nombre' "
//				+ "from Roles r inner join UsuarioRol ur on r.id = ur.id "
//				+ "where ur.idUsuario = ?", (rs, rowNum) -> new Rol(rs.getLong("id"), rs.getString("nombre")), id);
//	}
	
//	@Override
//	public int saveTablaRoles(long id, String rol) {
//		return jdbcTemplate.update("insert into Roles(id, nombre_rol) value (?,?)", id, "USER");
//	}
	
//	@Override
//	public int saveRol(long idRol, long idUsuario) {
//
//		return jdbcTemplate.update("insert into UsuarioRol(id, idUsuario) value (?,?)", idRol, idUsuario);
//	}
//
//	@Override
//	public long getId(String nombre) {
//		String query = "select id from UsuariosSecurity WHERE nombre = ?"; 
//		long id = jdbcTemplate.queryForObject(query, new Object[] {nombre}, Long.class);
//		return id;
//	}

}
