/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.exception;

import java.util.Date;

public class ExceptionConfig {
	private Date timestamp;
	private String mensaje;
	private String detalles;
	private String httpCodeMessage;

	public ExceptionConfig(Date timestamp, String message, String details,String httpCodeMessage) {
		super();
		this.timestamp = timestamp;
		this.mensaje = message;
		this.detalles = details;
		this.httpCodeMessage=httpCodeMessage;
	}

	public String getHttpCodeMessage() {
		return httpCodeMessage;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getDetalles() {
		return detalles;
	}

}