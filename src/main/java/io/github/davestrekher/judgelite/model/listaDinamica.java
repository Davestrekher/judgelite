package io.github.davestrekher.judgelite.model;

public class listaDinamica<T> {
    private T[] vetor;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public listaDinamica() {
        vetor = (T[]) new Object[1];
    }

    @SuppressWarnings("unchecked")
    public void add(T valor) {
        size++;
        if (size > vetor.length) {
            T[] temp = (T[]) new Object[2 * size];
            for (int i = 0; i < size - 1; i++) {
                // System.out.println(i);
                temp[i] = vetor[i];
            }
            vetor = temp;
        }

        vetor[size - 1] = valor;
    }

    // size = 1, vetor[0] = 4 => size = 2, temp = { , }, temp[0] = 4, temp
    public String exibirLista() {
        String res = "";
        for (int i = 0; i < size; i++) {
            res += vetor[i];
        }

        return res;
    }

    public int getSize() {
        return size;
    }

    public T getValor(int i) {
        return vetor[i];
    }
}