package br.com.cdf.cheapit;

/**
 * Created by Jimy on 4/29/17.
 */
public class Coupon {
    public String id;
    public String partner;
    public String description;
    public String couponCode;
    public String image;
    public String expires_at;
    public String status;
    public String points;

    public Coupon(String id, String partner, String description, String couponCode, String image, String expires_at, String status, String points) {
        this.id = id;
        this.partner = partner;
        this.description = description;
        this.couponCode = couponCode;
        this.image = image;
        this.expires_at = expires_at;
        this.status = status;
        this.points = points;
    }
}
