package ej;

public class Main {
    public static void main(String[] args) {
        String url = "localhost";
        String dbName = "codigo";

        Modelo m = new Modelo(url, dbName);
        Vista v = new Vista(m);
        Controlador c = new Controlador(m,v);
        c.ejecutar();


    }

}