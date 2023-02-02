/*
 * AR.cpp
 *
 *  Created on: 28 gen 2023
 *      Author: FCFra
 */
#include "AR.h"
#include <cmath>
#include <random>
#include "..\ottimizzazione\GradientDescent.h"


//ridefinizione dei metodi necessari
double AR::getA()
{
	return ARMA::getA();
}

void AR::stampaProcesso()
{
	std::cout<<std::endl<<"y(t) = "<<a<<"*y(t-1) + e(t)";
	std::cout<<std::endl<<"Media processo: "<<calcolaMedia()<<"\t\tMedia WN: "<<wn_mean
			 <<std::endl<<"Varianza processo: "<<calcolaVarianza()<<"\tVarianza WN: "<<wn_variance<<std::endl;
}

double AR::calcolaMedia()
{
	return ARMA::calcolaMedia();
}
double AR::calcolaVarianza()
{
	return ARMA::calcolaVarianza();
}
double AR::calcolaAutoCovarianza(int tau)
{
	return ARMA::calcolaAutoCovarianza(tau);
}

void AR::stimaParametri(std::unique_ptr<std::vector<double>> &y, int n, int iterazioni, double alpha)
{
	GradientDescent gd;
	std::unique_ptr<std::vector<double>> z (new std::vector<double>(n)); //deallocato alla fine della funzione
	double media = detrend(y,z,n);
	gd.ottimizza(this, z, n, iterazioni, alpha);
	wn_mean = media*(1-a)/(1+c);

}
double AR::previsioneAdUnPasso(double yt)
{
	return ARMA::previsioneAdUnPasso(yt);
}
double AR::simulaModello(double values[])
{
	return ARMA::simulaModello(values);
}
