package ThinkingInJava.Charpter15.utils;

import ThinkingInJava.Charpter15.Generator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @Author : jingtao
 * @Data : 2020/04/11/16:45
 * @Description :
 * @Page or WebSite：370
 * @Expected result ：
 */
class Customer {
    private static long counter = 1;
    private final long id = counter++;
    private Customer() {
    }
    @Override
    public String toString() {
        return "Customer" + id;
    }
    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;
    private Teller() {
    }
    @Override
    public String toString() {
        return "Teller" + id;
    }
    public static Generator<Teller> generator = new Generator<Teller>() {
        @Override
        public Teller next() {
            return new Teller();
        }
    };
}

public class BankTeller {
    public static void serve(Teller teller, Customer customer) {
        System.out.println(teller + " serve " + customer);
    }
    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<Customer> customers = new LinkedList<>();
        Generators.fill(customers, Customer.generator(), 15);
        ArrayList<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 4);
        for (Customer c : customers) {
            serve(tellers.get(random.nextInt(tellers.size())), c);
        }
    }
}
