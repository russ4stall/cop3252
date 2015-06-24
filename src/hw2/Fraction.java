package hw2;
// class hw2.Fraction
// Author:  Bob Myers
//
// For COP3252, Java Programming

public class Fraction
{
    private int numerator = 0;		// numerator (and keeps sign)
    private int denominator = 1;		// always stores positive value

    public Fraction()
    {
    }

    public Fraction(int n, int d)
    {
        if (set(n,d)==false)
            set(0,1);
    }

    public Fraction simplify() {
        int gcd = gcd(numerator,denominator);
        return new Fraction(numerator/Math.abs(gcd), denominator/Math.abs(gcd));
    }

    private int gcd(int a, int b)
    {
        if(a == 0 || b == 0) return a+b;
        return gcd(b,a%b);
    }

    public Fraction add(Fraction f) {
        int d = denominator * f.denominator;
        int n1 = numerator * f.denominator;
        int n2 = f.numerator * denominator;

        Fraction fraction = new Fraction(n1 + n2, d);

        return fraction.simplify();
    }

    public Fraction subtract(Fraction f) {
        int d = denominator * f.denominator;
        int n1 = numerator * f.denominator;
        int n2 = f.numerator * denominator;

        Fraction fraction = new Fraction(n1 - n2, d);
        return fraction.simplify();
    }

    public Fraction multiply(Fraction f) {
        Fraction fraction = new Fraction(numerator * f.numerator, denominator * f.denominator);
        return fraction.simplify();
    }

    public Fraction divide(Fraction f) {
        int n = numerator * f.denominator;
        int d = denominator * f.numerator;
        if (d < 0) {
            n = n * -1;
            d = d * -1;
        }

        Fraction fraction = new Fraction(n,d);

        return fraction.simplify();
    }

    public boolean set(int n, int d)
    {
        if (d > 0)
        {
            numerator = n;
            denominator = d;
            return true;
        }
        else
            return false;
    }

    public String toString()
    {
        return (numerator + "/" + denominator);
    }

    public int getNumerator()
    {
        return numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public double decimal()
    {
        return (double)numerator / denominator;
    }
}
