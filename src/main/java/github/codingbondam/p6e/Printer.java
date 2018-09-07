package main.java.github.codingbondam.p6e;

public class Printer {

    private String ones(int digit) {
        if (digit == 1) {
            return "ONE";
        } else if (digit == 2) {
            return "TWO";
        } else if (digit == 3) {
            return "THREE";
        } else if (digit == 4) {
            return "FOUR";
        } else if (digit == 5) {
            return "FIVE";
        } else if (digit == 6) {
            return "SIX";
        } else if (digit == 7) {
            return "SEVEN";
        } else if (digit == 8) {
            return "EIGHT";
        } else if (digit == 9) {
            return "NINE";
        } else if (digit == 10) {
            return "TEN";
        }
        // todo throw exception
        return null;
    }

    private String tens(int digit) {
        switch (digit) {
            case 2:
                return "TWENTY";
            case 3:
                return "THIRTY";
            case 4:
                return "FORTY";
            case 5:
                return "FIFTY";
            case 6:
                return "SIXTY";
            case 7:
                return "SEVENTY";
            case 8:
                return "EIGHTY";
            case 9:
                return "NINETY";
        }
        return null;
    }

    private String eleventotwenty(int digit) {
        switch (digit) {
            case 11:
                return "ELEVEN";
            case 12:
                return "TWELVE";
            case 13:
                return "THIRTEEN";
            case 14:
                return "FOURTEEN";
            case 15:
                return "FIFTEEN";
            case 16:
                return "SIXTEEN";
            case 17:
                return "SEVENTEEN";
            case 18:
                return "EIGHTEEN";
            case 19:
                return "NINETEEN";
        }
        return null;
    }


    public void english(int i) {

        if (i <= 10) {
            System.out.print(ones(i));
        } else if (i > 10 && i < 20) {
            System.out.print(eleventotwenty(i));
        } else if (i >= 20 && i < 100) {
            int tens = i / 10;
            int digit = i % 10;
            System.out.print(tens(tens));
            if (digit != 0) {
                System.out.print(" ");
                System.out.print(ones(digit));
            }
        } else if (i >= 100 && i < 1000) {
            int hundreds = i / 100;
            int rest = i % 100;
            english(hundreds);
            System.out.print(" HUNDRED");
            if (rest != 0) {
                System.out.print(" AND ");
                english(rest);
            }
        } else if (i >= 1000) {
            int thousands = i / 1000;
            int rest = i % 1000;
            english(thousands);
            System.out.print(" THOUSAND");
            if (rest != 0) {
                System.out.print(", ");
                english(rest);
            }
        }

    }

    public static void main(String[] args) {

        Printer p = new Printer();
        p.english(32134);

    }
}
