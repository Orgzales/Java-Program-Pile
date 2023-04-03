import java.math.*;
import java.util.StringTokenizer;

public class PostfixCalculator
{
    public PostfixCalculator()
    {

    }

    public static int stat(String ope)
    {
        if(ope.contains("^"))
            return 1;
        else if(ope.contains("*") || ope.contains("/"))
            return 2;
        else if(ope.contains("+") || ope.contains("-"))
            return 3;
        else
            return 4;
    }


    public static String infix2postfix(String infix)
    {

        StringBuilder postfix_exp = new StringBuilder(); //apoend
        LinkStack<String> stack = new LinkStack();
        StringTokenizer tokenizer = new StringTokenizer(infix, " \t\n");
        while (tokenizer.hasMoreTokens())
        {

            String token = tokenizer.nextToken();
            if (token.equals("("))
            {
                stack.push(token);
            }
            else if (token.equals(")"))
            {
                String operator = stack.pop();
                while(!operator.equals("(") )
                {
                    postfix_exp.append( operator + " ");
                    operator = stack.pop();
                }
            }
            else if (token.equals("^"))
            {
                while (!stack.isEmpty() && stat(token) > stat(stack.peek()))
                {
                    String topper = stack.pop();
                    postfix_exp.append(topper + " ");
                }
                stack.push(token);
            }


            else if ( token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-") )
            {

                while (!stack.isEmpty() && stat(token) > stat(stack.peek()))
                {

                    String topper = stack.pop();
                    postfix_exp.append(topper + " ");


                }
                stack.push(token);

            }
            else
            {
                postfix_exp.append(token + " ") ;
            }


        }

        while(!stack.isEmpty())
        {

            String top = stack.pop();
            postfix_exp.append(top + " ");

        }

        return postfix_exp.toString();
    }

    public static double solve(String postfix)
    {

        LinkStack<Double> solve_stack = new LinkStack<Double>();
        StringTokenizer tokenizer = new StringTokenizer(postfix, " \t\n");

        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();

            if (token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-") )
            {

                double operator_b = solve_stack.pop();
                double operator_a = solve_stack.pop();
                double results = equation( operator_a, operator_b,  token); //make switch method
                solve_stack.push(results);
            }
            else if (token.equals("^"))
            {

                double operator_b = solve_stack.pop();
                double operator_a = solve_stack.pop();
                double results = Math.pow(operator_a, operator_b);
                solve_stack.push(results);

            }


            else
            {
                double num = Double.parseDouble(token);
                solve_stack.push(num);
            }
        }

        return solve_stack.peek();
    }


    public static double equation(double ope_b , double ope_a , String operator)
    {
        double results = 0;
        if(operator.contains("*"))
        {
            results = ope_b * ope_a;
        }
        else if (operator.contains("/"))
        {
            results = ope_b / ope_a;
        }
        else if (operator.contains("+"))
        {
            results = ope_b + ope_a;
        }
        else if (operator.contains("-"))
        {
            results = ope_b - ope_a;
        }
        return results;
    }

}
