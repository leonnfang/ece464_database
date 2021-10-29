package com.ece464.recipewizard.Model;

import org.springframework.data.annotation.Id;
import java.util.List;

public class Recipe {
    @Id
    public int id;
    public String name;
    public List<List<String>> ingredient;
    public int label;
    public List<String> step;

}
