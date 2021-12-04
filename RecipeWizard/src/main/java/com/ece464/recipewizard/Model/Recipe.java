package com.ece464.recipewizard.Model;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * TODO need to improve the structure of the model
 * the data should be better saved in a way that its easier to store and fetch data
 */
@Data
@Document(collection="Scrapy_labeledrecipes")
public class Recipe {
    @Id
    private String _id;
    private String name;
    private String img_url;
    private JSONArray ingredients;
    private String ingredientsList;
    private String label;
    private JSONArray description;


}
