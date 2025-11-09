package aed;

import java.util.Stack;

public class ABB<T extends Comparable<T>> {
    /* ¡COMPLETAR! */
    private Nodo raiz;
    private int cardinal;

    private class Nodo {
        // Agregar atributos privados del Nodo
        Nodo nodoIzquierdo;
        Nodo nodoDerecho;
        Nodo nodoPadre;
        T valor;

        // Crear Constructor del nodo
        public Nodo(T valor) {
            this.nodoIzquierdo = null;
            this.nodoDerecho = null;
            this.nodoPadre = null;
            this.valor = valor;
        }
    }

    public class HandleABB {
        /* ¡COMPLETAR! */
        private Nodo nodoApuntado;

        public HandleABB(Nodo n) {
            this.nodoApuntado = n;
        }

        public T valor() {
            return this.nodoApuntado.valor;
        }

        public void eliminar() {
            eliminarNodo(this.nodoApuntado);

        }
    }

    private void eliminarNodo(Nodo n) {
        eliminar(n.valor);
    }

    public ABB() {
        this.raiz = null;
        this.cardinal = 0;
    }

    public int cardinal() {
        return this.cardinal;
    }

    public T minimoRecursivo(Nodo actual) {
        if (actual.nodoIzquierdo == null) {
            return actual.valor;
        }
        return minimoRecursivo(actual.nodoIzquierdo);
    }

    public T minimo() {
        if (this.raiz == null) {
            return null;
        }
        Nodo aux = this.raiz;
        return minimoRecursivo(aux);
    }

    public T maximoRecursivo(Nodo actual) {
        if (actual.nodoDerecho == null) {
            return actual.valor;
        }
        return maximoRecursivo(actual.nodoDerecho);
    }

    public T maximo() {
        if (this.raiz == null) {
            return null;
        }
        Nodo aux = this.raiz;
        return maximoRecursivo(aux);
    }

    public HandleABB insertar(T elem) {
        Nodo parent = null;
        Nodo current = raiz;
        while (current != null) {
            parent = current;
            int cmp = elem.compareTo(current.valor);
            if (cmp < 0) {
                current = current.nodoIzquierdo;
            } else if (cmp > 0) {
                current = current.nodoDerecho;
            } else {
                // exists, return existing
                return new HandleABB(current);
            }
        }
        Nodo newNode = new Nodo(elem);
        newNode.nodoPadre = parent;
        if (parent == null) {
            raiz = newNode;
        } else if (elem.compareTo(parent.valor) < 0) {
            parent.nodoIzquierdo = newNode;
        } else {
            parent.nodoDerecho = newNode;
        }
        cardinal++;
        return new HandleABB(newNode);
    }

    public boolean busquedaRecursiva(Nodo actual, T elem) {
        if (actual == null) {
            return false;
        }

        if (actual.valor.equals(elem)) {
            return true;
        }

        if ((actual.valor).compareTo(elem) > 0) {
            return busquedaRecursiva(actual.nodoIzquierdo, elem);
        } else {
            return busquedaRecursiva(actual.nodoDerecho, elem);
        }
    }

    public boolean pertenece(T elem) {
        Nodo aux = this.raiz;
        return busquedaRecursiva(aux, elem);
    }

    private void intercambiar(Nodo u, Nodo v) {
        if (u.nodoPadre == null) {
            this.raiz = v;
        } else if (u == u.nodoPadre.nodoIzquierdo) {
            u.nodoPadre.nodoIzquierdo = v;
        } else {
            u.nodoPadre.nodoDerecho = v;
        }

        if (v != null) {
            v.nodoPadre = u.nodoPadre;
        }
    }

    private Nodo getNodo(T elem) {
        Nodo aux = this.raiz;
        if (aux == null) {
            return null;
        }
        while (aux.valor != elem) {
            if (aux.valor.compareTo(elem) > 0) {
                aux = aux.nodoIzquierdo;
            } else {
                aux = aux.nodoDerecho;
            }
        }
        return aux;
    }

    public void eliminar(T elem) { // la explicacion del algoritmo esta en el Cormen
        Nodo actual = this.raiz;
        while (actual != null && !actual.valor.equals(elem)) {
            if (elem.compareTo(actual.valor) < 0) {
                actual = actual.nodoIzquierdo;
            } else {
                actual = actual.nodoDerecho;
            }
        } // aca lo busco

        if (actual == null)
            return; // El elemento no se encuentra en el árbol.

        if (actual.nodoIzquierdo == null) {
            intercambiar(actual, actual.nodoDerecho);
        } else if (actual.nodoDerecho == null) {
            intercambiar(actual, actual.nodoIzquierdo);
        } else {
            Nodo sucesor = getNodo(minimoRecursivo(actual.nodoDerecho));
            if (sucesor.nodoPadre != actual) {
                intercambiar(sucesor, sucesor.nodoDerecho);
                sucesor.nodoDerecho = actual.nodoDerecho;
                sucesor.nodoDerecho.nodoPadre = sucesor;
            }
            intercambiar(actual, sucesor);
            sucesor.nodoIzquierdo = actual.nodoIzquierdo;
            sucesor.nodoIzquierdo.nodoPadre = sucesor;
        }
        cardinal--;
    }

    private String stringInOrder(Nodo actual) {
        if (actual == null) {
            return "";
        }

        String izquierda = stringInOrder(actual.nodoIzquierdo);
        String derecha = stringInOrder(actual.nodoDerecho);

        return izquierda + (izquierda.isEmpty() ? "" : ", ") + actual.valor.toString() + (derecha.isEmpty() ? "" : ", ")
                + derecha;
    }

    @Override
    public String toString() {
        Nodo aux = this.raiz;
        String res = "{";
        res = res + stringInOrder(aux);
        res = res + "}";
        return res;
    }

    public class ABB_Iterador {
        private Nodo actual;
        private Stack<Nodo> stack; // vamos a ir guardando todos los elementos aca ya que es facil para sacarlos

        public ABB_Iterador() {
            actual = raiz;
            stack = new Stack<Nodo>();
            Nodo aux = actual;
            cargarDatosInOrder(aux);
        }

        private void cargarDatosInOrder(Nodo x) {
            if (x != null) {
                cargarDatosInOrder(x.nodoDerecho);
                stack.push(x);
                cargarDatosInOrder(x.nodoIzquierdo);
            }
        }

        public boolean haySiguiente() {
            return !(stack.isEmpty());
        }

        public T siguiente() {
            if (!haySiguiente()) {
                return null;
            }
            Nodo siguiente = stack.pop();
            return siguiente.valor;
        }
    }

    public ABB_Iterador iterador() {
        return new ABB_Iterador();
    }

}