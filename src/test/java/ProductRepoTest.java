import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @org.junit.jupiter.api.Test
    void getProducts() {
        //GIVEN
        ProductRepo repo = new ProductRepo();

        //WHEN
        List<Product> actual = repo.getProducts();

        //THEN
        List<Product> expected = new ArrayList<>();

        expected.add(new Product("1", "Apfel"));
        expected.add(new Product("2", "Banane"));
        expected.add(new Product("3", "Birne"));
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getProductById() {
        //GIVEN
        ProductRepo repo = new ProductRepo();

        //WHEN
        Optional<Product> actual = repo.getProductById("1");

        //THEN
        Optional<Product> expected = Optional.of(new Product("1", "Apfel"));
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void getProductById_WithoutProduct() {
        //GIVEN
        ProductRepo repo = new ProductRepo();

        //WHEN
        Optional<Product> actual = repo.getProductById("4");

        //THEN
        Optional<Product> expected = Optional.empty();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void addProduct() {
        //GIVEN
        ProductRepo repo = new ProductRepo();
        Product newProduct = new Product("2", "Banane");

        //WHEN
        Product actual = repo.addProduct(newProduct);

        //THEN
        Product expected = new Product("2", "Banane");
        assertEquals(expected, actual);

    }

    @org.junit.jupiter.api.Test
    void removeProduct() {
        //GIVEN
        ProductRepo repo = new ProductRepo();



        //WHEN
        repo.removeProduct("1");

        //THEN
      assertEquals(Optional.empty(), repo.getProductById("1"));
    }
}
