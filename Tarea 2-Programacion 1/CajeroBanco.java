import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.InputStreamReader;

import sun.misc.Cleaner;
//1-Usuario Visa
/** nombre:Juan Ferreras
 * id: 1207
 * contraseña:2378
 * balance en cuenta:90000
 */
//2-Usuario Mastercard
/** nombre:Jose Díaz
 * id: 2010
 * contraseña:1020
 * balance en cuenta:50000
*/
//3-Usuario Maestro
/**nombre:Geinel Díaz
 * id: 2303
 * contraseña: 1111
 * balance en cuenta: 60000
 */
//4-Usuario American Express
/** nombre:Glancy","Ferreras"
 * id: 1107
 * contraseña:9997
 * balance en cuenta: 70000
 */
//5-Usuario otras
/** nombre: Nancy Ferreras
 * id: 2012
 * contraseña:1220
 * balance en cuenta:73000
 */
public class CajeroBanco {

	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		
//Variables declaradas
		int z=0,m=0,m1=0,m2=0,m3=0,m4=0,x;
		int menu=0,menuEfectivo=0,tarjetas;
	    int balanceCajero = 100000;
		int decision=0;
		int p=0,de=0,y,l[]={2000,1000,500,200,100},p1=0,exit=509;
		
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(exit!=3){
    	
        System.out.println("+------------------------------------------------+");
        System.out.println("¦                    MENU                        ¦");
		System.out.println("¦Bienvenido al cajero automatico Ferraras & Asoc:¦");
        System.out.println("+------------------------------------------------+");
        System.out.println("Elija su tarjeta:\n1-Visa\n2-Mastercard\n3-Maestro\n4-American Express\n5-otras ");
        tarjetas = Integer.parseInt(br.readLine());
        
    while(tarjetas<1||tarjetas>5){
    	System.out.println("No hay tarjetas asignadas con esta opcion...\nSeleccione una de las anteriores: ");
    	tarjetas = Integer.parseInt(br.readLine());}
    
        System.out.println("Digite su id: ");
        z = Integer.parseInt(br.readLine());
    while((z!= 1207) && (z!=2010) &&(z!=2303) && (z!=1107) && (z!=2012)){
        System.out.println("Id incorrecto...\nDigite de nuevo su Id\n");
        z = Integer.parseInt(br.readLine());}
   
   
//Tarjeta Visa
    Cliente juan=new Cliente("Juan","Ferreras",1207,2378,90000);
    if(tarjetas==1){
        if(z==juan.idcuenta){
	    System.out.println("Digite su contraseña");
	    x = Integer.parseInt(br.readLine());
	    
	while (x!=juan.clave){
		System.out.println("Contraseña incorrecta\n");
		System.out.println("Digite de nuevo su contraseña");
		x = Integer.parseInt(br.readLine());
		if(p==1){
		System.out.println("ha exedido el numero de intentos su tarjeta ha sido retenida\n\n");
		break;}
		p++;
	}
	
	
	decision=1;
  while (decision!=2){
     if(x== juan.clave){
			         System.out.printf("Tarjeta Visa Bienvenido %s  %s",juan.nombre,juan.apellido);
			         System.out.println("\n+-------------------------------------+");
			         System.out.println("\n1-Retiro de efectivo\n2-Consulta de balance de cajero\n3-Consulta de balance de cuenta "); 
			         menu = Integer.parseInt(br.readLine());
			         
	 while(menu<1||menu>3){
			         System.out.println("No hay opciones asignadas con este numero...\nSeleccione una de las anteriores: ");
			         menu = Integer.parseInt(br.readLine());}
//Retiro de Efectivo
    if(menu ==1){
				  
				     System.out.println("Seleccione la cantidad deseada: \n1-100\n2-200\n3-500\n4-1000\n5-2000\n6-otra: ");
				     menuEfectivo = Integer.parseInt(br.readLine());
		while(menuEfectivo<1||menuEfectivo>6){
			         System.out.println("No hay cantidades asignadas con esta opcion...\nSeleccione una de las anteriores");
			         menuEfectivo = Integer.parseInt(br.readLine());}
		if(menuEfectivo == 1){
					 balanceCajero-=100;
					 juan.dinero-=100;
					 System.out.print("Un billete de 100");}
		
		 if(menuEfectivo == 2){
					 balanceCajero-=200;
					 juan.dinero-=200;
					 System.out.print("Un billete de 200");}
		 
		if(menuEfectivo == 3){
					 balanceCajero-=500;
					 juan.dinero-=500;
					 System.out.print("Un billete de 500");}	  
		
	    if(menuEfectivo == 4){
				    balanceCajero-=1000;
					juan.dinero-=1000;
					System.out.print("Un billete de 1000");}
	    
	    if(menuEfectivo == 5){
				    balanceCajero-=2000;
					juan.dinero-=2000;
					System.out.print("Un billete de 2000");}
	    
		 if(menuEfectivo ==6){
					System.out.println("Que cantidad desea realizar: ");
					y = Integer.parseInt(br.readLine());
					juan.dinero-=y;
					balanceCajero-=y;
					      if((y > juan.dinero) || (y<100)|| (y > balanceCajero) || (y%10)!=0||(y>20000)){
						      System.out.println("Esta transaccion no se puede realizar ");break;}
					      if((y < juan.dinero) && (y>100)&& (y < balanceCajero) && (y%10)==0){
						           p1=0;
						  while(y!=0){
							 
						  if(y>=l[p1]){
							           y-=l[p1];
							           System.out.printf("Un billete de %d\n%d",l[p1],m2);
							           if (l[p1]==2000){
								       m+=1;}}
						   if(y<l[p1]){
								       p1++;}
							           if (m==10){
								               l[0]=1000;}
						   if((l[0]==1000)&&(l[1]==1000)){
							    	   m1+=1;}
						               if(m1==21){
						    	               l[0]=500;
						    	               l[1]=500;}
						   if ((l[0]==500)&&(l[1]==500)&&(l[2]==500)){
						    	       m2+=1;}
						               if (m2==61){
							                   l[0]=200;
							                   l[1]=200;
							                   l[2]=200;}
						        if ((l[0]==200)&&(l[1]==200)&&(l[2]==200)&&(l[3]==200)){
							            m3+=1;}
						                if (m3==101){
							                   l[0]=100;
						                       l[1]=100;
						                       l[2]=100;
						                       l[3]=100;}
						        if((l[0]==100)&&(l[1]==100)&&(l[2]==100)&&(l[3]==100)){
							             m4+=1;
						 }
						       }
						       
					 }
				  }
				  
		
			  }
//Consulta de balance de cajero	
	if(menu ==2){
				  
				  System.out.println("El balance en el cajero es: "+balanceCajero);}
//Consulta de balance de cuenta
	if (menu ==3){
				  
				  System.out.println("El balance en su cuenta es: "+juan.dinero); 
		}
	              System.out.println("\nDesea continuar...\n1-Si\n2-No ");
		          decision = Integer.parseInt(br.readLine());}
	}
    }

	
    }
    	
//tarjeta Mastercard
	Cliente jose=new Cliente("Jose","Díaz",2010,1020,50000);
	if(tarjetas==2){
        
		if(z==jose.idcuenta){
		    System.out.println("Digite su contraseña");
		    x = Integer.parseInt(br.readLine());
		while (x!=jose.clave){
			System.out.println("Contraseña incorrecta\n");
			System.out.println("Digite de nuevo su contraseña");
			x = Integer.parseInt(br.readLine());
		if(p==1){ System.out.println("ha exedido el numero de intentos su tarjeta ha sido retenida");
			break;}
			p++;
			}
		
		decision=1;
		while (decision!=2){
			  if(x== jose.clave){
				      System.out.printf("Tarjeta Mastercard Bienvenido %s  %s",jose.nombre,jose.apellido);
				      System.out.println("\n+--------------------------------------+");
				      System.out.println("\n1-Retiro de efectivo\n2-Consulta de balance de cajero\n3-Consulta de balance de cuenta "); 
				      menu = Integer.parseInt(br.readLine());
	   while(menu<1||menu>3){
					         System.out.println("No hay opciones asignadas con este numero...\nSeleccione una de las anteriores: ");
					         menu = Integer.parseInt(br.readLine());}
//Retiro de efectivo
		     if(menu ==1){
					  
					  System.out.println("Seleccione la cantidad a retirar: \n1-100\n2-200\n3-500\n4-1000\n5-2000\n6-otra: ");
					  menuEfectivo = Integer.parseInt(br.readLine());
			 while(menuEfectivo<1||menuEfectivo>6){
					  System.out.println("No hay cantidades asignadas con esta opcion...\nSeleccione una de las anteriores");
					  menuEfectivo = Integer.parseInt(br.readLine());}
			 if(menuEfectivo == 1){
						  balanceCajero-=100;
					      jose.dinero-=100;
					      System.out.print("Un billete de 100");}
			 
			 if(menuEfectivo == 2){
						balanceCajero-=200;
						jose.dinero-=200;
						System.out.print("Un billete de 200");}
			 
			 if(menuEfectivo == 3){
						balanceCajero-=500;
						jose.dinero-=500;
						System.out.print("Un billete de 500");}	  
			 
		    if(menuEfectivo == 4){
					    balanceCajero-=1000;
						jose.dinero-=1000;
						System.out.print("Un billete de 1000");}
		    
		    if(menuEfectivo == 5){
					    balanceCajero-=2000;
						jose.dinero-=2000;
						System.out.print("Un billete de 2000");}
		    
			if(menuEfectivo ==6){
						  System.out.println("Que cantidad desea retirar: ");
						  y = Integer.parseInt(br.readLine());
						  jose.dinero-=y;
						  balanceCajero-=y;
						      if((y > jose.dinero) || (y<100)|| (y > balanceCajero) || (y%10)!=0||(y>20000)){
							      System.out.println("Esta transaccion no se puede realizar ");
						       }
						      if((y < jose.dinero) && (y>100)&& (y < balanceCajero) && (y%10)==0){
							           p1=0;
							       while(y!=0){
								 
								       if(y>=l[p1]){
								       y-=l[p1];
								       System.out.printf("Un billete de %d\n%d",l[p1],m2);
								       if (l[p1]==2000){
									   m+=1;}}
								       if(y<l[p1]){
									   p1++;}
								       if (m==10){
									       l[0]=1000;}
								       if((l[0]==1000)&&(l[1]==1000)){
								    	   m1+=1;}
							      if(m1==21){
							    	  l[0]=500;
							    	  l[1]=500;}
							    if ((l[0]==500)&&(l[1]==500)&&(l[2]==500)){
							    	m2+=1;
							    }
							 if (m2==61){
								 l[0]=200;
								 l[1]=200;
								 l[2]=200;}
							 if ((l[0]==200)&&(l[1]==200)&&(l[2]==200)&&(l[3]==200)){
								 m3+=1;
							 }
							 if (m3==101){
								 l[0]=100;
							     l[1]=100;
							     l[2]=100;
							     l[3]=100;}
							 if((l[0]==100)&&(l[1]==100)&&(l[2]==100)&&(l[3]==100)){
								 m4+=1;
							 }
							       }
							       
						 }
					  }
					  
			
				  }
//Consulta de balance de cajero		
		 if(menu ==2){
					  
					  System.out.println("El balance en el cajero es: "+balanceCajero);}
//Consulta de balance de cuenta
		if (menu ==3){
					  
					  System.out.println("El balance en su cuenta es: "+jose.dinero); 
			}
		              System.out.println("\nDesea continuar...\n1-Si\n2-No ");
			          decision = Integer.parseInt(br.readLine());}
		}
	    }
	    }
	    	
 
//tarjeta Maestro
	 Cliente geinel=new Cliente("Geinel","Díaz",2303,1111,60000);
	 if(tarjetas==3){
	        
		if(z==geinel.idcuenta){
			    System.out.println("Digite su contraseña");
			    x = Integer.parseInt(br.readLine());
		while (x!=geinel.clave){
				
				System.out.println("Contraseña incorrecta\n");
				System.out.println("Digite de nuevo su contraseña");
				x = Integer.parseInt(br.readLine());
		if(p==1){ System.out.println("ha exedido el numero de intentos su tarjeta ha sido retenida");
				break;}
				p++;
				}
		       decision=1;
			   while (decision!=2){
				if(x== geinel.clave){
					        System.out.printf("Tarjeta Maestro Bienvenido %s  %s",geinel.nombre,geinel.apellido);
					        System.out.println("\n+-----------------------------------+");
					        System.out.println("\n1-Retiro de efectivo\n2-Consulta de balance de cajero\n3-Consulta de balance de cuenta "); 
					        menu = Integer.parseInt(br.readLine());
			    while(menu<1||menu>3){
						    System.out.println("No hay opciones asignadas con este numero...\nSeleccione una de las anteriores: ");
						    menu = Integer.parseInt(br.readLine());}
//Retiro de efectivo
			    if(menu ==1){
						  
						  System.out.println("Seleccione la cantidad a retirar: \n1-100\n2-200\n3-500\n4-1000\n5-2000\n6-otra: ");
						  menuEfectivo = Integer.parseInt(br.readLine());
	            while(menuEfectivo<1||menuEfectivo>6){
						  System.out.println("No hay cantidades asignadas con esta opcion...\nSeleccione una de las anteriores");
						  menuEfectivo = Integer.parseInt(br.readLine());}
				   if(menuEfectivo == 1){
							balanceCajero-=100;
						    geinel.dinero-=100;
						    System.out.print("Un billete de 100");}
				   
				   if(menuEfectivo == 2){
							balanceCajero-=200;
							geinel.dinero-=200;
							System.out.print("Un billete de 200");}
				   
				   if(menuEfectivo == 3){
							balanceCajero-=500;
							geinel.dinero-=500;
							System.out.print("Un billete de 500");}	 
				   
			       if(menuEfectivo == 4){
						    balanceCajero-=1000;
							geinel.dinero-=1000;
							System.out.print("Un billete de 1000");}
			       
			       if(menuEfectivo == 5){
						    balanceCajero-=2000;
							geinel.dinero-=2000;
							System.out.print("Un billete de 2000");}
			       
				   if(menuEfectivo ==6){
							  System.out.println("Que cantidad desea retirar: ");
							  y = Integer.parseInt(br.readLine());
							  geinel.dinero-=y;
							  balanceCajero-=y;
							      if((y > geinel.dinero) || (y<100)|| (y > balanceCajero) || (y%10)!=0||(y>20000)){
								      System.out.println("Esta transaccion no se puede realizar ");
							       }
							      if((y < geinel.dinero) && (y>100)&& (y < balanceCajero) && (y%10)==0){
								           p1=0;
								       while(y!=0){
									 
									       if(y>=l[p1]){
									                      y-=l[p1];
									                      System.out.printf("Un billete de %d\n%d",l[p1],m2);
									       if (l[p1]==2000){
										                   m+=1;}}
									       if(y<l[p1]){
										                   p1++;}
									       if (m==10){
										                   l[0]=1000;}
									       if((l[0]==1000)&&(l[1]==1000)){
									    	               m1+=1;}
								           if(m1==21){
								    	                   l[0]=500;
								    	                   l[1]=500;}
								       if ((l[0]==500)&&(l[1]==500)&&(l[2]==500)){
								    	                   m2+=1;}
								               if (m2==61){
									                       l[0]=200;
									                       l[1]=200;
								   	                       l[2]=200;}
								       if ((l[0]==200)&&(l[1]==200)&&(l[2]==200)&&(l[3]==200)){
									                       m3+=1;}
								           if (m3==101){
									                        l[0]=100;
								                            l[1]=100;
								                            l[2]=100;
								                            l[3]=100;}
							      	 if((l[0]==100)&&(l[1]==100)&&(l[2]==100)&&(l[3]==100)){
									                        m4+=1;}
								       }
								       
							 }
						  }
						  
				
					  }
//Consulta de balance de cajero		
			 if(menu ==2){
						  
						  System.out.println("El balance en el cajero es: "+balanceCajero);}
//Consulta de balance de cuenta
			 if (menu ==3){
						  
						  System.out.println("El balance en su cuenta es: "+geinel.dinero); 
				}
			              System.out.println("\nDesea continuar ...\n1-Si\n2-No ");
				          decision = Integer.parseInt(br.readLine());}
			}
		    }
		    }
		    	
	 
//tarjeta American Express
		 Cliente glancy=new Cliente("Glancy","Ferreras",1107,9997,70000);
		 if(tarjetas==4){
		        
			if(z==glancy.idcuenta){
				    System.out.println("Digite su contraseña");
				    x = Integer.parseInt(br.readLine());
			while (x!=glancy.clave){
					System.out.println("Contraseña incorrecta\n");
					System.out.println("Digite de nuevo su contraseña");
					x = Integer.parseInt(br.readLine());
			if(p==1){  System.out.println("ha exedido el numero de intentos su tarjeta ha sido retenida");
					break;}
					p++;
					}
			
			     decision=1;
				 while (decision!=2){
				  if(x== glancy.clave){
						  System.out.printf("Tarjeta American Express Bienvenido %s  %s",glancy.nombre,glancy.apellido);
						  System.out.println("\n+---------------------------------------------------+");
						  System.out.println("\n1-Retiro de efectivo\n2-Consulta de balance de cajero\n3-Consulta de balance de cuenta "); 
						  menu = Integer.parseInt(br.readLine());
				  while(menu<1||menu>3){
						  System.out.println("No hay opciones asignadas con este numero...\nSeleccione una de las anteriores: ");
						  menu = Integer.parseInt(br.readLine());}
//Retiro de efectivo
				  if(menu ==1){
							     System.out.println("Seleccione la cantidad a retirar: \n1-100\n2-200\n3-500\n4-1000\n5-2000\n6-otra: ");
							     menuEfectivo = Integer.parseInt(br.readLine());
				   while(menuEfectivo<1||menuEfectivo>6){
								 System.out.println("No hay cantidades asignadas con esta opcion...\nSeleccione una de las anteriores");
								 menuEfectivo = Integer.parseInt(br.readLine());}
					if(menuEfectivo == 1){
								 balanceCajero-=100;
							     glancy.dinero-=100;
							     System.out.print("Un billete de 100");}
					
					 if(menuEfectivo == 2){
								balanceCajero-=200;
								glancy.dinero-=200;
								System.out.print("Un billete de 200");}
					 
					if(menuEfectivo == 3){
								balanceCajero-=500;
								glancy.dinero-=500;
								System.out.print("Un billete de 500");}	
					
				    if(menuEfectivo == 4){
							    balanceCajero-=1000;
								glancy.dinero-=1000;
								System.out.print("Un billete de 1000");}
				    
				    if(menuEfectivo == 5){
							    balanceCajero-=2000;
								glancy.dinero-=2000;
								System.out.print("Un billete de 2000");}
				    
					if(menuEfectivo ==6){
								  System.out.println("Que cantidad desea retirar: ");
								  y = Integer.parseInt(br.readLine());
								  glancy.dinero-=y;
								  balanceCajero-=y;
								  
								      if((y > glancy.dinero) || (y<100)|| (y > balanceCajero) || (y%10)!=0||(y>20000)){
									          System.out.println("Esta transaccion no se puede realizar ");
								       }
								      if((y < glancy.dinero) && (y>100)&& (y < balanceCajero) && (y%10)==0){
									           p1=0;
									      while(y!=0){
										 
										       if(y>=l[p1]){
										                    y-=l[p1];
										                    System.out.printf("Un billete de %d\n%d",l[p1],m2);
										       if (l[p1]==2000){
											                 m+=1;}}
										       if(y<l[p1]){
											                 p1++;}
										       if (m==10){
											                 l[0]=1000;}
										     if((l[0]==1000)&&(l[1]==1000)){
										    	             m1+=1;}
									            if(m1==21){
									    	                 l[0]=500;
									    	                 l[1]=500;}
									         if ((l[0]==500)&&(l[1]==500)&&(l[2]==500)){
									    	                  m2+=1;}
									            if (m2==61){
									                      	 l[0]=200;
										                     l[1]=200;
										                     l[2]=200;}
									         if ((l[0]==200)&&(l[1]==200)&&(l[2]==200)&&(l[3]==200)){
										                     m3+=1;}
									             if (m3==101){
										                     l[0]=100;
									                         l[1]=100;
									                         l[2]=100;
									                         l[3]=100;}
									         if((l[0]==100)&&(l[1]==100)&&(l[2]==100)&&(l[3]==100)){
										                     m4+=1;}
									       }
									       
								 }
							  }
							  
					
						  }
//Consulta de balance de cajero		
				 if(menu ==2){
							   System.out.println("El balance en el cajero es: "+balanceCajero);}
//Consulta de balance de cuenta
				if (menu ==3){
							  
							  System.out.println("El balance en su cuenta es: "+glancy.dinero); 
					}
				              System.out.println("\nDesea continuar ...\n1-Si\n2-No ");
					          decision = Integer.parseInt(br.readLine());}
				}
			    }
			    }
			    	
		 
		//otras	
		 Cliente nancy=new Cliente("Nancy","Ferreras",2012,1220,73000);
     if(tarjetas==5){
		        
			if(z==nancy.idcuenta){
				    System.out.println("Digite su contraseña");
				    x = Integer.parseInt(br.readLine());
				while (x!=nancy.clave){
					
					System.out.println("Contraseña incorrecta\n");
					System.out.println("Digite de nuevo su contraseña");
					x = Integer.parseInt(br.readLine());
				if(p==1){System.out.println("ha exedido el numero de intentos su tarjeta ha sido retenida");
					break;}
					p++;
					}
				
				     decision=1;
				    while (decision!=2){
					  if(x== nancy.clave){
						  System.out.printf("Other 2012 Bienvenido %s  %s",nancy.nombre,nancy.apellido);
						  System.out.println("\n+-----------------------------------+");
						  System.out.println("\n1-Retiro de efectivo\n2-Consulta de balance de cajero\n3-Consulta de balance de cuenta "); 
						  menu = Integer.parseInt(br.readLine());
					  while(menu<1||menu>3){
						  System.out.println("No hay opciones asignadas con este numero...\nSeleccione una de las anteriores: ");
						  menu = Integer.parseInt(br.readLine());}
//Retiro de efectivo
				      if(menu ==1){
							  
						  System.out.println("Seleccione la cantidad a retirar: \n1-100\n2-200\n3-500\n4-1000\n5-2000\n6-otra: ");
						  menuEfectivo = Integer.parseInt(br.readLine());
					 while(menuEfectivo<1||menuEfectivo>6){
						  System.out.println("No hay cantidades asignadas con esta opcion...\nSeleccione una de las anteriores");
						  menuEfectivo = Integer.parseInt(br.readLine());}
					   if(menuEfectivo == 1){
								balanceCajero-=100;
							    nancy.dinero-=100;
							    System.out.print("Un billete de 100");}
					   
					   if(menuEfectivo == 2){
								balanceCajero-=200;
								nancy.dinero-=200;
								System.out.print("Un billete de 200");}
					   
					   if(menuEfectivo == 3){
								balanceCajero-=500;
								nancy.dinero-=500;
								System.out.print("Un billete de 500");}	  
					   
				       if(menuEfectivo == 4){
							    balanceCajero-=1000;
								nancy.dinero-=1000;
								System.out.print("Un billete de 1000");}
				       
				       if(menuEfectivo == 5){
							    balanceCajero-=2000;
								nancy.dinero-=2000;
								System.out.print("Un billete de 2000");}
				       
					   if(menuEfectivo ==6){
								  System.out.println("Que cantidad desea retirar: ");
								  y = Integer.parseInt(br.readLine());
								  nancy.dinero-=y;
								  balanceCajero-=y;
								      if((y > nancy.dinero) || (y<100)|| (y > balanceCajero) || (y%10)!=0||(y>=2000)){
									        System.out.println("Esta transaccion no se puede realizar ");break;}
								      if((y < nancy.dinero) && (y>100)&& (y < balanceCajero) && (y%10)==0){
									           p1=0;
									       while(y!=0){
										 
										       if(y>=l[p1]){
										                    y-=l[p1];
										                    System.out.printf("Un billete de %d\n%d",l[p1],m2);
										       if (l[p1]==2000){
											                 m+=1;}}
										       if(y<l[p1]){
											                 p1++;}
										       if (m==10){
											                 l[0]=1000;}
										       if((l[0]==1000)&&(l[1]==1000)){
										    	             m1+=1;}
									           if(m1==21){
									    	                l[0]=500;
									    	                l[1]=500;}
									       if ((l[0]==500)&&(l[1]==500)&&(l[2]==500)){
									    	                 m2+=1;}
									          if (m2==61){
										                     l[0]=200;
										                     l[1]=200;
										                     l[2]=200;}
									       if ((l[0]==200)&&(l[1]==200)&&(l[2]==200)&&(l[3]==200)){
										                     m3+=1;}            
									          if (m3==101){
										                     l[0]=100;
									                         l[1]=100;
									                         l[2]=100;
									                         l[3]=100;}
									        if((l[0]==100)&&(l[1]==100)&&(l[2]==100)&&(l[3]==100)){
										                      m4+=1;}
									       }
									       
								 }
							  }
							  
					
						  }
//Consulta de balance de cajero	
				 if(menu ==2){
							  
							  System.out.println("El balance en el cajero es: "+balanceCajero);}
//Consulta de balnce de cuenta
				 if (menu ==3){
							  System.out.println("El balance en su cuenta es: "+nancy.dinero);}
				 
				              System.out.println("\nDesea continuar ...\n1-Si\n2-No ");
					          decision = Integer.parseInt(br.readLine());}
					  while(decision<1||decision>2){
						      System.out.println("No hay opciones asignadas con este numero\ns]Seleccione una de las anteriores");
						      decision = Integer.parseInt(br.readLine());}
				}
			    }
			    }
			    	
		  
    if (decision==2){
		System.out.println("Gracias por preferirnos\n");
		exit=4;}
       }
	}
	}
	
	



