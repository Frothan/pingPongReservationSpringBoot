package com.pingPongReservation.demo.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "myOrders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private String racketName;
    private String level;
    private String reservationStartDate;
    private String reservationEndDate;
    private Boolean isWishlist;

    public String getReservationStartDate() {
        return reservationStartDate;
    }

    public void setReservationStartDate(String reservationStartDate) {
        this.reservationStartDate = reservationStartDate;
    }

    public String getReservationEndDate() {
        return reservationEndDate;
    }

    public void setReservationEndDate(String reservationEndDate) {
        this.reservationEndDate = reservationEndDate;
    }

    public Boolean getWishlist() {
        return isWishlist;
    }

    public void setWishlist(Boolean wishlist) {
        isWishlist = wishlist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRacketName() {
        return racketName;
    }

    public void setRacketName(String racketName) {
        this.racketName = racketName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
