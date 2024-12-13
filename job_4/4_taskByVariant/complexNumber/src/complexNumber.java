class complexNumber {
    private double real;
    private double imaginary;

    public complexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public complexNumber divide(complexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        double newReal = (real * other.real + imaginary * other.imaginary) / denominator;
        double newImaginary = (imaginary * other.real - real * other.imaginary) / denominator;
        return new complexNumber(newReal, newImaginary);
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }

    public static void main(String[] args) {
        complexNumber num1 = new complexNumber(4, 5);
        complexNumber num2 = new complexNumber(3, -2);

        try {
            complexNumber result = num1.divide(num2);
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
