package aed;

public class ListaEnlazada<T> {
    private Nodo nodoPrimero;
    private Nodo nodoUltimo;
    private int longitud;

    private class Nodo {
        private T valor;
        private Nodo nodoSiguiente;
        private Nodo nodoAnterior;

        public Nodo(T valor) {
            this.valor = valor;
            this.nodoSiguiente = null;
            this.nodoAnterior = null;
        }
    }

    public ListaEnlazada() {
        nodoPrimero = null;
        nodoUltimo = null;
        longitud = 0;
    }

    public int longitud() {
        return longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (longitud == 0) {
            nodoPrimero = nodoUltimo = nuevo;
        } else {
            nuevo.nodoSiguiente = nodoPrimero;
            nodoPrimero.nodoAnterior = nuevo;
            nodoPrimero = nuevo;
        }
        longitud++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (longitud == 0) {
            nodoPrimero = nodoUltimo = nuevo;
        } else {
            nodoUltimo.nodoSiguiente = nuevo;
            nuevo.nodoAnterior = nodoUltimo;
            nodoUltimo = nuevo;
        }
        longitud++;
    }

    public T obtener(int i) {
        if (i < 0 || i >= longitud) throw new IndexOutOfBoundsException();
        Nodo actual = nodoPrimero;
        for (int j = 0; j < i; j++) {
            actual = actual.nodoSiguiente;
        }
        return actual.valor;
    }

    public void eliminar(int i) {
        if (i < 0 || i >= longitud) throw new IndexOutOfBoundsException();
        Nodo aEliminar;
        if (longitud == 1) {
            aEliminar = nodoPrimero;
            nodoPrimero = nodoUltimo = null;
        } else if (i == 0) {
            aEliminar = nodoPrimero;
            nodoPrimero = nodoPrimero.nodoSiguiente;
            nodoPrimero.nodoAnterior = null;
        } else if (i == longitud - 1) {
            aEliminar = nodoUltimo;
            nodoUltimo = nodoUltimo.nodoAnterior;
            nodoUltimo.nodoSiguiente = null;
        } else {
            Nodo actual = nodoPrimero;
            for (int j = 0; j < i; j++) {
                actual = actual.nodoSiguiente;
            }
            aEliminar = actual;
            aEliminar.nodoAnterior.nodoSiguiente = aEliminar.nodoSiguiente;
            aEliminar.nodoSiguiente.nodoAnterior = aEliminar.nodoAnterior;
        }
        longitud--;
    }

    public void modificarPosicion(int indice, T elem) {
        if (indice < 0 || indice >= longitud) throw new IndexOutOfBoundsException();
        Nodo actual = nodoPrimero;
        for (int j = 0; j < indice; j++) {
            actual = actual.nodoSiguiente;
        }
        actual.valor = elem;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        this();
        Nodo actual = lista.nodoPrimero;
        while (actual != null) {
            agregarAtras(actual.valor);
            actual = actual.nodoSiguiente;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Nodo actual = nodoPrimero;
        while (actual != null) {
            sb.append(actual.valor);
            if (actual.nodoSiguiente != null) {
                sb.append(", ");
            }
            actual = actual.nodoSiguiente;
        }
        sb.append("]");
        return sb.toString();
    }

    public class ListaIterador {
        private Nodo cursor;

        public ListaIterador() {
            cursor = new Nodo(null); 
            cursor.nodoSiguiente = nodoPrimero;
            if (nodoPrimero != null) {
                nodoPrimero.nodoAnterior = cursor;
            }
        }

        public boolean haySiguiente() {
            return cursor.nodoSiguiente != null;
        }

        public boolean hayAnterior() {
            return cursor != null && cursor.nodoAnterior != null && cursor.nodoAnterior.valor != null;
        }

        public T siguiente() {
            if (!haySiguiente()) throw new RuntimeException("No hay siguiente");
            cursor = cursor.nodoSiguiente;
            return cursor.valor;
        }

        public T anterior() {
            if (!hayAnterior()) throw new RuntimeException("No hay anterior");
            T valor = cursor.valor;
            cursor = cursor.nodoAnterior;
            return valor;
        }
    }

    public ListaIterador iterador() {
        return new ListaIterador();
    }
}