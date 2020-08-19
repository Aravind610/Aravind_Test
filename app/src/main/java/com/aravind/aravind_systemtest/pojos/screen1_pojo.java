package com.aravind.aravind_systemtest.pojos;

public class screen1_pojo {

   private int id;
    private String screen_text1;
    private String screen_text2;
    private String screen_count;
    private int count;
    private String price;

    public screen1_pojo(int id ,String text1,String text2,String price){
        this.id = id;
        this.screen_text1 = text1;
        this.screen_text2 = text2;
//        this.count = count;
        this.price = price;

    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScreen_text1() {
        return screen_text1;
    }

    public void setScreen_text1(String screen_text1) {
        this.screen_text1 = screen_text1;
    }

    public String getScreen_text2() {
        return screen_text2;
    }

    public void setScreen_text2(String screen_text2) {
        this.screen_text2 = screen_text2;
    }

    public String getScreen_count() {
        return screen_count;
    }

    public void setScreen_count(String screen_count) {
        this.screen_count = screen_count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
