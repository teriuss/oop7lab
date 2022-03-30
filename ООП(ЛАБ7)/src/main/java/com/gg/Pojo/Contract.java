package com.gg.Pojo;
import javax.persistence.*;

@Entity
@Table(name="contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IDcontract")
    private Integer IDcontract;

    @Column(name="agreementDate")
    private String agreementDate;

    //СВЯЗЬ ОДИН К ОДНОМУ С ТАБЛИЦЕЙ Client
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "client_id")
    private Client client;

    //СВЯЗЬ ОДИН К ОДНОМУ С ТАБЛИЦЕЙ Tour
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "tourNumber")
    private Tour tour;

    public Contract() {
    }


    public Contract(String agreementDate) {
        this.agreementDate = agreementDate;
    }

    public Integer getIDcontract() {
        return IDcontract;
    }

    public void setIDcontract(Integer IDcontract) {
        this.IDcontract = IDcontract;
    }

    public String getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(String agreementDate) {
        this.agreementDate = agreementDate;
    }



    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "IDcontract=" + IDcontract +
                ", agreementDate='" + agreementDate + '\'' +
                '}';
    }
}
