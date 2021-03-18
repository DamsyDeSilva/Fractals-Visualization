/*
    CO225 - Project_1 : Fractals
    Author : Damsy De Silva
*/

public class Fract extends Thread {
	
	 	protected float realMin = -1f, realMax = 1f, imgiMin = -1f, imgiMax = 1f;
	    protected int iterations = 1000;
	    
	    private static int[][] canvas = new int [800][800];
	    
	    protected int xStart, xEnd, yStart, yEnd;
	    protected int threadNumber;
	    

	    Fract() {    	
	    	
	    }

	    // Method to set iteration values in the canvas
	    protected static void setCanvasPoint(int x, int y, int val) {
	        canvas[x][y] = val;
	    }

	    // Method to get iteration values from the canvas 
	    protected static int getCanvasPoint(int x, int y) {
	        return canvas[x][y];
	    }

	    // Method to map screen x coordinates to the complexPlane
	    protected Complex mapToComplex(int x, int y){
	        float cX = (realMin + (x * (realMax - realMin) / 800));
	        float cY = (imgiMax - (y * (imgiMax - imgiMin) / 800));
	        return new Complex(cX, cY);
	    }
	    
	  
	    
	    // Method to determine the area covering from a particular thread
	    protected  void setThreadArea(int nuOfThreads, int threadNum) {
	    	xStart = (int) ((800/nuOfThreads) * threadNum);
	    	xEnd =  (int) ((800/nuOfThreads) * (threadNum+1));
	    	//xEnd =  (xStart + (800/nuOfThreads) );
	    	yStart  = 0;
	    	yEnd = 800;
	    }
	    
	    // Method to calculate the canvas
	    public void calCanvas(int xStart, int xEnd, int yStart, int yEnd, int iterations){
	        // will be overloaded by childClasses : Mandelbrot and Julia
	    }
	    
	    
	    // Thread run Method
	    @Override
	    public void run() {
	    	System.out.println("Thread " + threadNumber + " running  From (" + xStart + ", " + yStart + ")  To (" + xEnd + ", " + yEnd + ")....");
	        calCanvas(xStart, xEnd, yStart, yEnd, iterations);
	    }

}
