/*
    CO225 - Project_1 : Fractals
    Author : Damsy De Silva
*/

public class Julia extends Fract{
	
	private float cReal , cImagi;

	//class constructor
    Julia(int threadNumber,float cReal, float cImagi, int iterations){
    	this.threadNumber = threadNumber;
        this.cReal = cReal;
        this.cImagi = cImagi;
        this.iterations = iterations;
    }

    @Override
    public void calCanvas(int xStart, int xEnd, int yStart, int yEnd, int iterations){

    	
    	for(int x = xStart; x < xEnd; x++){ 
            for(int y = yStart; y < yEnd; y++){

            	// map x, y coordinate to region of interest in complex plane
            	Complex z = mapToComplex(x, y);
            	
            	Complex c = new Complex(this.cReal, this.cImagi);
                for(int i = 0; i < iterations; i++){
                	
                	// z = z^2 + c;
                    z = Complex.add(Complex.square(z), c);
                    
                    if (z.absSqr(z) > 4){
                    	Fract.setCanvasPoint(x, y, i);
                        break;
                    }
                }
            }
        }
    }
}
