/*
 * X.h
 *
 *  Created on: 28 gen 2023
 *      Author: FCFra
 */

#ifndef MODELLI_X_H_
#define MODELLI_X_H_

#include <cstdlib>
#include <memory>
#include <vector>

class X
{
	protected:
	double b;

	public:
	X(): X(0){}
	X(double B): b(B){}
	double getB() {return b;}
	void setB(double B) {b = B;}
	double previsioneAdUnPasso(double ut);
	void stimaParametri(std::unique_ptr<std::vector<double>> &y, std::unique_ptr<std::vector<double>> &u, int n, int iterazioni = 250, double alpha = 0.00001);
	void stampaProcesso();
};

#endif /* MODELLI_X_H_ */
