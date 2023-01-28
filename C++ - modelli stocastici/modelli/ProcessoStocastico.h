/*
 * ProcessoStocastico.h
 *
 *  Created on: 21 gen 2023
 *      Author: FCFra
 */

#ifndef MODELLI_PROCESSOSTOCASTICO_H_
#define MODELLI_PROCESSOSTOCASTICO_H_

//classe astratta
class ProcessoStocastico
{
	protected:
	double wn_mean;
	double wn_variance;

	public:
	//distruttore virtual -> rende virtual tutti quelli delle sottoclassi
	virtual ~ProcessoStocastico(){}

	//calcola parametri
	virtual double calcolaMedia(){return 0;}
	virtual double calcolaVarianza(){return 0;}
	virtual double calcolaAutoCovarianza(int tau){return 0;}

	//stima del modello e previsione
	virtual void stimaParametri(double y[], int n){}
	virtual double previsioneAdUnPasso(double yt){return 0;}
	virtual void stampaProcesso(){}

	virtual void setVarianza(double var) {wn_variance = var;}
	virtual void setMedia(double mean) {wn_mean = mean;}
};

#endif /* MODELLI_PROCESSOSTOCASTICO_H_ */
