module A { 
 export interface X { s: string } 
} 
 
/** 
 * this is a great module 
 */
module B { 
 /*var A = 1; */ 
 import Y = A; 
} 
