package sbu.cs.CalculatePi;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PiCalculator {

    static BigDecimal pi = new BigDecimal("0");
    public static class piCalculator implements Runnable {
        MathContext mc = new MathContext(1000000);
        int n;

        public piCalculator( int n) {
            this.n = n;

        }

        @Override
        public void run() {
            BigDecimal one = new BigDecimal("1");
            BigDecimal save ;
            BigDecimal save1 = new BigDecimal("1");
            BigDecimal three = new BigDecimal("3");
            BigDecimal four = new BigDecimal("4");

            three = three.divide(new BigDecimal(2 * n + 1), mc);
            four = one.divide(four , mc);
            four = four.pow(n);
            save = four.multiply(three , mc);

            for (int j = 1; j <= n; j++) {
                BigDecimal two = new BigDecimal((2 * j - 1));
                two = two.divide(new BigDecimal(2 * j),mc);
                save1 = save1.multiply(two , mc);
            }
            save = save.multiply(save1,mc);
            addToSum(save);

        }
    }

    public static synchronized void addToSum(BigDecimal value){
        pi = pi.add(value);
    }
    public static String calculate(int floatingPoint){
        ExecutorService threadPool = Executors.newFixedThreadPool(8);
        BigDecimal x = new BigDecimal("3");
        for ( int i =1 ; i< 1000000 ; i++){
            piCalculator task = new piCalculator(i);
            threadPool.execute(task);
        }
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(10000000,TimeUnit.MILLISECONDS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        pi = pi.add(x);
        return pi.toString().substring(0, floatingPoint + 2);

    }


        public static void main(String[] args) {
            // Use the main function to test the code yourself
            System.out.println(calculate(2));

        }
    }


