package entities;

public class MDC {
    private int m, n;

    public MDC(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public int getMDC() {
        int _m = this.m;
        int _n = this.n;
        int temp;

        while (_n != 0) {
             temp = _n;
             _n = _m%_n;
             _m = temp;
        }

        return _m;
    }

    public int getMDC(int m, int n) {
        if (n == 0) {
            return m;
        }
        return getMDC(n, m%n);
    }
}
