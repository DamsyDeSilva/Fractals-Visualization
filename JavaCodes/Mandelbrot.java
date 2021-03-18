/*
    CO225 - Project_1 : Fractals
    Author : Damsy De Silva
*/
public class Mandelbrot extends Fract {

    Mandelbrot(int threadNumber,float realMin, float realMax, float imgiMin, float imgiMax, int iterations){
        this.threadNumber = threadNumber;
    	this.realMin = realMin;
        this.realMax = realMax;
        this.imgiMin = imgiMin;
        this.imgiMax = imgiMax;
        this.iterations = iterations;
    }
    
    @Override
    public void calCanvas(int xStart, int xEnd, int yStart, int yEnd, int iterations){
    	
        for(int x = xStart; x < xEnd; x++){ 
            for(int y = yStart; y < yEnd; y++){
            	
            	// map x, y coordinate to region of interest in complex plane
            	Complex c = mapToComplex(x, y);
            
                Complex z = new Complex(0, 0);
                
                for(int i = 0; i < iterations; i++){
                    z = Complex.add(Complex.square(z), c);	// z = z^2 + c
                    if (z.absSqr(z) > 4){
                        Fract.setCanvasPoint(x, y, i);	// save the iterations in the grid
                        break;
                    }
                }
            }
        }
    }
}
