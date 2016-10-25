import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class NQueen {
    static ExecutorService ex;
    static AtomicInteger answer = new AtomicInteger(0);

    public static boolean isSafePosition(int y1, int y2, int x1, int x2) {
        if (y1 != y2 && x1 != x2) {
            double slope = ((y2 - y1) * 1.0) / (x2 - x1);
            if (slope != 1.0 && slope != -1.0) {
                return true;
            }
        }
        return false;
    }

    public static void doStuff() throws ExecutionException, InterruptedException {
        int a2 = 0, b2 = 1, c2 = 2, d2 = 3, e2 = 4, f2 = 5, g2 = 6, h2 = 7;
        int i = 1;
        for (int a = 0; a <= 7; a++) {
            int finalA = a;
            int finalA1 = a;
            Future<String> res = ex.submit(() -> {
                StringBuilder sb = new StringBuilder();
                for (int b = 0; b <= 7; b++) {
                    for (int c = 0; c <= 7; c++) {
                        for (int d = 0; d <= 7; d++) {
                            for (int e = 0; e <= 7; e++) {
                                for (int f = 0; f <= 7; f++) {
                                    for (int g = 0; g <= 7; g++) {
                                        for (int h = 0; h <= 7; h++) {

                                            if (isSafePosition(finalA, b, a2, b2) && isSafePosition(finalA, c, a2, c2) && isSafePosition(finalA, d, a2, d2) && isSafePosition(finalA, e, a2, e2) && isSafePosition(finalA, f, a2, f2) && isSafePosition(finalA, g, a2, g2) && isSafePosition(finalA, h, a2, h2)
                                                    && isSafePosition(b, c, b2, c2) && isSafePosition(b, d, b2, d2) && isSafePosition(b, e, b2, e2) && isSafePosition(b, f, b2, f2) && isSafePosition(b, g, b2, g2) && isSafePosition(b, h, b2, h2)
                                                    && isSafePosition(c, d, c2, d2) && isSafePosition(c, e, c2, e2) && isSafePosition(c, f, c2, f2) && isSafePosition(c, g, c2, g2) && isSafePosition(c, h, c2, h2)
                                                    && isSafePosition(d, e, d2, e2) && isSafePosition(d, f, d2, f2) && isSafePosition(d, g, d2, g2) && isSafePosition(d, h, d2, h2)
                                                    && isSafePosition(e, f, e2, f2) && isSafePosition(e, g, e2, g2) && isSafePosition(e, h, e2, h2)
                                                    && isSafePosition(f, g, f2, g2) && isSafePosition(f, h, f2, h2)
                                                    && isSafePosition(g, h, g2, h2)) {

                                                sb.append("Position  ").append(answer.incrementAndGet()).append(" : ").append(finalA1).append(" - ").append(b).append(" - ").append(c).append(" - ").append(d).append(" - ").append(e).append(" - ").append(f).append(" - ").append(g).append(" - ").append(h).append("\n");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return sb.toString();
            });

            System.out.println(res.get());
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long startTime = System.currentTimeMillis();
        ex = Executors.newCachedThreadPool();
        doStuff();
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime - startTime) + " milisec");
        //ex.shutdown();
    }

}
