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
    private String label;
    private JSONArray description;


    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return img_url;
    }

    public void setImageURL(String imageURL) {
        this.img_url = imageURL;
    }

    public JSONArray getIngredients() {
        return ingredients;
    }

    public void setIngredient(JSONArray ingredient) {
        this.ingredients = ingredient;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public JSONArray getDescription() {
        return description;
    }

    public void setDescription(JSONArray description) {
        this.description = description;
    }
}
