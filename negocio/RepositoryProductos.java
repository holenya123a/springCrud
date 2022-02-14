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
public class RepositoryProductos {

	@Autowired
	JdbcTemplate jdbcT;

	public Productos1 findById(long cod_producto) {
		return jdbcT.queryForObject("select * from productos1 where cod_producto=?", new Object[] { cod_producto },
				new BeanPropertyRowMapper<Productos1>(Productos1.class));
	}

	class ProductosRowMapper implements RowMapper<Productos1> {
		@Override
		public Productos1 mapRow(ResultSet rs_producto, int NombreFila) {
			Productos1 producto = new Productos1();
			try {
				producto.setCod_producto(rs_producto.getLong("cod_producto"));
				producto.setNombre(rs_producto.getString("nombre"));
				producto.setPrecio_compra(rs_producto.getLong("precio_compra"));
				producto.setUnidades(rs_producto.getLong("unidades"));

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return producto;

		}

	}

	public List<Productos1> VER_PRODUCTO() {
		return jdbcT.query("select * from productos", new ProductosRowMapper());
	}

	public int DELETEid_producto(long cod_producto) {
		return jdbcT.update("delete from productos where cod_producto=?", new Object[] { cod_producto });
	}

	public int INSERT_PRODUCTO(Productos1 producto1) {
		return jdbcT.update("insert into productos ( nombre, precio_compra, unidades) " + "values(?, ?, ?)",
				new Object[] { producto1.getNombre(), producto1.getPrecio_compra(), producto1.getUnidades() });
	}

	public int UPDATE_PRODUCTO(Productos1 producto1) {
		return jdbcT.update(
				"update productos " + " set nombre = ?, precio_compra = ?, unidades = ? " + " where cod_producto = ?",
				new Object[] { producto1.getNombre(), producto1.getPrecio_compra(), producto1.getUnidades(),
						producto1.getCod_producto() });
	}
}
