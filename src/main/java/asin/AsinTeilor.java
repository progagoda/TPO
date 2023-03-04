package asin;

public class AsinTeilor{
    public Double calculate(Double x){
        if (!validate(x)){
            return null;
        }

        Double current_monomial = 0D;
        Double n = 0D;
        Double result_sum = current_monomial;
        do {
            current_monomial = Math.pow(x, 2 * n + 1);
            current_monomial *= get_mult_for_monomial(n, x);
            result_sum += current_monomial;
            n += 1D;
            System.out.println("current_monomial: " + current_monomial);
            System.out.println("result_sum: " + result_sum);
        } while (Math.abs(current_monomial) > 0.001);
        return result_sum;
    }

    public boolean validate(Double x) throws NullPointerException {
        if (x == null) {
            throw new NullPointerException("Dot null argument");
        }
        if (Math.abs(x) > 1) {
            return false;
        }
        return true;
    }
    public Double fact(Double x){
        if (x <= 1){
            return 1D;
        }
        Double accum = 1D;
        Double mult = 1D;
        while (mult <= x){
            accum *= mult;
            mult++;
        }
        return accum;
    }
    public Double get_mult_for_monomial(Double n, Double x){
        if (n == 0){
            return 1D;
        }
        if (n < 0){
            return null;
        }
        Double numerator = fact(2 * n);
        Double denominator = Math.pow(2, 2 * n) * Math.pow(fact(n), 2) * (2 * n + 1);
        return numerator / denominator;
    }
}
