/**********************Q2-Devoir2 ITI1521*********/
package d2q2;

import d2q1.Operation;

class Calculator {

private double first, second; // two calculator operands
private String oP;  

Calculator() {};

 void operation(String str) {
first = second; // keep first operand
second = 0; // initialize and get ready for second operand
oP = str;
}

void add() { operation("+"); }
void subtract() { 
//VOTRE CODE VIENT ICI
 operation("-");
}
void multiply() {
// VOTRE CODE VIENT ICI
 operation("*") ;
}
void divide() { 
//VOTRE CODE VIENT ICI
 operation("/");
}
void factorial() { 
//VOTRE CODE VIENT ICI
 operation("!");
} 
void pow() { 
//VOTRE CODE VIENT ICI
 operation("POW");

} 
void rootSquare() { 
//VOTRE CODE VIENT ICI
 operation("sqrt");
} 
void nepLog() { 
//VOTRE CODE VIENT ICI
 operation("ln");
} 


void compute() {
 //VOTRE CODE VIENT ICI
// on va faire les differents cas d'opération
 // j'ai crée une variable result qui stock les resultat
 // j'utilise le equals pour ne pas comparer les references d'objects
 if (oP.equals("+")) {
  second = first + second;
 }
 if (oP.equals("*")) {
  second = first * second;
 }
 if (oP.equals("-")) {
  second = first - second;
 }
 if (oP.equals("/")) {
  second = first / second;
  if(second==0){
   System.out.println("Error, can't devide by 0");
  }
 }
 if (oP.equals("POW")) {
  second = Math.pow(first, second);
 }
 if (oP.equals("sqrt")) {
  if (first >= 0) {
   second = Math.pow(first, 0.5);
  } else {
   System.out.println("Error, sqrt always positive");
  }
 }
  if (oP.equals("!")) {
   if (first == 0) {
    second = 1;
   } else if (first != 0) {
    second = (int) (Math.pow(2 * Math.PI * first, 0.5) * Math.pow((first / 2.718), first) * (1 + (1 / (12 * first))));
   }
  }
  if(oP.equals("ln")){
   second=Math.log(first);
  }
}

 void clear() {
//VOTRE CODE VIENT ICI
  first=0;
  second = 0;
 }

 double display(){
//VOTRE CODE VIENT ICI
  return second;
 }

/*
AUTRES METHODES SI NECESSAIRE
*/
// les getters pour renvoyer les valuers des termes
 public double getFirst() {
  return first;
 }
public void setSecond(double p){
  second=p;
}
 public double getSecond() {
  return second;
 }
 public String getoP(){
  return oP;
 }
}











