package com.example.demo.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryVentas {
	@Autowired
	JdbcTemplate jdbcT;

	class Ventas1RowMapper implements RowMapper<Ventas1> {
		@Override
		public Ventas1 mapRow(ResultSet resultados, int num) throws SQLException {
			Ventas1 ventas1 = new Ventas1();
			ventas1.setCod_venta(resultados.getLong("cod_venta"));
			ventas1.setFecha(resultados.getDate("fecha"));
			ventas1.setPrecio_subasta(resultados.getLong("precio_subasta"));
			return ventas1;

		}
	}

	public List<Ventas1> VER_VENTAS() {
		return jdbcT.query("select * from Ventas", new Ventas1RowMapper());
	}

	public Ventas1 FINDId_VENTAS(long cod_venta) {
		return jdbcT.queryForObject("select * from Ventas where cod_venta=?", new Object[] { cod_venta },
				new BeanPropertyRowMapper<Ventas1>(Ventas1.class));

	}

	public int DELETEId_VENTAS(long cod_venta) {
		return jdbcT.update("delete from Ventas where cod_venta=?", new Object[] { cod_venta });
	}

	public int INSERT_VENTAS(Ventas1 ventas1) {
		return jdbcT.update("insert into Ventas ( fecha,precio_subasta) " + "values(  ?, ?)",
				new Object[] { ventas1.getFecha(), ventas1.getPrecio_subasta() });
	}

	public int UPDATE_VENTAS(Ventas1 ventas1) {
		return jdbcT.update("update Ventas " + " set fecha = ?, precio_subasta = ? " + " where cod_venta = ?",
				new Object[] { ventas1.getFecha(), ventas1.getPrecio_subasta(), ventas1.getCod_venta() });
	}

}
