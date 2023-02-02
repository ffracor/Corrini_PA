/*
 * ProcessoStocastico.h
 *
 *  Created on: 21 gen 2023
 *      Author: FCFra
 */

#ifndef MODELLI_PROCESSOSTOCASTICO_H_
#define MODELLI_PROCESSOSTOCASTICO_H_

#include <iostream>

//classe astratta
class ProcessoStocastico
{
	protected:
	double wn_mean;
	double wn_variance;

	public:
	//costruttore con lista di inizializzazione
	//distruttore virtual -> rende virtual tutti quelli delle sottoclassi
	ProcessoStocastico(double wnm, double wnv): wn_mean(wnm), wn_variance(wnv){}
	virtual ~ProcessoStocastico(){}

	//calcola parametri
	virtual double calcolaMedia(){return 0;}
	virtual double calcolaVarianza(){return 0;}
	virtual double calcolaAutoCovarianza(int tau){return 0;}

	//stima del modello e previsione
	virtual void stimaParametri(double y[], int n, int iterazioni, double alpha){}
	virtual double previsioneAdUnPasso(double yt){return 0;}
	virtual void stampaProcesso(){}

	//metodi set
	virtual void setVarianza(double var) {wn_variance = var;}
	virtual void setMedia(double mean) {wn_mean = mean;}

	//metodo per simulare il modello
	virtual double simulaModello(double values[] = NULL){return 0;}
};

#endif /* MODELLI_PROCESSOSTOCASTICO_H_ */
