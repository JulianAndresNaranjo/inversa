package co.uniquindio;

import java.util.ArrayList;

public class NotNotacionPolaca {

    private ArrayList<String> pila = new ArrayList<>();
    private ArrayList<String> polaca = new ArrayList<>();

    public NotNotacionPolaca(ArrayList<String> expresion) {
        notacion(expresion);
    }

    public ArrayList<String> notacion(ArrayList<String> expresion) {
        for (int i = 0; i < expresion.size(); i++) {

            if ("^".equals(expresion.get(i)) || "/".equals(expresion.get(i)) || "*".equals(expresion.get(i)) || "+".equals(expresion.get(i)) || "-".equals(expresion.get(i))) {
                if ("-".equals(expresion.get(i)) || "+".equals(expresion.get(i))) {
                    pila.add(expresion.get(i));
                } else {
                    for (int j = pila.size() - 1; j >= 0; j--) {
                        if ("^".equals(pila.get(j)) || "*".equals(pila.get(j)) || "/".equals(pila.get(j)) || "+".equals(pila.get(j)) || "-".equals(pila.get(j))) {
                            polaca.add(pila.get(j));
                            pila.remove(j);
                        }
                    }
                    pila.add(expresion.get(i));
                }
            } else {
                polaca.add(expresion.get(i));
            }
        }
        for (int i = pila.size() - 1; i >= 0; i--) {
            polaca.add(pila.get(i));
        }
        return polaca;
    }
}