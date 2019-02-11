package com.ipartek.formacion.tienda.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.tienda.modelo.dao.VentaDAO;
import com.ipartek.formacion.tienda.modelo.pojo.Venta;
import com.ipartek.formacion.tienda.service.VentaService;
import com.ipartek.formacion.tienda.service.exception.VentaException;

@Service
public class VentaServiceImpl implements VentaService {

	@Autowired
	VentaDAO ventaDAO;

	@Override
	/**
	 * Método que llama al DAO para crear una Venta
	 * 
	 * @return <b>True</b> si se crea la venta, <b>False</b> si no es posible
	 *         crearla
	 * @throws <b>VentaExcepcion</b> Si hay un error con la consulta SQL o no hay
	 *         Stock para el animal indicado
	 * @see VentaExcepcion
	 */
	public boolean crear(Venta venta) throws VentaException {
		boolean creado = false;
		try {
			if (ventaDAO.obtenerStock(venta)) {
				creado = ventaDAO.insert(venta);
			}
		} catch (SQLException e) {
			throw new VentaException(VentaException.EXCEPTION_VENTA);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return creado;
	}

}
