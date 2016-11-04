import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kulkarni_my on 11/3/2016.
 */
public class BinaryPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nhouse = in.nextInt();
        int nroads = in.nextInt();
        int distance = in.nextInt();
        List<List<List<Integer>>> graph = new ArrayList<>();

        for (int i = 0; i < nhouse; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < nroads; i++) {
            int from = in.nextInt() - 1;
            int to = in.nextInt() - 1;
            int road = in.nextInt();
            try {
                List<Integer> tmp = graph.get(from).get(road);
                graph.get(from).get(road).add(to);
            } catch (Exception e) {
                graph.get(from).add(Arrays.asList(to));
            }

            try {
                List<Integer> tmp = graph.get(to).get(road);
                graph.get(to).get(road).add(from);
            } catch (Exception e) {
                graph.get(to).add(Arrays.asList(from));
            }

        }
        new BinaryPathSolver().solve(graph, distance);
    }
}

class BinaryPathSolver {
    int maxDistance;
    int answersFound = 0;

    public void travel(List<List<List<Integer>>> graph, int currentDistance, int currendNode) {
        if (currentDistance == maxDistance) {
            answersFound++;
        } else {
            try {
                if (graph.get(currendNode).get(0) != null) {
                    for (int i : graph.get(currendNode).get(0)) {
                        travel(graph, currentDistance + 1, i);
                    }
                }
                if (graph.get(currendNode).get(1) != null) {
                    for (int i : graph.get(currendNode).get(1)) {
                        travel(graph, currentDistance + 1, i);
                    }
                }
            } catch (Exception e) {

            }
        }
    }

    public void solve(List<List<List<Integer>>> graph, int distance) {
        this.maxDistance = distance;
        travel(graph, 0, 0);
        System.out.println(answersFound);
    }
}