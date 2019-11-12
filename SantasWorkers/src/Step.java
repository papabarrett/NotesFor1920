
/**
 *
 * @author J. Barrett For use to solve the shortest path. Don't have to use, but
 * definitely helpful --Some parts may be intentionally broken--
 */

import java.lang.*;
import java.util.LinkedList;

public class Step implements Comparable {

    int r, c;
    LinkedList<Step> path;
    int steps;

    public Step(int r, int c) {
        this.r = r;
        this.c = c;
        path = new LinkedList();
        steps = 0;
    }

    public Step(int r, int c, LinkedList<Step> path) {
        this.r = r;
        this.c = c;
        this.path = path;
        steps = path.size();
    }

    @Override
    public int compareTo(Object t) {
        return 0;
    }

}
