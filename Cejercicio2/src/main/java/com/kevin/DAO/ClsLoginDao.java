package com.kevin.DAO;

import java.sql.*;
import java.sql.Connection;

import com.kevin.Conexion.ConexionBd;
import com.kevin.entidades.usuario;

public class ClsLoginDao {

		ConexionBd conexion = new ConexionBd();
		Connection con = conexion.RetornarConexion();
		
		public usuario Login(usuario user) {
			usuario usu = new usuario();
			
			try {
				
				CallableStatement statement = con.prepareCall("call SP_S_LOGIN(?,?);");
				
				statement.setString("PUsuario", user.getUsuario());
				statement.setString("PPass", user.getPass());
				
				ResultSet res = statement.executeQuery();
								
				while(res.next()) {				
					usu.setIdUsuario(res.getInt("idUsuario"));
					usu.setUsuario(res.getString("Usuario"));
					usu.setPass(res.getString("PassWord"));
					usu.setTipoUsuario(res.getInt("tipoUsuario"));
						
				}
						
			} catch (Exception e) {
				System.out.println("> Usuario no encontrado.");
			}
			
			return usu;
		}

}
