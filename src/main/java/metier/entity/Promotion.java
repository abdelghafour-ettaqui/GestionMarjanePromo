package metier.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "promo", schema = "public", catalog = "marjane")
public class Promotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpromo")
    private int idpromo;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "idcategory")
    private int idcategory;
    @Basic
    @Column(name = "percentage")
    private String percentage;
    @Basic
    @Column(name = "startdate")
    private Date startdate;
    @Basic
    @Column(name = "enddate")
    private Date enddate;
    @Basic
    @Column(name = "status")
    private String status;

    public int getIdpromo() {
        return idpromo;
    }

    public void setIdpromo(int idpromo) {
        this.idpromo = idpromo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        if (idpromo != promotion.idpromo) return false;
        if (idcategory != promotion.idcategory) return false;
        if (name != null ? !name.equals(promotion.name) : promotion.name != null) return false;
        if (percentage != null ? !percentage.equals(promotion.percentage) : promotion.percentage != null) return false;
        if (startdate != null ? !startdate.equals(promotion.startdate) : promotion.startdate != null) return false;
        if (enddate != null ? !enddate.equals(promotion.enddate) : promotion.enddate != null) return false;
        if (status != null ? !status.equals(promotion.status) : promotion.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpromo;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + idcategory;
        result = 31 * result + (percentage != null ? percentage.hashCode() : 0);
        result = 31 * result + (startdate != null ? startdate.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
