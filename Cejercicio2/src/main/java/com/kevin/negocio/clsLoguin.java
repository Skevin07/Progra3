package com.kevin.negocio;


import com.kevin.DAO.ClsLoginDao;
import com.kevin.entidades.*;

public class clsLoguin {

	public int acceso(usuario log) {
		int acceso = 0;

		/*if (log.getUsuario().equals("kevin") && log.getPass().equals("123"))

		{
			acceso = 1;
		}
*/
		
		ClsLoginDao LoginDao = new ClsLoginDao();
		usuario usu = new usuario();
		
		usu = LoginDao.Login(log);
		if (usu != null) {
			if (usu.getTipoUsuario() == 1) {
				acceso = 1;
				System.out.println(usu.getTipoUsuario());
			} else if (usu.getTipoUsuario() == 2) {
				acceso = 2;
				System.out.println(usu.getTipoUsuario());
			}
		} else {
			System.out.println("El usuario no existe");
		}
		
		return acceso;
	}

}
