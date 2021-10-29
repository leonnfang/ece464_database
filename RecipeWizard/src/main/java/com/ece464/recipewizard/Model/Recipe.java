package com.ece464.recipewizard.Model;

import org.springframework.data.annotation.Id;
import java.util.List;

/**
 * TODO need to improve the structure of the model
 * the data should be better saved in a way that its easier to store and fetch data
 */
public class Recipe {
    @Id
    public int id;
    public String name;
    public List<List<String>> ingredient;
    public int label;
    public List<String> step;

}
