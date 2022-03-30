package com.gg.Pojo;
import javax.persistence.*;

@Entity
@Table(name="hotelclass")
public class HotelClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="class")
    private String hotelClass;

    public HotelClass() {
    }

    public HotelClass(String hotelClass) {
        this.hotelClass = hotelClass;
    }

    public String getHotelClass() {
        return hotelClass;
    }

    public void setHotelClass(String hotelClass) {
        this.hotelClass = hotelClass;
    }

    @Override
    public String toString() {
        return "HotelClass{" +
                "hotelClass='" + hotelClass + '\'' +
                '}';
    }
}
