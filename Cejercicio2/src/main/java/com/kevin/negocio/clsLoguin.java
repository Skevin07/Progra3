package com.kevin.negocio;

import com.kevin.entidades.Loguin;

public class clsLoguin {

	
	public int acceso(Loguin log) {
		int acceso =0;
		
		if (log.getUser().equals("kevin") && log.getPass().equals("123"))
		
		{
			acceso=1;
		}
					
		return acceso;
	}
	
}
