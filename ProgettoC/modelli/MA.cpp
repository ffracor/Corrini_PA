/*
 * MA.cpp
 *
 *  Created on: 28 gen 2023
 *      Author: FCFra
 */
#include "MA.h"
#include <cmath>
#include <random>
#include "..\ottimizzazione\GradientDescent.h"

//ridefinizione dei metodi necessari
double MA::getC()
{
	return ARMA::getC();
}

void MA::stampaProcesso()
{
	std::cout<<std::endl<<"y(t) = e(t) + "<<c<<"*e(t-1)";
	std::cout<<std::endl<<"Media processo: "<<calcolaMedia()<<"\t\tMedia WN: "<<wn_mean
			 <<std::endl<<"Varianza processo: "<<calcolaVarianza()<<"\tVarianza WN: "<<wn_variance<<std::endl;

}

double MA::calcolaMedia()
{
	return ARMA::calcolaMedia();
}
double MA::calcolaVarianza()
{
	return ARMA::calcolaVarianza();
}
double MA::calcolaAutoCovarianza(int tau)
{
	return ARMA::calcolaAutoCovarianza(tau);
}

void MA::stimaParametri(std::unique_ptr<std::vector<double>> &y, int n, int iterazioni, double alpha)
{
	GradientDescent gd;
	std::unique_ptr<std::vector<double>> z (new std::vector<double>(n)); //deallocato alla fine della funzione
	double media = detrend(y,z,n);
	gd.ottimizza(this, z, n, iterazioni, alpha);
	wn_mean = media*(1-a)/(1+c);
}
double MA::previsioneAdUnPasso(double yt)
{
	return ARMA::previsioneAdUnPasso(yt);
}

double MA::simulaModello(double values[])
{
	double v[1] = {0};
	return ARMA::simulaModello(v);
}
