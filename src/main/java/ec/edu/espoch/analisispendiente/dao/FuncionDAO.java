package ec.edu.espoch.analisispendiente.dao;

import ec.edu.espoch.analisispendiente.model.Funcion;

public interface FuncionDAO {
    double derivadaLineal(Funcion f);
    double puntoCritico(Funcion f);
    double valorFuncion(Funcion f, double x);
    double segundaDerivada(Funcion f);
}









