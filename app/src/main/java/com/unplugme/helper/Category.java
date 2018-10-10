package com.unplugme.helper;

public class Category {

    int categoryId;
    String category;

    public Category(){

    }

    public Category(String category){
        this.category = category;

    }

    public Category(int categoryId, String category){
        this.categoryId = categoryId;
        this.category = category;
    }

    public int getcategoryId(){
        return this.categoryId;
    }

    public void setcategoryId(int categoryId){
        this.categoryId = categoryId;
    }

    public String getCategoryItem(){
        return this.category;
    }

    public void setCategoryItem(String category){
        this.category = category;
    }
}
