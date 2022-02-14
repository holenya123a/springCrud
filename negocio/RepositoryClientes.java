package com.example.demo.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryClientes {

	@Autowired
	JdbcTemplate jdbcT;

	class ClienteRmapper implements RowMapper<Clientes1> {
		@Override
		public Clientes1 mapRow(ResultSet rs, int numr) {
			Clientes1 cliente1 = new Clientes1();
			try {
				cliente1.setCod_cliente(rs.getLong("cod_cliente"));
				cliente1.setNombre(rs.getString("nombre"));
				cliente1.setApellidos(rs.getString("apellidos"));
				cliente1.setDni(rs.getString("dni"));
				cliente1.setTelefono(rs.getInt("telefono"));
				cliente1.setDireccion(rs.getString("direccion"));

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cliente1;

		}
	}

	public List<Clientes1> VER_CLIENTE() {
		return jdbcT.query("select * from clientes", new ClienteRmapper());
	}

	@SuppressWarnings("deprecation")
	public Clientes1 FIND_CLIENTE(long cod_cliente) {
		return jdbcT.queryForObject("select * from clientes where cod_cliente  =?", new Object[] { cod_cliente },
				new BeanPropertyRowMapper<Clientes1>(Clientes1.class));
	}

	public int DELETE_CLIENTE(long cod_cliente) {
		return jdbcT.update("delete from clientes where cod_cliente  =?", new Object[] { cod_cliente });
	}

	public int INSERT_CLIENTE(Clientes1 cliente1) {
		return jdbcT.update("insert into clientes (nombre, apellidos, dni, telefono, direccion)" + " values(?,?,?,?,?)",
				new Object[] { cliente1.getNombre(), cliente1.getApellidos(), cliente1.getDni(), cliente1.getTelefono(),
						cliente1.getDireccion() });

	}

	public int UPDATE_CLIENTE(Clientes1 cliente1) {
		return jdbcT.update(
				"update clientes" + " set nombre =?, apellidos =?, dni=?, telefono=?, direccion=? "
						+ "where cod_cliente =?",
				new Object[] { cliente1.getNombre(), cliente1.getApellidos(), cliente1.getDni(), cliente1.getTelefono(),
						cliente1.getDireccion(), cliente1.getCod_cliente() });
	}

}
