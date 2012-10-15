package GeneradorHotario;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Generadorhorario {

    public static void main(String[] args) throws IOException, DocumentException {
        Document documento = new Document();



        Materia Etica = new Materia("42A", "Etica", 3);
        Materia Pw = new Materia("41B", "Programacion Wed", 4);
        Materia F = new Materia("41C", "Fisica", 5);
        Materia CI = new Materia("41D", "Calculo Integral", 5);
        Materia CD = new Materia("41E", "Calculo Diferencial", 5);
        Materia PC = new Materia("41A", "Precalculo", 5);
        Materia Redaccion = new Materia("21A", "Redaccion Castellana", 4);
        Materia Fund = new Materia("AulaCad", "Fundamentos de Programacion", 4);
        Materia P1 = new Materia("11B", "Programacion 1", 4);
        Materia P2 = new Materia("11c", "Programacion 2 ", 4);
        Materia F2 = new Materia("42F", "Fisica II", 5);
        Materia P3 = new Materia("12D", "Programacion 3", 4);
        Materia Db = new Materia("11b", "Base de Datos", 4);
        Materia DBA = new Materia("12A", "Base de DAto Avansada", 4);
        Materia DibuTcnico = new Materia("AulaDraw", "Tecnichal Draw", 4);
        Materia c = new Materia("AulaCad", "Circuitos", 5);
        Materia f3 = new Materia("11D", "Fisica 3", 5);
        Materia Mineria = new Materia("11b", "Sisyema Operativo", 4);
        Materia OS = new Materia("12A", "Base de DAto Avansada", 4);
        Materia CCNA = new Materia("21A", "Tecnichal Draw", 4);
        Materia c2 = new Materia("AulaCad", "Circuitos 2", 5);
        int CantProf = 0, horas = 0, b = 0, cd = 0, m = 0, hp = 0, cdr = 0;
        Materia[] Listam = {Etica, Pw, F, CI, CD, PC, Redaccion, Fund, P1, P2, F2, P3, Db, DBA, DibuTcnico, f3, Mineria, OS, CCNA, c2};
        String nombre;
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        System.out
                .println("+------------------------------------------------+");
        System.out
                .println("¦                    MENU                        ¦");
        System.out
                .println("¦BIENVENIDO AL GENERADOR DE HORARIO ITLA:        ¦");
        System.out
                .println("+------------------------------------------------+\n");

        try {
            System.out.println("Ingrese la cantidad de profesores que desea Crear: ");
            CantProf = Integer.parseInt(sc.readLine());

        } catch (Exception e) {
            System.out.println("Error...Solo se aceptan números...vuelva a intentar: ");
            CantProf = Integer.parseInt(sc.readLine());

        }


        while (CantProf <= 0) {

            System.out.println("Opción invalida vuelva a intentarlo...Ingrese la cantidad de profesores que desea Crear: ");
            CantProf = Integer.parseInt(sc.readLine());
        }

        ArrayList<Profesor> lista = new ArrayList<Profesor>();
        String[] dias = {"Lunes", "Martes", "Mircoles", "Jueves", "Viernes", "Sabados"};
        String[] hora = {"8Am-11AM", "11AM-1PM", "2PM-6PM", "6PM-10PM", "2PM-5PM", "5PM-8PM"};

        while (CantProf > 0) {

            System.out.println("Ingrese el nombre del Profesor: ");
            nombre = sc.readLine();

            try {

                System.out.println("Elija la cantidad de horas del profesor del Profesor\n1:20 Horas\n2:40 Horas");
                horas = Integer.parseInt(sc.readLine());
            } catch (Exception e) {

                System.out.println("Error...Solo se aceptan números...Vuelva a intentar: ");
                horas = Integer.parseInt(sc.readLine());
            }

            while (horas <= 0 || horas > 2) {

                System.out.println("No hay números asignados con esta opción...vuelva a intentar ");
                horas = Integer.parseInt(sc.readLine());
            }

            if (horas == 1) {
                horas = 20;

            }

            if (horas == 2) {
                horas = 40;
            }

            lista.add(new Profesor(horas, nombre));
            CantProf -= 1;

        }

        for (Profesor x : lista) {

            PdfWriter.getInstance(documento, new FileOutputStream(x.nombre + ".pdf"));
            documento.open();

            if (x.horas == 20) {

                while (x.horas > 0) {

                    if (cd == cdr) {

                        System.out.print(dias[cd] + " \n");
                        documento.add(new Paragraph("\n"));
                        documento.add(new Paragraph(dias[cd] + " \n"));
                    }

                    cdr = 7;
                    x.horas -= 5;

                    if (b < Listam.length) {

                        System.out.print("Materia: " + Listam[b].nombre + " Aula: " + Listam[b].idaula + " ");
                        documento.add(new Paragraph("Materia: " + Listam[b].nombre + " Aula: " + Listam[b].idaula + " "));
                        b++;
                    }

                    System.out.print("Hora: " + hora[hp]);
                    documento.add(new Paragraph("Hora: " + hora[hp]));
                    hp += 1;

                    if (hp == 6) {
                        hp = 0;
                    }

                    System.out.print("Profesor: " + x.nombre + "\n");
                    documento.add(new Paragraph("Profesor: " + x.nombre + "\n"));


                    if (x.horas == 10) {
                        cd += 1;
                        cdr = cd;
                    }

                    if (x.horas == 5) {
                        cd += 2;
                        cdr = cd;
                    }

                    if (cd == 6) {//Termina de asignarle los datos a los profesores
                        cd = 0;
                    }

                    if (x.horas == 0) {// Se reinician los valores para el nuevo profesor
                        cd = 0;
                        cdr = cd;
                        x.horas = x.horas;
                    }
                }

                x.horas = x.horas;
                cd = 0;
            }

            if (x.horas == 40) {

                while (x.horas > 0) {

                    if (cd == cdr) {

                        documento.add(new Paragraph("\n"));
                        System.out.print(dias[cd] + " \n");

                        documento.add(new Paragraph(dias[cd]));

                    }
                    cdr = 7;

                    x.horas -= 5;
                    if (b < Listam.length) {
                        
                        System.out.print("Materia: " + Listam[b].nombre + "Aula: " + Listam[b].idaula + " ");

                        documento.add(new Paragraph("Materia: " + Listam[b].nombre + " Aula: " + Listam[b].idaula + " "));

                        b++;
                    }
                    System.out.print("Hora " + hora[hp]);
                    documento.add(new Paragraph("Hora " + hora[hp]));
                    hp += 1;
                    if (hp == 6) {
                        hp = 0;
                    }
                    System.out.print("Profesor: " + x.nombre + "\n");
                    documento.add(new Paragraph("Profesor: " + x.nombre + "\n"));
                    
                    if (x.horas == 10 || x.horas == 20 || x.horas == 30) {
                        cd += 1;
                        cdr = cd;
                    }
                    
                    if (x.horas == 35) {
                        cd += 2;
                        cdr = cd;
                    }
                    
                    if (cd == 6) {
                        cd = 0;
                    }
                    
                    if (x.horas == 0) {
                        cd = 0;
                        cdr = cd;
                        x.horas = x.horas;
                    }
                }
                
                x.horas = x.horas;
                cd = 0;
            }


        }

        documento.close();
    }
}
