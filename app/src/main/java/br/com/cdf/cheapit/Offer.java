package br.com.cdf.cheapit;

import org.json.JSONArray;

import java.util.HashMap;

/**
 * Created by Jimy on 1/17/17.
 */
public class Offer {
    public String id;
    public String partner;
    public String description;
    public String image;

    public Offer(String id, String partner, String description, String image) {
        this.id = id;
        this.partner = partner;
        this.description = description;
        this.image = image;
    }
}
