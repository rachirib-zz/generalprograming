package co.com.faces.utils;

public class Validaciones {

	public static void validar(Object object, String mensaje) throws Exception{
		if (object == null || object.toString().trim().length() == 0)
			throw new Exception(mensaje);
	}
	
	public static void validarCombos(Object object, String mensaje) throws Exception{
		if (object == null || object.toString().trim().equalsIgnoreCase("-1"))
			throw new Exception(mensaje);
	}
	
	public static Long isNumericoEntero(String input) throws Exception{
		try {
			return Long.parseLong(input);
		} catch (NumberFormatException e) {
			// s is not numeric
			throw e;
		}
	}
	
	public static Double isNumericoDecimal(String input) throws Exception{
		try {
			return Double.parseDouble(input);
		} catch (NumberFormatException e) {
			// s is not numeric
			throw e;
		}
	}
	
}
