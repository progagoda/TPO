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
    public Double doublefact(Double x){
        if (x <= 1){
            return 1D;
        }
        Double accum = 1D;
        Double mult = 1D;
        if (x % 2 == 0){
            mult = 2D;
        }

        while (mult <= x){
            accum *= mult;
            mult += 2;
        }

        return accum;
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
        Double numerator = 0D;
        Double denominator = 1D;
        if (Math.abs(x) <= 1){
            numerator = fact(2 * n);
            denominator = Math.pow(2, 2 * n) * Math.pow(fact(n), 2) * (2 * n + 1);
        }
        numerator = doublefact(2 * n + 1);
        denominator = doublefact(2 * n) * Math.pow(2 * n + 1, 2);
        return numerator / denominator;
    }
}
