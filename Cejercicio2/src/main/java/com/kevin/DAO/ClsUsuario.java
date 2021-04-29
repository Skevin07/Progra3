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

			CallableStatement consulta = con.prepareCall(
					"select u.idUsuario, u.Usuario, u.password,t.TipoUser from usuario as u inner join tipousuario as t where u.tipoUsuario = t.id;()");
			ResultSet rs = consulta.executeQuery();
			while (rs.next()) {
				usuario user = new usuario();
				user.setIdUsuario(rs.getInt("u.idUsuario"));
				user.setUsuario(rs.getString("u.Usuario"));
				user.setPass(rs.getString("u.password"));
				user.setTipoUser(rs.getString("t.TipoUser"));
				Lista.add(user);
			}
		} catch (Exception e) {

			System.out.println("No cargaron los Usuarios " + e);
		}

		return Lista;
	}

	public void Eliminar(usuario user) {

		try {
			CallableStatement statement = con.prepareCall("call sp_d_user(?)");
			statement.setInt("pIdUsuario", user.getIdUsuario());
			statement.executeQuery();
			System.out.println("Exito");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}

	public void ActualizarUsuario(usuario user) {

		try {
			CallableStatement consulta = con.prepareCall("call SP_U_USUARIO(?,?.?)");
			consulta.setString("pUsuario", user.getUsuario());
			consulta.setString("pPass", user.getPass());
			consulta.setInt("pidUsuario", user.getIdUsuario());
			consulta.executeQuery();

			System.out.println("Exito");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}

	public void AgregarUsuario(usuario user) {

		try {
			CallableStatement consulta = con.prepareCall("call SP_I_USUARIO(?,?.?)");
			consulta.setString("PUsuario", user.getUsuario());
			consulta.setString("PPass", user.getPass());
			consulta.setInt("PTipoUsuario", user.getIdTipoUsuario());
			consulta.executeQuery();

			System.out.println("Exito");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}

}