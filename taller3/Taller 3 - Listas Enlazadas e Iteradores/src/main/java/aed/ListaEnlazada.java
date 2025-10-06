package aed;

public class ListaEnlazada<T> {
    // Completar atributos privados
    private Nodo nodoPrimero;
    private Nodo nodoUltimo;
    private int longitud;
    private class Nodo {
        // Completar
        private T valor;
        private Nodo nodoSiguiente;
        private Nodo nodoAnterior;
        public Nodo(T valor){
            this.valor = valor;
            this.nodoSiguiente = null;
            this.nodoAnterior = null;
        }
    }

    public ListaEnlazada() {
        this.nodoPrimero = null;
        this.nodoUltimo = null;
        this.longitud = 0;
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAdelante(T elem) {
        if(this.nodoPrimero.valor == null){
            this.nodoPrimero.valor = elem;
        }
        else{
            Nodo nodoNuevo = new Nodo(elem);
            nodoNuevo.nodoSiguiente = nodoPrimero;
            nodoPrimero = nodoNuevo;
        }
        this.longitud += 1;
    }

    public void agregarAtras(T elem) {
        while(this.nodoPrimero != null){
            nodoPrimero = nodoPrimero.nodoSiguiente;
        }
        
    }

    public T obtener(int i) {
        int j = 0;
        while(j<i){
            nodoPrimero = nodoPrimero.nodoSiguiente;
        }
        return nodoPrimero.valor;
    }

    public void eliminar(int i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public class ListaIterador{
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public ListaIterador iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
