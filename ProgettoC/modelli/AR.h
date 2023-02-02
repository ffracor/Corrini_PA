/*
 * AR.h
 *
 *  Created on: 28 gen 2023
 *      Author: FCFra
 */

#ifndef MODELLI_AR_H_
#define MODELLI_AR_H_

#include "ARMA.h"

//AR non è un sottotipo di ARMA ma può riutilizzare parte del codice. usa quindi ereditarietà privata
//ridefinendo solo il metodi necessari
class AR: private ARMA
{
	public:
	//using ARMA::ARMA;
	AR(double a, double wnm, double wnv): ARMA(a, 0, wnm, wnv){}
	AR(): ARMA(0,0,0,1){}

	double getA();
	void setA(double A) {a = A;}
	void setMedia(double mean) {wn_mean = mean;}
	void setVarianza(double var) {wn_variance = var;}
	void stampaProcesso();

	double calcolaMedia();
	double calcolaVarianza();
	double calcolaAutoCovarianza(int tau);

	void stimaParametri(std::unique_ptr<std::vector<double>> &y, int n, int iterazioni = 250, double alpha = 0.00001);
	double previsioneAdUnPasso(double yt);
	double simulaModello(double values[] = NULL);
};

#endif /* MODELLI_AR_H_ */
