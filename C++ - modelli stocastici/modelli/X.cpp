/*
 * X.cpp
 *
 *  Created on: 28 gen 2023
 *      Author: FCFra
 */

#include "X.h"
#include <iostream>
#include "..\ottimizzazione\GradientDescent.h"
#include <memory>
#include <vector>
double X::previsioneAdUnPasso(double ut)
{
	return b*ut;
}

void X::stampaProcesso()
{
	std::cout<<std::endl<<"y(t) = " <<b<<" * u(t-1)"<<std::endl;
}

void X::stimaParametri(std::unique_ptr<std::vector<double>> &y, std::unique_ptr<std::vector<double>> &u, int n, int iterazioni, double alpha)
{
	GradientDescent dg;
	dg.ottimizza(this, y, u, n, iterazioni, alpha);
}
