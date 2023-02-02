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

class ARMA: public ProcessoStocastico
{
	protected:
	double a;
	double c;
	double *y_hat;	//predittore
	double *last_wn; //simulazione
	std::default_random_engine generator;

	double detrend(std::unique_ptr<std::vector<double>> &y, std::unique_ptr<std::vector<double>> &det, int n);

	public:
	ARMA(): ARMA(0,0,0,1){}
	ARMA(double A, double C, double wnm, double wnv): ProcessoStocastico(wnm, wnv), a(A), c(C)
	{
		y_hat = new double;
		last_wn = new double;
		(*y_hat) = 0;		//predittore ad un passo inizializzato a 0
		(*last_wn) = 0;	//ultimo wn per simulazione inizializzato a 0
	}
	~ARMA(){delete y_hat; delete last_wn;}
	double calcolaMedia();
	double calcolaVarianza();
	double calcolaAutoCovarianza(int tau);

	//stima del modello e previsione
	void stimaParametri(std::unique_ptr<std::vector<double>> &y, int n, int iterazioni = 250, double alpha = 0.00001);
	double previsioneAdUnPasso(double yt);
	void stampaProcesso();

	double getA() {return a;}
	double getC() {return c;}
	void setC(double C) {c = C;}
	void setA(double A) {a = A;}
	double simulaModello(double values[] = NULL);
};

#endif /* MODELLI_ARMA_H_ */
