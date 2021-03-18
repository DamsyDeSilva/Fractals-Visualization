/*
    CO225 - Project_1 : Fractals
    Author : Damsy De Silva
*/

public class Complex {

    private float real;
    private float imgi;

    public Complex (float real, float imgi){
        this.real = real;
        this.imgi = imgi;
    }

    // add two complex numbers
    public static Complex add(Complex z1, Complex z2){
        return new Complex(z1.real + z2.real , z1.imgi + z2.imgi);
    }

    // squared value of a complex numbers
    public static Complex square(Complex z1){
        return new Complex((z1.real * z1.real)-(z1.imgi * z1.imgi), 2*z1.real*z1.imgi);
    }

    // squared absolute value of a complex number
    public double absSqr(Complex z1){
        return (Math.pow(z1.real,2) + Math.pow(z1.imgi,2));
    }    
}