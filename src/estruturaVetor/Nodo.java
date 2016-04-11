/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturaVetor;

/**
 *
 * @author reque
 */
public class Nodo<T> {
    private T dado;
    private Nodo<T> next;
    private Nodo<T> previous;

    public Nodo(T dado) {
        this.dado = dado;
        this.next = null;
        this.previous = null;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public Nodo<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Nodo<T> previous) {
        this.previous = previous;
    }

    public T getDado() {
        return dado;
    }
    
    public void insertBefore(T dado) {
            Nodo<T> novo = new Nodo<T>(dado);
            Nodo<T> previous = this.getPrevious();
            novo.setPrevious(previous);
            novo.setNext(this);
            this.setPrevious(novo);
            previous.setNext(novo);
    }
    
}
