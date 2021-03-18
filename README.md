# Fractals-Visualization

### Introduction 
  This is a multi - threaded java program that would plot two of the most popular fractals: **Madelbrot Set** and **Julia Set**.
  
  Fractals are infinity many self-similar shapes formed by some simple mathematical computations.The computation varies from fractal set to set but are generally based on complex numbers.
  
  - The Mandelbrot Set
  
  In mathematics Mandelbrot set is defined as the set of **complex numbers C** such
that: Z<sub>n+1</sub> = Z<sup>2</sup><sub>n</sub> + C , starting with Z<sub>0</sub> = 0 remains bounded when n reach infinity. In other words if for some C the above equation remains bounded for after many iterations then that C is in the Mandelbrot
set.

  - The Julia Set

  The Julia set is similar to the Mandelbrot set in that it uses the same equation Z<sub>n+1</sub> = Z<sup>2</sup><sub>n</sub> + C, but Z<sub>0</sub> is the point in the complex plane corresponding to the pixel and **C is a constant**.
    
  
### Program
  - Program accepts user inputs as command line arguments; at least one which would specify what set to plot. 
  - If the set selected is **Mandelbrot** the user should give either 0, 4 or 5 arguments. 
  - If there are 0 arguments then use the default values as specified in the table below.
  - 4 arguments will be the region of interest in the complex plane and the 5th one is the number of iterations to do for a point.
  - For the Julia set the user should give 0 or 2 arguments. 
  - If there are no arguments one should use the default arguments and 2 arguments will be the real and complex part for C.


| **Item**             | **Default value**                      | **Note**                     |
| :---:                |    :----:                              |     :---:                    |
| Region of Interest   | -1 < real < 1 <br /> -1 < complex < 1  | Always use default for Julia |
| Number of Iterations | 1000                                   |                              |
| C                    | -0.4 + 0.6i                            | Only for Julia set           |

### How to run
  Here are two exapmles to show how to run the application.
  (Note that Fractal is the name of the application : Fractal.java)
  
    java Fractal Mandelbrot -0.5 0.5 -0.1 1 1000
      
This means the region of interest for the image wil be from -0.5< real < 0.5 and -0.1 < complex < 1 and for each point it'll run 1000 iterations before deciding that it is in the set.

    java Fractal Julia -0.5 0.156 1000
  
This means application will plot the Julia set for C = -0.5 + 0.156i with 1000 iterations for each point. You may take the region of interest in the complex plan as 1 < real part < 1 and -1< complex part<1 which cannot be modified.
      
#### Note 

This project was done as a Software Construction course Project.

For more datails about project, refer the Project_Description.pdf

Refer the ClassDiagram.pdf for overiew of implementation.
