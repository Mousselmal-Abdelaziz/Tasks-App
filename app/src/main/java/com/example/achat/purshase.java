package com.example.achat;

public class purshase {

private String item;
private String qte;

    public purshase(String item, String qte) {
        this.item = item;
        this.qte = qte;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQte() {
        return qte;
    }

    public void setQte(String qte) {
        this.qte = qte;
    }

}
