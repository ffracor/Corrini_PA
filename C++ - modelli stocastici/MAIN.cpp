/*
 * MAIN.cpp
 *
 *  Created on: 4 gen 2023
 *      Author: FCFra
 */

#include <iostream>
#include <cstdlib>
#include <cstring>
#include "modelli\AR.h"

using namespace std;

int main()
{
	cout<<endl<<"MAIN"<<endl;

	AR* ar = new AR;

	cout<<endl<<"Media: "<<ar->calcolaMedia()
		<<endl<<"Varianza: "<<ar->calcolaVarianza()
		<<endl<<"Auto1: "<<ar->calcolaAutoCovarianza(1);

	double vec[] = {1,2,1,0,1};
	ar->stimaParametri(vec, 5);
	cout<<"CIAO";
	return 0;
}
