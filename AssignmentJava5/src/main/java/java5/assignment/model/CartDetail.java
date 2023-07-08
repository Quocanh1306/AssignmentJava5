package java5.assignment.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "giohangctiet")
public class CartDetail  {
    @EmbeddedId
    private CartDetailID cartDetailID;

    @Column(name = "soluong")
    private int soLuong;

    public CartDetail() {
    }

    public CartDetail(CartDetailID cartDetailID, int soLuong) {
        this.cartDetailID = cartDetailID;
        this.soLuong = soLuong;
    }

    public CartDetailID getCartDetailID() {
        return cartDetailID;
    }

    public void setCartDetailID(CartDetailID cartDetailID) {
        this.cartDetailID = cartDetailID;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}


