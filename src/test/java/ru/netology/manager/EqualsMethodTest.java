package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EqualsMethodTest {

    @Test
    public void shouldEqualsObjectTrue() {

        Product product1 = new Product(1, "Телевизор", 39_000);

        Assertions.assertTrue(product1.equals(product1));
    }

    @Test
    public void shouldEqualsObjectNullFalse() {

        Product product1 = new Product(1, "Телевизор", 39_000);

        Assertions.assertFalse(product1.equals(null));
    }

    //
    @Test
    public void shouldEqualsObjectGetClassFalse() {

        Product product1 = new Product(1, "Телевизор", 39_000);

        Assertions.assertFalse(product1.equals(product1.getClass()));
    }

    @Test
    public void shouldEqualsObjectReturnTrue() {

        Product product1 = new Product(1, "Телевизор", 39_000);
        Product product2 = new Product(1, "Телевизор", 39_000);

        Assertions.assertTrue(product1.equals(product2));
    }

    @Test
    public void shouldEqualsObjectIdFalse() {

        Product product1 = new Product(1, "Телевизор", 39_000);
        Product product2 = new Product(2, "Телевизор", 39_000);

        Assertions.assertFalse(product1.equals(product2));
    }

    @Test
    public void shouldEqualsObjectTitleFalse() {

        Product product1 = new Product(1, "Телевизор", 39_000);
        Product product2 = new Product(1, "Холодильник", 39_000);

        Assertions.assertFalse(product1.equals(product2));
    }

    @Test
    public void shouldEqualsObjectPriceFalse() {

        Product product1 = new Product(1, "Телевизор", 39_000);
        Product product2 = new Product(1, "Телевизор", 25_000);

        Assertions.assertFalse(product1.equals(product2));
    }
}