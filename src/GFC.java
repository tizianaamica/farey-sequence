import java.util.*;

public class GFC {
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static void farey(int n) {
        ArrayList<Term> v = new ArrayList<Term>();

        for (int i = 1; i <= n; ++i) {
            for (int j = i + 1; j <= n; ++j)
                if (gcd(i, j) == 1)
                    v.add(new Term(i, j));
        }

        Collections.sort(v, new Comparator<Term>() {
            public int compare(Term a, Term b) {
                return a.x * b.y - b.x * a.y;
            }
        });

        System.out.print("0/1 ");

        for (int i = 0; i < v.size(); ++i)
            System.out.print(v.get(i).x + "/" + v.get(i).y
                    + " ");

        System.out.print("1/1");
    }
}