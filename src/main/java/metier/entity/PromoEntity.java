package metier.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "promo", schema = "public", catalog = "marjane")
public class PromoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpromo")
    private int idpromo;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "idcategory")
    private Integer idcategory ;
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
    @Basic
    @Column(name = "idsubcategory")
    private Integer idSubCategory;
    @Basic
    @Column(name = "idstore")
    private Integer idStore;

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

    public Integer getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Integer idcategory) {
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

    public Integer getIdSubCategory() {
        return idSubCategory;
    }

    public void setIdSubCategory(Integer idSubCategory) {
        this.idSubCategory = idSubCategory;
    }

    public Integer getIdStore() {
        return idStore;
    }

    public void setIdStore(Integer idStore) {
        this.idStore = idStore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromoEntity that = (PromoEntity) o;

        if (idpromo != that.idpromo) return false;
        if (idcategory != that.idcategory) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (percentage != null ? !percentage.equals(that.percentage) : that.percentage != null) return false;
        if (startdate != null ? !startdate.equals(that.startdate) : that.startdate != null) return false;
        if (enddate != null ? !enddate.equals(that.enddate) : that.enddate != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (idSubCategory != null ? !idSubCategory.equals(that.idSubCategory) : that.idSubCategory != null)
            return false;
        if (idStore != null ? !idStore.equals(that.idStore) : that.idStore != null) return false;

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
        result = 31 * result + (idSubCategory != null ? idSubCategory.hashCode() : 0);
        result = 31 * result + (idStore != null ? idStore.hashCode() : 0);
        return result;
    }
}
