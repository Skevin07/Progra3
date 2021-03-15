package com.kevin.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kevin.Conexion.ConexionBd;
import com.kevin.entidades.usuario;

public class ClsUsuario {
	
	ConexionBd conexion = new ConexionBd();
    Connection con = conexion.RetornarConexion();


	 public ArrayList<usuario> ListadoUSUARIOS() {
	        ArrayList<usuario> Lista = new ArrayList<>();

	        try {

	            CallableStatement consulta = con.prepareCall("call SP_S_SOLOUSUARIOS()");
	            ResultSet rs = consulta.executeQuery();
	            while (rs.next()) {
	                usuario user = new usuario();
	                user.setIdUsuario(rs.getInt("idUsuario"));
	                user.setUsuario(rs.getString("Usuario"));
	                user.setPass(rs.getString("PassWord"));
	                user.setIdTipoUsuario(rs.getInt("tipoUsuario"));
	                Lista.add(user);
	            }
	        } catch (Exception e) {
	        	
	        	System.out.println("No cargaron los Usuarios "+e);
	        }

	        return Lista;
	    }
	 
	public void Eliminar (usuario user) {
		
		try {
			CallableStatement statement= con.prepareCall("call sp_d_user(?)");
			statement.setInt("pIdUsuario", user.getIdUsuario());
			statement.executeQuery();
			System.out.println("Exito");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
}