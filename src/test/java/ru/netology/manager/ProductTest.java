package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.AlreadyExistsException;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ShopRepository;

public class ProductTest {
    ShopRepository shopRepository = new ShopRepository();

    Product product1 = new Product(1, "Телевизор", 39_000);
    Product product2 = new Product(2, "Холодильник", 69_000);

    @Test
    public void shouldRemoveProduct() {

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.remove(2);

        Product[] actual = shopRepository.findAll();
        Product[] expected = {product1};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldNotFoundException() {

        shopRepository.add(product1);
        shopRepository.add(product2);

        Assertions.assertThrows(NotFoundException.class, () ->
                shopRepository.remove(3)
        );
    }

    @Test
    public void addNewProduct() {
        Product productNew = new Product(25, "Монитор", 15_000);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(productNew);

        Product[] actual = shopRepository.findAll();
        Product[] expected = {product1, product2, productNew};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldAlreadyExistsException() {

        shopRepository.add(product1);
        shopRepository.add(product2);

        Assertions.assertThrows(AlreadyExistsException.class, () ->
                shopRepository.add(product2)
        );
    }
}

