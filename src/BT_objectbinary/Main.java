package BT_objectbinary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "a", "a1", 10));
        productList.add(new Product(2, "b", "b1", 20));
        productList.add(new Product(3, "c", "c1", 30));
        productList.add(new Product(4, "d", "d1", 40));
        productList.add(new Product(5, "e", "e1", 50));

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("product.txt"));
            objectOutputStream.writeObject(productList);
            objectOutputStream.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        try {
            productList = readBinary();
            for (Product product : productList) {
                System.out.println(product);
            }
        } catch (IOException | ClassNotFoundException ioe) {
            System.err.println(ioe.getMessage());
        }

        System.out.println("After fixed: ");
        for (Product product : productList){
            if(product.getPrice() == 10){
                product.setCodeProduct(100);
            }
        }

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("product.txt"));
            objectOutputStream.writeObject(productList);
            objectOutputStream.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        try {
            productList = readBinary();
            for (Product product : productList) {
                System.out.println(product);
            }
        } catch (IOException | ClassNotFoundException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    private static List<Product> readBinary() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("product.txt"));
        List<Product> list;
        list = (List<Product>) objectInputStream.readObject();
        objectInputStream.close();
        return list;
    }
}
