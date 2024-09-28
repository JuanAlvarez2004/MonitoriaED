package Clase7;

public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public Nodo iniArbol() {
        raiz = new Nodo("A");
        raiz.izq = new Nodo("B");
        raiz.der = new Nodo("C");
        raiz.izq.izq = new Nodo("D");
        raiz.izq.der = new Nodo("E");
        raiz.der.der = new Nodo("F");
        return raiz;
    }

    //I,R,D
    public void inorder(Nodo nodo) {
        if (nodo != null) {
            inorder(nodo.izq);
            System.out.print(nodo.valor + ", ");
            inorder(nodo.der);
        }
    }

    //R,I,D
    public void preorder(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + ", ");
            preorder(nodo.izq);
            preorder(nodo.der);
        }
    }

    //I,D,R
    public void postorder(Nodo nodo) {
        if (nodo != null) {
            postorder(nodo.izq);
            postorder(nodo.der);
            System.out.print(nodo.valor + ", ");
        }
    }

    public void impArbol() {
        System.out.println("""
                    A
                   / \\
                  B   C
                 / \\   \\
                D   E   F""");
    }


    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Nodo raiz = arbol.iniArbol();
        arbol.impArbol();
        System.out.println("\nInorder: ");
        arbol.inorder(raiz);
        System.out.println("\nPreorder: ");
        arbol.preorder(raiz);
        System.out.println("\nPostorder: ");
        arbol.postorder(raiz);

    }

}
