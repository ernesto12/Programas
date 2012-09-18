using System;

class programacion1
{
   static void Main(string[] args)
   {
   
double n=0;
double factorial=1;

   
     Console.WriteLine("Digite El Numero El Cual Quiera Saber Su Factorial");
	 double.TryParse(Console.ReadLine(), out n);
	
	 for(double i=n;i>0;i--)
	 {
	  factorial=i*factorial;
	  
	 }
	 Console.WriteLine("El Factorial Del Numero {0} Es Igual A {1}",n,factorial );
	 
	 Console.ReadKey();
   
   
   }


}
//vp= teclado
//factorial=1
//for i=vp; i>0; i--
//{
//fatorial= i*factorial
//}
