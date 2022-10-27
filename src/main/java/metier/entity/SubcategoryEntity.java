package metier.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subcategory", schema = "public", catalog = "marjane")
public class SubcategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idsubcategory")
    private int idsubcategory;
    @Basic
    @Column(name = "name")
    private String name;
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

        SubcategoryEntity that = (SubcategoryEntity) o;

        if (idsubcategory != that.idsubcategory) return false;
        if (idcategory != that.idcategory) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idsubcategory;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + idcategory;
        return result;
    }
}
