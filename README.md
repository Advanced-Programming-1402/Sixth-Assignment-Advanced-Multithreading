## Pi Number :

      Pi (often represented by the lower-case Greek letter π), one of the most well-known mathematical constants, is the ratio of a circle’s circumference to its diameter.  For any circle, the distance around the edge is a little more than three times the distance across.
Typing π into a calculator and pressing ENTER will yield the result 3.141592654, not because this value is exact, but because a calculator’s display is often limited to 10 digits.  Pi is actually an irrational number (a decimal with no end and no repeating pattern) that is most often approximated with the decimal 3.14 or the fraction 227.

The definition of π is:
 
 The Circumference  divided by the Diameter of a Circle.          

 ![pi](https://github.com/mahdi1ebi/Sixth-Assignment-Advanced-Multithreading/assets/160699586/d447f87e-6053-4f92-a99b-f78c7c5b00d6)

The number pi (π) is a mathematical constant that represents the ratio of a circle's circumference to its diameter. It is approximately equal to 3.14159 and is an irrational number, meaning it cannot be expressed as a fraction and its decimal representation goes on infinitely without repeating.

Pi has been studied for thousands of years and has applications in various fields such as mathematics, physics, engineering, and computer science. It is also a fundamental constant in trigonometry and calculus.

## Name :
   The symbol used by mathematicians to represent the ratio of a circle's circumference to its diameter is the lowercase Greek letter π, sometimes spelled out as pi. In English, π is pronounced as "pie" (/paɪ/ PY).In mathematical use, the lowercase letter π is distinguished from its capitalized and enlarged counterpart Π, which denotes a product of a sequence, analogous to how Σ denotes summation.

The choice of the symbol π is discussed in the section Adoption of the symbol π.

## Defenition :
   π is commonly defined as the ratio of a circle's circumference C to its diameter d:



## Where does pi occur? :
   Pi occurs in many areas of mathematics, far too many to list here.


## Methods for calculating pi :

#There are several algorithms for calculating the value of Pi (π), each with its own unique approach and characteristics. Here are some of the main differences:
  
  
   
   ### 1- Gauss Legendre Algorithm :
            
   The Gauss-Legendre algorithm is a method to compute the digits of π. It is based on the individual work of Carl Friedrich Gauss and Adrien-Marie Legendre, 
   combined with modern algorithms for multiplication and square roots. The algorithm repeatedly replaces two numbers by their arithmetic and geometric mean, in        order to approximate their arithmetic-geometric mean. It is notable for being rapidly convergent, with only 25 iterations producing 45 million correct              digits of π. However, it is computer memory-intensive. Successive iterations of the algorithm produce better approximations of the circle constant, π.

### The difference :dart: : 
This algorithm is known for its rapid convergence, meaning it can quickly provide a very accurate approximation of Pi.
   

#### Learn more : https://en.wikipedia.org/wiki/Gauss%E2%80%93Legendre_algorithm



  
   
   ### 2- Nilakantha Series : 

   The Nilakantha series is a method for calculating the value of π, named after the Indian mathematician Nilakantha who lived from 1444 to 15441. It is an infinite series that converges towards π1. The series is given by:

      π = 3 + 4 / (2*3*4) – 4 / (4*5*6) + 4 / (6*7*8) – . . .

The pattern of the series involves the multiplication of three consecutive numbers in the denominator and alternating addition and subtraction2. This series continues indefinitely, providing increasingly accurate approximations of π2.

### The difference 🏎️ : 
This series converges faster than Leibniz’s formula, which means it can provide a more accurate approximation of Pi with fewer terms.

   
#### Learn more : https://www.geeksforgeeks.org/calculate-pi-using-nilkanthas-series/



  
   
   ### 3- Leibniz Formula : 

   The Leibniz formula for π, named after Gottfried Wilhelm Leibniz, is a method for calculating the value of π using an alternating series1. It was first discovered by the Indian mathematician Madhava of Sangamagrama in the 14th or 15th century. The formula is given by:

          π=4∑k≥0(−1)k12k+1

 ### The difference 🍉: 
 This is a simple and elegant formula, but it converges very slowly. That means you need a lot of terms to get a precise value of Pi.

#### Learn more : https://en.wikipedia.org/wiki/Leibniz_formula_for_%CF%80



## My choice for the program :

You can find lots of formulas for calculating π, but my favorite is this one:

![1112222888](https://github.com/mahdi1ebi/Sixth-Assignment-Advanced-Multithreading/assets/160699586/6a32d096-c670-4db0-9e37-930f97286de9)


For some reason, it doesn't make most lists of π formulas, but I like it because of its simplicity. I can recall it easily without looking anything up. All you have to remember are the first two terms and a simple evolution rule for each of the three multiplicands.
It only uses addition, multiplication, and division. No square roots. It computes π directly (not 1/π). And even though there are complicated formulas that converge faster, this simple one still converges at about 0.6 decimal digits per term.


## Why I preferred this algorithm :

1. Easier to implement this algorithm as a code than other algorithms.
2. Good accuracy.
3. Time complexity.


The main differences between various algorithms for calculating Pi (π) lie in their accuracy, convergence speed, and computational complexity:

#### 1- Accuracy: 
Some algorithms can calculate Pi to a high degree of precision, while others provide an approximation. The accuracy depends on the number of iterations or terms used in the calculation.

#### 2- Convergence Speed: 
This refers to how quickly an algorithm can reach the actual value of Pi. Some algorithms converge slowly, requiring many iterations to get a precise value, while others converge rapidly.

#### 3-Computational Complexity: 
This refers to the computational resources (like time and space) required by an algorithm. Some algorithms are simple and require less computational power, while others are complex and require more.

Different algorithms also use different mathematical approaches.The choice of algorithm can depend on the specific requirements of the task at hand.
According to these points, this algorithm was the best algorithm that I found that performed well in these three properties.


##  Code explanation:
At this code I used multithreading (ThreadPool) & I also used BigDecimal

## ThreadPool:


   #### Thread Creation: 
   A ThreadPool creates a set number of threads upon initialization. These threads are kept alive and are reused to handle tasks.

   #### Task Execution: 
   When a task is submitted to the ThreadPool, it is executed by one of the idle threads. If all threads are busy, the task is placed in a queue and waits for a thread to become available3.
      
   #### Thread Reuse: 
   Once a thread completes a task, it becomes available to execute another task from the queue. This eliminates the overhead of thread creation and destruction for each task, making the application more 
   responsive.

   #### Resource Management: 
   By limiting the number of concurrent threads, a ThreadPool prevents excessive resource usage. This is important because creating too many threads can consume significant system resources and slow down the 
   application

   #### Shutdown: 
   When the ThreadPool is no longer needed, it can be shut down, which stops all worker threads after they’ve finished executing their current tasks.


## BigDecimal:


   #### Arbitrary Precision: 
   BigDecimal can handle very large and very small floating point numbers with great precision1. This is because it consists of an arbitrary precision integer unscaled value.

   #### Scale: 
   The scale is a 32-bit integer that if zero or positive, represents the number of digits to the right of the decimal point. If negative, the unscaled value of the number is multiplied by ten to the power of 
   the negation of the scale.

   #### Rounding: 
   BigDecimal gives the user complete control over rounding behavior. If no rounding mode is specified and the exact result cannot be represented, an exception is thrown.

   #### Arithmetic Operations: 
   BigDecimal provides methods for various arithmetic operations like addition, subtraction, multiplication, division, and power.

## Known Issues:
I had two main problems with this code :
1. What is MathContext & how to use it ?
2. What is the number of timeout in awaitTermination (because the code return wrong answer) ?

  For the first problem I use copilot and search on the internet.
  I checked sites like geeksforgeeks &stackoverflow.

   For the second problem I just increased its value (This gave threads more time to calculate and let them finished their job)



