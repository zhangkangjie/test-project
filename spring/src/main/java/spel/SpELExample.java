package spel;

import cache.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author kangjie.zhang@ttpai.cn
 * @date 2020/11/19 16:36
 */
public class SpELExample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Person person = new Person();
        person.setName("jack");
        Expression exp = parser.parseExpression("#this");

        System.out.println(exp.getValue(person));
    }

}
