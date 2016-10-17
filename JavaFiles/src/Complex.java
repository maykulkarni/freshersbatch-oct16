public class Complex implements Cloneable {
    int real;
    int imaginary;

    Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void add(Complex other) {
        this.real += other.real;
        this.imaginary += other.imaginary;
    }

    public void subtract(Complex other) {
        this.real -= other.real;
        this.imaginary -= other.imaginary;
    }

    public void multiply(Complex other) {
        this.real *= other.real;
        this.imaginary *= other.imaginary;
    }

    public void divide(Complex other) throws Exception {
        this.real /= other.real;
        this.imaginary /= other.imaginary;
    }

    public Complex swap(Complex other) throws Exception {
        Complex temp = (Complex) other.clone();
        other.real = this.real;
        other.imaginary = this.imaginary;
        this.real = temp.real;
        this.imaginary = other.imaginary;
        return other;
    }

    public static void main(String[] args) {

    }
}