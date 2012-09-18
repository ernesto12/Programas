
public class Granja {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   
		Perro perro = new Perro();
		Gallina gallina = new Gallina();
		Gato gato = new Gato();

		System.out.println(perro.decirQuienSoy());
		System.out.println(gallina.decirQuienSoy());
		System.out.println(gato.decirQuienSoy());
		
	}

}
