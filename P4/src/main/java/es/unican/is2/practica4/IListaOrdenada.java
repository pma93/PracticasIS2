package es.unican.is2.practica4;

/**
 * TDA Lista Ordenada 
 * 
 * @param <E> tipo de los elementos almacenados en la secuencia
 * @author IS2 Curso 15-16
 */
public interface IListaOrdenada<E> {

    /**
     * Retorna el elemento que ocupa la posicion indicada
     * Lanza IndexOutOfBoundsException si el indice es incorrecto
     * 
     * @param indice Indice del elemento al que se accede
     */
    public E get(int indice) throws IndexOutOfBoundsException;
    
    
    /**
     * Anhade el elemento que se pasa como parametro a la posicion de la lista
     * que le corresponda por orden natural
     * @param elemento Elemento a anhadir
     */
    public void add(E elemento);
    
    /**
     * Elimina el elemento que ocupa la posicion indicada
     * Lanza IndexOutOfBoundsException si el indice es incorrecto
     * @param indice Indice del elemento que se quiere eliminar
     */
    public E remove(int indice) throws IndexOutOfBoundsException;
    
    /**
     * Retorna el tamanho de la lista
     */
    public int size();
    
    /**
     * Vacia la lista
     */
     public void clear();

}