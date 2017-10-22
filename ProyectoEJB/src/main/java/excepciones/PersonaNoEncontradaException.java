package excepciones;

public class PersonaNoEncontradaException extends Exception {
	private static final long serialVersionUID = 1L;

	public PersonaNoEncontradaException(String mensaje) {
		super(mensaje);
	}
}