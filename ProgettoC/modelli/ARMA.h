/*
 * ARMA.h
 *
 *  Created on: 28 gen 2023
 *      Author: FCFra
 */

#ifndef MODELLI_ARMA_H_
#define MODELLI_ARMA_H_

#include "ProcessoStocastico.h"
#include <memory>
#include <vector>
#include <random>

//è sottotipo di processo stocastico, eredita i metodi ma ne ridefinisce la maggior parte
class ARMA: public ProcessoStocastico
{
	protected:
	double a; //parametri
	double c;
	double *y_hat;	//predittore
	double *last_wn; //simulazione
	std::default_random_engine generator; //per la generazione del white noise

	//metodo che non serve fuori dalla classe ma serve per eliminare la media dai processi
	double detrend(std::unique_ptr<std::vector<double>> &y, std::unique_ptr<std::vector<double>> &det, int n);

	public:
	//liste di inizializzazione
	ARMA(): ARMA(0,0,0,1){} //default
	ARMA(double A, double C, double wnm, double wnv): ProcessoStocastico(wnm, wnv), a(A), c(C)
	{
		y_hat = new double; //puntatori allo heap
		last_wn = new double;
		(*y_hat) = 0;		//predittore ad un passo inizializzato a 0
		(*last_wn) = 0;	//ultimo wn per simulazione inizializzato a 0
	}
	~ARMA(){delete y_hat; delete last_wn;} //uso il distruttore per deallocare le variabili allocate nel costruttore
	//evito memory leak

	//calcolo media varianza e covarianza
	double calcolaMedia();
	double calcolaVarianza();
	double calcolaAutoCovarianza(int tau);

	//stima del modello e previsione. definiti valori standard per iterazioni e learning rate alpha
	void stimaParametri(std::unique_ptr<std::vector<double>> &y, int n, int iterazioni = 250, double alpha = 0.1);
	double previsioneAdUnPasso(double yt);
	void stampaProcesso();

	//set get e simulazione
	double getA() {return a;}
	double getC() {return c;}
	void setC(double C) {c = C;}
	void setA(double A) {a = A;}
	double simulaModello(double values[] = NULL);
};

#endif /* MODELLI_ARMA_H_ */
