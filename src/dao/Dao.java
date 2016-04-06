/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;//Data Access Object

import Exception.LibroException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import data.Autor;
import data.DVD;
import data.Libro;
import data.Soporte;

/**
 * @author fabian.giraldo
 * Luego va ser mejorada
 */
public class Dao {
         
    public Autor cargarAutor(Scanner sc) {
	Autor autor = null;
	String nombre = sc.next().trim();
        String apellido = sc.next().trim();
        autor = new Autor(nombre, apellido);
        return autor;
    }
        
    public Libro cargarLibro(Scanner sc) throws LibroException{//throws lo que hace es cargar la responsabilidad de solucionar un problema sobre otra clase
	Libro libro = null;
	String titulo = sc.next().trim();
        
        if(titulo.length()< 5){
           throw new LibroException("Titulo incorrecto" + titulo);//Revisa un error relacionado con la longitud de la cadena de caracteres
        }
        Autor autor = cargarAutor(sc);//Es una funcion que lee el nombre y el apellido y retorna un objeto tipo autor
	String isbn = sc.next().trim();	
        libro = new Libro(isbn, titulo);
        libro.setAutor(autor);
         
        return libro;
    }//cuando se agrege la funcion para el DVD se debe tener en cuenta lo siguiente (DVD,Titulo,Nombre,Apellido,Duración)
    
    public DVD cargarDVD(Scanner sc){
        DVD dvd = null;
        Autor actor[] = new Autor[2];
        String titulo = sc.next().trim();
        Autor autor = cargarAutor(sc);
        actor[0] = cargarAutor(sc);
        actor[1] = cargarAutor(sc);
        int duracion = sc.nextInt();
        dvd = new DVD(actor, duracion, autor, titulo);//Si se presenta algun problema probar a cambiar los parametros
        return dvd;
    }
    
    public Soporte leerSoporte(Scanner sc) throws LibroException {
	String type = sc.next().trim();//Trim quita espacios que esten a la izquierda y derecha
	if (type.equals("Libro")) return cargarLibro(sc);
        else if(type.equals("DVD")) return cargarDVD(sc);
        else
		return null; //<---Se debe completar, falta DVD --->
    }
	
    public ArrayList<Soporte> cargarSoportes(String archivo) throws FileNotFoundException, LibroException{//me permite buscar los archivos
  	ArrayList<Soporte> soportes = new ArrayList<Soporte>();
	Scanner sc;
	sc = new Scanner(new File(archivo));//Vamos a usar rutas relativas
	sc.useDelimiter(",");//Lea cada archivo hasta la coma
	while (sc.hasNext()) {//Añado lo que leo en leerSoporte
		soportes.add(leerSoporte(sc));
	}
	
	return soportes;
   }

    
}
