package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            PiCalculatorTask task = new PiCalculatorTask(i);
            executor.execute(task);
        }

        executor.shutdown();
        try{
            executor.awaitTermination(Long.MAX_VALUE , TimeUnit.MILLISECONDS);

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        pi = pi.setScale(floatingPoint , RoundingMode.DOWN);
        return pi.toString();
    }
    public static BigDecimal pi = new BigDecimal(0);
    public static synchronized void addResult(BigDecimal term){
        pi = pi.add(term);
    }

    public static void main(String[] args) {
        PiCalculator piCalculator = new PiCalculator();
        String s = piCalculator.calculate(2);
        System.out.println(s);
    }


    }