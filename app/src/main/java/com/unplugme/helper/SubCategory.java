package com.unplugme.helper;

public class SubCategory {

    int subCategoryId;
    String subCategory;

    public SubCategory(){

    }

    public SubCategory(String category){
        this.subCategory = category;

    }

    public SubCategory(int categoryId, String category){
        this.subCategoryId = categoryId;
        this.subCategory = category;
    }

    public int getcategoryId(){
        return this.subCategoryId;
    }

    public void setcategoryId(int categoryId){
        this.subCategoryId = categoryId;
    }

    public String getCategoryItem(){
        return this.subCategory;
    }

    public void setCategoryItem(String category){
        this.subCategory = category;
    }
}
