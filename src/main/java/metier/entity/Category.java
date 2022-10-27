package metier.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "category", schema = "public", catalog = "marjane")
public class Category implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcategory")
    private int idcategory;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "percentage")
    private String percentage;
    @Basic
    @Column(name = "idstoreadmin")
    private int idstoreadmin;

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public int getIdstoreadmin() {
        return idstoreadmin;
    }

    public void setIdstoreadmin(int idstoreadmin) {
        this.idstoreadmin = idstoreadmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category that = (Category) o;

        if (idcategory != that.idcategory) return false;
        if (idstoreadmin != that.idstoreadmin) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (percentage != null ? !percentage.equals(that.percentage) : that.percentage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcategory;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (percentage != null ? percentage.hashCode() : 0);
        result = 31 * result + idstoreadmin;
        return result;
    }
}
