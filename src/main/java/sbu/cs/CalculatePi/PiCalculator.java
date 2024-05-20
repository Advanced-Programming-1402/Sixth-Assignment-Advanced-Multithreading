package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;

public class PiCalculator {
    static class PiCalculatorTask implements Runnable {
        private int finalI;
        public static BigDecimal pi;
        MathContext mc = new MathContext(1000);

        public PiCalculatorTask(int finalI) {
            this.finalI = finalI;
        }
        @Override
        public void run() {
            BigDecimal Consequent1 = new BigDecimal(8*finalI + 1);
            BigDecimal Consequent2 = new BigDecimal(8*finalI + 4);
            BigDecimal Consequent3 = new BigDecimal(8*finalI + 5);
            BigDecimal Consequent4 = new BigDecimal(8*finalI + 6);
            BigDecimal Consequent5 = new BigDecimal(16).pow(finalI);

            BigDecimal numerator1 = new BigDecimal(-1);
            BigDecimal numerator2 = new BigDecimal(-1);
            BigDecimal numerator3 = new BigDecimal(-2);
            BigDecimal numerator4 = new BigDecimal(4);

            numerator1 = numerator1.divide(Consequent3 , mc);
            numerator2 = numerator2.divide(Consequent4 , mc);
            numerator3 = numerator3.divide(Consequent2 , mc);
            numerator4 = numerator4.divide(Consequent1 , mc);

            BigDecimal term = ((numerator4.add(numerator3)).add(numerator1)).add(numerator2);
            term = term.divide(Consequent5);
            addResult(term);

//            synchronized (pi){
//                pi = pi.add(term);
//            }
        }
    }

    public String calculate(int floatingPoint)
    {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        // Use the main function to test the code yourself
    }


    }