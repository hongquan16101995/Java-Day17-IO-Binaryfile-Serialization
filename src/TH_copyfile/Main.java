package TH_copyfile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter source file: ");
        String sourceFileName = sc.nextLine();
        System.out.println("Enter dest file: ");
        String destFileName = sc.nextLine();

        System.out.println("Enter source file1: ");
        String sourceFileName1 = sc.nextLine();
        System.out.println("Enter dest file1: ");
        String destFileName1 = sc.nextLine();

        File sourceFile = new File(sourceFileName);
        File destFile = new File(destFileName);

        File sourceFile1 = new File(sourceFileName1);
        File destFile1 = new File(destFileName1);


        long first = System.currentTimeMillis();
        try {
            copyFileUserJava7File(sourceFile, destFile);
            System.out.println("Copy completed!");
        } catch (IOException ioe) {
            System.out.print("Can't copy that file : ");
            System.out.println(ioe.getMessage());
        }
        long last = System.currentTimeMillis();
        System.out.println(last-first);


        long first1 = System.currentTimeMillis();
        try {
            copyFileUserStream(sourceFile1, destFile1);
            System.out.println("Copy completed!");
        } catch (IOException ioe) {
            System.out.print("Can't copy that file : ");
            System.out.println(ioe.getMessage());
        }
        long last1 = System.currentTimeMillis();
        System.out.println(last1-first1);
    }

    private static void copyFileUserJava7File(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUserStream(File source, File dest) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(source);
            out = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        } finally {
            in.close();
            out.close();
        }
    }
}
