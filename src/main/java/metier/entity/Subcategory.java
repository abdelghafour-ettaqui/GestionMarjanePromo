package metier.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Subcategory implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idsubcategory")
    private int idsubcategory;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "creadit")
    private int creadit;
    @Basic
    @Column(name = "percentage")
    private String percentage;
    @Basic
    @Column(name = "idcategory")
    private int idcategory;

    public int getIdsubcategory() {
        return idsubcategory;
    }

    public void setIdsubcategory(int idsubcategory) {
        this.idsubcategory = idsubcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreadit() {
        return creadit;
    }

    public void setCreadit(int creadit) {
        this.creadit = creadit;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subcategory that = (Subcategory) o;

        if (idsubcategory != that.idsubcategory) return false;
        if (creadit != that.creadit) return false;
        if (idcategory != that.idcategory) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (percentage != null ? !percentage.equals(that.percentage) : that.percentage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idsubcategory;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + creadit;
        result = 31 * result + (percentage != null ? percentage.hashCode() : 0);
        result = 31 * result + idcategory;
        return result;
    }
}
