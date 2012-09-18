using System;


class Promedio
{
	public static void Main(string[] args)
	{
		int cnum = 0;
		float total = 0;
		float promedio;
		string numeros = "";

		Console.WriteLine("Programa que calcula el promedio de un grupo de calificaciones");
		Console.Write("Digite la cantidad de calificaciones que va a ingresar: ");
		int.TryParse(Console.ReadLine(), out cnum);

		int[] valores = new int[cnum];


		for(int x=0; x<cnum; x=x+1)
		{
			Console.Write("Digite una calificacion: ");
			int.TryParse(Console.ReadLine(), out valores[x]);
			Console.Clear();
			total = total + valores[x];
		}
		promedio = total / cnum;

		for(int y=0; y<cnum; y++)
		{
			numeros = numeros + ", " + valores[y];
		}

		Console.Clear();
		Console.WriteLine("El promedio de las calificaciones {0} es igual a {1}", numeros, promedio);
		Console.ReadKey();
	}
}