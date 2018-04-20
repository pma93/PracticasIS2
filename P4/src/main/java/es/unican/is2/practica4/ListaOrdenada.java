package es.unican.is2.practica4;

import java.util.ArrayList;

/**
 * Clase que implementa una lista ordenada 
 * Los elementos de la lista deben implementar la interfaz Comparable<E>
 *
 * @author IS2 2013/2014
 */
public class ListaOrdenada<E extends Comparable<E>> implements IListaOrdenada<E>{

       private ArrayList<E> lista = new ArrayList<E>();
        
       /**
        * Lectura posicional: get
        * Lanza IndexOutOfBoundsException si el indice es incorrecto
        * 
        * @param indice Indice del elemento al que se accede
        */
       public E get(int indice) {
          // retorna el elemento
          return lista.get(indice);
       }
       
       
       /**
        * A�adir: add
        * A�ade el elemento que se pasa como par�metro a la posici�n de la lista
        * que le corresponda por orden
        * @param elemento
        */
       public void add(E elemento) {
        // busca el lugar donde debe insertarse
           int indice = 0;
           if (lista.size() != 0) {
           
              while (indice<lista.size()  && elemento.compareTo(lista.get(indice))>0) {
                 indice++;
              }
           }
           lista.add(indice, elemento);
       }
       
       /**
        * Borrar posicional: remove
        * Lanza IndexOutOfBoundsException si el indice es incorrecto
        * @param indice Indice del elemento que se quiere eliminar
        */
       public E remove(int indice) {
          E borrado = lista.remove(indice);
          return borrado;
       }
       
       /**
        * Retorna el tama�o de la lista
        */
       public int size() {
           return lista.size();         
        }
        
        /**
        * Hace nula la lista
        */
        public void clear() {
        	lista.clear();
        }
  } 