import java.util.Random;

public class Fraction {
	
	//instance variable (attribute or fields)
	private int numerator, denominator;
	
	//constructor(s)
	public Fraction () { // default constructor
		numerator = 1;
		denominator = 1;
	}
	
	public Fraction (int n, int d) { //parameterized constructor
		numerator = n;
		setDenominator(d);
	}
	
	public Fraction (String n) {
		for (int i = 0; i < n.length(); i++) {
			if (n.substring(i, i+1).equals("/")) {
				numerator = Integer.parseInt(n.substring(0, i));
				setDenominator(Integer.parseInt(n.substring(i+1)));
			}
		}
	} 
	
	public Fraction (Fraction f) {
		numerator =  f.numerator;
		denominator = f.denominator;

	}
	
	//behaviour methods (accessor, mutator, helper)
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	//mutator methods
	public void setNumerator(int n) {
		numerator = n;
	}
	
	public void setDenominator(int d) {
		if (d != 0) {
			denominator = d;
		} else {
			denominator = 1;
			System.out.println("Denominator cannot be 0.");
		}
	}
	public static Fraction mult(Fraction a, Fraction b){
		int n = a.getNumerator() * b.getNumerator();
		int d = b.getDenominator() * b.getDenominator();
		Fraction answer = new Fraction(n,d);
		return answer;
	}
	
	public static Fraction divide(Fraction a, Fraction b) {
		int n = a.getNumerator() * b.getDenominator();
		int d = a.getDenominator() * b.getNumerator();
		Fraction answer = new Fraction(n, d);
		return answer;
}

	public static Fraction add(Fraction a, Fraction b) {
		int n = (a.getNumerator() * b.getDenominator()) + (b.getNumerator() * a.getDenominator());
		int d = a.getDenominator() * b.getDenominator();
		Fraction answer = new Fraction(n, d);
		return answer;
}

	public static Fraction subtract(Fraction a, Fraction b) {
		int n = (a.getNumerator() * b.getDenominator()) - (b.getNumerator() * a.getDenominator());
		int d = a.getDenominator() * b.getDenominator();
		Fraction answer = new Fraction(n, d);
		return answer;
}
	public static int getGCF(int a, int b) {
    while (a != b) {
        if (a > b) {
            a = a - b;
        } else {
            b = b - a;
        }
    }
    return a;
}
	private void reduce() {
    if (numerator == 0) {
        denominator = 1;
        return;
    }
    if (denominator < 0) {
        numerator = -numerator;
        denominator = -denominator;
    }
    int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
    numerator = numerator / gcd;
}

	private int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

}
