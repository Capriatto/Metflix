package bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CambiarBean {
	private String atributo1;
	private String atributo2;

	/**
	 * Metodo que permite intercambiar parametros
	 */
	public void cambiar() {
		String aux = atributo1;
		atributo1 = atributo2;
		atributo2 = aux;
	}

	/**
	 * 
	 * @return
	 */
	public String getAtributo1() {
		return atributo1;
	}

	/**
	 * 
	 * @param atributo1
	 */
	public void setAtributo1(String atributo1) {
		this.atributo1 = atributo1;
	}

	/**
	 * 
	 * @return
	 */
	public String getAtributo2() {
		return atributo2;
	}

	/**
	 * 
	 * @param atributo2
	 */
	public void setAtributo2(String atributo2) {
		this.atributo2 = atributo2;
	}

}
