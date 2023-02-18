package spel;

import cache.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author kangjie.zhang
 * @date 2020/11/19 16:36
 */
public class SpELExample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Person person = new Person();
        person.setName("jack");
        Expression exp = parser.parseExpression("#this");

        System.out.println(exp.getValue(person));

        Expression expression = parser.parseExpression("#price > #p[0] and #price<#p[1]");
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        context.setVariable("price",5000);
        context.setVariable("p",Arrays.asList(0,6000));
        System.out.println(expression.getValue(context));


        Expression expression2 = parser.parseExpression("#this[price] > #this[p][0]");
        final HashMap<String, Object> map = new HashMap<>();
        map.put("price",5000);
        map.put("p",Arrays.asList(0,6000));
        System.out.println(expression2.getValue(map));


    }

}
