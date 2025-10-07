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
        Nodo nuevoNodo = new Nodo(elem);
        if(this.nodoPrimero == null){
            this.nodoPrimero = nuevoNodo;
            this.nodoUltimo = nuevoNodo;
        }else{
            nuevoNodo.nodoSiguiente = this.nodoPrimero;
            this.nodoPrimero = nuevoNodo;
        }
        this.longitud++;

    }

    public void agregarAtras(T elem) {
        Nodo nuevoNodo = new Nodo(elem);
        if(nodoUltimo == null){
            nodoPrimero = nuevoNodo;// 
            nodoUltimo = nuevoNodo;
        }else{
            this.nodoUltimo.nodoSiguiente = nuevoNodo;// "conectmos" el ultimo.siguiente a el nuevo Ndoo  
            nuevoNodo.nodoAnterior = this.nodoUltimo;// aca "concectamos" el nodoanterior del nuevo nodo a el ultimo nodo de nuestra instancia   
            this.nodoUltimo = nuevoNodo; // reemplazamos el ultimo noodo de la isntncia por el nuevo nodo que ya esta "conectado" al ultimo nodo de una instancia anterior 
        }
        this.longitud++;
    }

    public T obtener(int i) {
        Nodo nodoAuxiliar = this.nodoPrimero;
        int j = 0;
        while(j<i){
            nodoAuxiliar = nodoAuxiliar.nodoSiguiente; 
            j++;
        }
        return nodoAuxiliar.valor;
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
