/**
 *
 */
package br.com.report.tests.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Simple entity for creating of a Excel file.
 */
@Getter
@Setter
public class TestClass {

    private String name;
    private String path;
    private String directory;
    private Integer containedFiles;
    private Double doubleField;

    public TestClass() {
    }

    public TestClass(String name, String path, String directory, Integer containedFiles, Double doubleField) {
        super();
        this.name = name;
        this.path = path;
        this.directory = directory;
        this.containedFiles = containedFiles;
        this.doubleField = doubleField;
    }

    @Override
    public String toString() {
        return "TestClass [containedFiles=" + containedFiles + ", directory=" + directory + ", doubleField=" +
                doubleField + ", name=" + name + ", path=" + path + "]";
    }

    // Generate some sample data.
    public static List<TestClass> getTestData() {
        List<TestClass> testClasses = new ArrayList<>();

        String currentDirectory = System.getProperty("user.home") + "/Downloads";

        File currentDirectoryFile = new File(currentDirectory);
        File[] files = currentDirectoryFile.listFiles();

        double dbl = 0;
        for (File file : files) {
            TestClass testClass = null;
            if (file.isDirectory()) {
                testClass = new TestClass(file.getName(), file.getPath(), "directory", file.list().length, dbl++);
            } else {
                testClass = new TestClass(file.getName(), file.getPath(), "file", 0, dbl++);
            }
            testClasses.add(testClass);
        }
        return testClasses;
    }
}
