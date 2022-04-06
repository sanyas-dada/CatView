package com.sanyasdada.catview;

public class ImageModel {
    int imageView;
    String productName;
    String  productPrice;

    public ImageModel(int imageView, String productName, String productPrice) {
        this.imageView = imageView;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
