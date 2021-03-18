/*
    CO225 - Project_1 : Fractals
    Author : Damsy De Silva
*/
public class Fractal {
	
	public static void main(String[] args) {

		// thread approach
        int totThreads = 10;
        Thread[] thread = new Thread[totThreads];
        
        
        int argLength = args.length;
        
        // Default values
        float realMin = -1f, realMax = 1f, imgiMin = -1f, imgiMax = 1f;
        int iterations = 1000;
        
        // Mandelbrot set
        if(args[0].equals("Mandelbrot")){
           
        	// checking for valid number of commandline argument 
            if (argLength == 1 || argLength == 5 || argLength == 6){
                if (argLength  == 5){
                    realMin = Float.parseFloat(args[1]);
                    realMax = Float.parseFloat(args[2]);
                    imgiMin = Float.parseFloat(args[3]);
                    imgiMax = Float.parseFloat(args[4]);
                }
                if (argLength == 6){
                	realMin = Float.parseFloat(args[1]);
                    realMax = Float.parseFloat(args[2]);
                    imgiMin = Float.parseFloat(args[3]);
                    imgiMax = Float.parseFloat(args[4]);
                    iterations = Integer.parseInt(args[5]);
                }
            }
            else{
               System.out.println("Invalid Input");
               return;
            }
            
            // Mandelbrot object array
            Mandelbrot[] mandelbrot = new Mandelbrot[totThreads];
            
            // starting threads
            for (int i = 0; i < totThreads; i++) {
                
            	// create Mandelbrot object for current thread
                mandelbrot[i] = new Mandelbrot(i, realMin, realMax, imgiMin, imgiMax, iterations);	
                // set areas to to calculate on the canvas by current thread
                mandelbrot[i].setThreadArea(totThreads, i);	
                
                thread[i] = new Thread(mandelbrot[i]);
                thread[i].start();		
            }

            try {
                for (int i = 0; i < totThreads; i++) {
                    thread[i].join();
                }
            }
            catch (Exception e) {
            	System.out.println("Exception has been caught " + e); 
            }
          
            // Draw the canvas 
            Panel p = new Panel("Madelbrot");
            p.drawCanvas();
        }

        // Julia set
        else if(args[0].equals("Julia")){
        	//Default values
            float cReal = -0.4f, cImgi = 0.6f;

            // checking for valid number of commandline argument 
            if (argLength == 1 || argLength == 3 || argLength == 4){
                if (argLength  == 3){
                    cReal = Float.parseFloat(args[1]);
                    cImgi = Float.parseFloat(args[2]);     
                }
                if (argLength == 4){
                	cReal = Float.parseFloat(args[1]);
                    cImgi = Float.parseFloat(args[2]);
                    iterations = Integer.parseInt(args[3]);
                }
            }
            else{
               System.out.println("Invalid Input");
               return;
            }
            
            // Julia object array
            Julia[] julia = new Julia[totThreads];
            
            
            for (int i = 0; i < totThreads; i++) {
            	// create julia object for current thread
                julia[i] = new Julia(i ,cReal, cImgi, iterations);	
                // set areas to to calculate on the canvas by current thread
                julia[i].setThreadArea(totThreads, i);		
                
                thread[i] = new Thread(julia[i]);
                thread[i].start();
            }

            try {
                for (int i = 0; i < totThreads; i++) {
                    thread[i].join();
                }
            }
            catch (Exception e) {
            	System.out.println("Exception has been caught " + e); 
            }
   
            // Draw the canvas on 
            Panel p = new Panel("Julia");
            p.drawCanvas();
        }
    }
}
