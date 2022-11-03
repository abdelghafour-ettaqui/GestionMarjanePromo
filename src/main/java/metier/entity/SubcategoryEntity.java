package metier.entity;

import jakarta.persistence.*;

import java.util.Collection;

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
    @Basic
    @Column(name = "creadit")
    private Integer creadit;
    @Basic
    @Column(name = "percentage")
    private String percentage;
    @OneToMany(mappedBy = "subcategoryByIdsubcategory")
    private Collection<PromoEntity> promosByIdsubcategory;
    @ManyToOne
    @JoinColumn(name = "idcategory", referencedColumnName = "idcategory", nullable = false, insertable = false, updatable = false)
    private CategoryEntity categoryByIdcategory;

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

    public Integer getCreadit() {
        return creadit;
    }

    public void setCreadit(Integer creadit) {
        this.creadit = creadit;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubcategoryEntity that = (SubcategoryEntity) o;

        if (idsubcategory != that.idsubcategory) return false;
        if (idcategory != that.idcategory) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (creadit != null ? !creadit.equals(that.creadit) : that.creadit != null) return false;
        if (percentage != null ? !percentage.equals(that.percentage) : that.percentage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idsubcategory;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + idcategory;
        result = 31 * result + (creadit != null ? creadit.hashCode() : 0);
        result = 31 * result + (percentage != null ? percentage.hashCode() : 0);
        return result;
    }

    public Collection<PromoEntity> getPromosByIdsubcategory() {
        return promosByIdsubcategory;
    }

    public void setPromosByIdsubcategory(Collection<PromoEntity> promosByIdsubcategory) {
        this.promosByIdsubcategory = promosByIdsubcategory;
    }

    public CategoryEntity getCategoryByIdcategory() {
        return categoryByIdcategory;
    }

    public void setCategoryByIdcategory(CategoryEntity categoryByIdcategory) {
        this.categoryByIdcategory = categoryByIdcategory;
    }
}
